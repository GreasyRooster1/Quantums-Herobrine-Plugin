package io.github.greasyrooster1.quantumsherobrine.Commands.Admin;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import io.github.greasyrooster1.quantumsherobrine.QuantumsHerobrine;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RegisterCommand {
    public void register(){
        new CommandBase("register",true){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                QuantumsHerobrine.getInstance().registerHerobrineCommands();
                return true;
            }

            @Override
            public String getUsage() {
                return "/register";
            }
            @Override
            public @NotNull String getDescription() {
                return "[QH] register herobrine commands";
            }
        }.setOp(true);
    }
}
