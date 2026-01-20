package com.assetmanager;

public class AssetManagerApp {
	public static void main(String[] args) {
		// 動作確認用
		System.out.println("資産アプリを起動します。");
		
		// Asset(資産)を生成
		Asset myMoney = new Asset("銀行A", 10000, "銀行");
		
		// 中身の確認
		System.out.println("名前：" + myMoney.getName());
		System.out.println("残高：" + myMoney.getBalance());
		System.out.println("種類：" + myMoney.getType());
	}
}
