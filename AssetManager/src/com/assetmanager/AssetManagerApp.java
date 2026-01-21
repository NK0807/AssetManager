package com.assetmanager;

public class AssetManagerApp {
	public static void main(String[] args) {
		// 動作確認用
		System.out.println("資産アプリを起動します。");
		
		// サービスとスキャナーを用意する
		AssetService service = new AssetService();
		ConsoleUI ui = new ConsoleUI();

		while(true){
			// メニュー表示
			int choice = ui.showMenu();

			// 選ばれた番号によって処理を決める
			switch(choice){
				case 1:	// 登録
					// 入力処理
					Asset newAsset = ui.askUserForAsset();

					// 登録処理
					if(newAsset != null){
						//入力された情報でAssetを作成して登録
						service.addAsset(newAsset);
						System.out.println(">> " + newAsset.getName() + "を登録しました！");
					}
					break;
				case 2:	// 一覧表示
					ui.showAssetList(service.getAssetList(), service.getTotalBalance());
					break;
				case 9:	// 終了
					System.out.println("システムを終了します。お疲れさまでした！");
					ui.close();
					return;
				default:
					System.out.println(">> 1, 2, 9 のどれかを入力してください。");
					break;
			}
		}
	}
}
