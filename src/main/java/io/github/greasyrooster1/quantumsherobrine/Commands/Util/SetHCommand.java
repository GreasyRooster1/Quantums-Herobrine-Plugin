package io.github.greasyrooster1.quantumsherobrine.Commands.Util;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import io.github.greasyrooster1.quantumsherobrine.Herobrine.HerobrineData;
import io.github.greasyrooster1.quantumsherobrine.Util.Msg;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetHCommand {
    public void register(){
        new CommandBase("seth",1,false){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                if(args[0].equals("on")) {
                    HerobrineData.enabled =true;
                    Msg.send(sender,"&bHerobrine commands are now &a&lENABLED");
                }
                if(args[0].equals("off")) {
                    HerobrineData.enabled =false;
                    Msg.send(sender,"&bHerobrine commands are now &c&lDISABLED");
                }
                return true;
            }

            @Override
            public String getUsage() {
                return "/seth <on|off>";
            }
            @Override
            public @NotNull String getDescription() {
                return "[QH] enable or disable herobrine commands";
            }
        }.setOp(true);
    }
}
