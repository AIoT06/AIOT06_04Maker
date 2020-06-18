package com.aiotdelivery.tools;

public class MyStringFix {
    public static String addZero(String numString, int length) {
        String zeroString = numString;
        int zeroNum = Math.max(length - numString.length(), 0);
        String zeros = String.format("%0" + zeroNum + "d", 0);

        if (zeroString.length() < length) {
            zeroString = zeros + numString;
        }
        return zeroString;
    }

    public static String cutUserName(String username) {
        // username@testmail.com => username
        return username.split("@")[0];
    }


}
