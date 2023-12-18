package io.github.greasyrooster1.quantumsherobrine;

import io.github.greasyrooster1.quantumsherobrine.Util.Msg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Msg.send(sender,"&bYou are a player!");
        }else{
            Msg.send(sender,"&bYou are not a player!");
        }
        return true;
    }
}
