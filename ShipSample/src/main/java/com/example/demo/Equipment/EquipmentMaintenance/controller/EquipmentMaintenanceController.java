package com.example.demo.Equipment.EquipmentMaintenance.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Equipment.EquipmentMaintenance.form.EquipmentMaintenanceForm;
import com.example.demo.Equipment.EquipmentMaintenance.service.EquipmentMaintenanceService;
import com.example.demo.entity.ConsumablePartsInfo;
import com.example.demo.entity.EquipmentInfo;
import com.example.demo.entity.ItemInfo;
import com.example.demo.entity.ProgramInfo;
import com.example.demo.entity.ShipInfo;
import com.example.demo.model.EquipmentMaintenanceModel;

@Controller
@RequestMapping("/Equipment/EquipmentMaintenance")
public class EquipmentMaintenanceController {
	private EquipmentMaintenanceModel equipmentMaintenanceModel = new EquipmentMaintenanceModel();
	
	@Autowired
	private EquipmentMaintenanceService equipmentMaintenanceService;
	
	@Autowired
	private MessageSource messageSource;
	
    @GetMapping("/index/{equipmentid}")    
    // 初期表示処理(更新)
    private String updatePost(@PathVariable int equipmentid,  Model model) {
    	//EquipmentMaintenanceModel equipmentMaintenance =  equipmentMaintenanceService.getEquipmentMaintenanceModel(equipmentid);
    	this.equipmentMaintenanceModel = new EquipmentMaintenanceModel();
    	this.equipmentMaintenanceModel.setShipInfo(equipmentMaintenanceService.getShipInfoByEquipmentId(equipmentid));
    	this.equipmentMaintenanceModel.setEquipmentInfo(equipmentMaintenanceService.getEquipmentInfo(equipmentid));
    	this.equipmentMaintenanceModel.setItemInfoList(equipmentMaintenanceService.getItemInfoList(equipmentid));
    	this.equipmentMaintenanceModel.setProgramInfoList(equipmentMaintenanceService.getProgramInfoList(equipmentid));
    	this.equipmentMaintenanceModel.setConsumablePartsInfoList(equipmentMaintenanceService.getConsumablePartsInfoList(equipmentid));
    	this.equipmentMaintenanceModel.setModelStrList(equipmentMaintenanceService.getModelStrList());
    	this.equipmentMaintenanceModel.setItemStrList(equipmentMaintenanceService.getItemStrList());

    	model.addAttribute("shipInfo", this.equipmentMaintenanceModel.getShipInfo() != null? this.equipmentMaintenanceModel.getShipInfo() : new ShipInfo());
    	model.addAttribute("equipmentInfo", this.equipmentMaintenanceModel.getEquipmentInfo() != null ? this.equipmentMaintenanceModel.getEquipmentInfo(): new EquipmentInfo() );
    	model.addAttribute("itemInfoList", chkValidatedList(this.equipmentMaintenanceModel.getItemInfoList()) ? this.equipmentMaintenanceModel.getItemInfoList(): new ArrayList<ItemInfo>());
    	model.addAttribute("programInfoList", chkValidatedList(this.equipmentMaintenanceModel.getProgramInfoList())? this.equipmentMaintenanceModel.getProgramInfoList(): new ArrayList<ProgramInfo>());
    	model.addAttribute("consumablepartsInfoList", chkValidatedList(this.equipmentMaintenanceModel.getConsumablePartsInfoList())? this.equipmentMaintenanceModel.getConsumablePartsInfoList(): new ArrayList<ConsumablePartsInfo>());
    	model.addAttribute("modelStrList", chkValidatedList(this.equipmentMaintenanceModel.getModelStrList())? this.equipmentMaintenanceModel.getModelStrList(): new ArrayList<String>());
    	model.addAttribute("itemStrList", chkValidatedList(this.equipmentMaintenanceModel.getItemStrList())? this.equipmentMaintenanceModel.getItemStrList(): new ArrayList<String>());
        return "/Equipment/EquipmentMaintenance/update";
    }
    
