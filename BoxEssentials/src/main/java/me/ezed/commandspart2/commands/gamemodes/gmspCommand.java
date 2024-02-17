package me.ezed.commandspart2.commands.gamemodes;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmspCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players.");
            return true;
        }else {
            Player player = (Player) sender;
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD +"Your gamemode has been set to spectator.");
        }
        return true;
    }
}
