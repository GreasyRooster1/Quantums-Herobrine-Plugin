package io.github.greasyrooster1.quantumsherobrine.Commands.Admin;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import io.github.greasyrooster1.quantumsherobrine.Util.Msg;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

import static net.kyori.adventure.text.Component.text;

public class AdminToolsCommand {
    public void register(){
        new CommandBase("admintools",true){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                Inventory inventory = Bukkit.createInventory((InventoryHolder) sender,27);
                ItemStack adminSword = new ItemStack(Material.WOODEN_SWORD);
                adminSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL,999);
                adminSword.getItemMeta().setUnbreakable(true);
                adminSword.getItemMeta().setDisplayName("Admin Sword");
                ArrayList<Component> lore = new ArrayList<>();
                lore.add( text("QAT0x01"));
                adminSword.getItemMeta().lore(lore);
                addItem(inventory,adminSword,11);

                ItemStack adminPickaxe = new ItemStack(Material.NETHERITE_PICKAXE);
                adminPickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED,999);
                adminPickaxe.getItemMeta().setUnbreakable(true);
                adminPickaxe.getItemMeta().setDisplayName("Admin Pickaxe");
                ArrayList<Component> lore1 = new ArrayList<>();
                lore.add( text("QAT0x02"));
                adminSword.getItemMeta().lore(lore1);
                addItem(inventory,adminPickaxe,12);

                ItemStack adminBow = new ItemStack(Material.BOW);
                adminBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE,999);
                adminBow.addUnsafeEnchantment(Enchantment.ARROW_FIRE,5);
                adminBow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK,5);
                adminBow.getItemMeta().setUnbreakable(true);
                adminBow.getItemMeta().setDisplayName("Admin Bow");
                ArrayList<Component> lore2 = new ArrayList<>();
                lore.add( text("QAT0x03"));
                adminSword.getItemMeta().lore(lore2);
                addItem(inventory,adminBow,13);

                ItemStack smiteRod = new ItemStack(Material.BLAZE_ROD);
                smiteRod.getItemMeta().setUnbreakable(true);
                smiteRod.addUnsafeEnchantment(Enchantment.IMPALING,69);
                smiteRod.getItemMeta().addItemFlags(ItemFlag.HIDE_ENCHANTS);
                smiteRod.getItemMeta().setDisplayName("Smite Rod");
                ArrayList<Component> lore3 = new ArrayList<>();
                lore.add( text("QAT0x04"));
                adminSword.getItemMeta().lore(lore3);
                addItem(inventory,smiteRod,13);

                ((Player) sender).openInventory(inventory);
                return true;
            }

            @Override
            public String getUsage() {
                return "/admintools";
            }

            @Override
            public @NotNull List<String> getAliases() {
                List<String> aliases = new ArrayList<>();
                aliases.add("admint");
                aliases.add("atools");
                aliases.add("optools");
                return aliases;
            }

            @Override
            public @NotNull String getDescription() {
                return "[QH] very powerful tools and weapons";
            }
        }.setOp(true);
    }

    public void addItem(Inventory inventory,ItemStack item,int i){
        inventory.setItem(i,item);
    }
}
