package com.opencart.managers;

import com.github.javafaker.Faker;

public class RandomDataManager {
    private static Faker fakerObject = new Faker();

    public static String generateRandomEmail(String prefix, String sufix){

        String randomMidPart = String.valueOf(fakerObject.random().nextInt(1, 99999));
        return prefix + randomMidPart + sufix;

    }

    public static String generateRandomEmail(){
        return fakerObject.internet().emailAddress();
    }

    public static String generateName(){
        return fakerObject.funnyName().name();
    }
}