    @GetMapping("/insert/{fshipno}")    
    // 初期表示処理(新規)
    private String inserGet(EquipmentMaintenanceForm equipmentMaintenanceForm, @PathVariable String fshipno, Model model) {
    	this.equipmentMaintenanceModel = new EquipmentMaintenanceModel();
    	this.equipmentMaintenanceModel.setShipInfo(equipmentMaintenanceService.getShipInfoByFShipNo(fshipno));
    	this.equipmentMaintenanceModel.setModelStrList(equipmentMaintenanceService.getModelStrList());
    	this.equipmentMaintenanceModel.setItemStrList(equipmentMaintenanceService.getItemStrList());
    	model.addAttribute("shipInfo", this.equipmentMaintenanceModel.getShipInfo() != null? this.equipmentMaintenanceModel.getShipInfo() : new ShipInfo());
    	model.addAttribute("modelStrList", chkValidatedList(this.equipmentMaintenanceModel.getModelStrList())? this.equipmentMaintenanceModel.getModelStrList(): new ArrayList<String>());
    	model.addAttribute("itemStrList", chkValidatedList(this.equipmentMaintenanceModel.getItemStrList())? this.equipmentMaintenanceModel.getItemStrList(): new ArrayList<String>());

    	
    	return "/Equipment/EquipmentMaintenance/insert";
    }
    
    @PostMapping("/save/{fshipno}")    
    // 登録処理（新規）
    private String savePost(EquipmentMaintenanceForm equipmentMaintenanceForm,  Model model, @PathVariable String fshipno) {
    	int newEquipmentID = equipmentMaintenanceService.getNewestEquipmentID() + 1;
    	// フィールド検証
    	List<String> errorMessageList = new ArrayList<String>();
    	
    	List<String> modelStrList = equipmentMaintenanceService.getModelStrList();
    	if (!equipmentMaintenanceForm.getModel().equals("") &&
    			!modelStrList.contains(equipmentMaintenanceForm.getModel())) {
        	model.addAttribute("shipInfo", this.equipmentMaintenanceModel.getShipInfo() != null? this.equipmentMaintenanceModel.getShipInfo() : new ShipInfo());
        	model.addAttribute("modelStrList", chkValidatedList(this.equipmentMaintenanceModel.getModelStrList())? this.equipmentMaintenanceModel.getModelStrList(): new ArrayList<String>());
        	model.addAttribute("itemStrList", chkValidatedList(this.equipmentMaintenanceModel.getItemStrList())? this.equipmentMaintenanceModel.getItemStrList(): new ArrayList<String>());
        	errorMessageList.add("modelStrError");
        	errorMessageList.add(messageSource.getMessage("message.w.0021", new String[] {"機種"}, Locale.JAPAN));
    	}
    	
    	List<String> itemStrList = equipmentMaintenanceService.getItemStrList();
    	List<ItemInfo> tarItemStrList = prepareItemInfoList(0,equipmentMaintenanceForm);
    	if (tarItemStrList.stream().filter(el -> !(el.getItem() == null || el.getItem().equals(""))).count() > 0 &&
    			tarItemStrList.stream().filter(el -> itemStrList.contains(el.getItem())).count() == 0) {
        	model.addAttribute("shipInfo", this.equipmentMaintenanceModel.getShipInfo() != null? this.equipmentMaintenanceModel.getShipInfo() : new ShipInfo());
        	model.addAttribute("modelStrList", chkValidatedList(this.equipmentMaintenanceModel.getModelStrList())? this.equipmentMaintenanceModel.getModelStrList(): new ArrayList<String>());
        	model.addAttribute("itemStrList", chkValidatedList(this.equipmentMaintenanceModel.getItemStrList())? this.equipmentMaintenanceModel.getItemStrList(): new ArrayList<String>());
        	errorMessageList.add(messageSource.getMessage("message.w.0021", new String[] {"品目"}, Locale.JAPAN));
    	}
    	
    	if (errorMessageList.size() > 0) {
        	model.addAttribute("errorMessageList",errorMessageList);
            return "/Equipment/EquipmentMaintenance/insert";
    	}

    	EquipmentInfo equipmentInfo = prepareEquipmentInfo(newEquipmentID, fshipno, equipmentMaintenanceForm);
    	if (equipmentInfo != null) {
    		equipmentMaintenanceService.insertEquipmentInfo(equipmentInfo);
    	}
    	
    	List<ItemInfo> itemInfoList = prepareItemInfoList(newEquipmentID, equipmentMaintenanceForm);
    	if (itemInfoList.size() > 0) {
    		equipmentMaintenanceService.insertBulkItemInfoList(itemInfoList);
    	}
    	
    	List<ProgramInfo> programInfoList = prepareProgramInfoList(newEquipmentID, equipmentMaintenanceForm);
    	if (programInfoList.size() > 0) {
    		equipmentMaintenanceService.insertBulkProgramInfoList(programInfoList);
    	}
    	
    	List<ConsumablePartsInfo> consumablePartsInfoList = prepareConsumablePartsInfoList(newEquipmentID, equipmentMaintenanceForm);
    	if (consumablePartsInfoList.size() > 0) {
    		equipmentMaintenanceService.insertBulkConsumablePartsInfoList(consumablePartsInfoList);
    	}
    	
        return "redirect:/Equipment/EquipmentList/index/" + fshipno;
    }
    
