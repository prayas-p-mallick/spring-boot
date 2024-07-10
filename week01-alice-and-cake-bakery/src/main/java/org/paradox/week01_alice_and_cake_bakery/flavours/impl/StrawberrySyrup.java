package org.paradox.week01_alice_and_cake_bakery.flavours.impl;

import org.paradox.week01_alice_and_cake_bakery.flavours.Syrup;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "syrup", name = "strawberry", havingValue = "use")
public class StrawberrySyrup implements Syrup {

    @Override
    public String getSyrupType() {

        return "Strawberry Syrup";
    }
}
