package io.github.greasyrooster1.quantumsherobrine.Herobrine;

import net.citizensnpcs.api.trait.Trait;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import javax.swing.text.Position;

import java.time.LocalDateTime;

import static java.lang.Math.pow;

public class MurderTrait extends Trait {
    Player target;
    public MurderTrait(Player _target) {
        super("murder");
        target = _target;
    }

    @Override
    public void run() {
        if(LocalDateTime.now().getSecond()%10==0) {
            HerobrineData.herobrine.getNavigator().setTarget(target.getLocation());
        }
        HerobrineData.herobrine.faceLocation(target.getLocation());
        Location herobrinePos = HerobrineData.herobrine.getEntity().getLocation();
        double killDist = 2;
        if(pow(herobrinePos.x()-target.getX(),2)+pow(herobrinePos.y()-target.getY(),2)+pow(herobrinePos.z()-target.getZ(),2)<pow(killDist,2)){
            target.damage(999,HerobrineData.herobrine.getEntity());
        }
    }
}
