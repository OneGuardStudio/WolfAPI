package pl.oneguardstudio.wolfapi.yaml;

import java.io.File;

import pl.oneguardstudio.wolfapi.WolfAPI;

class GetExist {
	
	static boolean GetYamlFileExist(String LocalFileName) {
		if(LocalFileName != null) {
			if(LocalFileName.length() > 0) {
				LocalFileName = WolfAPI.plugin.getDataFolder().getParentFile() + "/" + LocalFileName + ".yml";
				return new File(LocalFileName).exists();
			} else return false;
		} else return false;
	}

}
