package me.ezed.commandspart2.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class TrashCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player) sender;

        Inventory inventory = Bukkit.createInventory(p, 54, ChatColor.DARK_GREEN + "Trash");

        p.openInventory(inventory);


        return true;
    }
}
