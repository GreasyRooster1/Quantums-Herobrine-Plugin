package io.github.greasyrooster1.quantumsherobrine.Commands;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import io.github.greasyrooster1.quantumsherobrine.Util.Msg;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HBJoinCommand {
    public void register(){
        new CommandBase("hbjoin",false){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                Msg.broadcast(sender,"&eHerobrine joined the game");
                return true;
            }

            @Override
            public String getUsage() {
                return "/hbjoin";
            }

            @Override
            public @NotNull List<String> getAliases() {
                List<String> aliases = new ArrayList<>();
                aliases.add("hjoin");
                return aliases;
            }

            @Override
            public @NotNull String getDescription() {
                return "[QH] send herobrine join message";
            }
        }.setOp(true).setHerobrine(true);
    }
}
