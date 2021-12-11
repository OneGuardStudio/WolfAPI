package pl.oneguardstudio.wolfapi.yaml;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import pl.oneguardstudio.wolfapi.WolfAPI;

class GetIntValue {
	
	static int getYamlInt(String name, String fileName) {
		if(name != null && fileName != null) {
			if(name.length() > 0 && fileName.length() > 0) {
				File file = new File(WolfAPI.plugin.getDataFolder().getParentFile() + "/" + fileName + ".yml");
				FileConfiguration fileYamlConfig = YamlConfiguration.loadConfiguration(file);
				return fileYamlConfig.getInt(name);
			} else return -999999;
		} else return -999999;
	}

}
