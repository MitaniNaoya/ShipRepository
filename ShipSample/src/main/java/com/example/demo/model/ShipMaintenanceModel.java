package com.example.demo.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ShipMaintenanceModel {
	private String fShipNo;                           // F-ShipNo
	private String status;                            // ステータス
	private int projectNo;                            // 案件No
	private String smsKeyNo;                          // SMSキーNo
	private String torishinNo;                        // 取申No
	private String remarks;                           // 備考
	private String imoNo;                             // IMONo
	private String shipStatus;                        // 船ステータス
	private String shipType;                          // 船舶タイプ
	private String shipyardNameJP;                    // 造船所名_和
	private String shipyardNameEN;                    // 造船所名称_英
	private String shipNumber;                        // 船番
	private String shipNameJP;                        // 船名_和
	private String series;                            // シリーズ
	private String shipNameEN;                        // 船名_英
	private String shipNameEN2;                       // 船名_英2
	private String shipSpeciesNameJP;                 // 船種名_和
	private String shipSpeciesSeaWeb;                 // 船種コード(Seaweb)
	private String shipClass;                         // 船級
	private String shipClassF;                        // 船級フル
	private String shipClassM;                        // 船級ミドル
	private String countryCode;                       // 国コード
	private String grossTonnage;                      // 重量（gt）
	private LocalDate buildDate;                  // 建造年月日
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
	private LocalDate updDate;                    // 更新日
	private String groupBeneficialOwnerBK;            // グループ実質オーナー_前回
	private String shipManager;                       // 船管理者
	private String shipManagerBK;                     // 船管理者_前回
	private String registeredOwner;                   // 登録オーナー
	private String registeredOwnerBK;                 // 登録オーナー_前回
	private String docCompany;                        // DOC記載会社
	private String docCompanyBK;                      // DOC記載会社_前回
	private String technicalManager;                  // 技術管理者
	private String technicalManagerBK;                // 技術管理者_前回
	private String operator;                          // 運航者
	private String operatorBK;                        // 運航者_前回
	private String ownerCustomerManual;               // 船主(マニュアル入力)
	private LocalDate ownerCustomerLastUpdDate;   // 船管最終更新日
	private String ownerCustomerManualBK;             // 船主(マニュアル入力)_前回
	private String ownerManagementManual;             // 管理会社(マニュアル入力)
	private LocalDate ownerManagementLastUpdDate; // 管理会社最終更新日
	private String ownerManagementManualBK;           // 管理会社(マニュアル入力)_前回
}
