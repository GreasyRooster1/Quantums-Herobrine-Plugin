package io.github.greasyrooster1.quantumsherobrine;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuantumsHerobrine extends JavaPlugin {

    @Override
    public void onEnable() {
        //Bukkit.getPluginManager().registerEvents();
        getCommand("test").setExecutor(new TestCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
