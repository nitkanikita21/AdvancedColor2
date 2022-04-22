package com.nitkanikita.advancedcolor2.api.animations.anims;

import com.nitkanikita.advancedcolor2.api.animations.AbstractAnimation;
import com.nitkanikita.advancedcolor2.api.types.CustomCharacter;
import com.nitkanikita.advancedcolor2.api.types.CustomText;

public class Rainbow extends AbstractAnimation {


    public Rainbow(CustomText text) {
        super(text);
    }

    @Override
    public void onTick(int tick) {
        if (tick % 2 == 0){
            text = CustomText.text(" "+tick, CustomCharacter.Code.BOLD.bit());
        }
    }
}
