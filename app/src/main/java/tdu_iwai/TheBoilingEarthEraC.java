package tdu_iwai;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.collect.Streams;

public class TheBoilingEarthEraC {
    public static void main(String[] args) {
        var temperatures = 地球沸騰時代猛暑日.generateTemperatures();

        System.out.println("真夏日連続ペア:");
        Streams.mapWithIndex(Stream.of(temperatures), (temps, year) -> {
            System.out.println((2016 + year) + "年:");
            return Streams.zip(
                IntStream.range(0, temps.length).boxed(),
                IntStream.range(0, temps.length).skip(1).boxed(),
                (day1, day2) -> {
                    if (temps[day1] >= 30.0 && temps[day2] >= 30.0) {
                        System.out.printf(
                            "%d年7月%d日\t%.1f℃\tと\t%d年7月%d日\t%.1f℃\n",
                            2016 + year, day1 + 1, temps[day1],
                            2016 + year, day2 + 1, temps[day2]
                        );
                    }
                    return null;
                }
            ).collect(Collectors.counting());
        }).collect(Collectors.counting());
        System.out.println("End of List");
    }
}
