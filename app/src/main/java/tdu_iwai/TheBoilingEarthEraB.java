package tdu_iwai;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import com.google.common.collect.Streams;

public class TheBoilingEarthEraB {
    public static void main(String[] args) {
        var temperatures = 地球沸騰時代猛暑日.generateTemperatures();
        final var indexOf2025 = 9; // 3

        System.out.println("真夏日連続ペア:");
        Streams.zip(
            IntStream.range(0, temperatures[indexOf2025].length).boxed(),
            IntStream.range(0, temperatures[indexOf2025].length).skip(1).boxed(),
            (day1, day2) -> {
                if (temperatures[indexOf2025][day1] >= 30.0 && temperatures[indexOf2025][day2] >= 30.0) {
                    System.out.printf(
                        "2025年7月%d日\t%.1f℃\tと\t2025年7月%d日\t%.1f℃\n",
                        day1 + 1, temperatures[indexOf2025][day1],
                        day2 + 1, temperatures[indexOf2025][day2]
                    );
                }
                return null;
            }
        ).collect(Collectors.counting());
        System.out.println("End of List");
    }
}
