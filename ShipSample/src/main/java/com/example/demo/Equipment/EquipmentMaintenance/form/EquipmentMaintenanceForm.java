package com.example.demo.Equipment.EquipmentMaintenance.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.example.demo.model.ConsumablePartsInfo;
import com.example.demo.model.EquipmentInfo;
import com.example.demo.model.ItemInfo;
import com.example.demo.model.ProgramInfo;

import lombok.Data;

@Data
public class EquipmentMaintenanceForm {
	// 装備情報
	private EquipmentInfo equipmentInfo;
	private String model; //機種
	private String identificationcode; // 識別コード
	private String identificationname; // 識別名
	private String shippingdate; // 出荷日(HTMLから取得)
	private String equipmentdateFleet; // 出荷日（Fleet）(HTMLから取得)
	private String equipmentdate; // 装備日(HTMLから取得)
	private String equipmentremovedate; // 装備外し日(HTMLから取得)
	private String shiprecycle; // シップリサイクル
	private String equipmentstatuskbn; // 装備ステータス
	private String salesjurisdict; // 販売所管
	private String remarks; // 備考
	private String warrantydate; // 全保証期限(HTMLから取得)(HTMLから取得)
	private String shipyardwarrantydate; // 造船所保証期限(HTMLから取得)

	// 品目情報リスト
	private List<ItemInfo> itemInfoList;
	private String iStatus; // ステータス	
	private String sortno; // 表示順序(HTMLから取得)
	private String item; // 品目
	private String machinenum; // 機番
	private String quantity; // 数量(HTMLから取得)

	// プログラム情報リスト
	private List<ProgramInfo> programInfoList;
	private String individualsupport; // 個別対応ソフト
	private String base; // 基盤
	private String programno; // プログラム番号
	private String pRemarks; // 備考

	// 消耗部品情報リスト
	private List<ConsumablePartsInfo> consumablePartsInfoList;
	private String partsname; // 部品名称
	private String mandatoryparts; // 法廷義務品
	private String exchangecycle; // 交換周期(HTMLから取得)
	private String expecteddate; // 交換予定日(HTMLから取得)
	
	public void prepareDBDatas(int equipmentID) {
		
		// 装備情報
		this.equipmentInfo = new EquipmentInfo();
		if ((this.model != null && !this.model.equals(""))
				|| (this.identificationcode != null && !this.identificationcode.equals(""))
				|| (this.identificationname != null && !this.identificationname.equals(""))
				|| (this.shippingdate != null && !this.shippingdate.equals(""))
				|| (this.equipmentdateFleet != null && !this.equipmentdateFleet.equals(""))
				|| (this.equipmentdate != null && !this.equipmentdate.equals(""))
				|| (this.equipmentremovedate != null && !this.equipmentremovedate.equals(""))
				|| (this.shiprecycle != null && !this.shiprecycle.equals(""))
				|| (this.equipmentstatuskbn != null && !this.equipmentstatuskbn.equals(""))
				|| (this.salesjurisdict != null && !this.salesjurisdict.equals(""))
				|| (this.remarks != null && !this.remarks.equals(""))
				|| (this.warrantydate != null && !this.warrantydate.equals(""))
				|| (this.shipyardwarrantydate != null && !this.shipyardwarrantydate.equals(""))) {
			this.equipmentInfo.setEquipmentid(equipmentID);	//装備ID
			this.equipmentInfo.setModel(this.model);	// 機種		
			this.equipmentInfo.setIdentificationcode(this.identificationcode);	// 識別コード
			this.equipmentInfo.setIdentificationname(this.identificationname);	// 識別名
			this.equipmentInfo.setShippingdate(isLocalDate(this.shippingdate)?  LocalDate.parse(this.shippingdate, DateTimeFormatter.ofPattern("yyyy-MM-dd")): null);	// 出荷日
			this.equipmentInfo.setEquipmentdateFleet(isLocalDate(this.equipmentdateFleet)? LocalDate.parse(this.equipmentdateFleet, DateTimeFormatter.ofPattern("yyyy-MM-dd")): null);	// 出荷日（Fleet）
			this.equipmentInfo.setEquipmentdate(isLocalDate(this.equipmentdate)? LocalDate.parse(this.equipmentdate, DateTimeFormatter.ofPattern("yyyy-MM-dd")): null);	// 装備日
			this.equipmentInfo.setEquipmentremovedate(isLocalDate(this.equipmentremovedate)? LocalDate.parse(this.equipmentremovedate, DateTimeFormatter.ofPattern("yyyy-MM-dd")): null);	// 装備外し日
			this.equipmentInfo.setShiprecycle(this.shiprecycle);	// シップリサイクル
			this.equipmentInfo.setEquipmentstatuskbn(this.equipmentstatuskbn);	// 装備ステータス
			this.equipmentInfo.setSalesjurisdict(this.salesjurisdict);	// 販売所管
			this.equipmentInfo.setRemarks(this.remarks);	// 備考
			this.equipmentInfo.setWarrantydate(isLocalDate(this.warrantydate)? LocalDate.parse(this.warrantydate, DateTimeFormatter.ofPattern("yyyy-MM-dd")): null);	// 全保証期限
			this.equipmentInfo.setShipyardwarrantydate(isLocalDate(this.shipyardwarrantydate)? LocalDate.parse(this.shipyardwarrantydate, DateTimeFormatter.ofPattern("yyyy-MM-dd")): null);	// 造船所保証期限
		} else {
			this.equipmentInfo = null;
		}

		// 品目情報リスト
		this.itemInfoList = new ArrayList<ItemInfo>();
		 List<List<String>> itemInfoElList = makeDataList(new ArrayList<String>(Arrays.asList(
				 this.iStatus, 		// ステータス:0
				 this.sortno,		// 表示順:1
				 this.item,			// 品目:2
				 this.machinenum,	// 機番:3
				 this.quantity		// 数量:4
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
			 this.itemInfoList.add(itemInfo);
		 }
		
		 // プログラム情報リスト
		 this.programInfoList = new ArrayList<ProgramInfo>();
		 List<List<String>> programInfoElList = makeDataList(new ArrayList<String>(Arrays.asList(
				 this.individualsupport,// 個別対応ソフト:0
				 this.base,				// 基盤:1
				 this.programno,		// プログラム番号:2
				 this.pRemarks			// 備考:3
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
			 this.programInfoList.add(programInfo);
		 }

		 // 消耗部品情報リスト
		 this.consumablePartsInfoList = new ArrayList<ConsumablePartsInfo>();
		 List<List<String>> consumablePartsInfoElList = makeDataList(new ArrayList<String>(Arrays.asList(
				 this.partsname,// 部品名称:0
				 this.mandatoryparts,	// 法廷義務品:1
				 this.exchangecycle,	// 交換周期:2
				 this.expecteddate		// 交換予定日:3
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
			 this.consumablePartsInfoList.add(consumablePartsInfo);
		 }
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
			String[] paramArray = param.split(",");
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
}
