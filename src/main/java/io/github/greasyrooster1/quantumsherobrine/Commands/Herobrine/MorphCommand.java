package io.github.greasyrooster1.quantumsherobrine.Commands.Herobrine;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import io.github.greasyrooster1.quantumsherobrine.Herobrine.GenocideTrait;
import io.github.greasyrooster1.quantumsherobrine.Herobrine.HerobrineData;
import io.github.greasyrooster1.quantumsherobrine.Herobrine.MorphTrait;
import io.github.greasyrooster1.quantumsherobrine.Util.Msg;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MorphCommand {
    public MorphCommand(){

    }
    public void register(){
        new CommandBase("morph",true){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                Player target = (Player) sender;
                if(args.length==1) {
                    if (Objects.equals(args[0], "start")) {
                        HerobrineData.herobrine.removeTrait(MorphTrait.class);
                        HerobrineData.herobrine.addTrait(new MorphTrait(target));
                        ((Player) sender).setInvisible(true);
                    } else if (Objects.equals(args[0], "stop")) {
                        HerobrineData.herobrine.removeTrait(MorphTrait.class);
                        ((Player) sender).setInvisible(false);
                    }
                }else{
                    Msg.sendError(sender,"you need to specify start or stop ( /morph <stop|start>)");
                }
                return true;
            }

            @Override
            public String getUsage() {
                return "/morph";
            }
            @Override
            public @NotNull String getDescription() {
                return "[QH] morph into herobrine";
            }
        }.setOp(true).setHerobrine(true);
    }
}
