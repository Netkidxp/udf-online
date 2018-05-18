package udf.compile;
import java.io.Serializable;
import udf.common.*;
public class Config implements Serializable{

	/**
	 * 
	 */
	private static String CONFIG_FILE_NAME = "set.config";
	private static final long serialVersionUID = -6138598957066997693L;
	private String workplace;
	private static Config config;
	private Config(String workplace) {
		super();
		this.workplace = workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	public static Config loadFromFile(String cfg)
	{
		return new Serializer<Config>(cfg).UnSerialize();
	}
	public String getWorkplace() {
		return workplace;
	}
	public static Config currentConfig() {
		
		if(config!=null)
			return config;
		else
		{
			config = Config.loadFromFile(CONFIG_FILE_NAME);
			return config;
		}
	}
}
