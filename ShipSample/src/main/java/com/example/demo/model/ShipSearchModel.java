package com.example.demo.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ShipSearchModel {
	private String status;            // ステータス
	private String fShipNo;           // FShipNo
	private String shipyardNameJP;    // 造船所名_和
	private String shipNumber;        // 船番
	private String series;            // シリーズ
	private String customerNameJP;    // 顧客名_和
	private String shipNameJp;        // 船名_和
	private String shipNameEn;        // 船名_英
	private String shipSpeciesSeaWeb; // 船種コード(SeaWeb)
	private String shipSpeciesNameJP; // 船種名_和
	private String shipClass;         // 船級
	private String imoNo;             // IMONo
	private String updUser;           // 更新者
	private LocalDateTime updDate;    // 更新日時
}
