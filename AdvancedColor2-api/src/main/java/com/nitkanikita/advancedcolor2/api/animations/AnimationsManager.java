package com.nitkanikita.advancedcolor2.api.animations;

import com.nitkanikita.advancedcolor2.api.animations.anims.Rainbow;
import lombok.Getter;
import lombok.experimental.UtilityClass;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class AnimationsManager {

    private static Map<String, AbstractAnimation> animations = new HashMap<>();

    public static void init(){

    }

    public static void registerAnimation(String id, AbstractAnimation anim){
        animations.put(id,anim);
    }

    public static void deleteAnimation(String id){
        animations.remove(id);
    }

    @Nullable
    public static AbstractAnimation getAnimation(String id){
        return animations.get(id);
    }

    public static void onTick(int timer){
        for (AbstractAnimation animation : animations.values()) {
            animation.onTick(timer);
        }
    }

}
