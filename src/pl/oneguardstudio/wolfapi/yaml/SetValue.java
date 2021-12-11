package pl.oneguardstudio.wolfapi.yaml;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import pl.oneguardstudio.wolfapi.WolfAPI;

class SetValue {

	static void setYamlValue(String name, String value, String fileName) {
		if(name != null && value != null && fileName != null) {
			if(name.length() > 0 && value.length() > 0 && fileName.length() > 0) {
				File file = new File(WolfAPI.plugin.getDataFolder().getParentFile() + "/" + fileName + ".yml");
				FileConfiguration fileYamlConfig = YamlConfiguration.loadConfiguration(file);
				if(value.matches("[0-9]+")) {
					int intValue = Integer.parseInt(value);
					fileYamlConfig.set(name, intValue);
				} else if(value.equalsIgnoreCase("true")) {
					fileYamlConfig.set(name, true);
				} else if(value.equalsIgnoreCase("false")) {
					fileYamlConfig.set(name, false);
				} else
					fileYamlConfig.set(name, value);
				Save.saveYamlFile(fileYamlConfig, file);
			}
		}
	}
	
}
