package pl.oneguardstudio.wolfapi.yaml;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;

class Save {
	
	 static void saveYamlFile(FileConfiguration yamlConfig, File yamlFile) {
		if(yamlConfig != null && yamlFile != null) {
			 try {
				 yamlConfig.save(yamlFile);
			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		}
	}
	 
}