    @PostMapping("/commit")    
    // 登録処理（更新）
    private String commitPost(EquipmentMaintenanceForm equipmentMaintenanceForm,Model model) {
    	
    	//int newEquipmentID = equipmentMaintenanceService.getNewestEquipmentID() + 1;
    	int equipmentID = Integer.parseInt(equipmentMaintenanceForm.getEquipmentid());
    	String fshipno = this.equipmentMaintenanceModel.getShipInfo().getFShipno();
    	
    	EquipmentInfo equipmentInfo = prepareEquipmentInfo(equipmentID, fshipno, equipmentMaintenanceForm);
    	List<ItemInfo> itemInfoList = prepareItemInfoList(equipmentID,equipmentMaintenanceForm);
    	List<ProgramInfo> programInfoList = prepareProgramInfoList(equipmentID,equipmentMaintenanceForm);
    	List<ConsumablePartsInfo> consumablePartsInfoList = prepareConsumablePartsInfoList(equipmentID,equipmentMaintenanceForm);
    	List<String> itemStrList = equipmentMaintenanceService.getItemStrList();
    	List<String> modelStrList = equipmentMaintenanceService.getModelStrList();
    	
    	// フィールド検証
    	List<String> errorMessageList = new ArrayList<String>();
    	
    	if (!equipmentMaintenanceForm.getModel().equals("") &&
    			!modelStrList.contains(equipmentMaintenanceForm.getModel())) {
        	model.addAttribute("shipInfo", this.equipmentMaintenanceModel.getShipInfo() != null? this.equipmentMaintenanceModel.getShipInfo() : new ShipInfo());
        	model.addAttribute("equipmentInfo", equipmentInfo != null ? equipmentInfo: new EquipmentInfo() );
        	model.addAttribute("itemInfoList", chkValidatedList(itemInfoList) ? itemInfoList: new ArrayList<ItemInfo>());
        	model.addAttribute("programInfoList", chkValidatedList(programInfoList)? programInfoList: new ArrayList<ProgramInfo>());
        	model.addAttribute("consumablepartsInfoList", chkValidatedList(consumablePartsInfoList)? consumablePartsInfoList: new ArrayList<ConsumablePartsInfo>());
        	model.addAttribute("modelStrList", chkValidatedList(modelStrList)? modelStrList: new ArrayList<String>());
        	model.addAttribute("itemStrList", chkValidatedList(itemStrList)? itemStrList: new ArrayList<String>());
        	errorMessageList.add(messageSource.getMessage("message.w.0021", new String[] {"機種"}, Locale.JAPAN));
        	
        	
    	}
    	
    	
    	List<ItemInfo> tarItemStrList = prepareItemInfoList(0,equipmentMaintenanceForm);
    	if (tarItemStrList.stream().filter(el -> !(el.getItem() == null || el.getItem().equals(""))).count() > 0 &&
    			tarItemStrList.stream().filter(el -> itemStrList.contains(el.getItem())).count() == 0) {
        	model.addAttribute("shipInfo", this.equipmentMaintenanceModel.getShipInfo() != null? this.equipmentMaintenanceModel.getShipInfo() : new ShipInfo());
        	model.addAttribute("equipmentInfo", equipmentInfo != null ? equipmentInfo: new EquipmentInfo() );
        	model.addAttribute("itemInfoList", chkValidatedList(itemInfoList) ? itemInfoList: new ArrayList<ItemInfo>());
        	model.addAttribute("programInfoList", chkValidatedList(programInfoList)? programInfoList: new ArrayList<ProgramInfo>());
        	model.addAttribute("consumablepartsInfoList", chkValidatedList(consumablePartsInfoList)? consumablePartsInfoList: new ArrayList<ConsumablePartsInfo>());
        	model.addAttribute("modelStrList", chkValidatedList(modelStrList)? modelStrList: new ArrayList<String>());
        	model.addAttribute("itemStrList", chkValidatedList(itemStrList)? itemStrList: new ArrayList<String>());
        	errorMessageList.add(messageSource.getMessage("message.w.0021",new String[] {"品目"}, Locale.JAPAN));
    	}
    	
    	if (errorMessageList.size() > 0) {
        	model.addAttribute("errorMessageList",errorMessageList);
            return "/Equipment/EquipmentMaintenance/update";
    	}
    	
    	if (equipmentInfo != null) {
    		equipmentMaintenanceService.updateEquipmentInfo(equipmentInfo);
    	}
    	
    	if (itemInfoList.size() > 0) {
    		int existedRowNo = equipmentMaintenanceService.getNewestItemRowNo();
    		List<ItemInfo> updateList = itemInfoList.subList(0, existedRowNo);
    		equipmentMaintenanceService.updateBulkItemInfoList(updateList);
    		List<ItemInfo> insertList = itemInfoList.subList(existedRowNo, itemInfoList.size());
    		equipmentMaintenanceService.insertBulkItemInfoList(insertList);
    	}
    	
    	if (programInfoList.size() > 0) {
    		int existedRowNo = equipmentMaintenanceService.getNewestProgramRowNo();
    		List<ProgramInfo> updateList = programInfoList.subList(0, existedRowNo);
    		equipmentMaintenanceService.updateBulkProgramInfoList(updateList);
    		List<ProgramInfo> insertList = programInfoList.subList(existedRowNo, programInfoList.size());
    		equipmentMaintenanceService.insertBulkProgramInfoList(insertList);
    	}
    	
    	if (consumablePartsInfoList.size() > 0) {
    		int existedRowNo = equipmentMaintenanceService.getNewestConsumablePartsRowNo();
    		List<ConsumablePartsInfo> updateList = consumablePartsInfoList.subList(0, existedRowNo);
    		equipmentMaintenanceService.updateBulkConsumablePartsInfoList(updateList);
    		List<ConsumablePartsInfo> insertList = consumablePartsInfoList.subList(existedRowNo, consumablePartsInfoList.size());
    		equipmentMaintenanceService.insertBulkConsumablePartsInfoList(insertList);
    	}

    	return "redirect:/Equipment/EquipmentList/index/" + fshipno;
    }
    
