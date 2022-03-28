package uz.pdp.services.oil;

import uz.pdp.dao.oilMark.OilMarkDao;
import uz.pdp.dao.payment.PaymentDao;
import uz.pdp.models.car.Car;
import uz.pdp.models.oilMark.OilMark;
import uz.pdp.models.paymentType.PaymentType;
import uz.pdp.services.car.CarService;

import java.util.ArrayList;

import static uz.pdp.utils.input.Input.getNum;
import static uz.pdp.utils.input.Input.getStr;
import static uz.pdp.utils.print.Print.println;
import static uz.pdp.utils.print.Print.warning;

public class OilService {
    public static void oilMark() {
        CarService.crudMenu();
        oilMark();
    }
    // helper for oil
    private static void create() {
        String name = getStr("Name: ");
        double price = getNum("Price: ");
        OilMarkDao.addOilMark(OilMark.builder().name(name).price(price).build());
    }

    private static void update() {
        read();
        int choice = getNum("Choose OilMark :");
        if (choice > OilMarkDao.getOilMarks().size() || choice < 1) {
            warning("Wrong choice");
        } else {
            String name = getStr("New name: ");
            double price = getNum("Price: ");
            OilMarkDao.updateOilMark(choice - 1, OilMark.builder().name(name).price(price).build());
        }
    }

    private static void delete() {
        read();
        int choice = getNum("Choose OilMark :");
        if (choice > OilMarkDao.getOilMarks().size() || choice < 1) {
            warning("Wrong choice");
        } else {
            OilMarkDao.deleteOilMark(choice - 1);
        }
    }

    private static void read() {
        ArrayList<OilMark> paymentTypes = OilMarkDao.getOilMarks();
        int i = 0;
        for (OilMark oilMark : OilMarkDao.getOilMarks()) {
            println((i++) + ". " + oilMark.getName().toUpperCase() + " [ Price: " + oilMark.getPrice() + "]");
        }
    }
}
