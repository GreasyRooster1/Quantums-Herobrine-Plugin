package io.github.greasyrooster1.quantumsherobrine.Commands.Util;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import io.github.greasyrooster1.quantumsherobrine.Util.Msg;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand {
    public void register(){
        new CommandBase("qhelp",true){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                Msg.send(sender,"&d------Help------\n" +
                                        "&l&8Quantums Herobrine V1.2&r" +
                                        "&l&9-CORE COMMANDS-&r\n" +
                                        "\n" +
                                        "&b/herobrine&7 - herobrine related actions\n" +
                                        "   &b/herobrine &6create&7 - spawn herobrine (required for other commands)\n" +
                                        "   &b/herobrine &6remove&7 - remove herobrine\n" +
                                        "   &b/herobrine &6walk&7 - make herobrine walk to a location or player\n" +
                                        "   &b/herobrine &6face&7 - make herobrine face a location or player\n" +
                                        "   &b/herobrine &6track <stop|start> [player]&7 - make herobrine track a player\n" +
                                        "   &b/herobrine &6murder <stop|start> [player]&7 - set a player for herobrine to kill\n" +
                                        "   &b/herobrine &6genocide <stop|start>&7 - make herobrine kill every player\n" +
                                        "   &f&l------------\n" +
                                        "   &7 when using the herobrine actions (track/murder/genocide), you need to disable any previously activated actions. For example, if you use &b/herobrine &6murder start Esporterz1&7  then you decide you want to enable genocide with &b/herobrine &6genocide start&7, you need to disable the murder action with &b/herobrine &6murder stop&7. this logic also applies if you want to switch to murder/track another player\n" +
                                        "&b/seth <on|off>&7 - enable or disable herobrine\n" +
                                        "   &7 this command is needed to use herobrine related commands\n" +
                                        "&b/panic [total]&7 - fix issues that may happen\n" +
                                        "   &7 This command should fix any issues with the plugin.\n" +
                                        "   &7 Use /panic total to disable the plugin entirely if you are still having issues" +
                                        "   &7 Test1234! " +
                                        "\n" +
                                        "&l&9-OTHER COMMANDS-&r\n" +
                                        "&b/admintools&7 - give yourself some useful tools\n" +
                                        "&b/despawn&7 - despawn all fake players (use if there is an issue with them)\n" +
                                        "&b/explode&7 - explode a player\n" +
                                        "&b/altar&7 - place a herobrine altar at your position\n" +
                                        "&b/hbjoin&7 and&b /hbleave&7 - send a herobrine leave/join message to everyone\n" +
                                        "&b/hbmessage&7 - send a message to everyone as herobrine (color codes supported with &)\n" +
                                        "&b/morph&7 - morph into herobrine (requires herobrine to be in the world)\n");
                return true;
            }

            @Override
            public String getUsage() {
                return "/qhelp";
            }


            @Override
            public @NotNull String getDescription() {
                return "[QH] help menu";
            }
        }.setOp(true);
    }
}
