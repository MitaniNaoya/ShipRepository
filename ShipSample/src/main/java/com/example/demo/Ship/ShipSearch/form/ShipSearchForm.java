package com.example.demo.Ship.ShipSearch.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	private String grosstonnageFrom;      // 重量 From(HTML取得内容)
	private String grosstonnageTo;	      // 重量 To(HTML取得内容)
	private int grossTonnageFromByInt;    // 重量 From
	private int grossTonnageToByInt;  	  // 重量 To
	private String imono;  	              // IMONo
	private String builddateFrom;  	      // 建造年月日 From(HTML取得内容)
	private String builddateTo;  	      // 建造年月日 To(HTML取得内容)
	private LocalDate buildDateFromByDate;// 建造年月日 From
	private LocalDate buildDateToByDate;  // 建造年月日 To
	private String fShipno;  	          // F-ShipNo
	private int logicalDelete;  	      // 論理削除表示 含
	private int ownerchangekbn;           // オーナー変更 有
	
	public void preparreDBSearchData() {
		// 重量 From(HTML取得内容)をint型に変更
		if (!(this.grosstonnageFrom == null || this.grosstonnageFrom.equals(""))) {
			for (char c: this.grosstonnageFrom.toCharArray()) {
				if (!Character.isDigit(c)) {
					this.grosstonnageFrom = "";
					break;
				}
			}
			this.grossTonnageFromByInt = Integer.parseInt(grosstonnageFrom);
		}
		// 重量 To(HTML取得内容)をint型に変更
		if (!(this.grosstonnageTo == null || this.grosstonnageTo.equals(""))) {
			for (char c: this.grosstonnageTo.toCharArray()) {
				if (!Character.isDigit(c)) {
					this.grosstonnageTo = "";
					break;
				}
			}
			this.grossTonnageToByInt = Integer.parseInt(grosstonnageTo);
		}
		// 建造年月日 From(HTML取得内容)をLocalDate型に変更
		this.buildDateFromByDate = (this.builddateFrom == null || this.builddateFrom.equals(""))
				? null
				: LocalDate.parse(this.builddateFrom, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		// 建造年月日 To(HTML取得内容)をLocalDate型に変更
		this.buildDateToByDate = (this.builddateTo == null || this.builddateTo.equals(""))
				? null
				: LocalDate.parse(this.builddateTo, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
}
