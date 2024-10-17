
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception
    {
        List<Car> cars = CarGatherer.gather(50, 500, "Camry");

        Map<String, List<Car>> groupedCars = FilterAndGroup.filterAndGroup(cars, 6, 24);

        CarStatistics stats = cars.stream().collect(CarStatistics.carStatisticsCollector());

        System.out.println("--- Car price statistics ---");
        System.out.println(stats);

        CarPriceAnalysis priceAnalysis = new CarPriceAnalysis();
        Map<String, Long> result = priceAnalysis.analyzePriceOutliers(cars);
        System.out.println("--- Outliers ---");
        System.out.println(result);
    }
}

