package com.assetmanager;

import java.util.ArrayList;
import java.util.List;

public class AssetService {
    // 複数の資産を入れておくリスト
    private List<Asset> assetList = new ArrayList<>();

    // 資産を追加するメソッド
    public void addAsset(Asset asset){
        assetList.add(asset);
    }

    // 登録されている全ての資産の合計金額を計算するメソッド
    public int getTotalBalance(){
        int total = 0;

        // リストの中身を一つずつ取り出して計算
        for(Asset asset : assetList){
            total += asset.getBalance();
        }

        return total;
    }

    // 全ての資産リストを取得するメソッド
    public List<Asset> getAssetList(){
        return assetList;
    }

    // 指定された番号の資産をリストから削除する
    public void deleteAsset(int index){
        // 番号が正しいかチェック
        if(index >= 0 && index < assetList.size()){
            assetList.remove(index);
        } else{
            System.out.println("エラー：存在しない番号です。");
        }
    }
}
