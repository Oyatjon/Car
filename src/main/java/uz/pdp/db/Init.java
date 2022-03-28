package uz.pdp.db;

import uz.pdp.dao.car.CarDao;
import uz.pdp.dao.oilMark.OilMarkDao;
import uz.pdp.dao.payment.PaymentDao;
import uz.pdp.dao.user.UserDao;
import uz.pdp.models.car.Car;
import uz.pdp.models.oilMark.OilMark;
import uz.pdp.models.paymentType.PaymentType;
import uz.pdp.models.user.User;

public class Init {
    public static  void init() {
        User user = User.builder().username("admin").password("123").isAdmin(true).build();
        UserDao.addUser(user);
        PaymentDao.addPaymentType(new PaymentType("CASH"));
        PaymentDao.addPaymentType(new PaymentType("CLICK"));
        OilMarkDao.addOilMark(OilMark.builder().name("A-95").price(8000).build());
        OilMarkDao.addOilMark(OilMark.builder().name("A-93").price(8500).build());
        CarDao.addCar(Car.builder().name("Malibu").brend("GM").mileage(10000).each100KM(10).tank(10).tankCapasity(20).build());
    }
}
