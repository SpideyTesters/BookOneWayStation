package library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public static Properties readPropertiesFile()
	{
		FileInputStream fis = null;
		try 
		{
			String filePath = "./Properties/MakeMyTrip.properties";
			//path of configuration file
			fis = new FileInputStream(filePath);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try
		{
			prop.load(fis); //load file into the properties object
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return prop;
	}

}
