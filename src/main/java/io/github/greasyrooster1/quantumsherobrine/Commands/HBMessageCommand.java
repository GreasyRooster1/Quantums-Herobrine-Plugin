package io.github.greasyrooster1.quantumsherobrine.Commands;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import io.github.greasyrooster1.quantumsherobrine.Util.Msg;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HBMessageCommand {
    public void register(){
        new CommandBase("hbmessage",false){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                String message = String.join(" ",args);
                Msg.broadcast(sender,"<Herobrine> "+message);
                return true;
            }

            @Override
            public String getUsage() {
                return "/hbmessage <message>";
            }

            @Override
            public @NotNull List<String> getAliases() {
                List<String> aliases = new ArrayList<>();
                aliases.add("hbm");
                return aliases;
            }

            @Override
            public @NotNull String getDescription() {
                return "[QH] broadcast a chat message as herobrine, use &a, &ad, and &0 for red, dark red, and black";
            }
        }.setOp(true);
    }
}
