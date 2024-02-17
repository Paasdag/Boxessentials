package me.ezed.commandspart2;

import me.ezed.commandspart2.commands.*;
import me.ezed.commandspart2.commands.gamemodes.gmaCommand;
import me.ezed.commandspart2.commands.gamemodes.gmcCommand;
import me.ezed.commandspart2.commands.gamemodes.gmsCommand;
import me.ezed.commandspart2.commands.gamemodes.gmspCommand;
import me.ezed.commandspart2.listeners.JoinListener;
import me.ezed.commandspart2.listeners.SpawnListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BoxEssentials extends JavaPlugin {

    @Override
    public void onEnable() {

        // for config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();


        // for commands
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("rename").setExecutor(new Rename());
        getCommand("clearlore").setExecutor(new ClearLoreCommand());
        getCommand("setlore").setExecutor(new SetLore());
        getCommand("trash").setExecutor(new TrashCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("flyspeed").setExecutor(new FlySpeedCommand());
        getCommand("gmc").setExecutor(new gmcCommand());
        getCommand("gms").setExecutor(new gmsCommand());
        getCommand("gmsp").setExecutor(new gmspCommand());
        getCommand("gma").setExecutor(new gmaCommand());

        //for events/listeners
        getServer().getPluginManager().registerEvents(new SpawnListener(this), this);
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
