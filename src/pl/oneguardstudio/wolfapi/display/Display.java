package pl.oneguardstudio.wolfapi.display;

import javax.annotation.Nullable;

import org.bukkit.boss.BarColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import pl.oneguardstudio.wolfapi.WolfAPI;
import pl.oneguardstudio.wolfapi.yaml.Yaml;

public class Display {
	
	/**
	 * Example: Display.DisplayActionBar(player, "Hello");
	 *
	 * @param player - Player from Bukkit (Player)
	 * @param Message - Message (String)
	 * 
	 * @apiNote Added in version 0.14
	 * @author GempXPlay
	 */
	public static void displayActionBar(Player player, String Message) {
    	if(Yaml.getYamlBooleanValue("WolfAPI.allow-display-action-bars", WolfAPI.configFile)) {
			if(player != null && Message != null) {
				if(player.isOnline())
					ActionBar.DisplayActionBar(player, Message);
			}
    	}
	}
	
	/**
	 * Example: Display.DisplayBossBar(player, "Hello", 100, Color);
	 *
	 * @param player - Player from Bukkit (Player)
	 * @param Message - Message (String)
	 * @param Filled - Boss bar fill 0-100 (int)
	 * @param Color - Boss bar color (BarColor)
	 * 
	 * @apiNote Added in version 0.14
	 * @author GempXPlay
	 */
	public static void displayBossBar(Player player, String Message, int Filled, BarColor Color) {
    	if(Yaml.getYamlBooleanValue("WolfAPI.allow-display-boss-bars", WolfAPI.configFile)) {
			if(player != null && Message != null && Filled >= 0 && Filled <= 100 && Color != null) {
				if(player.isOnline())
					BossHealthBar.DisplayBossBar(player, Message, Filled, Color);
			}
    	}
	}
	
	/**
	 * Example: Display.UpdateBossBar(player, "Hello", 100, Color);
	 *
	 * @param player - Player from Bukkit (Player)
	 * @param Message - Message (String)
	 * @param Filled - Boss bar fill 0-100 (int)
	 * @param Color - Boss bar color (BarColor)
	 * 
	 * @apiNote Added in version 0.14
	 * @author GempXPlay
	 */
	public static void updateBossBar(Player player, String Message, int Filled, BarColor Color) {
    	if(Yaml.getYamlBooleanValue("WolfAPI.allow-update-boss-bars", WolfAPI.configFile)) {
			if(player != null && Message != null && Filled >= 0 && Filled <= 100 && Color != null) {
				if(player.isOnline())
					BossHealthBar.UpdateBossBar(player, Message, Filled, Color);
			}
    	}
	}
	
	/**
	 * Example: Display.RemoveBossBar(player);
	 *
	 * @param player - Player from Bukkit (Player)
	 * 
	 * @apiNote Added in version 0.14
	 * @author GempXPlay
	 */
	public static void removeBossBar(Player player) {
    	if(Yaml.getYamlBooleanValue("WolfAPI.allow-remove-boss-bars", WolfAPI.configFile)) {
			if(player != null) {
				if(player.isOnline())
					BossHealthBar.RemoveBossBar(player);
			}
    	}
	}
	
	/**
	 * Example: Display.DisplayTitleAndSubTitle(player, "Hello", null, 0, 0, 0);
	 *
	 * @param player - Player from Bukkit (Player)
	 * @param Title - Title (String)
	 * @param SubTitle - Sub title (String) [can be null]
	 * @param FadeIn - Fade in animation time (int) [in ticks]
	 * @param Stay - Stay on screen (int) [in ticks]
	 * @param FadeOut - Fade out animation time (int) [in ticks]
	 * 
	 * @apiNote Added in version 0.14
	 * @author GempXPlay
	 */
	public static void displayTitleAndSubTitle(Player player, String Title, @Nullable String SubTitle, @Nullable int FadeIn, @Nullable int Stay, @Nullable int FadeOut) {
		if(Yaml.getYamlBooleanValue("WolfAPI.allow-display-titles", WolfAPI.configFile)) {
			if(FadeIn < 1)
				FadeIn = 1;
			if(Stay < 20)
				Stay = 20;
			if(FadeOut < 1)
				FadeOut = 1;
			if(player != null && Title != null) {
				if(player.isOnline())
					TitleAndSubTitle.DisplayTitle(player, Title, SubTitle, FadeIn, Stay, FadeOut);
			}
		}
	}
	
	/**
	 * Only for WolfAPI, don't use this boolean!
	 * 
	 * @apiNote Added in version 0.15
	 * @author GempXPlay
	 */
	public static boolean removedAllBossBars(Plugin plugin) {
		if(plugin == WolfAPI.plugin) {
			BossHealthBar.RemoveAllBossBars();
			return true;
		} else return false;
	}

}
