package me.LeviCppn;

import me.LeviCppn.listeners.OreGenerationListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class BiggerVeins extends JavaPlugin {

    private int veinSizeMultiplier;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadConfigValues();

        getServer().getPluginManager().registerEvents(new OreGenerationListener(veinSizeMultiplier), this);
        getLogger().info("BiggerVeins is activaded! Veins are " + veinSizeMultiplier + "x times bigger.");
    }

    private void loadConfigValues() {
        FileConfiguration config = getConfig();
        veinSizeMultiplier = config.getInt("vein-size-multiplier", 2);
    }

    @Override
    public void onDisable() {
        getLogger().info("BiggerVeins is down.");
    }
}
