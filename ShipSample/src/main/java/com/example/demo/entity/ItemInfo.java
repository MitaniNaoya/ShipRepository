package com.example.demo.entity;

import lombok.Data;

@Data
// 品目情報
public class ItemInfo {
	private Integer equipmentid;                  // 装備ID
	private Integer iRowno;                       // 行番号
	private Integer sortno;                       // 表示順序
	private String iStatus;                       // 品目ステータス
	private String item;                          // 品目
	private String itemTxtJ;                      // 品目名
	private String iMachinenum;                   // 機番
	private Integer quantity = null;                     // 数量
	private String sapshippingno;                 // 出荷伝票番号
	private String sapshippinglineno;             // 出荷伝票明細番号
	private String iSaporderno;                   // 受注伝票番号
	private String iSaporderlineno;               // 受注伝票明細番号
}
