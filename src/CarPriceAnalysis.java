import java.util.*;
import java.util.stream.Collectors;

public class CarPriceAnalysis {

    public static Map<String, Long> analyzePriceOutliers(List<Car> cars) {

        List<Double> prices = cars.stream()
                                  .map(Car::getPrice)
                                  .sorted()
                                  .collect(Collectors.toList());

        double q1 = getPercentile(prices, 25);
        double q3 = getPercentile(prices, 75);

        double iqr = q3 - q1;

        double lowerBound = q1 - 1.5 * iqr;
        double upperBound = q3 + 1.5 * iqr;

        Map<String, Long> result = cars.stream()
                .collect(Collectors.partitioningBy(
                        car -> car.getPrice() < lowerBound || car.getPrice() > upperBound, 
                        Collectors.counting()
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey() ? "outliers" : "data",
                        Map.Entry::getValue
                ));

        return result;
    }

    private static double getPercentile(List<Double> sortedValues, double percentile) {
        int index = (int) Math.ceil(percentile / 100.0 * sortedValues.size()) - 1;
        return sortedValues.get(index);
    }
}
