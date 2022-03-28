package uz.pdp.services.user;

import uz.pdp.dao.payment.PaymentDao;
import uz.pdp.dao.user.UserDao;
import uz.pdp.models.paymentType.PaymentType;
import uz.pdp.services.car.CarService;
import uz.pdp.services.oil.OilService;
import uz.pdp.services.payment.PaymentTypeService;

import java.util.ArrayList;
import java.util.Locale;

import static uz.pdp.utils.input.Input.getNum;
import static uz.pdp.utils.input.Input.getStr;
import static uz.pdp.utils.print.Print.println;
import static uz.pdp.utils.print.Print.warning;

public class AdminService {
    public static void adminMenu() {
        String choice = getStr("""
                🔴 Car -> 1
                🔴 OilMark -> 2
                🔴 PaymentType -> 3
                🔴 Logout -> 0
                ? : """);
        if (choice.equals("1")) {
            CarService.car();
        } else if (choice.equals("2")) {
            OilService.oilMark();
        } else if (choice.equals("3")) {
            PaymentTypeService.paymentType();
        } else if (choice.equals("0")) {
            UserDao.setSession(null);
            return;
        } else {
            warning("Wrong choice");
        }
        adminMenu();
    }




}
