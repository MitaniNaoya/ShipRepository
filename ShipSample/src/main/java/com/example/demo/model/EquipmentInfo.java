package com.example.demo.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EquipmentInfo {
	private int equipmentid;                    // 装備ID
	private String status;                      // ステータス
	private String model;                       // 機種
	//private String modelCode;                 // 機種コード
	//private String modelNameJP;               // 機種名_和
	private String identification;              // 識別
	//private String identificationNameJP;      // 識別_和
	//private String identificationName;        // 識別名
	private String machinenum;                  // 機番
	private LocalDate shippingdate;             // 出荷日
	private LocalDate equipmentdate;            // 装備日
	private String salesjurisdict;              // 販売所管
	private LocalDate shipyardwarrantydate;     // 造船所保証
	private LocalDate warrantydate;             // 保証期限
	private String remarks;                     // 備考

}
