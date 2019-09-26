package com.trinke.onedrive.common.util;

import java.util.Random;

public class RandomNumUtil {
    public static int createNum(int len) {
        Random random = new Random();
        return random.nextInt((int) Math.pow(10,len)-(int)Math.pow(10,len-1)) + (int)Math.pow(10,len-1);
    }
}
