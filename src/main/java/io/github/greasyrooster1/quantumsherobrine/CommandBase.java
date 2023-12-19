package io.github.greasyrooster1.quantumsherobrine;

import io.github.greasyrooster1.quantumsherobrine.Herobrine.HerobrineData;
import io.github.greasyrooster1.quantumsherobrine.Util.Msg;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.SimplePluginManager;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class CommandBase extends BukkitCommand implements CommandExecutor {
    private List<String> delayedPlayers = null;
    private int delay = 0;
    private final int minArguments;
    private final int maxArguments;
    private final boolean playerOnly;
    private boolean isOp = false;
    private boolean isHerobrine = false;
    public CommandBase(String command){
        this(command,false);
    }
    public CommandBase(String command,boolean playerOnly){
        this(command,0,playerOnly);
    }
    public CommandBase(String command,int argumentAmount){
        this(command,argumentAmount,argumentAmount);
    }
    public CommandBase(String command,int minArguments,int maxArguments){
        this(command,minArguments,maxArguments,false);
    }
    public CommandBase(String command,int argumentAmount, boolean playerOnly){
        this(command,argumentAmount,argumentAmount,playerOnly);
    }

    public CommandBase(String command,int minArguments,int maxArguments, boolean playerOnly){
        super(command);
        this.minArguments = minArguments;
        this.maxArguments = maxArguments;
        this.playerOnly = playerOnly;
        CommandMap commandMap = getCommandMap();
        if(commandMap!=null){
            commandMap.register(command,this);
        }
    }

    public CommandMap getCommandMap(){
        try {
            if (Bukkit.getPluginManager() instanceof SimplePluginManager) {
                Field field = SimplePluginManager.class.getDeclaredField("commandMap");
                field.setAccessible(true);

                return (CommandMap) field.get(Bukkit.getPluginManager());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public CommandBase enableDely(int delay){
        this.delay = delay;
        this.delayedPlayers = new ArrayList<>();
        return this;
    }

    public CommandBase setOp(boolean op){
        isOp = op;
        return this;
    }

    public void removeDelay(Player player){
        this.delayedPlayers.remove(player.getName());
    }

    public void sendUsage(CommandSender sender){
        Msg.send(sender,getUsage());
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if(args.length<minArguments||(args.length<maxArguments && maxArguments==-1)){
            sendUsage(sender);
            return true;
        }

        if(isHerobrine&& !HerobrineData.enabled){
            Msg.sendError(sender,"Herobrine commands are not enabled!");
            return true;
        }

        if(playerOnly && !(sender instanceof Player)){
            Msg.sendError(sender,"Only players can use this command!");
            return true;
        }

        String permission = getPermission();
        if(permission!=null&& !sender.hasPermission(permission)){
            Msg.sendError(sender,"You do not have the required permissions");
            return true;
        }

        if(isOp&&!sender.isOp()){
            Msg.sendError(sender,"You do not have the required permissions");
            return true;
        }

        if(delayedPlayers!=null&&sender instanceof Player){
            Player player = (Player)sender;
            if(delayedPlayers.contains(player.getName())) {
                Msg.sendError(player,"Please wait before using this command again");
                return true;
            }
            delayedPlayers.add(player.getName());
            Bukkit.getScheduler().scheduleSyncDelayedTask(QuantumsHerobrine.getInstance(),()->{
                delayedPlayers.remove(player.getName());
            }, 20L *delay);
        }

        if(!onCommand(sender,args)){
            sendUsage(sender);
        }

        return false;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return this.onCommand(sender,command,label,args);
    }

    public abstract boolean onCommand(@NotNull CommandSender sender,@NotNull String[] args);

    public abstract String getUsage();

    public void setHerobrine(boolean herobrine){
        isHerobrine = herobrine;
    }
}
