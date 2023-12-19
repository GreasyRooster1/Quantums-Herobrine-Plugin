package io.github.greasyrooster1.quantumsherobrine;

import io.github.greasyrooster1.quantumsherobrine.Commands.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuantumsHerobrine extends JavaPlugin {
    static QuantumsHerobrine plugin;


    @Override
    public void onEnable() {
        //Bukkit.getPluginManager().registerEvents();

        plugin = this;

        new SetHCommand().register();
        new PanicCommand().register();

        getCommand("test").setExecutor(new TestCommand());
        getCommand("heal").setExecutor(new HealCommand());
        new FeedCommand().register();
        new ExplodeCommand().register();
    }

    public void registerHerobrineCommands(){
        new HerobrineCommand().register();
        new HBMessageCommand().register();
        new MorphCommand().register();
        new AltarCommand().register();
        new HBJoinCommand().register();
        new HBLeaveCommand().register();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static QuantumsHerobrine getInstance(){
        return plugin;
    }
}
