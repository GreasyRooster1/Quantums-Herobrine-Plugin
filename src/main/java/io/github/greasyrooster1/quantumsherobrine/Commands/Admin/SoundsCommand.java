package io.github.greasyrooster1.quantumsherobrine.Commands.Admin;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import static net.kyori.adventure.text.Component.text;

public class SoundsCommand {
    public static String[] keys = {};
    public static Sound[] sounds = {};
    public void register(){
        new CommandBase("sounds",true){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                Inventory inventory = Bukkit.createInventory((InventoryHolder) sender,27);

                keys = new String[0];
                sounds = new Sound[0];

                ItemStack cave = createDisk(Material.MUSIC_DISC_11, Sound.AMBIENT_CAVE,toolText("Cave"),1);
                addItem(inventory,cave,10);
                ItemStack enderman = createDisk(Material.MUSIC_DISC_MALL, Sound.ENTITY_ENDERMAN_DEATH,toolText("Enderman"),2);
                addItem(inventory,enderman,11);
                ItemStack vex = createDisk(Material.MUSIC_DISC_WAIT, Sound.ENTITY_VEX_DEATH,toolText("Vex"),3);
                addItem(inventory,vex,12);
                ItemStack horse = createDisk(Material.MUSIC_DISC_BLOCKS, Sound.ENTITY_HORSE_DEATH,toolText("Horse"),4);
                addItem(inventory,horse,13);
                ItemStack roar = createDisk(Material.MUSIC_DISC_STAL, Sound.ENTITY_ENDER_DRAGON_GROWL,toolText("Dragon Roar"),5);
                addItem(inventory,roar,14);
                ItemStack death = createDisk(Material.MUSIC_DISC_STRAD, Sound.ENTITY_ENDER_DRAGON_DEATH,toolText("Dragon Death"),6);
                addItem(inventory,death,15);
                ItemStack victory = createDisk(Material.MUSIC_DISC_CAT, Sound.UI_TOAST_CHALLENGE_COMPLETE,toolText("Victory"),7);
                addItem(inventory,victory,16);

                ((Player) sender).openInventory(inventory);
                return true;
            }

            @Override
            public String getUsage() {
                return "/sounds";
            }

            @Override
            public @NotNull String getDescription() {
                return "[QH] spook players with sounds";
            }
        }.setOp(true);
    }

    public void addItem(Inventory inventory,ItemStack item,int i){
        inventory.setItem(i,item);
    }

    public ItemStack createDisk(Material material, Sound sound, Component name, int id){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.IMPALING,200,true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        meta.displayName(name);
        ArrayList<Component> lore = new ArrayList<>();
        lore.add( text("QAT0x1"+id));
        meta.lore(lore);
        item.setItemMeta(meta);

        sounds = appendSound(sounds,sound);
        keys = appendStr(keys,"QAT0x1"+id);

        return item;
    }

    public Component toolText(String name){
        return Component.text(name).color(TextColor.color(255,127,0)).decorate(TextDecoration.BOLD);
    }
    private Sound[] appendSound(Sound[] arr, Sound s){
        Sound[] newArray = Arrays.copyOf(arr, arr.length + 1);
        newArray[arr.length] = s;

        return newArray;
    }
    private String[] appendStr(String[] arr, String s){
        String[] newArray = Arrays.copyOf(arr, arr.length + 1);
        newArray[arr.length] = s;

        return newArray;
    }
}
