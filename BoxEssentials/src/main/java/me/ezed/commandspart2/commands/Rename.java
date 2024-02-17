package me.ezed.commandspart2.commands;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Rename implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to use this command");
            return true;
        }
        final Player player = (Player)sender;
        if (!player.hasPermission("boxessentials.Rename")) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "You don't have permission to do that!"));
            return true;
        }
        final ItemStack item = player.getItemInHand();
        if (item.getAmount() == 0) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "You don't have an item in your hand!"));
            return true;
        }
        String Name = "";
        for (int i = 0; i < args.length; ++i) {
            Name += args[i];
            Name += " ";
        }
        final ItemMeta itemStackMeta = item.getItemMeta();
        if (player.hasPermission("boxessentials.Color")) {
            itemStackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
        }
        else {
            itemStackMeta.setDisplayName(Name);
        }
        item.setItemMeta(itemStackMeta);
        return true;
    }
}