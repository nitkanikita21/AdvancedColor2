package com.nitkanikita.advancedcolor2.spigot;

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

            return true;
        });
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
