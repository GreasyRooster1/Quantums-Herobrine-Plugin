package io.github.greasyrooster1.quantumsherobrine.Events;

import io.github.greasyrooster1.quantumsherobrine.Commands.Admin.SoundsCommand;
import io.github.greasyrooster1.quantumsherobrine.Util.Util;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Random;

import static io.github.greasyrooster1.quantumsherobrine.Util.Util.randint;

public class PlayerEvents implements Listener {
    @EventHandler
    public void onPlayerClicks(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();

        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
            if(item!=null) {
                if(item.getItemMeta().hasLore()) {
                    if (item.getItemMeta().lore().get(0).toString().contains("QAT0x03")) {
                        Location loc = player.getTargetBlock(null, 512).getLocation();
                        player.getWorld().strikeLightning(loc);
                    }
                    if (item.getItemMeta().lore().get(0).toString().contains("QAT0x04")) {
                        Location loc = player.getTargetBlock(null, 512).getLocation();
                        player.getWorld().createExplosion(loc,7);
                    }
                    if (item.getItemMeta().lore().get(0).toString().contains("QAT0x05")) {
                        Location loc = player.getTargetBlock(null, 512).getLocation().add(0,25,0);
                        player.getWorld().getBlockAt(loc).setType(Material.ANVIL,true);
                    }
                    if (item.getItemMeta().lore().get(0).toString().contains("QAT0x06")) {
                        Location loc = player.getTargetBlock(null, 512).getLocation();
                        for (int i = 0; i < 20; i++) {
                            player.getWorld().strikeLightning(loc);
                        }
                        player.getWorld().createExplosion(loc,5);
                    }
                    if (item.getItemMeta().lore().get(0).toString().contains("QAT0x07")) {
                        Fireball fireball = player.launchProjectile(Fireball.class,player.getLocation().getDirection());
                        fireball.setDirection(player.getLocation().getDirection());
                        fireball.setYield(10);
                    }
                    int index =0;
                    for (String key:SoundsCommand.keys) {
                        if(item.getItemMeta().lore().get(0).toString().contains(key)){
                            for (Player p:player.getWorld().getPlayers()) {
                                p.playSound(p.getLocation(), SoundsCommand.sounds[index], 500.0f, 1.0f);
                            }
                        }
                        index++;
                    }
                }
            }
        }

    }
}
