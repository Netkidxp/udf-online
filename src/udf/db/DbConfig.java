package udf.compile;
import java.io.Serializable;
import udf.common.*;
import udf.io.Directory;
public class DbConfig implements Serializable{

	/**
	 * 
	 */
	private static String DEFAULT_CONFIG_FILE_NAME = "db.cfg";
	private static final long serialVersionUID = -6138598957066997693L;
	
	private String db_con_str;
	public String getDb_con_str() {
		return db_con_str;
	}
	public void setDb_con_str(String db_con_str) {
		this.db_con_str = db_con_str;
	}
	public String getDb_con_usr() {
		return db_con_usr;
	}
	public void setDb_con_usr(String db_con_usr) {
		this.db_con_usr = db_con_usr;
	}
	public String getDb_con_pwd() {
		return db_con_pwd;
	}
	public void setDb_con_pwd(String db_con_pwd) {
		this.db_con_pwd = db_con_pwd;
	}
	private String db_con_usr;
	private String db_con_pwd;
	
	public DbConfig() {
		super();
	}
	
	public static DbConfig loadFromFile(String cfg)
	{
		return new Serializer<DbConfig>(cfg).UnSerialize();
	}
	public void write(String cfg)
	{
		new Serializer<DbConfig>(cfg).Serialize(this);
	}
	public static DbConfig defaultConfig() {
		
		return DbConfig.loadFromFile(DEFAULT_CONFIG_FILE_NAME);
	}
	public void writeDefault()
	{
		write(DEFAULT_CONFIG_FILE_NAME);
	}
}
