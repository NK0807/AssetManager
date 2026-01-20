package com.assetmanager;

public class Asset {
	
	// データ
	private String name;	// 名前
	private int balance;	// 金額
	private String type;	// 種類(例：銀行、現金、投資)
	
	// コンストラクタ
	public Asset(String name, int balance, String type) {
		this.name = name;
		this.balance = balance;
		this.type = type;
	}
	
	// ゲッター
	public String getName() {
		return this.name;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public String getType() {
		return this.type;
	}
}
