package uz.pdp.services.payment;

import uz.pdp.dao.payment.PaymentDao;
import uz.pdp.models.paymentType.PaymentType;
import uz.pdp.services.car.CarService;

import java.util.ArrayList;

import static uz.pdp.utils.input.Input.getNum;
import static uz.pdp.utils.input.Input.getStr;
import static uz.pdp.utils.print.Print.println;
import static uz.pdp.utils.print.Print.warning;

public class PaymentTypeService {
    // main
    public static void paymentType() {
        CarService.crudMenu();
        paymentType();
    }

    // helper for paymentType()
    private static void update() {
        read();
        int choice = getNum("Choose payment :");
        if (choice > PaymentDao.getPaymentsSize() || choice < 1) {
            warning("Wrong choice");
        } else {
            String name = getStr("New name: ");
            PaymentDao.updatePaymentType(choice - 1, new PaymentType(name));
        }
    }

    private static void delete() {
        read();
        int choice = getNum("Choose payment :");
        if (choice > PaymentDao.getPaymentsSize() || choice < 1) {
            warning("Wrong choice");
        } else {
            PaymentDao.deletePaymentType(choice - 1);
        }
    }

    private static void read() {
        ArrayList<PaymentType> paymentTypes = PaymentDao.getPaymentTypes();
        int i = 0;
        for (PaymentType paymentType : paymentTypes) {
            println((i++) + ". " + paymentType.getName().toUpperCase());
        }
    }

    private static void create() {
        String name = getStr("Name: ");
        PaymentDao.addPaymentType(new PaymentType(name));
    }
}
