package com.example.demo.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EquipmentListModel {
	private String fShipNo;                     // F-ShipNo
	private String imoNo;                       // IMONo
	private String shipType;                    // 船舶タイプ
	private String shipyardCode;                // 造船所コード
	private String shipyardNameJP;              // 造船所名_和
	private String shipNumber;                  // 船番
	private String shipNameJP;                  // 船名_和
	private String series;                      // シリーズ
	private String shipSpecies;                 // 船種コード
	private String shipSpeciesNameJP;           // 船種名_和
	private String shipClass;                   // 船級
	private String shipNationality;             // 船籍（国コード）
	private String countryNameJP;               // 国名_和
	private int grossTonnage;                   // 重量（gt）
	private LocalDateTime buildDate;            // 建造年月日
	private String customerCode;                // 顧客コード
	private String customerNameJP;              // 顧客名_和
	private String status;                      // ステータス
	private String modelCode;                   // 機種コード
	private String modelNameJP;                 // 機種名_和
	private String identificationNameJP;        // 識別_和
	private String identificationName;          // 識別名
	private String machineNum;                  // 機番
	private LocalDateTime shippingDate;         // 出荷日
	private LocalDateTime equipmentDate;        // 装備日
	private String salesJurisdict;              // 販売所管
	private LocalDateTime shipyardWarrantyDate; // 造船所保証
	private LocalDateTime warrantyDate;         // 保証期限
	private String remarks;                     // 備考
}
