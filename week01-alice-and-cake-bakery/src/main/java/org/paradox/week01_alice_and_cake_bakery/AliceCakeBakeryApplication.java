package org.paradox.week01_alice_and_cake_bakery;

import org.paradox.week01_alice_and_cake_bakery.bake.CakeBakery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AliceCakeBakeryApplication {

	private static CakeBakery cakeBakery;

	public AliceCakeBakeryApplication(CakeBakery cakeBakery) {
		AliceCakeBakeryApplication.cakeBakery = cakeBakery;
	}

	public static void main(String[] args) {
		SpringApplication.run(AliceCakeBakeryApplication.class, args);
		cakeBakery.bakeCake();
	}

}
