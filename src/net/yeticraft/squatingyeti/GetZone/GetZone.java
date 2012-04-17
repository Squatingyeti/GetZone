package net.yeticraft.squatingyeti.GetZone;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

import static com.sk89q.worldguard.bukkit.BukkitUtil.toVector;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.managers.RegionManager;


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
		//Location loc = player.getLocation();
		World world = player.getWorld();
		if(!(world.getName().equalsIgnoreCase("yeticraft"))){
			player.sendMessage(ChatColor.RED + "Every Squatch for themselves");
			return true;
		}
			if (label.equalsIgnoreCase("getZone") || label.equalsIgnoreCase("gz")) {
				
				Location loc = player.getLocation();
				int x = loc.getBlockX();
				int z = loc.getBlockZ();
				if (currentZone(player.getLocation(), player.getName()).equalsIgnoreCase("Almas")) {
					if ((x > -106 && x < 115) && (z > -137 && z < 139)) {
						player.sendMessage(ChatColor.GRAY + "You are in " + ChatColor.GREEN + "Spawn - "
								+ ChatColor.GRAY + "Build: " + ChatColor.RED + "OFF" + ChatColor.GRAY + " PVP: "
								+ ChatColor.RED + "OFF");
								return true;
					}
					if ((x > -461 && x < 460) && (z > -461 && z < 460)) {
						player.sendMessage(ChatColor.GRAY + "You are in " + ChatColor.GREEN + "Starting Area - "
								+ ChatColor.GRAY + "Build: " + ChatColor.GREEN + "ON" + ChatColor.GRAY + " PVP: "
								+ ChatColor.GREEN + "ON");
								return true;
					} else{
					player.sendMessage(ChatColor.GRAY + "You are in " + ChatColor.GREEN + "Almas - "
							+ ChatColor.GRAY + "Build: " + ChatColor.GREEN + "ON" + ChatColor.GRAY + " PVP: "
							+ ChatColor.GREEN + "ON");
							return true;
					}
				}

				if (currentZone(player.getLocation(), player.getName()).equalsIgnoreCase("Sasquai")) {
					player.sendMessage(ChatColor.GRAY + "You are in " + ChatColor.GREEN + "Sasquai - "
							+ ChatColor.GRAY + "Build: " + ChatColor.GREEN + "ON" + ChatColor.GRAY + " PVP: "
							+ ChatColor.GREEN + "ON");
							return true;
				}
				
				if (currentZone(player.getLocation(), player.getName()).equalsIgnoreCase("Sasquai_Front")) {
					player.sendMessage(ChatColor.GRAY + "You are in " + ChatColor.GREEN + "Sasquai Front - "
							+ ChatColor.GRAY + "Build: " + ChatColor.GREEN + "ON" + ChatColor.GRAY + " PVP: "
							+ ChatColor.GREEN + "ON");
							return true;
				}
				
				if (currentZone(player.getLocation(), player.getName()).equalsIgnoreCase("Yowie_Front")) {
					player.sendMessage(ChatColor.GRAY + "You are in " + ChatColor.GREEN + "Yowie Front - "
							+ ChatColor.GRAY + "Build: " + ChatColor.GREEN + "ON" + ChatColor.GRAY + " PVP: "
							+ ChatColor.GREEN + "ON");
							return true;
				}	
			
				if (currentZone(player.getLocation(), player.getName()).equalsIgnoreCase("Yowie")) {
					player.sendMessage(ChatColor.GRAY + "You are in " + ChatColor.GREEN + "Yowie - "
							+ ChatColor.GRAY + "Build: " + ChatColor.GREEN + "ON" + ChatColor.GRAY + " PVP: "
							+ ChatColor.GREEN + "ON");
							return true;
				}
				else {
				player.sendMessage(ChatColor.YELLOW + "You must be in a special zone. Move a bit and try again");
				}
			} return true;
	}
			
	public WorldGuardPlugin getWorldGuard() {
		Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
		
		if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
			return null;
		}
		return (WorldGuardPlugin) plugin;
	}

	public String currentZone(Location loc, String player) {
		
		WorldGuardPlugin worldGuard = getWorldGuard();
		
		Vector pt = toVector(loc);
		
		RegionManager regionManager = worldGuard.getRegionManager(loc.getWorld());
		List<String> regionSet = regionManager.getApplicableRegionsIDs(pt);
	
		for(String currentRegion : regionSet) {
			if (currentRegion.toLowerCase().equalsIgnoreCase("Sasquai"))
				return ("Sasquai");
			if (currentRegion.toLowerCase().equalsIgnoreCase("Sasquai_Front"))
				return ("Sasquai_Front");
			if (currentRegion.toLowerCase().equalsIgnoreCase("Almas")) 
				return ("Almas");
			if (currentRegion.toLowerCase().equalsIgnoreCase("Yowie_Front"))
				return ("Yowie_Front");
			if (currentRegion.toLowerCase().equalsIgnoreCase("Yowie"))
				return ("Yowie");

		}
	 return ("Unknown");
	} 
}		