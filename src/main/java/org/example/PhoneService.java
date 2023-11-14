package org.example;

import com.github.javafaker.Faker;

import java.util.Locale;

public class PhoneService {
    public String generatePhone() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.phoneNumber().cellPhone();
    }


}

