package me.ezed.commandspart2.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlySpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.hasPermission("be.flyspeed")){

                if (args.length == 0){
                    p.sendMessage(ChatColor.RED + "Please provide the speed");
                    p.sendMessage(ChatColor.GREEN + "Example: /flyspeed 0.5");
                }else {
                    String flystring = args[0];
                    int flyint = Integer.parseInt(flystring);

                    switch (flyint) {
                        case 1:
                            p.setFlySpeed(0.1F);
                            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Sucsesfully set the  flyspeed to 1.");
                            break;
                        case 2:
                            p.setFlySpeed(0.2F);
                            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Sucsesfully set the flyspeed to 2.");
                            break;
                        case 3:
                            p.setFlySpeed(0.3F);
                            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Sucsesfully set the flyspeed to 3.");
                            break;
                        case 4:
                            p.setFlySpeed(0.4F);
                            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Sucsesfully set the flyspeed to 4.");
                            break;
                        case 5:
                            p.setFlySpeed(0.5F);
                            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Sucsesfully set the flyspeed to 5.");
                            break;
                        case 6:
                            p.setFlySpeed(0.6F);
                            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Sucsesfully set the flyspeed to 6.");
                            break;
                        case 7:
                            p.setFlySpeed(0.7F);
                            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Sucsesfully set the flyspeed to 7.");
                            break;
                        case 8:
                            p.setFlySpeed(0.8F);
                            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Sucsesfully set the flyspeed to 8.");
                            break;
                        case 9:
                            p.setFlySpeed(0.9F);
                            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Sucsesfully set the flyspeed to 9.");
                            break;
                        case 10:
                            p.setFlySpeed(1F);
                            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Sucsesfully set the flyspeed to 10.");
                            break;
                    }

                }
            }
        }
        return true;
    }
}
