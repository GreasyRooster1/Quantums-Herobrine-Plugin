package io.github.greasyrooster1.quantumsherobrine.Commands;

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
                if(args.length==2) {
                    if (Objects.equals(args[1], "start")) {
                        HerobrineData.herobrine.removeTrait(MorphTrait.class);
                        HerobrineData.herobrine.addTrait(new MorphTrait(target));
                    } else if (Objects.equals(args[1], "stop")) {
                        HerobrineData.herobrine.removeTrait(MorphTrait.class);
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
        }.setOp(true);
    }
}
