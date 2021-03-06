package ru.krgolovin.lego.mindstorm.plugin.java.task;


import java.util.regex.Pattern;

public class Main {
    public static boolean matches(String text, String regex) {
        return Pattern.compile(regex).matcher(new InterimCharSequence(text, 5000L)).matches();
    }

    public static void main(String[] args) {
        System.out.println(matches(
                "aaaaaaaaaaaaaaaabaaaaaaaaabaaaaaaaaaaaaabaaaaaaaaaaabaaaaaaaa",
                "(((a*)a*)a*)*b*(((a*)a*)a*)*bb "));
    }
}
