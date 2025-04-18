package april0418;

import java.util.Random;
import java.util.stream.IntStream;

import com.google.common.base.Preconditions;

public class 地球沸騰時代猛暑日 {
    public static void main(String[] args) {
        System.out.println("地球沸騰時代猛暑日！！！");

        var temperatures = generateTemperatures();
        System.out.println(temperatures[9][30]);
    }

    public static double[][] generateTemperatures(
        int yearStart, int yearEnd,
        double initialAvgTemp, double avgTempGainByYear,
        double tempShift
    ) {
        Preconditions.checkArgument(yearStart <= yearEnd, "year range must be yearStart <= yearEnd");
        Preconditions.checkArgument(tempShift >= 0, "tempShift must be positive or zero");

        var random = new Random("地球沸騰時代猛暑日".hashCode());
        return IntStream.rangeClosed(yearStart, yearEnd)
            .mapToDouble((year) -> initialAvgTemp + avgTempGainByYear * (year - yearStart))
            .mapToObj((avgTemp) -> {
                return IntStream.rangeClosed(1, 31)
                    .mapToDouble((x) -> avgTemp + random.nextDouble(-tempShift, tempShift))
                    .map((x) -> Math.round(x * 10.0) / 10.0)
                    .toArray();
            })
            .toArray((size) -> new double[size][]);
    }

    public static double[][] generateTemperatures() {
        return generateTemperatures(2016, 2025, 29.0, 0.3, 0.5);
    }
}
