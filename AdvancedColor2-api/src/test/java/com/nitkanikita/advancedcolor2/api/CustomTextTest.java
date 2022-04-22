package com.nitkanikita.advancedcolor2.api;

import com.nitkanikita.advancedcolor2.api.types.CustomCharacter;
import com.nitkanikita.advancedcolor2.api.types.CustomColor;
import com.nitkanikita.advancedcolor2.api.types.CustomText;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CustomTextTest {

    @Test
    void getMinecraftString() {
        CustomCharacter c = new CustomCharacter('A');
        c.setColor(CustomColor.fromHEX("#ff0000"));
        c.enableFormatting(CustomCharacter.Code.BOLD.bit());

        CustomText test = CustomText.empty();
        test.addCharacter(c);
        assertEquals("&x&f&f&0&0&0&0&lA&r",test.toMinecraftString());

        test.addCharacter(c);
        assertEquals("&x&f&f&0&0&0&0&lA&lA&r",test.toMinecraftString());

        CustomCharacter c2 = new CustomCharacter('B');

        c2.setColor(CustomColor.of(Color.ORANGE));
        test.addCharacter(c2);
        assertEquals("&x&f&f&0&0&0&0&lA&lA&x&f&f&c&8&0&0B&r",test.toMinecraftString());
    }
}