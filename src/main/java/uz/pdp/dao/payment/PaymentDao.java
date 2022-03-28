package uz.pdp.dao.payment;

import uz.pdp.models.paymentType.PaymentType;

import java.util.ArrayList;

import static uz.pdp.utils.print.Print.println;

public class PaymentDao {
    private static ArrayList<PaymentType> paymentTypes = new ArrayList<>();

    public static void addPaymentType(PaymentType paymentType) {
        paymentTypes.add(paymentType);
    }

    public static ArrayList<PaymentType> getPaymentTypes() {
        return paymentTypes;
    }

    public static int getPaymentsSize() {
        return paymentTypes.size();
    }
    public static void deletePaymentType(int index) {
        paymentTypes.remove(index);
    }
    public static void updatePaymentType(int index, PaymentType paymentType) {
        paymentTypes.set(index, paymentType);
    }

    public static void showPaymentType() {
        int i = 1;
        for (PaymentType paymentType : paymentTypes) {
            println((i++) +  ". " + paymentType.getName());
        }
    }
}
