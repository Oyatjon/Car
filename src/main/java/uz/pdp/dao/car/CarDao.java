package uz.pdp.dao.car;

import uz.pdp.models.car.Car;
import uz.pdp.models.paymentType.PaymentType;

import java.util.ArrayList;
import java.util.Objects;

import static uz.pdp.utils.print.Print.println;

public class CarDao {
    private static ArrayList<Car> cars = new ArrayList<>();

    public static void addCar(Car car) {
        cars.add(car);
    }

    public static ArrayList<Car> getCars() {
        return cars;
    }

    public static int getCarsSize() {
        return cars.size();
    }
    public static void deleteCar(int index) {
        cars.remove(index);
    }
    public static void updateCar(int index, Car car) {
        cars.set(index, car);
    }

    public static Car get(int index) {
        return cars.get(index);
    }
    public static void setDriverID(int index, String id) {
        Car car = cars.get(index);
        car.setDriverID(id);
        cars.set(index, car);
    }

    public static Car getCar(String driverID) {
        for (Car car : cars) {
            if (Objects.nonNull(car.getDriverID()) && car.getDriverID().equals(driverID)) {
                return car;
            }
        }
        return null;
    }
    public static void addOil(String id, double oil) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                car.setTank(car.getTankCapasity());
            }
        }
    }

    public static void showCar() {
        int i = 1;
        for (Car car : cars) {
            println(String.format("""
                    %s. Name: %s
                        Brend: %s
                        Mileage: %s
                        Tank Capasity: %s
                        consumption: %s """, i++, car.getName(), car.getBrend(), car.getMileage(), car.getTankCapasity(), car.getEach100KM()));
        }
    }
}
