package io.github.greasyrooster1.quantumsherobrine.Herobrine;

import net.citizensnpcs.api.trait.Trait;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.time.LocalDateTime;
import java.util.List;

import static java.lang.Math.pow;

public class GenocideTrait extends Trait {
    Player target;
    public GenocideTrait(Player _target) {
        super("genocide");
        target = _target;
    }

    @Override
    public void run() {
        List<Entity> near = HerobrineData.herobrine.getEntity().getNearbyEntities(50.0D, 50.0D, 50.0D);
        for(Entity entity : near) {
            if(entity instanceof Player) {
                Player nearPlayer = (Player) entity;
                target = nearPlayer;
                break;
            }
        }
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
