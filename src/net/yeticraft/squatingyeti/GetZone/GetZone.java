package net.yeticraft.squatingyeti.GetZone;

import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;


public class GetZone extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	
	public void onDisable() {
		log.info("GetZone disabled");
	}
	
	public void onEnable() {
		log.info("GetZone has been Enabled");
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// only works for players in game
		if (!(sender instanceof Player)) {
            sender.sendMessage("This Command only works for players");
            return true;
        }

		Player player =(Player) sender;
		Location loc = player.getLocation();
		World world = player.getWorld();
		if(!(world.getName().equalsIgnoreCase("yeticraft"))){
			player.sendMessage(ChatColor.RED + "Every Squatch for themselves");
			return true;
		}
			if (label.equalsIgnoreCase("getZone") || label.equalsIgnoreCase("gz")) {
			int x = loc.getBlockX(); 
			int z = loc.getBlockZ();
				if (x > -4000 && x < 4000 && z < -500 && z > -2250) {
				player.sendMessage(ChatColor.GRAY + "You are in " + ChatColor.GREEN + "Sasqaui Front - "
						+ ChatColor.GRAY + "Build: " + ChatColor.GREEN + "ON" + ChatColor.GRAY + " PVP: "
						+ ChatColor.GREEN + "ON");
				return true;
			}
					else if (x > -4000 && x < 4000 && z < -2250 && z > -4000) {
						player.sendMessage(ChatColor.GRAY + "You are in " + ChatColor.GREEN + "Sasqaui - "
								+ ChatColor.GRAY + "Build: " + ChatColor.GREEN + "ON" + ChatColor.GRAY + " PVP: "
								+ ChatColor.GREEN + "ON");
				return true;
			}
					else if (x > -4000 && x < 4000 && z > 500 && z < 2250) {
						player.sendMessage(ChatColor.GRAY + "You are in " + ChatColor.GREEN + "Yowie Front - "
								+ ChatColor.GRAY + "Build: " + ChatColor.GREEN + "ON" + ChatColor.GRAY + " PVP: "
								+ ChatColor.GREEN + "ON");
				return true;
			}
					else if (x > -4000 && x < 4000 && z > 2250 && z < 4000) {
						player.sendMessage(ChatColor.GRAY + "You are in " + ChatColor.GREEN + "Yowie - "
								+ ChatColor.GRAY + "Build: " + ChatColor.GREEN + "ON" + ChatColor.GRAY + " PVP: "
								+ ChatColor.GREEN + "ON");
				return true;
			}
					else if (x > -4000 && x < -750 && z > -500 && z < 500 || x > 750 && x < 4000 && z > -500 && z < 500) {
						player.sendMessage(ChatColor.GRAY + "You are in " + ChatColor.GREEN + "Almas - "
								+ ChatColor.GRAY + "Build: " + ChatColor.GREEN + "ON" + ChatColor.GRAY + " PVP: "
								+ ChatColor.GREEN + "ON");
				return true;
			}
			else {
				player.sendMessage(ChatColor.GRAY + "You are in " + ChatColor.GREEN + "Spawn - "
						+ ChatColor.GRAY + "Build: " + ChatColor.GREEN + "ON" + ChatColor.GRAY + " PVP: "
						+ ChatColor.RED + "OFF");
				return true;
			}
		}
		return false;
	}
}