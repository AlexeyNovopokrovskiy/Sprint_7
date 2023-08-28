package PatternsJSON;

import java.util.Random;

public class Utils {

    public static String randomString(int length){
        Random random = new Random();
        int leftLimit = 97;
        int rightLimit = 122;
        StringBuilder buffer = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append(Character.toChars(randomLimitedInt));
        }

        return buffer.toString();
    }

    public static int rnd(int max){
        return (int) (Math.random() * ++max);
    }

    public static String rndDate(){
        int day = rnd(26)+1;
        int month = rnd(11)+1;
        String date = "2020-"+ month + "-" + day;
        return date;

    }
}
