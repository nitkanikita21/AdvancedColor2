package com.nitkanikita.advancedcolor2.spigot;

import com.nitkanikita.advancedcolor2.api.AdvancedColor2;
import com.nitkanikita.advancedcolor2.api.animations.AnimationsManager;
import com.nitkanikita.advancedcolor2.api.animations.anims.Rainbow;
import com.nitkanikita.advancedcolor2.api.types.CustomCharacter;
import com.nitkanikita.advancedcolor2.api.types.CustomColor;
import com.nitkanikita.advancedcolor2.api.types.CustomText;
import com.nitkanikita.advancedcolor2.api.builders.GradientTextBuilder;
import com.nitkanikita.advancedcolor2.api.platforms.SpigotPlatform;
import com.nitkanikita.advancedcolor2.spigot.placeholders.TestPlaceholder;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.util.logging.Logger;


public class SpigotMain extends JavaPlugin {
    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void onEnable() {


        Logger logger = getLogger();
        logger.info("");
        logger.info("");
        logger.info("  AdvancedColor2 Plugin "+getDescription().getVersion());
        logger.info("#============================");
        logger.info("| AC2 Library: "+ SpigotPlatform.getInstance().getDescription().getVersion());
        logger.info("| ");
        logger.info("| Visit https://github.com/nitkanikita21/AdvancedColor2");
        logger.info("");
        logger.info("");

        AdvancedColor2.setup();
        AdvancedColor2.setControlCharacter(ChatColor.COLOR_CHAR);

        AnimationsManager.registerAnimation("test",new Rainbow(CustomText.text(
                "GAYBAR Billy Herrington",
                CustomCharacter.Code.BOLD.bit()
        ),3));

        getCommand("advancedcolor2").setExecutor((sender, command, label, args) -> {

            String minecraftString = GradientTextBuilder.get()
                    .addText(CustomText.text("Hello! Its my cool text. Do you like my gradient?", CustomCharacter.Code.ITALIC.bit()))
                    .addColor(CustomColor.of(Color.CYAN))
                    .addColor(CustomColor.of(Color.GREEN))
                    .addColor(CustomColor.of(Color.ORANGE))
                    .smooth(0.03)
                    .generate()
                    .toMinecraftString();

            sender.sendMessage("");
            sender.sendMessage("");

            sender.sendMessage(
                    ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "-=" + ChatColor.DARK_GRAY + "[ " +
                    ChatColor.BLUE + ChatColor.BOLD + getDescription().getName() +
                    ChatColor.DARK_GRAY + " ]" + ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "=-"
            );

            sender.sendMessage(CustomText.text(
                    "------------------------------",
                    CustomCharacter.Code.STRIKETHROUGH.bit(),
                    CustomColor.of(Color.DARK_GRAY)
                    )+"");

            String gradient = GradientTextBuilder.get()
                    .addColor(CustomColor.of(Color.WHITE))
                    .addColor(CustomColor.of(Color.GRAY))
                    .smooth(0.2)
                    .addText(CustomText.text("AC2 Library: "+ SpigotPlatform.getInstance().getDescription().getVersion()))
                    .generate()
                    .toMinecraftString();
            sender.sendMessage(gradient);

            sender.sendMessage("");
            sender.sendMessage("");


            return true;
        });

        if(getServer().getPluginManager().getPlugin("PlaceholderAPI") != null){
            new TestPlaceholder().register();
        }

    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
