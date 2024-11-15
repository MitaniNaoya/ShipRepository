package com.example.demo.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ShipInfo {
	private String fShipno;                     // F-ShipNo
	private String imono;                       // IMONo
	private String shipnumber;                  // 船番
	private String shiptype;                    // 船舶タイプ
	private String shipnationality;             // 船籍
	//private String shipNationality;             // 船籍（国コード）
	//private String countryNameJP;               // 国名_和
	private String shipspecies;                 // 船種
	//private String shipSpecies;                 // 船種コード
	//private String shipSpeciesNameJP;           // 船種名_和
	private String shipnamejp;                  // 船名
	private String series;                      // シリーズ
	private int grosstonnage;                   // 総トン数
	private String shipclass;                   // 船級
	private String shipyard;                    // 造船場
	//private String shipyardCode;                // 造船所コード
	//private String shipyardNameJP;              // 造船所名_和
	private LocalDate builddate;                // 建造年月日
	private String customer;                            // 取引先
	//private String customerCode;                // 顧客コード
	//private String customerNameJP;              // 顧客名_和

}
