package com.assetmanager;

public class AssetManagerApp {
	public static void main(String[] args) {
		// 動作確認用
		System.out.println("資産アプリを起動します。");
		
		// サービスを用意する
		AssetService service = new AssetService();

		// 資産を作って、サービスに登録する
		service.addAsset(new Asset("Java銀行", 50000, "銀行"));
		service.addAsset(new Asset("自分の財布", 3000, "現金"));
		service.addAsset(new Asset("へそくり", 10000, "現金"));

		// 登録された資産を表示する
		System.out.println("----- 資産一覧 -----");
		for(Asset a : service.getAssetList()){
			System.out.println(a.getName() + "：" + a.getBalance() + "円");
		}

		// 合計金額を表示する
		System.out.println("-------------------");
		System.out.println("資産合計：" + service.getTotalBalance() + "円");
	}
}
