package io.github.greasyrooster1.quantumsherobrine;

import io.github.greasyrooster1.quantumsherobrine.Commands.ExplodeCommand;
import io.github.greasyrooster1.quantumsherobrine.Commands.FeedCommand;
import io.github.greasyrooster1.quantumsherobrine.Commands.HealCommand;
import io.github.greasyrooster1.quantumsherobrine.Commands.TestCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuantumsHerobrine extends JavaPlugin {
    static Plugin plugin;

    @Override
    public void onEnable() {
        //Bukkit.getPluginManager().registerEvents();

        plugin = this;

        getCommand("test").setExecutor(new TestCommand());
        getCommand("heal").setExecutor(new HealCommand());
        new FeedCommand().register();
        new ExplodeCommand().register();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getInstace(){
        return plugin;
    }
}
