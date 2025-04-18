package tdu_iwai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class CSVReader {
	public static void main(String[] args) {
		String csvFile = "./src/main/resources/address.csv"; // ファイルのパスを指定してください
		String line = "";
		String csvSplitBy = ","; // CSVファイルの区切り文字を指定してください

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String[] cols = Objects.requireNonNull(br.readLine(), "csv must contain a header line")
                .split(csvSplitBy);

            int index = Arrays.asList(cols).indexOf("区");
            if (index < 0) {
                throw new IllegalArgumentException("couldn't find column with the value '区'");
            }

            while ((line = br.readLine()) != null) {
                // 1行をカンマで分割して単語の配列を取得
                String[] words = line.split(csvSplitBy);

                // 単語を一つずつ出力
                // for (String word : words) {
                //     System.out.println(word);
                // }

                System.out.println(words[index]);
            }//while end
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//main end
}//class end
