package kitty.scalper.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderPolicy {
    private OrderPolicyType type;
    private double value;

    public OrderPolicy(double value) {
        this.value = value;
    }
}
