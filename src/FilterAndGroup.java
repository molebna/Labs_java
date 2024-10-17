
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class FilterAndGroup {

    private static int calculateMonthsSinceManufacture(Car car) {
        LocalDate manufactureDate = car.getManufactureDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        return Period.between(manufactureDate, LocalDate.now()).getMonths() + 
               Period.between(manufactureDate, LocalDate.now()).getYears() * 12;
    }

    public static Map<String, List<Car>> filterAndGroup(List<Car> cars, int minMonths, int maxMonths) {
        return cars.stream()
                .filter(car -> {
                    int months = calculateMonthsSinceManufacture(car);
                    return months >= minMonths && months <= maxMonths;
                })
                .collect(Collectors.groupingBy(car -> (String) car.getClassType()));
    }
}

