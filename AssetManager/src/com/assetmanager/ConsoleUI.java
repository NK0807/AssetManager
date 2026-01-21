package com.assetmanager;

import java.util.Scanner;
import java.util.List;

public class ConsoleUI {
    private Scanner scanner;

    // コンストラクタ
    public ConsoleUI(){
        this.scanner = new Scanner(System.in);
    }

    public Asset askUserForAsset(){
        System.out.println("資産を登録しますか？（y：はい / n：いいえ）");
        String choice = scanner.nextLine();

        // "y"以外なら何もしない
        if(!choice.equals("y")){
            return null;
        }

        // 質問開始
        System.out.print("資産の名前を入力してください: ");
        String name = scanner.nextLine();

        System.out.print("金額を入力してください: ");
        int balance = Integer.parseInt(scanner.nextLine());

        System.out.print("種類を入力してください: ");
        String type = scanner.nextLine();

        // 集めたデータでAssetを作成し、呼び出し元に渡す
        return new Asset(name, balance, type);
    }

    public void showAssetList(List<Asset> assetList, int totalbalance){
        // 登録された資産を表示する
		System.out.println("----- 資産一覧 -----");
		for(Asset a : assetList){
			System.out.println(a.getName() + "：" + a.getBalance() + "円（" + a.getType() + "）");
		}

        
		// 合計金額を表示する
		System.out.println("-------------------");
		System.out.println("資産合計：" + totalbalance + "円");
    }

    // 後始末
    public void close() {
        scanner.close();
    }
}
