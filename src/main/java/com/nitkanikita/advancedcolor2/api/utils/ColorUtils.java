package com.nitkanikita.advancedcolor2.api.utils;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;
import net.kyori.adventure.text.format.TextColor;

import java.util.List;

@UtilityClass
@FieldDefaults(level = AccessLevel.PUBLIC)
public class ColorUtils {
    TextColor getColorFromGradient(List<TextColor> colors, double xPosition, double smooth) {
        double r = 0.0, g = 0.0, b = 0.0;
        double total = 0.0;
        double step = 1.0 / (double) (colors.size() - 1);
        double mu = 0.0;
        double sigma_2 = smooth;

        for (TextColor color : colors) {
            total += Math.exp(-(xPosition - mu) * (xPosition - mu) / (2.0 * sigma_2)) / Math.sqrt(2.0 * Math.PI * sigma_2);
            mu += step;
        }

        mu = 0.0;
        for (TextColor color : colors) {
            double percent = Math.exp(-(xPosition - mu) * (xPosition - mu) / (2.0 * sigma_2)) / Math.sqrt(2.0 * Math.PI * sigma_2);
            mu += step;

            r += color.red() * percent / total;
            g += color.green() * percent / total;
            b += color.blue() * percent / total;
        }

        return TextColor.color((int) r, (int) g, (int) b);
    }
}
