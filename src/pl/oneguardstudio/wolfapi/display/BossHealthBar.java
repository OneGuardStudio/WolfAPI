package pl.oneguardstudio.wolfapi.display;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import java.util.*;

class BossHealthBar {
	static BossBar[] boss = new BossBar[999999];
	static Player[] players = new Player[999999];
	
	static void RemoveAllBossBars() {
		for (int i = 0; i < players.length; i++) {
			if(players[i] == null && boss[i] == null)
				RemoveBossBar(players[i]);
		}
	}
	
	static void UpdateBossBar(Player player, String Message, int Filled, BarColor Color) {
		for (int i = 0; i < players.length; i++) {
			if(players[i] == player && boss[i] == null) {
				RemoveBossBar(players[i]);
				DisplayBossBar(player, Message, Filled, Color);
				break;
			}
		}
	}
	
	static void DisplayBossBar(Player player, String Message, int Filled, BarColor Color) {
		Objects.requireNonNull(Message, "&7WOLF&9&lSK2");
				
		Message = ChatColor.translateAlternateColorCodes('&', Message);
				
		BarColor barColor = Color;
				
		for (int i = 0; i < players.length; i++) {
			if(players[i] == null && boss[i] == null) {
				players[i] = player;
				boss[i] = Bukkit.createBossBar(Message, barColor, BarStyle.SOLID);
				boss[i].addPlayer(player);
				boss[i].setProgress((float)Filled/100);
				boss[i].setVisible(true);
				break;
			}
		}
	}
	static void RemoveBossBar(Player player) {
		for (int i = 0; i < players.length; i++) {
			if(players[i] == player && boss[i] != null) {
				players[i] = null;
				boss[i].removePlayer(player);
				boss[i].setVisible(false);
				boss[i] = null;
				break;
			}
		}
	}
}
