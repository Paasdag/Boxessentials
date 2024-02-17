package me.ezed.commandspart2.commands;

import me.ezed.commandspart2.BoxEssentials;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final BoxEssentials plugin;

    public SetSpawnCommand(BoxEssentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            Location location = player.getLocation();

            plugin.getConfig().set("spawn", location);
            plugin.saveConfig();
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Location set succsesfully");



        }else {
            System.out.println("Not executable from console.");
        }

        return true;
    }
}
