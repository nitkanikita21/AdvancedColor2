package com.nitkanikita.advancedcolor2.api;

import com.google.common.primitives.Chars;
import lombok.Getter;
import lombok.Setter;

public class CustomCharacter {

    @Getter
    @Setter
    private static char controlChar = '&';

    public enum Code {
        ITALIC('o'),
        BOLD('l');


        final char charCode;

        Code( char charCode) {
            this.charCode = charCode;
        }

        public int bit() {
            return 1 << this.ordinal();
        }

    }

    private int formatting = 0;

    @Getter
    @Setter
    private CustomColor color = CustomColor.fromRGB(0);

    @Getter
    @Setter
    private char symbol = '?';

    public void enableFormatting(int flag) {
        formatting |= flag;
    }

    public void disableFormatting(int flag) {
        formatting &= ~flag;
    }

    public void toggleFormatting(int flag) {
        formatting ^= flag;
    }

    public CustomCharacter(char symbol) {
        this.symbol = symbol;
    }

    public CustomCharacter(char symbol, CustomColor color) {
        this.color = color;
        this.symbol = symbol;
    }

    public CustomCharacter(char symbol, int formatting) {
        this.formatting = formatting;
        this.symbol = symbol;
    }

    public CustomCharacter(char symbol, int formatting, CustomColor color) {
        this.formatting = formatting;
        this.color = color;
        this.symbol = symbol;
    }

    public String getMinecraftString(){
        return this.getMinecraftString(true);
    }

    public String getMinecraftString(boolean addColor){
        StringBuilder s = new StringBuilder();
        if(addColor){
            s.append(controlChar)
                    .append('x')
                    .append(controlChar)
                    .append(Chars.join(controlChar+"", color.toHexString().toCharArray()));
        }
        for (Code value : Code.values()) {
            if((formatting & value.bit()) != 0){
                s.append(controlChar + (value.charCode+""));
            }
        }
        s.append(symbol);

        return s.toString();
    }

}
