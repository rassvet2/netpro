package tdu_iwai;

import java.util.stream.DoubleStream;

import com.google.common.collect.Streams;

public class TheBoilingEarthEraA {
    public static void main(String[] args) {
        var temperatures = 地球沸騰時代猛暑日.generateTemperatures();
        final var indexOf2025 = 9;

        Streams.mapWithIndex(DoubleStream.of(temperatures[indexOf2025]), (temp, index) -> {
            return "2025年7月" + (index + 1) + "日: " + temp + "℃";
        }).forEach(System.out::println);
    }
}
