package udf.fluent;

import java.io.File;

public class FluentConfig {
	private FluentConfig(Version version) {
		super();
		this.version = version;
	}
	String fluent_inc;
	Version version;
	public String getMakefilePath() {
		return fluent_inc + File.separator + "fluent" + version.getRelease() +
				File.separator + "src" + File.separatorChar + "udf" +
				"makefile_nt.udf";
	}
	public static FluentConfig Load(Version ver)
	{
		FluentConfig fc=new FluentConfig(ver);
		
		return null;
	}
	public boolean Write(String ver)
	{
		return true;
	}
}
