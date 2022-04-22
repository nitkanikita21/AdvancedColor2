package com.nitkanikita.advancedcolor2.api.builders;

import com.nitkanikita.advancedcolor2.api.types.CustomColor;
import com.nitkanikita.advancedcolor2.api.types.CustomText;

import java.awt.*;

public class SolidTextBuilder implements CustomTextBuilder{

    public static SolidTextBuilder get(){
        return new SolidTextBuilder();
    }

    private SolidTextBuilder(){}

    private CustomColor color = CustomColor.of(Color.RED);
    private int formatting = 0;
    private String text = "";

    public SolidTextBuilder color(CustomColor color){
        this.color = color;
        return this;
    }

    public SolidTextBuilder text(String text){
        this.text = text;
        return this;
    }

    public SolidTextBuilder formatting(int formatting){
        this.formatting = formatting;
        return this;
    }

    @Override
    public CustomText generate() {
        return CustomText.text(text,formatting,color);
    }
}
