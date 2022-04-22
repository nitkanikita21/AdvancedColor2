package com.nitkanikita.advancedcolor2.api.utils;

import com.nitkanikita.advancedcolor2.api.types.CustomColor;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ColorUtils {
    public static CustomColor InterpolateColor(List<CustomColor> colors, double xPosition, double smooth)
    {
        double r = 0.0, g = 0.0, b = 0.0;
        double total = 0.0;
        double step = 1.0 / (double)(colors.size() - 1);
        double mu = 0.0;
        double sigma_2 = smooth;

        for (CustomColor color : colors)
        {
            total += Math.exp(-(xPosition - mu) * (xPosition - mu) / (2.0 * sigma_2)) / Math.sqrt(2.0 * Math.PI * sigma_2);
            mu += step;
        }

        mu = 0.0;
        for(CustomColor color : colors)
        {
            double percent = Math.exp(-(xPosition - mu) * (xPosition - mu) / (2.0 * sigma_2)) / Math.sqrt(2.0 * Math.PI * sigma_2);
            mu += step;

            r += color.getRed() * percent / total;
            g += color.getGreen() * percent / total;
            b += color.getBlue() * percent / total;
        }

        return CustomColor.fromRGB( (int)r, (int)g, (int)b);
    }
}
