import java.util.function.*;
import java.util.stream.Collector;
import java.util.*;

public class CarStatistics {
    private double minPrice;
    private double maxPrice;
    private double averagePrice;
    private double standardDeviation;

    public CarStatistics(double minPrice, double maxPrice, double averagePrice, double standardDeviation) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.averagePrice = averagePrice;
        this.standardDeviation = standardDeviation;
    }

    @Override
    public String toString() {
        return String.format("Min price: %.2f\nMax price: %.2f\nAverage price: %.2f\nStandart deviation: %.2f",
                             minPrice, maxPrice, averagePrice, standardDeviation);
    }

    public static Collector<Car, CarAccumulator, CarStatistics> carStatisticsCollector(){
        return new Collector<Car, CarAccumulator, CarStatistics>() {
            @Override
            public Supplier<CarAccumulator> supplier() {
                return CarAccumulator::new;
            }

            @Override
            public BiConsumer<CarAccumulator, Car> accumulator() {
                return CarAccumulator::accumulate;
            }

            @Override
            public BinaryOperator<CarAccumulator> combiner() {
                return CarAccumulator::combine;
            }

            @Override
            public Function<CarAccumulator, CarStatistics> finisher() {
                return CarAccumulator::finish;
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Collections.emptySet();
            }
        };
    }
}

class CarAccumulator {
    private double sum = 0;
    private double sumOfSquares = 0;
    private double min = Double.MAX_VALUE;
    private double max = Double.MIN_VALUE;
    private int count = 0;

    public void accumulate(Car car) {
        double price = car.getPrice();
        sum += price;
        sumOfSquares += price * price;
        min = Math.min(min, price);
        max = Math.max(max, price);
        count++;
    }

    public CarAccumulator combine(CarAccumulator other) {
        sum += other.sum;
        sumOfSquares += other.sumOfSquares;
        min = Math.min(min, other.min);
        max = Math.max(max, other.max);
        count += other.count;
        return this;
    }

    public CarStatistics finish() {
        double average = sum / count;
        double variance = (sumOfSquares / count) - (average * average);
        double stdDev = Math.sqrt(variance);

        return new CarStatistics(min, max, average, stdDev);
    }
}
