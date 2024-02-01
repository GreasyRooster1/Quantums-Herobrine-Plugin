package io.github.greasyrooster1.quantumsherobrine.Util;

import java.util.Random;

public class Util {
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static int randint(int min,int max){
        return new Random().nextInt(min,max+1);
    }
}
