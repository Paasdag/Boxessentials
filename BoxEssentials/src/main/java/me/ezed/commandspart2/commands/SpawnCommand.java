package me.ezed.commandspart2.commands;

import me.ezed.commandspart2.BoxEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final BoxEssentials plugin;

    public SpawnCommand(BoxEssentials plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null) {
                // Save the initial player location
                Location initialLocation = p.getLocation();

                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                    // Check if the player has moved from the initial location (ignoring looking around)
                    Location currentLocation = p.getLocation();
                    double deltaX = initialLocation.getX() - currentLocation.getX();
                    double deltaY = initialLocation.getY() - currentLocation.getY();
                    double deltaZ = initialLocation.getZ() - currentLocation.getZ();
                    double squaredDistance = deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ;

                    if (squaredDistance < 0.001) { // Adjust the threshold as needed
                        p.teleport(location);
                        p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Successfully teleported you to spawn");
                    } else {
                        p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Teleportation canceled: You moved before teleporting.");
                    }
                }, 5 * 20);

            } else {
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "If you are a player, please report this to the owner/development team or use /setspawn command.");
            }
        }
        return true;
    }

}