    @PostMapping("/delete/{equipmentid}")    
    // 登録処理（削除）
    private String deletePost(EquipmentMaintenanceForm equipmentMaintenanceForm, @PathVariable int equipmentid, Model model) {
    	equipmentMaintenanceService.updateDeleteEquipmentInfo(equipmentid);
    	equipmentMaintenanceService.updateDeleteItemInfo(equipmentid);
    	equipmentMaintenanceService.deleteProgramInfo(equipmentid);
    	equipmentMaintenanceService.deleteProgramInfo(equipmentid);

    	return "redirect:/Ship/ShipSearch/research";
    }

    
    // formから装備情報のエンティティに詰め替え
	public EquipmentInfo prepareEquipmentInfo(int equipmentID, String fShipno, EquipmentMaintenanceForm equipmentMaintenanceForm) {
		
		// 装備情報
		EquipmentInfo equipmentInfo = new EquipmentInfo();
		equipmentInfo.setFshipno(fShipno); // F-ShipNo
		equipmentInfo.setEquipmentid(equipmentID);	//装備ID
		if ((equipmentMaintenanceForm.getModel() != null && !equipmentMaintenanceForm.getModel().equals(""))
				|| (equipmentMaintenanceForm.getIdentificationcode() != null && !equipmentMaintenanceForm.getIdentificationcode().equals(""))
				|| (equipmentMaintenanceForm.getIdentificationname() != null && !equipmentMaintenanceForm.getIdentificationname().equals(""))
				|| (equipmentMaintenanceForm.getShippingdate() != null && !equipmentMaintenanceForm.getShippingdate().equals(""))
				|| (equipmentMaintenanceForm.getEquipmentdateFleet() != null && !equipmentMaintenanceForm.getEquipmentdateFleet().equals(""))
				|| (equipmentMaintenanceForm.getEquipmentdate() != null && !equipmentMaintenanceForm.getEquipmentdate().equals(""))
				|| (equipmentMaintenanceForm.getEquipmentremovedate() != null && !equipmentMaintenanceForm.getEquipmentremovedate().equals(""))
				|| (equipmentMaintenanceForm.getShiprecycle() != null && !equipmentMaintenanceForm.getShiprecycle().equals(""))
				|| (equipmentMaintenanceForm.getEquipmentstatuskbn() != null && !equipmentMaintenanceForm.getEquipmentstatuskbn().equals(""))
				|| (equipmentMaintenanceForm.getSalesjurisdict() != null && !equipmentMaintenanceForm.getSalesjurisdict().equals(""))
				|| (equipmentMaintenanceForm.getRemarks() != null && !equipmentMaintenanceForm.getRemarks().equals(""))
				|| (equipmentMaintenanceForm.getWarrantydate() != null && !equipmentMaintenanceForm.getWarrantydate().equals(""))
				|| (equipmentMaintenanceForm.getShipyardwarrantydate() != null && !equipmentMaintenanceForm.getShipyardwarrantydate().equals(""))) {
			equipmentInfo.setStatus(equipmentMaintenanceForm.getStatus());	//ステータス
			equipmentInfo.setModel(equipmentMaintenanceForm.getModel());	// 機種	
			equipmentInfo.setIdentificationcode(equipmentMaintenanceForm.getIdentificationcode());	// 識別コード
			equipmentInfo.setIdentificationname(equipmentMaintenanceForm.getIdentificationname());	// 識別名
			equipmentInfo.setShippingdate(isLocalDate(equipmentMaintenanceForm.getShippingdate())?  LocalDate.parse(equipmentMaintenanceForm.getShippingdate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")): null);	// 出荷日
			equipmentInfo.setEquipmentdateFleet(isLocalDate(equipmentMaintenanceForm.getEquipmentdateFleet())? LocalDate.parse(equipmentMaintenanceForm.getEquipmentdateFleet(), DateTimeFormatter.ofPattern("yyyy-MM-dd")): null);	// 出荷日（Fleet）
			equipmentInfo.setEquipmentdate(isLocalDate(equipmentMaintenanceForm.getEquipmentdate())? LocalDate.parse(equipmentMaintenanceForm.getEquipmentdate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")): null);	// 装備日
			equipmentInfo.setEquipmentremovedate(isLocalDate(equipmentMaintenanceForm.getEquipmentremovedate())? LocalDate.parse(equipmentMaintenanceForm.getEquipmentremovedate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")): null);	// 装備外し日
			equipmentInfo.setShiprecycle(equipmentMaintenanceForm.getShiprecycle());	// シップリサイクル
			equipmentInfo.setEquipmentstatuskbn(equipmentMaintenanceForm.getEquipmentstatuskbn());	// 装備ステータス
			equipmentInfo.setSalesjurisdict(equipmentMaintenanceForm.getSalesjurisdict());	// 販売所管
			equipmentInfo.setRemarks(equipmentMaintenanceForm.getRemarks());	// 備考
			equipmentInfo.setWarrantydate(isLocalDate(equipmentMaintenanceForm.getWarrantydate())? LocalDate.parse(equipmentMaintenanceForm.getWarrantydate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")): null);	// 全保証期限
			equipmentInfo.setShipyardwarrantydate(isLocalDate(equipmentMaintenanceForm.getShipyardwarrantydate())? LocalDate.parse(equipmentMaintenanceForm.getShipyardwarrantydate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")): null);	// 造船所保証期限
			equipmentInfo.setSmskeyno(equipmentMaintenanceForm.getSmskeyno());	// SMSキーNo
			equipmentInfo.setProjectmodelid(equipmentMaintenanceForm.getProjectmodelid());	// 案件機種ID
			equipmentInfo.setSaporderno(equipmentMaintenanceForm.getSaporderno());	// 受注伝票番号
			equipmentInfo.setSaporderlineno(equipmentMaintenanceForm.getSaporderlineno());	// 受注伝票明細番号
		}
		return equipmentInfo;
	}
	
	// formから品目情報のエンティティに詰め替え
	public List<ItemInfo> prepareItemInfoList(int equipmentID, EquipmentMaintenanceForm equipmentMaintenanceForm) {
		 // 品目情報リスト
		 List<ItemInfo> itemInfoList = new ArrayList<ItemInfo>();
		 List<List<String>> itemInfoElList = makeDataList(new ArrayList<String>(Arrays.asList(
				 equipmentMaintenanceForm.getIStatus(), 		// ステータス:0
				 equipmentMaintenanceForm.getSortno(),		// 表示順:1
				 equipmentMaintenanceForm.getItem(),			// 品目:2
				 equipmentMaintenanceForm.getMachinenum(),	// 機番:3
				 equipmentMaintenanceForm.getQuantity()		// 数量:4
				 )));
		 for (int i = 0; i < itemInfoElList.size(); i++) {
			 List<String> elList = itemInfoElList.get(i);
			 if (elList.stream().filter(el -> !(el == null || el.equals(""))).count() == 0) {
				 continue;
			 }
			 ItemInfo itemInfo = new ItemInfo();
			 itemInfo.setEquipmentid(equipmentID);	// 装備ID
			 itemInfo.setIRowno(i + 1);             // 枝番
			 itemInfo.setIStatus(elList.get(0));	// ステータス
			 itemInfo.setSortno(isInt(elList.get(1))? Integer.parseInt(elList.get(1)): null);	// 表示順
			 itemInfo.setItem(elList.get(2));	// 品目
			 itemInfo.setIMachinenum(elList.get(3));	// 機番
			 itemInfo.setQuantity(isInt(elList.get(4))? Integer.parseInt(elList.get(4)): null);	//数量
			 itemInfoList.add(itemInfo);
		 }
		 return itemInfoList;
	}
	
	// formからプログラム情報のエンティティに詰め替え
	public List<ProgramInfo> prepareProgramInfoList(int equipmentID, EquipmentMaintenanceForm equipmentMaintenanceForm) {
		 // プログラム情報リスト
		 List<ProgramInfo> programInfoList = new ArrayList<ProgramInfo>();
		 List<List<String>> programInfoElList = makeDataList(new ArrayList<String>(Arrays.asList(
				 equipmentMaintenanceForm.getIndividualsupport(),// 個別対応ソフト:0
				 equipmentMaintenanceForm.getBase(),				// 基盤:1
				 equipmentMaintenanceForm.getProgramno(),		// プログラム番号:2
				 equipmentMaintenanceForm.getPRemarks()			// 備考:3
				 )));
		 for (int i = 0; i < programInfoElList.size(); i++) {
			 List<String> elList = programInfoElList.get(i);	
			 if (elList.stream().filter(el -> !(el == null || el.equals(""))).count() == 0) {
				 continue;
			 }
			 ProgramInfo programInfo = new ProgramInfo();		
			 programInfo.setEquipmentid(equipmentID);	// 装備ID
			 programInfo.setPRowno(i + 1);              // 枝番
			 programInfo.setIndividualsupport(elList.get(0));	// 個別対応ソフト
			 programInfo.setBase(elList.get(1));	// 基盤
			 programInfo.setProgramno(elList.get(2));	// プログラム番号
			 programInfo.setPRemarks(elList.get(3));	//備考
			 programInfoList.add(programInfo);
		 }
		 return programInfoList;
	}
	
	// formから消耗部品情報のエンティティに詰め替え
	public List<ConsumablePartsInfo> prepareConsumablePartsInfoList(int equipmentID, EquipmentMaintenanceForm equipmentMaintenanceForm) {
		 // 消耗部品情報リスト
		 List<ConsumablePartsInfo> consumablePartsInfoList = new ArrayList<ConsumablePartsInfo>();
		 List<List<String>> consumablePartsInfoElList = makeDataList(new ArrayList<String>(Arrays.asList(
				 equipmentMaintenanceForm.getPartsname(),// 部品名称:0
				 equipmentMaintenanceForm.getMandatoryparts(),	// 法廷義務品:1
				 equipmentMaintenanceForm.getExchangecycle(),	// 交換周期:2
				 equipmentMaintenanceForm.getExpecteddate()		// 交換予定日:3
				 )));
		 
		 for (int i = 0; i < consumablePartsInfoElList.size(); i++) {
			 List<String> elList = consumablePartsInfoElList.get(i);
			 if (elList.stream().filter(el -> !(el == null || el.equals(""))).count() == 0) {
				 continue;
			 }
			 ConsumablePartsInfo consumablePartsInfo = new ConsumablePartsInfo();
			 consumablePartsInfo.setEquipmentid(equipmentID);	// 装備ID
			 consumablePartsInfo.setCRowno(i + 1);              // 枝番
			 consumablePartsInfo.setPartsnamejp(elList.get(0));	// 部品名称
			 consumablePartsInfo.setMandatoryparts(elList.get(1));	// 法廷義務品
			 consumablePartsInfo.setExchangecycle(isInt(elList.get(2))? Integer.parseInt(elList.get(2)): null);	// 交換周期
			 consumablePartsInfo.setExpecteddate(isLocalDate(elList.get(3))? LocalDate.parse(elList.get(3), DateTimeFormatter.ofPattern("yyyy-MM-dd")): null);	//交換予定日
			 consumablePartsInfoList.add(consumablePartsInfo);
		 }
		 return consumablePartsInfoList;
	}
	
	// HTMLから取得したデータがint型に変更できるかを確認
	private boolean isInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	// HTMLから取得したデータがLocalDate型に変更できるかを確認
	private boolean isLocalDate(String str) {
		try {
			LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	// HTMLから取得したカンマ区切りのデータをリスト化し、レコード単位の配列を作成
	private List<List<String>> makeDataList(List<String> params) {
		List<String[]> paramsList = new ArrayList<>();
		for (String param: params) {
			String[] paramArray = param != null ? param.split(","): new String[0];
			paramsList.add(paramArray);
		}
		
		List<List<String>> resultList = new ArrayList<>();		
		for (int i = 0; i < paramsList.stream().map(el -> el.length).max(Comparator.naturalOrder()).orElse(0); i++) {
			List<String> paramList = new ArrayList<>();
			for (String[] arr: paramsList) {
				if (arr.length > i) {
					paramList.add(arr[i]);
				} else {
					paramList.add("");
				}
				
			}
			resultList.add(paramList);
		}
		
		return resultList;
	}
	
	private boolean chkValidatedList(List<?> list) {
		if (list != null && list.size() > 0) {
			if (!(list.size() == 1 && list.get(0) == null)) {
				return true;
			}
		}
		return false;
		
	}
}