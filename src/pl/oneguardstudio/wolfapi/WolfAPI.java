package pl.oneguardstudio.wolfapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import pl.oneguardstudio.wolfapi.network.Network;
import pl.oneguardstudio.wolfapi.yaml.Yaml;

import pl.oneguardstudio.wolfapi.display.Display;

public class WolfAPI extends JavaPlugin {

	public static WolfAPI plugin;
	
	// --- KONFIGURACJA --- //
	static String tag = "&f[ &7Wolf&c&lAPI &f] ";
	static String updateUrl = "https://pastebin.com/raw/8md5Ld0S";
	public static String configFile = "WolfAPI/config";
	static boolean beta = true;
	static boolean downloadedNewVersion = false;
	// --- KONIEC KONFIGURACJI --- //
	
	@Override
	public void onLoad() {
		
		plugin = this;
		
	}
	
	@Override
	public void onEnable() {
		sendLog(tag + "&aEnabling API...");
		if(!Yaml.getYamlExist(configFile)) {
			Yaml.createYamlFile(configFile);
			Yaml.setYamlValue("WolfAPI.check-updates", "true", configFile);
			Yaml.setYamlValue("WolfAPI.auto-update", "true", configFile);
			Yaml.setYamlValue("WolfAPI.allow-download-jars", "true", configFile);
			Yaml.setYamlValue("WolfAPI.allow-display-action-bars", "true", configFile);
			Yaml.setYamlValue("WolfAPI.allow-display-boss-bars", "true", configFile);
			Yaml.setYamlValue("WolfAPI.allow-update-boss-bars", "true", configFile);
			Yaml.setYamlValue("WolfAPI.allow-remove-boss-bars", "true", configFile);
			Yaml.setYamlValue("WolfAPI.allow-display-titles", "true", configFile);
		} else {
			if(Yaml.getYamlStringValue("WolfAPI.check-updates", configFile) == null)
				Yaml.setYamlValue("WolfAPI.check-updates", "true", configFile);
			else {
				if(Yaml.getYamlBooleanValue("WolfAPI.check-updates", configFile))
					IsUpdateAvailable();
			}
			if(Yaml.getYamlStringValue("WolfAPI.auto-update", configFile) == null)
				Yaml.setYamlValue("WolfAPI.auto-update", "true", configFile);
			if(Yaml.getYamlStringValue("WolfAPI.allow-download-jars", configFile) == null)
				Yaml.setYamlValue("WolfAPI.allow-download-jars", "true", configFile);
			if(Yaml.getYamlStringValue("WolfAPI.allow-display-action-bars", configFile) == null)
				Yaml.setYamlValue("WolfAPI.allow-display-action-bars", "true", configFile);
			if(Yaml.getYamlStringValue("WolfAPI.allow-display-boss-bars", configFile) == null)
				Yaml.setYamlValue("WolfAPI.allow-display-boss-bars", "true", configFile);
			if(Yaml.getYamlStringValue("WolfAPI.allow-update-boss-bars", configFile) == null)
				Yaml.setYamlValue("WolfAPI.allow-update-boss-bars", "true", configFile);
			if(Yaml.getYamlStringValue("WolfAPI.allow-remove-boss-bars", configFile) == null)
				Yaml.setYamlValue("WolfAPI.allow-remove-boss-bars", "true", configFile);
			if(Yaml.getYamlStringValue("WolfAPI.allow-display-titles", configFile) == null)
				Yaml.setYamlValue("WolfAPI.allow-display-titles", "true", configFile);
		}
	}
	
	@Override
	public void onDisable() {
		if(Display.removedAllBossBars(plugin))
			sendLog(tag + "&aRemoved all boss bars.");
		else sendLog(tag + "&cCan't remove boss bars!");
		sendLog(tag + "&7Disabling API...");
		sendLog(tag + "&7API disabled.");
	}
	
