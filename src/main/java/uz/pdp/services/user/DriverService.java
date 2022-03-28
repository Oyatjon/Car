package uz.pdp.services.user;

import uz.pdp.dao.car.CarDao;
import uz.pdp.dao.oilMark.OilMarkDao;
import uz.pdp.dao.payment.PaymentDao;
import uz.pdp.dao.user.UserDao;
import uz.pdp.models.car.Car;
import uz.pdp.services.auth.AuthService;
import uz.pdp.services.car.CarService;
import uz.pdp.services.payment.PaymentTypeService;

import java.util.Objects;

import static uz.pdp.utils.color.Color.GREEN;
import static uz.pdp.utils.color.Color.PURPLE;
import static uz.pdp.utils.input.Input.getNum;
import static uz.pdp.utils.input.Input.getStr;
import static uz.pdp.utils.print.Print.println;
import static uz.pdp.utils.print.Print.warning;

public class DriverService {
    public static void driverMenu() {
        String choice = getStr("""
                🔴 Choose car -> 1         🔴 Turn on -> 2
                🔴 Turn off -> 3           🔴 Drive -> 4
                🔴 FillTank -> 5           🔴 Add balance -> 6
                🔴 Logout -> 0
                ? : """);
        if (choice.equals("1")) {
            chooseCar();
        } else if (choice.equals("2")) {
             turnOn();
        }else if (choice.equals("3")) {
             turnOff();
        }else if (choice.equals("4")) {
             drive();
        }else if (choice.equals("5")) {
            fillTank();
        }else if (choice.equals("6")) {
            addBalance();
        }else if (choice.equals("0")) {
            UserDao.setSession(null);
            return;
        }else {
             warning("Wrong choice");
        }
        driverMenu();
    }

    private static void addBalance() {
        println(String.format("Balance: %s", UserDao.getSessionUser().getBalance()));
        String choice = getStr("""
                Do you want to add ?
                    🔴 YES -> 1
                    🔴 NO -> 2
                    ? : """);
        if (choice.equals("1")) {
            yes();
        } else if (choice.equals("2")) {
            return;
        } else {
            warning("Wrong choice");
            addBalance();
        }
    }

    private static void yes() {
        if (choosePaymentType()) {
            double money = getNum("Enter money: ");
            UserDao.addMoney(money);
        } else {
            return;
        }
    }

    private static void fillTank() {
        OilMarkDao.showOilMarks();
        int oilchoice = getNum("Choose oilMark: ");
        if (oilchoice < 0 || oilchoice > OilMarkDao.getOilMarksSize()) {
            warning("Wrong choice");
            return;
        }
        PaymentDao.showPaymentType();
        int paymentType = getNum("Choose Payment Type: ");
        if (paymentType < 0 || paymentType > PaymentDao.getPaymentsSize()) {
            warning("Wrong choice");
            return;
        }
        fillMenu(oilchoice);
    }

    private static void fillMenu(int oilchoice) {
        String choice = getStr("""
                🔴 Fill full tank -> 1
                🔴 Fill by money -> 2
                🔴 Fill by Oil amount -> 3
                ? : """);
        if (choice.equals("1")) {
            fillFull(oilchoice);
        } else if (choice.equals("2")) {
            fillByMoney();
        } else if (choice.equals("3")) {
            fillByAmount();
        } else {
            warning("Wrong choice");
            fillMenu(oilchoice);
        }
    }

    private static void fillByAmount() {
        warning("This way is not working");
    }

    private static void fillByMoney() {
        warning("This way is not working");
    }

    private static void fillFull(int oilchoice) {
        Car car = CarDao.getCar(UserDao.getSessionUser().getId());
        if (car.getTank() == car.getTankCapasity()) {
            warning("Your tank full");
        } else {
            double oilAmount = car.getTankCapasity() - car.getTank();
            CarDao.addOil(car.getId(), oilAmount);
            double summa = OilMarkDao.getOilMarks().get(oilchoice - 1).getPrice() * oilAmount;
            println("Summa: " + summa);
        }
    }

    private static void drive() {
        Car car = CarDao.getCar(UserDao.getSessionUser().getId());
        if (Objects.isNull(car)) {
            warning("You don't have any car");
        } else {
            driveCar(car);
        }
    }

    private static void driveCar(Car car) {
        if (!car.isIsturnOn()) {
            warning("Your car is turn off. Please turn on");
        } else {
            println(GREEN, "Your car is driving.");
        }
    }

    private static void turnOff() {
        Car car = CarDao.getCar(UserDao.getSessionUser().getId());
        if (Objects.nonNull(car)) {
            turnOff(car);
        } else {
            warning("You don't have a car");
        }
    }

    private static void turnOff(Car car) {
        if (!car.isIsturnOn()) {
            warning("Your car already turn Off");
        } else {
            car.setIsturnOn(false);
            println(GREEN, "Successfully turn off");
        }
    }

    private static void turnOn() {
        Car car = CarDao.getCar(UserDao.getSessionUser().getId());
        if (Objects.nonNull(car)) {
            turnOn(car);
        } else {
            warning("You don't have a car");
        }
    }

    private static void turnOn(Car car) {
        if (car.isIsturnOn()) {
            warning("Your car is already turn on");
        }
        if (car.getTank() > 0) {
            car.setIsturnOn(true);
            println(GREEN, "Successfully Turn on");
        } else {
            warning("No oil");
        }
    }

    private static void chooseCar() {
        CarService.read();
        int choice = getNum("Choose car :");
        if (choice > CarDao.getCarsSize() || choice < 1) {
            warning("Wrong choice");
        } else {
            CarDao.setDriverID(choice - 1, UserDao.getSessionUser().getId());
            println(GREEN, "Car successfully take");
        }
    }

    private static boolean choosePaymentType() {
        PaymentDao.showPaymentType();
        int choice = getNum("Choose payment Type: ");
        if (choice < 0 || choice > PaymentDao.getPaymentsSize()) {
            warning("Wrong choice");
            return false;
        }
        return true;
    }
}

