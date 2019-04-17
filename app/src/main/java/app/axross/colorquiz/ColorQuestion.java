package app.axross.colorquiz;

import android.graphics.Color;

import java.util.Random;

public class ColorQuestion {
    ColorQuestion() {
        Random random = new Random();

        this.left = colorChoices[random.nextInt(colorChoices.length)];

        ColorChoice right = colorChoices[random.nextInt(colorChoices.length)];

        while (right.equals(this.left)) {
            right = colorChoices[random.nextInt(colorChoices.length)];
        }

        this.right = right;
        this.answer = random.nextInt(2) == 0 ? this.left : this.right;
    }

    public final ColorChoice left;

    public final ColorChoice right;

    public final ColorChoice answer;

    private static ColorChoice[] colorChoices = {
        new ColorChoice("Black", Color.BLACK),
        new ColorChoice("Gray", Color.GRAY),
        new ColorChoice("Blue", Color.BLUE),
        new ColorChoice("Red", Color.RED),
        new ColorChoice("Green", Color.GREEN),
        new ColorChoice("Cyan", Color.CYAN),
        new ColorChoice("Magenta", Color.MAGENTA),
        new ColorChoice("Yellow", Color.YELLOW),
    };
}
