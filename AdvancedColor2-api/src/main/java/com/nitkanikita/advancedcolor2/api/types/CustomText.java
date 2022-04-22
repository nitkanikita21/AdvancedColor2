package com.nitkanikita.advancedcolor2.api.types;

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

    public static CustomText text(String text, CustomColor color){
        CustomText customText = new CustomText();
        for (char c : text.toCharArray()) {
            customText.addCharacter(new CustomCharacter(c, 0, color));
        }
        return customText;
    }

    @Getter
    private List<CustomText> components = new ArrayList<>();

    private List<CustomCharacter> chars = new ArrayList<>();

    public List<CustomCharacter> getChars() {
        List<CustomCharacter> arr = this.chars;
        for (CustomText component : components) {
            arr.addAll(component.getChars());
        }
        return arr;
    }

    private CustomText(){}

    public void addCharacter(CustomCharacter c){
        chars.add(c);
    }
    public void addAllCharacters(List<CustomCharacter> c){
        chars.addAll(c);
    }

    public void append(CustomText text){
        components.add(text);
    }

    public String toMinecraftString(){
        StringBuilder string = new StringBuilder();
        string.append(chars.get(0).toMinecraftString(true));
        for (int i = 1; i < chars.size(); i++) {
            CustomCharacter c = chars.get(i);
            if(c.getColor().getRGB() == chars.get(i-1).getColor().getRGB()){
                string.append(c.toMinecraftString(false));
            }else{
                string.append(c.toMinecraftString(true));
            }
        }
        string.append(CustomCharacter.Code.RESET + "");

        for (CustomText component : components) {
            string.append(component.toMinecraftString());
        }

        return string.toString();
    }

    public String toPlainText(){
        StringBuilder s = new StringBuilder();
        for (CustomCharacter aChar : chars) {
            s.append(aChar.toPlainText());
        }
        return s.toString();
    }

    @Override
    public String toString() {
        return toMinecraftString();
    }
}
