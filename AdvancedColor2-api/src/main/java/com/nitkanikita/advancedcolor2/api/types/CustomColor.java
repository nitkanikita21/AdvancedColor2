package com.nitkanikita.advancedcolor2.api.types;

import java.awt.*;
import java.awt.color.ColorSpace;

public class CustomColor extends Color {
    private CustomColor(int r, int g, int b) {
        super(r, g, b);
    }

    private CustomColor(int rgb) {
        super(rgb);
    }

    private CustomColor(float r, float g, float b) {
        super(r, g, b);
    }

    private CustomColor(String hex){
        super(Integer.valueOf(hex.replaceAll("#",""), 16));
    }

    private CustomColor(ColorSpace cspace, float[] components, float alpha) {
        super(cspace, components, alpha);
    }

    /**
     * Convert color to HEX color string
     * <p>
     * Converts a color to an RRGGBB format string, where R, G, and B correspond to color channels
     * @return String
     */
    public String toHexString(){
        return Integer.toHexString(this.getRGB()).substring(2);
    }

    public static CustomColor fromRGB(int r, int g, int b){
        return new CustomColor(r,g,b);
    }
    public static CustomColor fromRGB(float r, float g, float b){
        return new CustomColor(r,g,b);
    }
    public static CustomColor fromRGB(int RGB){
        return new CustomColor(RGB);
    }
    public static CustomColor fromHEX(String hex){
        return new CustomColor(hex);
    }
    public static CustomColor fromHSB(float h, float s, float b){
        return of(Color.getHSBColor(h,s,b));
    }
    public static CustomColor of(Color color){ return new CustomColor(color.getRGB()); }
}
