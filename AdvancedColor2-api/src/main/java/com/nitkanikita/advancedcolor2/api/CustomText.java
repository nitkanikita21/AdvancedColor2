package com.nitkanikita.advancedcolor2.api;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class CustomText {

    public static CustomText empty(){
        return new CustomText();
    }
    public static CustomText text(String text){
        CustomText customText = new CustomText();
        for (char c : text.toCharArray()) {
            customText.addCharacter(new CustomCharacter(c));
        }
        return customText;
    }

    public static CustomText text(String text, int formatting){
        CustomText customText = new CustomText();
        for (char c : text.toCharArray()) {
            customText.addCharacter(new CustomCharacter(c,formatting));
        }
        return customText;
    }

    public static CustomText text(String text, int formatting, CustomColor color){
        CustomText customText = new CustomText();
        for (char c : text.toCharArray()) {
            customText.addCharacter(new CustomCharacter(c, formatting, color));
        }
        return customText;
    }

    @Getter
    private List<CustomCharacter> chars = new ArrayList<>();

    private CustomText(){}

    public void addCharacter(CustomCharacter c){
        chars.add(c);
    }
    public void addAllCharacters(List<CustomCharacter> c){
        chars.addAll(c);
    }

    public String getMinecraftString(){
        StringBuilder string = new StringBuilder();
        string.append(chars.get(0).getMinecraftString(true));
        for (int i = 1; i < chars.size(); i++) {
            CustomCharacter c = chars.get(i);
            if(c.getColor().getRGB() == chars.get(i-1).getColor().getRGB()){
                string.append(c.getMinecraftString(false));
            }else{
                string.append(c.getMinecraftString(true));
            }
        }

        return string.toString();
    }

}
