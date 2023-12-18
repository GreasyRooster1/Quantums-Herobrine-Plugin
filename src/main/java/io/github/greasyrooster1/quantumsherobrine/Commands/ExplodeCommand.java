package io.github.greasyrooster1.quantumsherobrine.Commands;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static io.github.greasyrooster1.quantumsherobrine.Util.Util.isNumeric;

public class ExplodeCommand {
    public void register(){
        new CommandBase("explode",true){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                Player player = (Player) sender;
                int explosionForce = 10;
                if(isNumeric(args[0])){
                    explosionForce = Integer.parseInt(args[0]);
                    if(!args[1].isEmpty()){
                        player = Bukkit.getPlayer(args[0]);
                    }
                }else{
                    if(!args[0].isEmpty()) {
                        player = Bukkit.getPlayer(args[0]);
                    }
                }
                player.getWorld().createExplosion(player.getLocation(),explosionForce);
                return true;
            }

            @Override
            public String getUsage() {
                return "/explosion [power] [player]";
            }

            @Override
            public @NotNull String getDescription() {
                return "[QH] create an explosion on a player";
            }
        };
    }
}
