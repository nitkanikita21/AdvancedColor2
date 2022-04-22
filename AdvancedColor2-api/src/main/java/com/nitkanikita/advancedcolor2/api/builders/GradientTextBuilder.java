package com.nitkanikita.advancedcolor2.api.builders;

import com.nitkanikita.advancedcolor2.api.types.CustomCharacter;
import com.nitkanikita.advancedcolor2.api.types.CustomColor;
import com.nitkanikita.advancedcolor2.api.types.CustomText;
import com.nitkanikita.advancedcolor2.api.utils.ColorUtils;

import java.util.ArrayList;
import java.util.List;


public class GradientTextBuilder implements CustomTextBuilder{
    public static GradientTextBuilder get(){
        return new GradientTextBuilder();
    }

    private GradientTextBuilder(){}

    private final List<CustomColor> colors = new ArrayList<>();
    private double smooth = 0;
    private final List<CustomText> texts = new ArrayList<>();

    public GradientTextBuilder addColor(CustomColor color){
        this.colors.add(color);
        return this;
    }

    public GradientTextBuilder addText(CustomText text){
        this.texts.add(text);
        return this;
    }

    public GradientTextBuilder smooth(double smooth){
        this.smooth = smooth;
        return this;
    }

    @Override
    public CustomText generate() {

        List<CustomCharacter> chars = new ArrayList<>();
        for (CustomText text : texts) {
            chars.addAll(text.getChars());
        }

        for (int i = 0; i < chars.size(); i++) {
            float procent = ((float) i/(float)chars.size())*100f;
            int pr = Math.round(procent);

            CustomColor customColor = ColorUtils.InterpolateColor(colors, (double) pr / 100, smooth);
            CustomCharacter c = chars.get(i);
            c.setColor(customColor);
            chars.set(i,c); // set new char to index
        }

        CustomText finalText = CustomText.empty();
        finalText.addAllCharacters(chars);

        return finalText;
    }
}
