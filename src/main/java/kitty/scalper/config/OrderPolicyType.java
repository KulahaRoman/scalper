package kitty.scalper.config;

import lombok.Getter;

@Getter
public enum OrderPolicyType {
    MINIMUM,
    MAXIMUM,
    PERCENTAGE;
}
