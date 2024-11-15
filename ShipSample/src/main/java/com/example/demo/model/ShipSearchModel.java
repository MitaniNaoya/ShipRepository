package com.example.demo.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ShipSearchModel {
	private String status;                  // ステータス
	private String fShipno;                 // FShipNo
	private String shipyardnamejp;          // 造船所名_和
	private String shipnumber;              // 船番
	private String series;                  // シリーズ
	private String customernamejp;          // 顧客名_和
	private String shipnamejp;              // 船名_和
	private String shipnameen;              // 船名_英
	private String furunorescompany;        // 販売所管
	private String shipspeciesnamejpSeaweb; // 船種コード(SeaWeb)
	private String shipspeciesnamejp;       // 船種名_和
	private String shipclass;               // 船級
	private String imono;                   // IMONo
	private String updUser;                 // 更新者
	private LocalDate updDate;              // 更新日時
}
