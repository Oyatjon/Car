package uz.pdp.models.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.models.Entity;
@Setter
@Getter
@Builder
public class User extends Entity {
    private String username;
    private String password;
    private double balance;
    private boolean isAdmin;
    private boolean isDriver;
}
