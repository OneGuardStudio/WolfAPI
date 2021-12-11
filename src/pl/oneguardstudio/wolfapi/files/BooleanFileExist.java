package pl.oneguardstudio.wolfapi.files;

import java.io.File;

import pl.oneguardstudio.wolfapi.WolfAPI;

class BooleanFileExist {
	
	static boolean Exist(String LocalFileName) {
		if(LocalFileName != null) {
			if(LocalFileName.length() > 0) {
				LocalFileName = WolfAPI.plugin.getDataFolder().getParentFile() + "/" + LocalFileName;
				return new File(LocalFileName).exists();
			} else return false;
		} else return false;
	}

}
