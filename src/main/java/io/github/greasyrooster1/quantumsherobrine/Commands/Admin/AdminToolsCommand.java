package io.github.greasyrooster1.quantumsherobrine.Commands.Admin;

import io.github.greasyrooster1.quantumsherobrine.CommandBase;
import io.github.greasyrooster1.quantumsherobrine.Util.Msg;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.BufferedCommandSender;
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
import java.util.InvalidPropertiesFormatException;
import java.util.List;

import static net.kyori.adventure.text.Component.text;

public class AdminToolsCommand {
    public void register(){
        new CommandBase("admintools",true){
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args) {
                Inventory inventory = Bukkit.createInventory((InventoryHolder) sender,27);

                ItemStack adminSword = createAdminTool(Material.NETHERITE_SWORD,Enchantment.DAMAGE_ALL,"&k&5QH &r&dAdmin Sword &k&5QH",1);
                addItem(inventory,adminSword,11);

                ItemStack adminPickaxe = createAdminTool(Material.NETHERITE_PICKAXE,Enchantment.DIG_SPEED,"&k&5QH &r&dAdmin Pickaxe &k&5QH",2);
                addItem(inventory,adminPickaxe,12);

                ItemStack smiteRod = createAdminTool(Material.BLAZE_ROD,Enchantment.CHANNELING,"&k&5QH &r&dSmite Rod &k&5QH",3);
                addItem(inventory,smiteRod,13);

                ItemStack bombRod = createAdminTool(Material.REDSTONE_TORCH,Enchantment.CHANNELING,"&k&5QH &r&dBomb Rod &k&5QH",3);
                addItem(inventory,bombRod,14);

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

    public ItemStack createAdminTool(Material material,Enchantment enchantment,String name,int id){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        item.addUnsafeEnchantment(enchantment,999);
        meta.setUnbreakable(true);
        meta.displayName(Component.text(ChatColor.translateAlternateColorCodes('&',name)));
        ArrayList<Component> lore = new ArrayList<>();
        lore.add( text("QAT0x0"+id));
        meta.lore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
