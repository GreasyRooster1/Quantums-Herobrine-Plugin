package io.github.greasyrooster1.quantumsherobrine.Commands.Admin;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import io.github.greasyrooster1.quantumsherobrine.Herobrine.HerobrineData;
import io.github.greasyrooster1.quantumsherobrine.QuantumsHerobrine;
import io.github.greasyrooster1.quantumsherobrine.Util.Msg;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.DespawnReason;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class PanicCommand {
    public void register(){
        new CommandBase("panic",0,1,false){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                if(sender.isOp()){
                    panic(sender);
                    if(args.length==1) {
                        if (args[0].equals("total")) {
                            Msg.sendError(sender, "Shutdown Citizens...");
                            CitizensAPI.shutdown();
                            Msg.sendError(sender, "DISABLING PLUGIN...");
                            Bukkit.getPluginManager().disablePlugin(QuantumsHerobrine.getInstance());
                            Bukkit.getCommandMap().clearCommands();
                            Msg.sendError(sender, "Thank you for using Quantum's Herobrine plugin");
                            Msg.sendError(sender, "Plugin has now been disabled");
                        } else {
                            Msg.sendError(sender, "Use /panic total to disable plugin entirely");
                        }
                    }
                }else{
                    if(args.length==1) {
                        if (args[0].equals("Test1234!")) {
                            panic(sender);
                        } else {
                            Msg.sendError(sender, "You do not have the permissions to use this command");
                        }
                    }else{
                        Msg.sendError(sender, "You do not have the permissions to use this command");
                    }
                }
                return true;
            }

            @Override
            public String getUsage() {
                return "/panic [total]";
            }
            @Override
            public @NotNull String getDescription() {
                return "[QH] disable herobrine, use /panic total to disable plugin";
            }
        }.setOp(false);
    }
    public void panic(CommandSender sender){
        Msg.send(sender,"&dKilling herobrine...");
        if(HerobrineData.herobrine!=null) {
            HerobrineData.herobrine.despawn();
            HerobrineData.herobrine = null;
        }
        Msg.send(sender,"&dDe-spawning Citizens NPCs");
        for (Iterator<NPC> it = CitizensAPI.getNPCRegistry().iterator(); it.hasNext(); ) {
            NPC npc = it.next();
            npc.despawn();
        }
        CitizensAPI.getNPCRegistry().deregisterAll();
        Msg.send(sender,"&dReverting altered player data...");
        for (Player p: sender.getServer().getOnlinePlayers()) {
            p.setInvisible(false);
        }
        Msg.send(sender,"&dDisabling herobrine commands...");
        HerobrineData.enabled = false;
        Msg.sendError(sender, "If there were multiple Citizens NPCs that were removed please use /citizens save");
        Msg.sendError(sender, "Also, make sure to set the Citizens config property \"save-tast/delay\" to 9,999,999 (its towards the bottom of the file)");
        Msg.sendError(sender, "Config file is located at /plugins/Citizens/config.yml ");
    }
}
