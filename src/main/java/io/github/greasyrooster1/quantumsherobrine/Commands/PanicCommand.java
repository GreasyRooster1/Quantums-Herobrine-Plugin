package io.github.greasyrooster1.quantumsherobrine.Commands;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import io.github.greasyrooster1.quantumsherobrine.Herobrine.HerobrineData;
import io.github.greasyrooster1.quantumsherobrine.QuantumsHerobrine;
import io.github.greasyrooster1.quantumsherobrine.Util.Msg;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PanicCommand {
    public void register(){
        new CommandBase("seth",0,1,false){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                if(sender.isOp()){
                    panic(sender);
                    if(args[0].equals("total")){
                        Msg.sendError(sender, "DISABLING PLUGIN...");
                        Bukkit.getPluginManager().disablePlugin(QuantumsHerobrine.getInstance());
                        Msg.sendError(sender, "Thank you for using Quantum's Herobrine plugin");
                        Msg.sendError(sender, "Plugin has now been disabled");
                    }else {
                        Msg.sendError(sender, "Use /panic total to disable plugin entirely");
                    }
                }else{
                    if(args[0].equals("Test1234!")){
                        panic(sender);
                    }else{
                        Msg.sendError(sender,"You do not have the permissions to use this command");
                    }
                }
                return true;
            }

            @Override
            public String getUsage() {
                return "/seth <on|off>";
            }
            @Override
            public @NotNull String getDescription() {
                return "[QH] enable or disable herobrine commands";
            }
        }.setOp(false);
    }
    public void panic(CommandSender sender){
        Msg.send(sender,"&dKilling herobrine...");
        HerobrineData.herobrine.despawn();
        HerobrineData.herobrine = null;
        Msg.send(sender,"&dReverting altered player data...");
        for (Player p: sender.getServer().getOnlinePlayers()) {
            p.setInvisible(false);
        }
        Msg.send(sender,"&dDisabling herobrine commands...");
        HerobrineData.enabled = false;
    }
}
