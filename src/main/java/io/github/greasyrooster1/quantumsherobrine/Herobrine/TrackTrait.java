package io.github.greasyrooster1.quantumsherobrine.Herobrine;

import net.citizensnpcs.api.trait.Trait;
import org.bukkit.entity.Player;

import java.time.LocalDateTime;

public class TrackTrait extends Trait {
    Player target;
    public TrackTrait(Player _target) {
        super("track");
        target = _target;
    }

    @Override
    public void run() {
        if(LocalDateTime.now().getSecond()%10==0) {
            HerobrineData.herobrine.getNavigator().setTarget(target.getLocation());
        }
        HerobrineData.herobrine.faceLocation(target.getLocation());
    }
}
