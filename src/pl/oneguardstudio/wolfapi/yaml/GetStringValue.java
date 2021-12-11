package pl.oneguardstudio.wolfapi.yaml;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import pl.oneguardstudio.wolfapi.WolfAPI;

class GetStringValue {

	static String getYamlString(String name, String fileName) {
		if(name != null && fileName != null) {
			if(name.length() > 0 && fileName.length() > 0) {
				File file = new File(WolfAPI.plugin.getDataFolder().getParentFile() + "/" + fileName + ".yml");
				FileConfiguration fileYamlConfig = YamlConfiguration.loadConfiguration(file);
				return fileYamlConfig.getString(name);
			} else return null;
		} else return null;
	}
	
}
