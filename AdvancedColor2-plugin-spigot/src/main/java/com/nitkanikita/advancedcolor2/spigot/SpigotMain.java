package com.nitkanikita.advancedcolor2.spigot;

import com.nitkanikita.advancedcolor2.api.CustomCharacter;
import com.nitkanikita.advancedcolor2.api.CustomColor;
import com.nitkanikita.advancedcolor2.api.CustomText;
import com.nitkanikita.advancedcolor2.api.builders.GradientTextBuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.util.List;

public class SpigotMain extends JavaPlugin {
    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void onEnable() {
        getCommand("advancedcolor2").setExecutor((sender, command, label, args) -> {

            String minecraftString = GradientTextBuilder.get()
                    .addText(CustomText.text("Hello! Its my cool text. Do you like my gradient?", CustomCharacter.Code.ITALIC.bit() | CustomCharacter.Code.BOLD.bit()))
                    .addColor(CustomColor.of(Color.MAGENTA))
                    .addColor(CustomColor.of(Color.GREEN))
                    .addColor(CustomColor.of(Color.BLUE))
                    .smooth(0.01)
                    .generate()
                    .getMinecraftString();

            sender.sendMessage(minecraftString);

            return true;
        });
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