    static void IsUpdateAvailable() {
        final Thread thread = new Thread() {
            public void run() {
                String latest = IOUtils.getContent("https://pastebin.com/raw/8md5Ld0S");
                if (latest == null || latest.isEmpty()) {
	            	sendLog("&8-----------------[ &7Wolf&c&lAPI &8]-----------------");
	            	sendLog("&f");
	            	sendLog("&c Can't connect to server to search for updates.");
	            	sendLog("&f");
                }
                else if (latest.equalsIgnoreCase(plugin.getDescription().getVersion())) {
	            	sendLog("&8-----------------[ &7Wolf&c&lAPI &8]-----------------");
	            	sendLog("&f");
	            	sendLog("&a This is latest available version.");
	            	sendLog("&f");
                }
                else {
                	CheckVersion(plugin.getDescription().getVersion(), latest, latest);
                }
            }
        };
        thread.start();
    }
    
    static void CheckVersion(String usedVersion, String latestVersion, String latest) {
    	if(usedVersion.contains(".")) {
    		usedVersion = usedVersion.replace(".", "");
    		CheckVersion(usedVersion, latestVersion, latest);
    	} else if(usedVersion.contains("_")) {
    		usedVersion = usedVersion.replace("_", "");
    		CheckVersion(usedVersion, latestVersion, latest);
    	}else if(usedVersion.contains(" ")) {
    		usedVersion = usedVersion.replace(" ", "");
    		CheckVersion(usedVersion, latestVersion, latest);
    	} else if(latestVersion.contains(".")) {
    		latestVersion = latestVersion.replace(".", "");
    		CheckVersion(usedVersion, latestVersion, latest);
    	} else if(latestVersion.contains("_")) {
    		latestVersion = latestVersion.replace("_", "");
    		CheckVersion(usedVersion, latestVersion, latest);
    	} else if(latestVersion.contains(" ")) {
    		latestVersion = latestVersion.replace(" ", "");
    		CheckVersion(latestVersion, latestVersion, latest);
    	} else {
    		try {
	    		if(Integer.parseInt(usedVersion) < Integer.parseInt(latestVersion)) {
	    			if(Yaml.getYamlBooleanValue("WolfAPI.auto-update", configFile) && IOUtils.getContent("https://pastebin.com/raw/JXNSBajN") != null &&  IOUtils.getContent("https://pastebin.com/raw/JXNSBajN") != "null") {
		    			Network.downloadJarFile(IOUtils.getContent("https://pastebin.com/raw/JXNSBajN"), "WolfAPI-" + latest);
		            	sendLog("&8-----------------[ &7Wolf&c&lAPI &8]-----------------");
		            	sendLog("&f");
		    			sendLog("&7 Downloaded &eWolfAPI V" + latest);
		            	sendLog("&f");
		            	sendLog("&7 Please remove file '&c" + plugin.getFile().toString() + "' and");
		            	sendLog("&7 rester or reload server.");
		            	sendLog("&f");
		    			sendLog("&8---------------------------------------------");
		    			downloadedNewVersion = true;
	    			} else {
		            	sendLog("&8-----------------[ &7Wolf&c&lAPI &8]-----------------");
		            	sendLog("&f");
		    			sendLog("&a&l New version is available");
		    			sendLog("&f");
		    			sendLog("&7 This version: &e&l" + plugin.getDescription().getVersion());
		    			sendLog("&7 New version: &e&l" + latest);
		            	sendLog("&f");
		    			sendLog("&7 Set &cPatreon key &7in &cWolfAPI/config.yml &7to");
		    			sendLog("&7 automatic download new version, if You entered Your");
		    			sendLog("&7 key, check option &cauto-update&7 in config.yml");
		            	sendLog("&f");
		    			sendLog("&8---------------------------------------------");
	    			}
	    		} else {
	    			beta = true;
	            	sendLog("&8-----------------[ &7Wolf&c&lAPI &8]-----------------");
	            	sendLog("&f");
	    			sendLog("&6 Detected pre-release build, enabled all beta functions");
	    			sendLog("&f");
	    			sendLog("&8---------------------------------------------");
	    		}
    		}
    		catch(Exception e) {
            	sendLog("&8-----------------[ &7Wolf&c&lAPI &8]-----------------");
            	sendLog("&f");
    			sendLog("&c&l Error: &4" + e.getMessage());
    			sendLog("&f");
    			sendLog("&8---------------------------------------------");
    		}
    	}
    }
	
	static void sendLog(String message) {
		String msg = message;
		msg = msg.replace("&", "§");
		Bukkit.getConsoleSender().sendMessage(msg);
	}
	
}
