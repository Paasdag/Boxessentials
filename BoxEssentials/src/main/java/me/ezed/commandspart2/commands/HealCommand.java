package me.ezed.commandspart2.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player ){
            Player p = (Player) sender;

            if (args.length == 0){
                p.setHealth(20);
                p.sendMessage(ChatColor.GREEN + "U have been healed");

            }else {

                String playerName = args[0];

                Player target = Bukkit.getServer().getPlayerExact(playerName);

                if (target == null){
                    p.sendMessage(ChatColor.RED + "This player is not online or exists!");
                }else{
                    p.sendMessage(ChatColor.GREEN + "Player has been healed");
                    target.setHealth(20);
                    target.sendMessage(ChatColor.GREEN + "U have been healed by " + p.getDisplayName());
                }

            }

        }

        return true;
    }
}
