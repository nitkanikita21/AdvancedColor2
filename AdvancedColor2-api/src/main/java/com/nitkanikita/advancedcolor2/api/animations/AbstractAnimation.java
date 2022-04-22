package com.nitkanikita.advancedcolor2.api.animations;

import com.nitkanikita.advancedcolor2.api.types.CustomText;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractAnimation {

    @Getter
    @Setter
    protected CustomText text;

    public AbstractAnimation(CustomText text) {
        this.text = text;
    }

    public abstract void onTick(int tick);
    public String toMinecraftString(){
        return getText().toMinecraftString();
    }
}
