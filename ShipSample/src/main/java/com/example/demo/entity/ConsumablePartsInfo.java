package com.example.demo.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
// 消耗部品情報
public class ConsumablePartsInfo {
	private Integer equipmentid;                // 装備ID
	private Integer cRowno;                     // 消耗部品情報行数
	private String partsnamejp;                 // 部品名称_和
	private String mandatoryparts;              // 法定義務品
	private Integer exchangecycle;              // 交換周期
	private LocalDate expecteddate;             // 交換予定日
}
