package io.github.greasyrooster1.quantumsherobrine.Herobrine;

import net.citizensnpcs.api.trait.Trait;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.List;

public class MorphTrait extends Trait {
    Player target;
    public MorphTrait(Player _target) {
        super("track");
        target = _target;
    }

    @Override
    public void run() {
        List rayBlocks = target.getLineOfSight(null,100);
        Block block = (Block) rayBlocks.get(rayBlocks.toArray().length - 1);
        Location loc = block.getLocation();
        Location behindLoc = target.getLocation().add(target.getLocation().getDirection().multiply(-0.4f));
        behindLoc.setY(target.getY());

        HerobrineData.herobrine.faceLocation(loc);
        HerobrineData.herobrine.teleport(behindLoc, PlayerTeleportEvent.TeleportCause.UNKNOWN);
    }
}
