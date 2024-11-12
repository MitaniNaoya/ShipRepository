package com.example.demo.Ship.ShipMaintenance.form;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ShipMaintenanceForm {
	private String status;                            // ステータス
	private String remarks;                           // 備考
	private String imoNo;                             // IMONo
	private String shipType;                          // 船舶タイプ
	private String shipyardNameJP;                    // 造船所名_和
	private String shipyardNameEN;                    // 造船所名称_英
	private String shipNumber;                        // 船番
	private String shipNameJP;                        // 船名_和
	private String series;                            // シリーズ
	private String shipNameEN;                        // 船名_英
	private String shipSpeciesNameJP;                 // 船種名_和
	private String shipClass;                         // 船級
	private String shipClassF;                        // 船級フル
	private String shipClassM;                        // 船級ミドル
	private String countryCode;                       // 国コード
	private String grossTonnage;                      // 重量（gt）
	private LocalDateTime buildDate;                  // 建造年月日
	private String registrationNo;                    // 登録番号
	private String fishingRegistrationNo;             // 漁船登録番号
	private String licenseNo;                         // 免許番号
	private String teu;                               // TEU
	private String mainPowerSupply;                   // メイン電源
	private String customerCode;                      // 顧客コード
	private String managementOfficeCode;              // 管理会社コード
	private String contactCode;                       // コンタクト先コード
	private String groupCode;                         // グループコード
	private String furunoResCompany;                  // フルノ担当会社
	private String groupBeneficialOwner;              // グループ実質オーナー
	private String shipManager;                       // 船管理者
	private String registeredOwner;                   // 登録オーナー
	private String docCompany;                        // DOC記載会社
	private String technicalManager;                  // 技術管理者
	private String operator;                          // 運航者
	private String ownerCustomerManual;               // 船主(マニュアル入力)
	private String ownerManagementManual;             // 管理会社(マニュアル入力)
	      // private String 不明;                     // 船主／管理会社-船主
	      // private String 不明;                     // 船主／管理会社-管理会社
	      // private String 不明;                     // フルノ管理会社-船主
	      // private String 不明;                     // フルノ管理会社-管理会社
	
	/* 使用しない想定
	private LocalDateTime deliveryDate;               // 引渡年月日
	private LocalDateTime shipyardWarrantyDate;       // 造船所保証期限
	private LocalDateTime allWarrantyDate;            // 全保証期限
	private String mmsi;                              // MMSI
	private String callSign;                          // CALL Sign
	private String inmarsatTEL;                       // インマルサットTEL
	private String inmarsatTEL2;                      // インマルサットTEL2
	private String inmarsatFAX;                       // インマルサットFAX
	private String inmarsatFAX2;                      // インマルサットFAX2
	private String inmarsatEmail;                     // インマルサットEmail
	private String inmarsatEmail2;                    // インマルサットEmail2
	private String inmarsatCTEL;                      // インマルサットCTEL
	private String inmarsatCTEL2;                     // インマルサットCTEL2
	private String inmarsatCFAX;                      // インマルサットCFAX
	private String inmarsatCFAX2;                     // インマルサットCFAX2
	private String inmarsatCEmail;                    // インマルサットCEmail
	private String inmarsatCEmail2;                   // インマルサットCEmail2
	private String shipTEL;                           // 船舶電話
	private String shipTEL2;                          // 船舶電話2
	private String rmsCode;                           // RMSコード
	*/
}
