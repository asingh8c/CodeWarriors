package datamanagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This is singleton class which loads the default properties from given
 * location into a Properties object
 * 
 * @author jtulip
 */
public class AppProperties {
	private static AppProperties self = null; // singleton object creation
	private Properties properties;

	/**
	 * 
	 * @return self Single Instance of AppProperties
	 */
	public static AppProperties getInstance() {
		if (self == null) {
			self = new AppProperties();
		}
		return self;
	}

	/**
	 * Default constructor loads the properties through file
	 */
	private AppProperties() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream("Properties.prop")); // load the
																		// file
																		// data
																		// to
																		// properties
		} catch (IOException e) {
			throw new RuntimeException("Could not read properties.prop file");
		}
	}

	/**
	 * 
	 * @return properties Set of properties fetched from file
	 */
	public Properties getProperties() {
		return properties;
	}
}
