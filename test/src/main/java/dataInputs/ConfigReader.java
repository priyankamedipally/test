package dataInputs;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigReader {

	static WebDriver driver;
	static Properties prop = new Properties();

	public ConfigReader() {
		try {
			FileInputStream objFile = new FileInputStream("./resources/configuration.properties");

			prop.load(objFile);

		} catch (Exception e) {
		}
	}

	public static String getConfigData(String dataName) {
		String value = null;
		try {
			value = prop.getProperty(dataName);
		} catch (Exception e) {

		}
		return value;
	}

}
