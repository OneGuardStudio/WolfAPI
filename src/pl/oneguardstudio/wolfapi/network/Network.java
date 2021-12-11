package pl.oneguardstudio.wolfapi.network;

import org.bukkit.Bukkit;

import pl.oneguardstudio.wolfapi.IOUtils;
import pl.oneguardstudio.wolfapi.WolfAPI;
import pl.oneguardstudio.wolfapi.yaml.Yaml;

public class Network {

	/**
	 * Example: String text = Network.GetStringFromUrl("https://pastebin.com/raw/axmXjR9r");
	 * 
	 * @return String
	 * 
	 * @param Url - Url to file with text (e.g. https://pastebin.com/raw/axmXjR9r)
	 * 
	 * @apiNote Added in version 0.12
	 * @author GempXPlay
	 */
	public static String getStringFromUrl(String Url) {
		if(Url != null) {
			if(Url.length() > 0) {
				return IOUtils.getContent(Url);
			} else return null;
		} return null;
	}
	
	/**
	 * Example: if(Network.DownloadJarFile("https://mypage.example/plugin.jar", "MyPlugin"))
	 * Automtically download as JAR fie (.jar)
	 * 
	 * @return boolean
	 * 
	 * @param Url - Url to file with text (e.g. https://mypage.example/plugin.jar)
	 * @param LocalFileName - Downloaded file name (e.g. MyPlugin-1.0)
	 * 
	 * @apiNote Added in version 0.12
	 * @author GempXPlay
	 */
	public static void downloadJarFile(String Url, String LocalFileName) {
		if(Yaml.getYamlBooleanValue("WolfAPI.allow-download-jars", WolfAPI.configFile)) {
			if(Url != null && LocalFileName != null) {
				if(Url.length() > 0 && LocalFileName.length() > 0) {
					LocalFileName = WolfAPI.plugin.getDataFolder().getParentFile() + "/" +  LocalFileName + ".jar";
					Bukkit.getConsoleSender().sendMessage("WolfAPI - " + Url + ", " + LocalFileName);
					Download.DownloadFile(Url, LocalFileName);
				}
			}
		}
	}
	
}
