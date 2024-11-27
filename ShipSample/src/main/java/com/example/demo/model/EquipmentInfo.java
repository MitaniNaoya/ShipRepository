package com.example.demo.model;

import java.time.LocalDate;

import lombok.Data;

@Data
// 装備情報
public class EquipmentInfo {
	private Integer equipmentid;                // 装備ID
	private String fshipno;                     // F-ShipNo
	private String status;                      // ステータス
	private String model;                       // 機種
	private String identification;              // 識別
	private String identificationcode;          // 識別コード
	private String identificationname;          // 識別名
	private String machinenum;                  // 機番
	private LocalDate shippingdate;             // 出荷日
	private LocalDate equipmentdateFleet;       // 出荷日（Fleet）
	private LocalDate equipmentdate;            // 装備日
	private LocalDate equipmentremovedate;      // 装備外し日
	private String shiprecycle;                 // シップリサイクル
	private String equipmentstatuskbn;          // 装備ステータス	
	private String salesjurisdict;              // 販売所管
	private LocalDate shipyardwarrantydate;     // 造船所保証
	private LocalDate warrantydate;             // 保証期限
	private String remarks;                     // 備考
	private String smskeyno;                    // SMSキーNo
	private String projectmodelid;              // 案件機種ID
	private String saporderno;                  // 受注伝票番号
	private String saporderlineno;              // 受注伝票明細番号

}
