package com.nitkanikita.advancedcolor2.api;

import com.nitkanikita.advancedcolor2.api.types.CustomCharacter;
import com.nitkanikita.advancedcolor2.api.types.CustomColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomCharacterTest {

    @Test
    void getMinecraftChar() {
        CustomCharacter test = new CustomCharacter('A');
        test.setColor(CustomColor.fromHEX("#ff0000"));
        assertEquals("&x&f&f&0&0&0&0A",test.toMinecraftString());

        test.enableFormatting(CustomCharacter.Code.BOLD.bit());
        assertEquals("&x&f&f&0&0&0&0&lA",test.toMinecraftString());

        test.enableFormatting(CustomCharacter.Code.ITALIC.bit());
        assertEquals("&x&f&f&0&0&0&0&o&lA",test.toMinecraftString());

        assertEquals("&o&lA",test.toMinecraftString(false));

        CustomCharacter test2 = new CustomCharacter('A');
        test2.setColor(CustomColor.fromHEX("#ff0000"));
        test2.enableFormatting(CustomCharacter.Code.BOLD.bit() | CustomCharacter.Code.ITALIC.bit());
        assertEquals("&o&lA",test2.toMinecraftString(false));
    }
}