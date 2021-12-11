package pl.oneguardstudio.wolfapi.files;

public class Files {
	
	/**
	 * Example: boolean exist = Files.FileExist("MyPlugin/myFile.yml");
	 * 
	 * @return boolean
	 *
	 * @param LocalFileName - File name to check (e.g. MyPlugin/myFile)
	 * 
	 * @apiNote Added in version 0.13
	 * @author GempXPlay
	 */
	public static boolean fileExist(String LocalFileName) {
		return BooleanFileExist.Exist(LocalFileName);
	}

}
