package pl.oneguardstudio.wolfapi.display;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

class ActionBar {
	
    static void DisplayActionBar(Player player, String message) {
	    message = ChatColor.translateAlternateColorCodes('&', message);
	    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
    }
    
}
