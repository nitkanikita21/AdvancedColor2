package com.nitkanikita.advancedcolor2.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomCharacterTest {

    @Test
    void getMinecraftChar() {
        CustomCharacter test = new CustomCharacter('A');
        test.setColor(CustomColor.fromHEX("#ff0000"));
        assertEquals("&x&f&f&0&0&0&0A",test.getMinecraftString());

        test.enableFormatting(CustomCharacter.Code.BOLD.bit());
        assertEquals("&x&f&f&0&0&0&0&lA",test.getMinecraftString());

        test.enableFormatting(CustomCharacter.Code.ITALIC.bit());
        assertEquals("&x&f&f&0&0&0&0&o&lA",test.getMinecraftString());

        assertEquals("&o&lA",test.getMinecraftString(false));

        CustomCharacter test2 = new CustomCharacter('A');
        test2.setColor(CustomColor.fromHEX("#ff0000"));
        test2.enableFormatting(CustomCharacter.Code.BOLD.bit() | CustomCharacter.Code.ITALIC.bit());
        assertEquals("&o&lA",test2.getMinecraftString(false));
    }
}