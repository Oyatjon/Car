package uz.pdp.models.oilMark;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.models.Entity;
@Setter
@Getter
@Builder
public class OilMark extends Entity {
    private String name;
    private double price;
}
