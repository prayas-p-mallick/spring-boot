package org.paradox.week01_alice_and_cake_bakery.bake;

import java.util.concurrent.TimeUnit;
import org.paradox.week01_alice_and_cake_bakery.flavours.Frosting;
import org.paradox.week01_alice_and_cake_bakery.flavours.Syrup;
import org.springframework.stereotype.Service;

@Service
public class CakeBakery {

    private final Syrup syrup;
    private final Frosting frosting;

    public CakeBakery(Syrup syrup, Frosting frosting) {

        this.syrup = syrup;
        this.frosting = frosting;
    }

    public void bakeCake() {

        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            String msg = String.format("Cake is baked with %s and %s",
                                       syrup.getSyrupType(),
                                       frosting.getFrostingType()
            );
            System.out.println(msg);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
