package uz.pdp.dao.oilMark;

import uz.pdp.models.oilMark.OilMark;
import uz.pdp.models.paymentType.PaymentType;

import java.util.ArrayList;

import static uz.pdp.utils.print.Print.println;

public class OilMarkDao {
    private static ArrayList<OilMark> oilMarks = new ArrayList<>();
    public  static  void addOilMark(OilMark oilMark) {
        oilMarks.add(oilMark);
    }
    public static  void deleteOilMark(int index) {
        oilMarks.remove(index);
    }

    public static ArrayList<OilMark> getOilMarks() {
        return oilMarks;
    }

    public static int getOilMarksSize() {
        return oilMarks.size();
    }

    public static void updateOilMark(int index, OilMark oilMark) {
        oilMarks.set(index, oilMark);
    }

    public static void showOilMarks() {
        int i = 1;
        for (OilMark oilMark : oilMarks) {
            println(String.format("""
                    %s. Name: %s
                        Price: %s """, i++, oilMark.getName(), oilMark.getPrice()));
        }
    }

}
