package com.assetmanager;

public class AssetManagerApp {
	public static void main(String[] args) {
		// 動作確認用
		System.out.println("資産アプリを起動します。");
		
		// サービスとスキャナーを用意する
		AssetService service = new AssetService();
		ConsoleUI ui = new ConsoleUI();

		// 入力処理
		Asset newAsset = ui.askUserForAsset();

		// 登録処理
		if(newAsset != null){
			//入力された情報でAssetを作成して登録
			service.addAsset(newAsset);
			System.out.println(">> " + newAsset.getName() + "を登録しました！");
		} else{
			System.out.println(">> 登録をスキップしました。");
		}

		// 表示処理
		ui.showAssetList(service.getAssetList(), service.getTotalBalance());

		// 後始末
        ui.close();
	}
}
