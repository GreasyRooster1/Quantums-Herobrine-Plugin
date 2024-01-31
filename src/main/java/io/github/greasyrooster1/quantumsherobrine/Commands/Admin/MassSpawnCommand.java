package io.github.greasyrooster1.quantumsherobrine.Commands.Admin;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static io.github.greasyrooster1.quantumsherobrine.Util.Msg.sendError;
import static io.github.greasyrooster1.quantumsherobrine.Util.Util.isNumeric;

public class MassSpawnCommand {
    public void register(){
        new CommandBase("multspawn",true){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                Player player = (Player) sender;
                if(args.length==2) {
                    for (int i = 0; i < Integer.parseInt(args[1]); i++) {
                        player.getWorld().spawn(player.getLocation(), (Class) getEntityByName(args[0]).getClass());
                    }
                } else if (args.length==1) {
                    player.getWorld().spawn(player.getLocation(), (Class) getEntityByName(args[0]).getClass());
                }else{
                    sendError(sender,"please specify an entity()");
                    sendUsage(sender);
                }
                return true;
            }

            @Override
            public String getUsage() {
                return "/multspawn (entity) [amount]";
            }

            @Override
            public @NotNull String getDescription() {
                return "[QH] spawn multiple entities at player location";
            }
        }.setOp(true);
    }
    public EntityType getEntityByName(String name) {
        for (EntityType type : EntityType.values()) {
            if(type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }
}
