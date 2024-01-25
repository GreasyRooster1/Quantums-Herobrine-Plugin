package io.github.greasyrooster1.quantumsherobrine.Commands.Admin;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import io.github.greasyrooster1.quantumsherobrine.Herobrine.HerobrineData;
import io.github.greasyrooster1.quantumsherobrine.Util.Msg;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class DespawnCommand {
    public void register(){
        new CommandBase("despawn",true){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                if(!HerobrineData.citizensInstalled){
                    Msg.sendError(sender,"Citizens is not installed on this server");
                    return true;
                }
                for (Iterator<NPC> it = CitizensAPI.getNPCRegistry().iterator(); it.hasNext(); ) {
                    NPC npc = it.next();
                    npc.despawn();
                }
                CitizensAPI.getNPCRegistry().deregisterAll();

                return true;
            }

            @Override
            public String getUsage() {
                return "/despawn";
            }
            @Override
            public @NotNull String getDescription() {
                return "[QH] despawn citizens npcs";
            }
        }.setOp(true);
    }
}
