package me.ezed.commandspart2.commands;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    private ArrayList<Player> list_of_flying_players = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (p.hasPermission("be.fly"))
                if (this.list_of_flying_players.contains(p)) {
                    this.list_of_flying_players.remove(p);
                    p.setAllowFlight(false);
                    p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Flying disabled");
                } else if (!this.list_of_flying_players.contains(p)) {
                    this.list_of_flying_players.add(p);
                    p.setAllowFlight(true);
                    p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Flying enabled");
                }
        }
        return true;
    }
}
