package me.ezed.commandspart2.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SetLore implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (!player.hasPermission("be.setlore")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "You don't have permission to do that!"));
                return true;
            }
            ItemStack item = player.getItemInHand();
            if (item.getAmount() == 0) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "You don't have an item in your hand!"));
                return true;
            }
            String Name = "";
            for (int i = 0; i < args.length; i++) {
                Name = Name + args[i];
                Name = Name + " ";
            }
            try {
                List<String> list;
                ItemMeta itemStackMeta = item.getItemMeta();
                if(itemStackMeta.getLore() == null) {
                    list = new ArrayList<>();
                } else {
                    list = itemStackMeta.getLore();
                }
                if (player.hasPermission("be.color")) {
                    list.add(ChatColor.translateAlternateColorCodes('&', Name));
                } else {
                    list.add(Name);
                }
                itemStackMeta.setLore(list);
                item.setItemMeta(itemStackMeta);
                player.sendMessage(ChatColor.GREEN + "Lore " + Name + "&r has been added to your " + item.getType().name().toLowerCase());
            } catch (Exception e) {
                System.out.println(e);
                player.sendMessage(ChatColor.RED + "Something went wrong here");
            }
            return true;
        }
        System.out.println("You must be a player to use this command");
        return true;
    }
}
