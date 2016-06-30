package Helpers;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by orozumniuk on 6/30/2016.
 */
public class stringHelper  {

    public static String generateRandomString(int stringLength){
        return  RandomStringUtils.randomAlphabetic(stringLength);
    }

    public static String generateRandomName(int length, String marker  ) {
        int lengthOfMarker = marker.length();

        String allowedChars = "abcdefghijklmnopqrstuvwxyz" +   //alphabets
                "1234567890" +   //numbers
                "";   //special characters

        String temp = RandomStringUtils.random(length, allowedChars);
        return   temp.substring(0, temp.length() - lengthOfMarker) + marker;
    }


}
