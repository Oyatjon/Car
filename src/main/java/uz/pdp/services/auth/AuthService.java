package uz.pdp.services.auth;

import uz.pdp.dao.user.UserDao;
import uz.pdp.models.user.User;
import uz.pdp.services.user.AdminService;
import uz.pdp.services.user.DriverService;

import java.util.ArrayList;
import java.util.Objects;

import static uz.pdp.utils.input.Input.getStr;
import static uz.pdp.utils.print.Print.warning;

public class AuthService {
    public static boolean registrate() {
        String username = getStr("Username: ");
        // TODO: 11/26/2021 Valid or invalid
        String password = getStr("Password: ");
        // TODO: 11/26/2021 Valid or invalid
        User user = User.builder().username(username).password(password).isDriver(true).build();
        UserDao.addUser(user);
        return true;
    }

    public static boolean login() {
        String username = getStr("Username: ");
        String password = getStr("Password: ");
        User user = findUserByUsername(username, password);
        if (Objects.isNull(user)) {
            warning("Bad Credentials");
            return false;
        }
        UserDao.setSession(user);
        return true;
    }

    private static User findUserByUsername(String username, String password) {
        ArrayList<User> users =  UserDao.getUsers();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static void detectUser()  {
        if (UserDao.getSessionUser().isAdmin()) {
            AdminService.adminMenu();
        } else {
            DriverService.driverMenu();
        }
    }
}
