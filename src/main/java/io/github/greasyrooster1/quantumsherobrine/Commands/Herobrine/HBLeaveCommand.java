package io.github.greasyrooster1.quantumsherobrine.Commands.Herobrine;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import io.github.greasyrooster1.quantumsherobrine.Util.Msg;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HBLeaveCommand {
    public void register(){
        new CommandBase("hbleave",false){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                Msg.broadcast(sender,"&eHerobrine left the game");
                return true;
            }

            @Override
            public String getUsage() {
                return "/hbleave";
            }

            @Override
            public @NotNull List<String> getAliases() {
                List<String> aliases = new ArrayList<>();
                aliases.add("hleave");
                return aliases;
            }

            @Override
            public @NotNull String getDescription() {
                return "[QH] send herobrine leave message";
            }
        }.setOp(true).setHerobrine(true);
    }
}
