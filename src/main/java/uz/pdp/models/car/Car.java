package uz.pdp.models.car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.models.Entity;

@Getter
@Setter
@Builder
public class Car extends Entity {
    private String name;
    private  String brend;
    private double mileage;
    private double tankCapasity;
    private double each100KM;
    private String driverID;
    private boolean isturnOn;
    private double tank;
}
