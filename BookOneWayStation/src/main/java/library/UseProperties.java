package library;

import java.util.Properties;

public class UseProperties {                           //To use the properties file

	static Properties prop = ReadProperties.readPropertiesFile();

	public static String getBrowser()
	{
		return prop.getProperty("Browser");             

	}
	public static String getUrl()
	{
		return prop.getProperty("URL");                  
	}

}
