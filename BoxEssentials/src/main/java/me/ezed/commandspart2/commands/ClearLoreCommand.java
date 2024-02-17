package me.ezed.commandspart2.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClearLoreCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (!player.hasPermission("be.clearlore")) {
                player.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                return true;
            }
            ItemStack item = player.getItemInHand();
            if (item.getAmount() == 0) {
                player.sendMessage(ChatColor.RED + "You don't have an item in your hand!");
                return true;
            }
            String Name = "";
            ItemMeta itemStackMeta = item.getItemMeta();
            itemStackMeta.setLore(null);
            item.setItemMeta(itemStackMeta);
            player.sendMessage(ChatColor.GREEN + "Lore has been cleared from your " + item.getType().name().toLowerCase());
            return true;
        }
        sender.sendMessage("You must be a player to use this command");
        return true;
    }
}
