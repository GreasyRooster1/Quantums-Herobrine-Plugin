package io.github.greasyrooster1.quantumsherobrine.Events;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class PlayerEvents implements Listener {
    @EventHandler
    public void onPlayerClicks(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();

        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
            if(item!=null) {
                if (Objects.requireNonNull(item.getItemMeta().lore()).get(0).contains(Component.text("QAT0x03"))) {
                    player.sendMessage("You have right click a slime ball!");
                }
            }
        }

    }
}
