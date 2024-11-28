package com.example.demo.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
// 船情報
public class ShipInfo {
	private String fShipno;                     // F-ShipNo
	private String imono;                       // IMONo
	private String shipnumber;                  // 船番
	private String shiptype;                    // 船舶タイプ
	private String shipnationality;             // 船籍
	private String shipspecies;                 // 船種
	private String shipnamejp;                  // 船名
	private String series;                      // シリーズ
	private Integer grosstonnage;               // 総トン数
	private String shipclass;                   // 船級
	private String shipyard;                    // 造船場
	private LocalDate builddate;                // 建造年月日
	private String customer;                    // 取引先

}
