package com.nitkanikita.advancedcolor2.api.animations.anims;

import com.nitkanikita.advancedcolor2.api.animations.AbstractAnimation;
import com.nitkanikita.advancedcolor2.api.builders.GradientTextBuilder;
import com.nitkanikita.advancedcolor2.api.types.CustomCharacter;
import com.nitkanikita.advancedcolor2.api.types.CustomColor;
import com.nitkanikita.advancedcolor2.api.types.CustomText;

import java.awt.*;

public class Rainbow extends AbstractAnimation {

    private float hChannnel = 0;

    private final float add = 0.03f;
    private int count = 2;

    public Rainbow(CustomText text, int countColors) {
        super(text);
        count = countColors;
    }

    public Rainbow(CustomText text) {
        super(text);
    }

    @Override
    public CustomText getText() {
        GradientTextBuilder smooth = GradientTextBuilder.get()
                .addText(text)
                .addColor(CustomColor.fromHSB(hChannnel, 1, 1))
                .smooth(0.05);

        for (int i = 1; i < count; i++) {
            float h = hChannnel - (add * (i*2));
            smooth.addColor(CustomColor.fromHSB(h, 1, 1));
        }

        return smooth.generate();
    }

    @Override
    public void onTick(int tick) {
        if (tick % 2 == 0){
            hChannnel += add;
        }
    }
}
