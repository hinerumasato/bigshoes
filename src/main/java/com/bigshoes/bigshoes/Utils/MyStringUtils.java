package com.bigshoes.bigshoes.Utils;

public class MyStringUtils {
    public static String slugToContent(String str) {
        return str.replaceAll("-", " ");
    }
}
