package uz.pdp.models.paymentType;

import lombok.*;
import uz.pdp.models.Entity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentType extends Entity {
    private String name;
}
