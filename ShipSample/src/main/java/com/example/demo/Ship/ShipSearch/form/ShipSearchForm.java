package com.example.demo.Ship.ShipSearch.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ShipSearchForm {
	private String shipyardCdorNm; 	      // 造船所
	private String shipNumber;            // 船番
	private String customerCode; 	      // 取引先
	private String series;  	          // シリーズ
	private String shipNameJP;  	      // 船名
	private String managementOfficeCode;  // 船舶管理会社
	private String shipSpecies;  	      // 船種
	private String shipNationality;  	  // 船籍
	private String shipClass;  	          // 船級
	private int shipType;  	              // 船舶タイプ
	private int grossTonnageFrom;  	      // 重量 From
	private int grossTonnageTo;  	      // 重量 To
	private String imoNo;  	              // IMONo
	private LocalDate buildDateFrom;  	  // 建造年月日 From
	private LocalDate buildDateTo;  	  // 建造年月日 To
	private String fShipNo;  	          // F-ShipNo
	private int status;  	              // 論理削除表示 含
	private int ownerChangeKbn;       	  // オーナー変更 有

}
