package com.example.demo.Ship.ShipSearch.form;

import lombok.Data;

@Data
public class ShipSearchForm {
	private String shipyardcode; 	      // 造船所
	private String shipnumber;            // 船番
	private String customercode;   	      // 取引先
	private String series;  	          // シリーズ
	private String shipnamejp;     	      // 船名
	private String managementofficecode;  // 船舶管理会社
	private String shipspecies;  	      // 船種
	private String shipnationality;  	  // 船籍
	private String shipclass;  	          // 船級
	private String shiptype;  	          // 船舶タイプ
	private String grosstonnageFrom;      // 重量 From
	private String grosstonnageTo;	      // 重量 To
	private String imono;  	              // IMONo
	private String builddateFrom;    	  // 建造年月日 From
	private String builddateTo;  	      // 建造年月日 To
	private String fShipno;  	          // F-ShipNo
	private int logicalDelete;  	  // 論理削除表示 含
	private int ownerchangekbn;       // オーナー変更 有
}
