package org.paradox.week01_alice_and_cake_bakery.flavours.impl;

import org.paradox.week01_alice_and_cake_bakery.flavours.Frosting;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "frosting", name = "chocolate", havingValue = "use")
public class ChocolateFrosting implements Frosting {

    @Override
    public String getFrostingType() {

        return "Chocolate Frosting";
    }
}
