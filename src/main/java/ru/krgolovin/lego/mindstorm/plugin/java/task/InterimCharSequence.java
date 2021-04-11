package ru.krgolovin.lego.mindstorm.plugin.java.task;

import java.util.stream.IntStream;

public class InterimCharSequence implements CharSequence {

    public InterimCharSequence(CharSequence charSequence, Long duration) {
        this.charSequence = charSequence;
        this.duration = duration;
    }

    @Override
    public int length() {
        checkTime();
        return charSequence.length();
    }

    @Override
    public char charAt(int index) {
        checkTime();
        return charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        checkTime();
        return new InterimCharSequence(
                charSequence.subSequence(start, end),
                startTime + duration - System.currentTimeMillis()
        );
    }


    private void checkTime() {
        if (duration < System.currentTimeMillis() - startTime) {
            throw new IllegalStateException("TIME_OUT");
        }
    }

    private final long startTime = System.currentTimeMillis();
    private final CharSequence charSequence;
    private final Long duration;
}
