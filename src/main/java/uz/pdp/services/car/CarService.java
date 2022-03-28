package uz.pdp.services.car;

import uz.pdp.dao.car.CarDao;
import uz.pdp.dao.payment.PaymentDao;
import uz.pdp.models.car.Car;
import uz.pdp.models.paymentType.PaymentType;

import java.util.ArrayList;

import static uz.pdp.utils.input.Input.getNum;
import static uz.pdp.utils.input.Input.getStr;
import static uz.pdp.utils.print.Print.println;
import static uz.pdp.utils.print.Print.warning;

public class CarService {
    public static void car() {
        crudMenu();
        car();
    }

    // helper for paymentType()
    private static void update() {
        read();
        int choice = getNum("Choose car :");
        if (choice > CarDao.getCarsSize() || choice < 1) {
            warning("Wrong choice");
        } else {
            Car car = getCar();
            CarDao.updateCar(choice - 1, car);
        }
    }

    private static void delete() {
        read();
        int choice = getNum("Choose car :");
        if (choice > CarDao.getCarsSize() || choice < 1) {
            warning("Wrong choice");
        } else {
            CarDao.deleteCar(choice - 1);
        }
    }

    public static void read() {
        CarDao.showCar();
    }

    private static void create() {
        Car car = getCar();
        CarDao.addCar(car);
    }

    private static Car getCar() {
        String name = getStr("Name: ");
        String brend = getStr("Brend: ");
        double mileage = getNum("Mileage: ");
        double tankCapasity = getNum("Tank capasity: ");
        double each100Km = getNum("Each 100KM: ");
        double tank = getNum("Tank: ");
        Car car = Car.builder().name(name).brend(brend).mileage(mileage).tankCapasity(tankCapasity).each100KM(each100Km).tank(tank).build();
        return car;
    }

    // general CRUD menu
    public static void crudMenu() {
        String choice = getStr("""
                🔴 Create -> 1
                🔴 Read -> 2
                🔴 Update -> 3
                🔴 Delete -> 4
                🔴 Back to menu -> 0
                ? : """);
        if (choice.equals("1")) {
            create();
        } else if (choice.equals("2")) {
            read();
        } else if (choice.equals("3")) {
            delete();
        } else if (choice.equals("4")) {
            update();
        } else if (choice.equals("0")) {
            return;
        } else {
            warning("Wrong choice");
        }
    }
}

