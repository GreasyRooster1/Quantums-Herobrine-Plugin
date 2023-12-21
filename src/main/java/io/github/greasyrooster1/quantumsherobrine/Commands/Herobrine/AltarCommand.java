package io.github.greasyrooster1.quantumsherobrine.Commands.Herobrine;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AltarCommand {
    public void register(){
        new CommandBase("altar",true){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                Player p = (Player) sender;
                World w = p.getWorld();
                for (int i = -1; i <=1 ; i++) {
                    for (int j = -1; j <=1 ; j++) {
                        setBlock(p,new Location(w,i,0,j),Material.GOLD_BLOCK);
                    }
                }
                setBlock(p,new Location(w,0,1,0),Material.NETHERRACK);
                setBlock(p,new Location(w,0,2,0),Material.FIRE);
                setBlock(p,new Location(w,1,1,0),Material.REDSTONE_TORCH);
                setBlock(p,new Location(w,-1,1,0),Material.REDSTONE_TORCH);
                setBlock(p,new Location(w,0,1,1),Material.REDSTONE_TORCH);
                setBlock(p,new Location(w,0,1,-1),Material.REDSTONE_TORCH);

                return true;
            }

            @Override
            public String getUsage() {
                return "/altar";
            }
            @Override
            public @NotNull String getDescription() {
                return "[QH] create a herobrine altar";
            }
        }.setOp(true).setHerobrine(true);
    }

    private void setBlock(Player p, Location loc, Material mat){
        p.getWorld().getBlockAt(loc.add(p.getLocation())).setType(mat);
    }
}
