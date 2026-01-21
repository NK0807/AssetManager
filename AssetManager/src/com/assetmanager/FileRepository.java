package com.assetmanager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// データをファイル(CSV)に保存したり、読み込んだりするクラス
public class FileRepository {

    // 保存するファイルの名前
    private static final String FILE_NAME = "assets.csv";

    // リストの中身をファイルに保存する（書き込み）    
    public void saveToFile(List<Asset> assetList) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            
            for (Asset asset : assetList) {
                // 名前,金額,種類 の形式で1行ずつ書き込む
                writer.println(asset.getName() + "," + asset.getBalance() + "," + asset.getType());
            }
            System.out.println(">> データをファイルに保存しました。");
            
        } catch (IOException e) {
            System.out.println("エラー：ファイルの保存に失敗しました。" + e.getMessage());
        }
    }

    // ファイルからデータを読み込んでリストにする（読み込み）
    public List<Asset> loadFromFile() {
        List<Asset> loadedList = new ArrayList<>();
        File file = new File(FILE_NAME);

        // ファイルがまだ無ければ、空っぽのリストを返す
        if (!file.exists()) {
            return loadedList; 
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            // 1行ずつ読み込む
            while ((line = reader.readLine()) != null) {
                // "銀行A,1000,銀行" をカンマ(,)で3つに分解する
                String[] parts = line.split(",");
                
                // データが壊れていないかチェック（ちゃんと3つあるか？）
                if (parts.length == 3) {
                    String name = parts[0];
                    int balance = Integer.parseInt(parts[1]); // 数字に直す
                    String type = parts[2];
                    
                    // Assetを作ってリストに追加
                    loadedList.add(new Asset(name, balance, type));
                }
            }
            System.out.println(">> ファイルからデータを読み込みました。");

        } catch (IOException e) {
            System.out.println("エラー：ファイルの読み込みに失敗しました。" + e.getMessage());
        }
        
        return loadedList;
    }
}