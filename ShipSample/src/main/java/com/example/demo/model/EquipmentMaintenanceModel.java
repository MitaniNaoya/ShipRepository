package com.example.demo.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EquipmentMaintenanceModel {
	private String fShipNo;                       // F-ShipNo
	private String imoNo;                         // IMONo
	private String shipType;                      // 船舶タイプ
	private String shipyardCode;                  // 造船所コード
	private String shipyardNameJP;                // 造船所名_和
	private String shipNumber;                    // 船番
	private String shipNameJP;                    // 船名_和
	private String series;                        // シリーズ
	private String shipSpecies;                   // 船種コード
	private String shipSpeciesNameJP;             // 船種名_和
	private String shipClass;                     // 船級
	private String shipNationality;               // 船籍（国コード）
	private String countryNameJP;                 // 国名_和
	private int grossTonnage;                     // 重量（gt）
	private LocalDateTime buildDate;              // 建造年月日
	private String customerCode;                  // 顧客コード
	private String customerNameJP;                // 顧客名_和
	private String status;                        // ステータス
	private int equipmentID;                      // 装備ID
	private String modelCode;                     // 機種コード
	private String modelNameJP;                   // 機種名_和
	private String identificationNameJP;          // 識別_和
	private String identificationName;            // 識別名
	private LocalDateTime shippingDate;           // 出荷日
	private LocalDateTime equipmentDate_Fleet;    // 出荷日（Fleet）
	private LocalDateTime equipmentDate;          // 装備日
	private LocalDateTime equipmentRemoveDate;    // 装備外し日
	private String shipRecycle;                   // シップリサイクル
	private String equipmentStatusKbn;            // 装備ステータス
	private String salesJurisdict;                // 販売所管
	private String equipmentemarks;               // 備考
	private LocalDateTime warrantyDate;           // 保証期限
	private LocalDateTime shipyardWarrantyDate;   // 造船所保証
	private String smsKeyNo;                      // SMSキーNo
	private String projectModelID;                // 案件機種ID
	private String sapOrderNo;                    // 受注伝票番号
	private String sapOrderLineNo;                // 受注伝票明細番号
	private int sortNo;                           // 表示順序
	private String itemStatus;                    // 品目ステータス
	//品目
	//品目名
	private String machineNum;                    //機番
	private int quantity;                         //数量
	private String sapShippingNo;                 //出荷伝票番号
	private String sapShippingLineNo;             //出荷伝票明細番号
	
	private String individualSupport;             // 個別対応ソフト
	private String base;                          // 基盤
	private String programNo;                     // プログラム番号
	private String programRemarks;                // 備考
	private String partsNameJP;                   // 部品名称_和
	private String mandatoryParts;                // 法定義務品
	private int exchangeCycle;                    // 交換周期
	private LocalDateTime expectedDate;           // 交換予定日
}
