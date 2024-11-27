package com.example.demo.Equipment.EquipmentMaintenance.form;

import lombok.Data;

@Data
public class EquipmentMaintenanceForm {
	// 基本情報
	private String fShipno; // F-ShipNo
	private String imono; // IMONo
	private String shipnumber; // 船番
	private String shiptype; // 船舶タイプ
	private String shipnationality; // 船籍
	private String shipspecies; // 	船種
	private String shipnamejp; // 船名
	private String series; // シリーズ
	private String grosstonnage; // 総トン数
	private String shipclass; // 船級
	private String shipyard; // 造船所
	private String builddate; // 建造年月日
	private String customer; // 取引先
	
	// 装備情報
	private String equipmentid;	// 装備ID
	private String status; // ステータス
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
	private String smskeyno;	// SMSキーNo
	private String projectmodelid;	// 案件機種ID
	private String saporderno;	// 受注伝票番号
	private String saporderlineno;	// 受注伝票明細番号

	// 品目情報リスト
	private String iStatus; // ステータス	
	private String sortno; // 表示順序(HTMLから取得)
	private String item; // 品目
	private String machinenum; // 機番
	private String quantity; // 数量(HTMLから取得)

	// プログラム情報リスト
	private String individualsupport; // 個別対応ソフト
	private String base; // 基盤
	private String programno; // プログラム番号
	private String pRemarks; // 備考

	// 消耗部品情報リスト
	private String partsname; // 部品名称
	private String mandatoryparts; // 法廷義務品
	private String exchangecycle; // 交換周期(HTMLから取得)
	private String expecteddate; // 交換予定日(HTMLから取得)
}
