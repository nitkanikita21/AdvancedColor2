package com.nitkanikita.advancedcolor2.api.platforms;

import com.nitkanikita.advancedcolor2.api.animations.AnimationsManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class SpigotPlatform extends JavaPlugin {
    @Getter
    private static SpigotPlatform instance;

    @Override
    public void onEnable() {
        instance = this;

        Logger logger = getServer().getLogger();
        logger.info("");
        logger.info("AdvancedColor2 Library " + getDescription().getVersion());
        logger.info("");

        init();
    }

    public void init(){
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

            private int tickTimer = 0;

            @Override
            public void run() {
                AnimationsManager.onTick(tickTimer);
                tickTimer++;
            }
        },0,0);


    }
}
