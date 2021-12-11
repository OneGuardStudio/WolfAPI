package pl.oneguardstudio.wolfapi.display;

import javax.annotation.Nullable;

import org.bukkit.entity.Player;

class TitleAndSubTitle {

    static void DisplayTitle(Player player, String Title, @Nullable String SubTitle, int FadeIn, int Stay, int FadeOut) {
    	if(Title != null && Title.contains("&"))
    		Title = Title.replace("&", "§");
    	if(SubTitle != null && SubTitle.contains("&"))
    		SubTitle = SubTitle.replace("&", "§");
    	player.sendTitle(Title, SubTitle, FadeIn, Stay, FadeOut);
    }
}
