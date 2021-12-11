package pl.oneguardstudio.wolfapi.yaml;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import pl.oneguardstudio.wolfapi.WolfAPI;

class Create {

	static void createYamlFile(String fileName) {
		if(fileName != null) {
			if(fileName.length() > 0) {
				File file = new File(WolfAPI.plugin.getDataFolder().getParentFile() + "/" + fileName + ".yml");
				FileConfiguration fileYamlConfig = YamlConfiguration.loadConfiguration(file);
				Save.saveYamlFile(fileYamlConfig, file);
			}
		}
	}
	
}
