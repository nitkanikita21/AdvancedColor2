package com.nitkanikita.advancedcolor2.spigot.placeholders;

import com.nitkanikita.advancedcolor2.api.animations.AnimationsManager;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;

public class TestPlaceholder extends PlaceholderExpansion {
    @Override
    public String getIdentifier() {
        return "test";
    }

    @Override
    public String getAuthor() {
        return "NitkaNikita";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        return AnimationsManager.getAnimation(getIdentifier()).toMinecraftString();
    }
}
