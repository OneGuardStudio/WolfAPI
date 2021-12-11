package pl.oneguardstudio.wolfapi.yaml;

import java.io.File;

import pl.oneguardstudio.wolfapi.WolfAPI;

class Delete {
	
	static void deleteYamlFile(String fileName) {
		if(fileName != null) {
			if(fileName.length() > 0) {
				File file = new File(WolfAPI.plugin.getDataFolder().getParentFile() + "/" + fileName + ".yml");
				if(file.exists())
					file.delete();
			}
		}
	}

}
