package udf.compile;
import java.io.File;
import udf.cas.*;
public class PreProcessor {
	public PreProcessor(Request request) {
		super();
		this.request = request;
		
	}
	private Request request;
	
	public Request getRequest() {
		return request;
	}
	public boolean initEnvironment() {
		return true;
	}
	public boolean makeDirStruct(Request req)
	{
		String sep = File.separator;
		String stb = Config.currentConfig().getWorkplace()+sep+req.getGuid();
		String stl = stb + sep + req.getLibName();
		String sts = stl + sep + "src";
		String stp = stl + sep + req.getLauncher().getArch().toString();
		return true;
	}
}
