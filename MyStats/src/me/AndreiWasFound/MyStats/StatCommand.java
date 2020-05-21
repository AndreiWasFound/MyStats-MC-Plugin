package me.AndreiWasFound.MyStats;

import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("mystats")) {
			if (!(sender instanceof Player)) {
				//console
				sender.sendMessage("Console cannot run this command");
				return true;
			}
			Player player = (Player) sender;
			if (args.length == 0) {
				// /mystats
				player.sendMessage(ChatColor.RED + "Usage: /mystats {deaths/logins/mobKills/playerKills}");
				return true;
			}
			if (args.length >= 1) {
				if (args[0].equalsIgnoreCase("deaths")) {
					player.sendMessage(ChatColor.AQUA + "You have died " + player.getStatistic(Statistic.DEATHS) + " times");
					return true;
				}
				if (args[0].equalsIgnoreCase("logins")) {
					player.sendMessage(ChatColor.AQUA + "You have logged in " + (player.getStatistic(Statistic.LEAVE_GAME) + 1) + " times");
					return true;
				}
				if (args[0].equalsIgnoreCase("mobKills")) {
					player.sendMessage(ChatColor.AQUA + "You have killed " + player.getStatistic(Statistic.MOB_KILLS) + " mobs");
					return true;
				}
				if (args[0].equalsIgnoreCase("playerKills")) {
					player.sendMessage(ChatColor.AQUA + "You have killed " + player.getStatistic(Statistic.PLAYER_KILLS) + " players");
					return true;
				}
			}
			
		}
		return false;	
	}
}
