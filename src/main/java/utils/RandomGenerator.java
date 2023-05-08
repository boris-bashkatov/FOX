package utils;

import org.apache.commons.lang3.RandomStringUtils;


public class RandomGenerator {

    public static String getRandomString(int minStringLength, int maxStringLength) {
        return RandomStringUtils.randomAlphabetic(minStringLength, maxStringLength);
    }

    public static String capitaliseStringFirstLetter(String inputName) {
        String s = inputName.substring(0, 1).toUpperCase();
        String nameCapitalized = s + inputName.substring(1);
        return nameCapitalized;
    }

    public static String getRandomNum(int minStringLength, int maxStringLength) {
        return RandomStringUtils.randomNumeric(minStringLength, maxStringLength);
    }

    public static String getRandomAlphanumeric(int minStringLength, int maxStringLength) {
        return RandomStringUtils.randomAlphanumeric(minStringLength, maxStringLength);
    }
}
