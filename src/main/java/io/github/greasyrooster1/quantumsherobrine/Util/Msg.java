package io.github.greasyrooster1.quantumsherobrine.Util;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Msg {
    public static void send(CommandSender sender, String message){
        send(sender,message,"&f");
    }
    public static void sendError(CommandSender sender, String message){
        send(sender,message,"&c");
    }
    public static void sendWarn(CommandSender sender, String message){
        send(sender,message,"&e");
    }
    public static void sendSuccess(CommandSender sender, String message){
        send(sender,message,"&a");
    }
    public static void sendMinor(CommandSender sender, String message){
        send(sender,message,"&7");
    }

    public static void send(CommandSender sender, String message, String prefix){
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix+message));
    }
    public static void broadcast(CommandSender sender, String message){
        Bukkit.broadcast(Component.text(ChatColor.translateAlternateColorCodes('&',message)));
    }
}
