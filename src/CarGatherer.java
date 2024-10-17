import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarGatherer {
    public static List<Car> gather(int n, int count, String modelToSkip) {
        final int[] remaining = {n};
        return Stream.generate(CarGenerator::generate)
                     .filter(car -> {
                         boolean shouldSkip = car.getModel().equals(modelToSkip) && remaining[0] > 0;
                         if (shouldSkip) {
                             remaining[0]--;
                         }
                         return !shouldSkip;
                     })
                     .limit(count)
                     .collect(Collectors.toList());
    }
}
