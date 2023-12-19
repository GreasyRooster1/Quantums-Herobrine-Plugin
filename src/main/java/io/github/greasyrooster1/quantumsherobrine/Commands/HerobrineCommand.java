package io.github.greasyrooster1.quantumsherobrine.Commands;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import io.github.greasyrooster1.quantumsherobrine.Herobrine.GenocideTrait;
import io.github.greasyrooster1.quantumsherobrine.Herobrine.HerobrineData;
import io.github.greasyrooster1.quantumsherobrine.Herobrine.MurderTrait;
import io.github.greasyrooster1.quantumsherobrine.Herobrine.TrackTrait;
import io.github.greasyrooster1.quantumsherobrine.Util.Msg;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class HerobrineCommand {
    public void register(){
        new CommandBase("herobrine",true){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                Player player = (Player) sender;
                if(args.length>0) {
                    switch (args[0]){
                        case "create": create(player,args); break;
                        case "remove": remove(player,args); break;
                        case "walk": walk(player,args); break;
                        case "face": face(player,args); break;
                        case "track": track(player,args); break;
                        case "murder": murder(player,args); break;
                        case "genocide": genocide(player,args); break;
                        default:Msg.sendError(sender,"please specify an action (create|remove|walk|face|track|murder|genocide)"); break;
                    }
                }
                return true;
            }

            @Override
            public String getUsage() {
                return "/herobrine <create|remove|walk|face|track|murder|genocide> [target] [x] [y] [z]";
            }

            @Override
            public @NotNull String getDescription() {
                return "[QH] preform a Herobrine related action";
            }
        }.setOp(true);
    }

    private void create(Player sender,String[] args) {
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "Herobrinee");
        npc.spawn(sender.getLocation());
        npc.getEntity();
        HerobrineData.herobrine = npc;
    }
    private void remove(Player sender,String[] args) {
        HerobrineData.herobrine.despawn();
    }
    private void walk(Player sender,String[] args) {
        Location loc = null;
        if(args.length==4) {
            loc = new Location(sender.getWorld(), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
        } else if (args.length==1) {
            loc = sender.getLocation();
        }
        else if (args.length==2) {
            loc = Bukkit.getPlayer(args[1]).getLocation();
        }
        HerobrineData.herobrine.getNavigator().setTarget(loc);;
    }
    private void face(Player sender,String[] args) {
        Location loc = null;
        if(args.length==4) {
            loc = new Location(sender.getWorld(), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
        } else if (args.length==1) {
            loc = sender.getLocation();
        }
        else if (args.length==2) {
            loc = Bukkit.getPlayer(args[1]).getLocation();
        }
        HerobrineData.herobrine.faceLocation(loc);
    }

    private void track(Player sender,String[] args) {
        Player target = sender;
        if(args.length==2) {
            if (Objects.equals(args[1], "start")) {
                HerobrineData.herobrine.removeTrait(TrackTrait.class);
                HerobrineData.herobrine.addTrait(new TrackTrait(target));
            } else if (Objects.equals(args[1], "stop")) {
                HerobrineData.herobrine.removeTrait(TrackTrait.class);
            }
        }else if(args.length==3){
            target = Bukkit.getPlayer(args[1]);
            if (Objects.equals(args[2], "start")) {
                HerobrineData.herobrine.removeTrait(TrackTrait.class);
                HerobrineData.herobrine.addTrait(new TrackTrait(target));
            } else if (Objects.equals(args[2], "stop")) {
                HerobrineData.herobrine.removeTrait(TrackTrait.class);
            }
        }else{
            Msg.sendError(sender,"you need to specify start or stop ( /herobrine track <stop|start> [player])");
        }
    }

    private void murder(Player sender,String[] args) {
        Player target = sender;
        if(args.length==2) {
            if (Objects.equals(args[1], "start")) {
                HerobrineData.herobrine.removeTrait(MurderTrait.class);
                HerobrineData.herobrine.addTrait(new MurderTrait(target));
            } else if (Objects.equals(args[1], "stop")) {
                HerobrineData.herobrine.removeTrait(MurderTrait.class);
            }
        }else if(args.length==3){
            target = Bukkit.getPlayer(args[1]);
            if (Objects.equals(args[2], "start")) {
                HerobrineData.herobrine.removeTrait(MurderTrait.class);
                HerobrineData.herobrine.addTrait(new MurderTrait(target));
            } else if (Objects.equals(args[2], "stop")) {
                HerobrineData.herobrine.removeTrait(MurderTrait.class);
            }
        }else{
            Msg.sendError(sender,"you need to specify start or stop ( /herobrine murder <stop|start> [player])");
        }
    }
    private void genocide(Player sender,String[] args) {
        Player target = sender;
        if(args.length==2) {
            if (Objects.equals(args[1], "start")) {
                HerobrineData.herobrine.removeTrait(GenocideTrait.class);
                HerobrineData.herobrine.addTrait(new GenocideTrait(target));
            } else if (Objects.equals(args[1], "stop")) {
                HerobrineData.herobrine.removeTrait(GenocideTrait.class);
            }
        }else if(args.length==3){
            target = Bukkit.getPlayer(args[1]);
            if (Objects.equals(args[2], "start")) {
                HerobrineData.herobrine.removeTrait(GenocideTrait.class);
                HerobrineData.herobrine.addTrait(new GenocideTrait(target));
            } else if (Objects.equals(args[2], "stop")) {
                HerobrineData.herobrine.removeTrait(GenocideTrait.class);
            }
        }else{
            Msg.sendError(sender,"you need to specify start or stop ( /herobrine genocide <stop|start> [player])");
        }
    }
}
