package pl.oneguardstudio.wolfapi.yaml;

public class Yaml {

	/**
	 * Example: Yaml.CreateYamlFile("MyPlugin/myFile");
	 * Create file Plugins/MyPlugin/myFile.yml
	 * 
	 * Create required directory if not exist.
	 * 
	 * @param FileName - Your file name (e.g. MyPlugin/myFile)
	 * 
	 * @apiNote Added in version 0.10
	 * @author GempXPlay
	 */
	public static void createYamlFile(String FileName) {
		Create.createYamlFile(FileName);
	}
	
	/**
	 * Example: Yaml.DeleteYamlFile("MyPlugin/myFile");
	 * Delete file myFile.yml in Plugins/MyPlugin/myFile.yml
	 * 
	 * @param FileName - Your file name (e.g. MyPlugin/myFile)
	 * 
	 * @apiNote Added in version 0.10
	 * @author GempXPlay
	 */
	public static void deleteYamlFile(String FileName) {
		Delete.deleteYamlFile(FileName);
	}
	
	/**
	 * Example: Yaml.SetYamlValue("my.value","1","MyPlugin/myFile");
	 * Set value in Plugins/MyPlugin/myFile.yml
	 * 
	 * Automatically detect INT - BOOLEAN - STRING
	 * 
	 * @param PathName - In Yaml file path (e.g. "my.file.value")
	 * @param Value - Value of param PathName
	 * @param FileName - Your file name (e.g. MyPlugin/myFile)
	 * 
	 * @apiNote Added in version 0.10
	 * @author GempXPlay
	 */
	public static void setYamlValue(String PathName, String Value, String FileName) {
		SetValue.setYamlValue(PathName, Value, FileName);
	}
	
	/**
	 * Example: Yaml.RemoveYamlValue("my.value","MyPlugin/myFile");
	 * Remove "value" from path in Plugins/MyPlugin/myFile.yml
	 * 
	 * @param PathName - In Yaml file path (e.g. "my.file.value")
	 * @param FileName - Your file name (e.g. MyPlugin/myFile)
	 * 
	 * @apiNote Added in version 0.10
	 * @author GempXPlay
	 */
	public static void removeYamlValue(String PathName, String FileName) {
		RemoveValue.removeYamlValue(PathName, FileName);
	}
	
	/**
	 * Example: String value = Yaml.GetYamlStringValue("my.value","MyPlugin/myFile");
	 * 
	 * @return String
	 *
	 * @param PathName - In Yaml file path (e.g. "my.file.value")
	 * @param FileName - Your file name (e.g. MyPlugin/myFile)
	 * 
	 * @apiNote Added in version 0.10
	 * @author GempXPlay
	 */
	public static String getYamlStringValue(String PathName, String FileName) {
		return GetStringValue.getYamlString(PathName, FileName);
	}
	
	/**
	 * Example: int value = Yaml.GetYamlIntValue("my.value","MyPlugin/myFile");
	 * 
	 * @return int
	 *
	 * @param PathName - In Yaml file path (e.g. "my.file.value")
	 * @param FileName - Your file name (e.g. MyPlugin/myFile)
	 * 
	 * @apiNote Added in version 0.10
	 * @author GempXPlay
	 */
	public static int getYamlIntValue(String PathName, String FileName) {
		return GetIntValue.getYamlInt(PathName, FileName);
	}

	/**
	 * Example: boolean value = Yaml.GetYamlBooleanValue("my.value","MyPlugin/myFile");
	 * 
	 * @return boolean
	 *
	 * @param PathName - In Yaml file path (e.g. "my.file.value")
	 * @param FileName - Your file name (e.g. MyPlugin/myFile)
	 * 
	 * @apiNote Added in version 0.10
	 * @author GempXPlay
	 */
	public static boolean getYamlBooleanValue(String PathName, String FileName) {
		return GetBooleanValue.getYamlBoolean(PathName, FileName);
	}
	
	/**
	 * Example: boolean exist = Yaml.GetYamlExist("MyPlugin/myFile");
	 * 
	 * @return boolean
	 *
	 * @param LocalFileName - File name to check [.yml] (e.g. MyPlugin/myFile)
	 * 
	 * @apiNote Added in version 0.13
	 * @author GempXPlay
	 */
	public static boolean getYamlExist(String LocalFileName) {
		return GetExist.GetYamlFileExist(LocalFileName);
	}
	
}
