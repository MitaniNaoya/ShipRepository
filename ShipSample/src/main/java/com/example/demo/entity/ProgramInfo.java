package com.example.demo.entity;

import lombok.Data;

@Data
//プログラム情報
public class ProgramInfo {
	private Integer equipmentid;                  // 装備ID
	private Integer pRowno;                       // プログラム情報行番号
	private String individualsupport;             // 個別対応ソフト
	private String base;                          // 基盤
	private String programno;                     // プログラム番号
	private String pRemarks;                      // 備考
}
