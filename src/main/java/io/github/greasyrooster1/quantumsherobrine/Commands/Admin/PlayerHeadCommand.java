package io.github.greasyrooster1.quantumsherobrine.Commands.Admin;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import static io.github.greasyrooster1.quantumsherobrine.Util.Util.isNumeric;

public class PlayerHeadCommand {
    public void register(){
        new CommandBase("playerhead",true){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                Player player = (Player) sender;
                ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
                player.getInventory().addItem(itemStack);
                
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
        }.setOp(true);
    }
}
