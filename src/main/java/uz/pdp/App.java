package uz.pdp;

import uz.pdp.models.user.User;
import uz.pdp.services.auth.AuthService;

import static uz.pdp.db.Init.init;
import static uz.pdp.services.user.AdminService.adminMenu;
import static uz.pdp.utils.color.Color.PURPLE;
import static uz.pdp.utils.input.Input.getStr;
import static uz.pdp.utils.print.Print.println;

public class App {
    public static void main(String[] args) {
        init();
        mainMenu();
    }

    private static void mainMenu() {
        String choice = getStr("""
                🔴 Login -> 1
                🔴 Register -> 2
                🔴 Quit -> 0
                ? : """);
        if(choice.equals("1")) {
            if (AuthService.login()) {
                AuthService.detectUser();
            }
        } else if (choice.equals("2")) {
            if(AuthService.registrate()) {
                println(PURPLE, "Successfully registrate");
            }
        } else if (choice.equals("0")) {
            return;
        }
        mainMenu();
    }
}
