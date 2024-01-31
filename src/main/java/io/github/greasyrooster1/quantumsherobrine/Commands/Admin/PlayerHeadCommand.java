package io.github.greasyrooster1.quantumsherobrine.Commands.Admin;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import static io.github.greasyrooster1.quantumsherobrine.Util.Util.isNumeric;

public class PlayerHeadCommand {
    public void register(){
        new CommandBase("playerhead",true){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                Player player = (Player) sender;
                if(args.length>0) {
                    ItemStack skull = new ItemStack(Material.PLAYER_HEAD); // Create a new ItemStack of the Player Head type.
                    SkullMeta skullMeta = (SkullMeta) skull.getItemMeta(); // Get the created item's ItemMeta and cast it to SkullMeta so we can access the skull properties
                    skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(args[0])); // Set the skull's owner so it will adapt the skin of the provided username (case sensitive).
                    skull.setItemMeta(skullMeta); // Apply the modified meta to the initial created item
                    player.getInventory().addItem(skull);
                }else{
                    ItemStack skull = new ItemStack(Material.PLAYER_HEAD); // Create a new ItemStack of the Player Head type.
                    SkullMeta skullMeta = (SkullMeta) skull.getItemMeta(); // Get the created item's ItemMeta and cast it to SkullMeta so we can access the skull properties
                    skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(player.getName())); // Set the skull's owner so it will adapt the skin of the provided username (case sensitive).
                    skull.setItemMeta(skullMeta); // Apply the modified meta to the initial created item
                    player.getInventory().addItem(skull);
                }
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
