package app.axross.colorquiz;

import android.support.annotation.ColorInt;

public class ColorChoice {
    ColorChoice(String name, @ColorInt int color) {
        this.name = name;
        this.color = color;
    }

    private final String name;

    private final @ColorInt int color;

    public String getName() {
        return name;
    }

    public @ColorInt int getColor() {
        return color;
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(getClass())) {
            return false;
        }

        ColorChoice objAsColorChoice = (ColorChoice) obj;

        return objAsColorChoice.getName().equals(getName());
    }
}
