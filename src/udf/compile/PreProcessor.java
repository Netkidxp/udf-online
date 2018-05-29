package udf.compile;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import udf.cas.*;
import udf.common.*;
import udf.fluent.*;
import udf.io.Directory;

public class PreProcessor {
	public PreProcessor(Request request) {
		super();
		this.request = request;
	}
	private Request request;
	private String[] stPos = {"2d","2d_host","2d_node",
			"2ddp","2ddp_host","2ddp_node",
			"3d","3d_host","3d_node",
			"3ddp","3ddp_host","3ddp_node"
			};
	private String USER_NT = "user_nt.udf";
	public Request getRequest() {
		return request;
	}
	public void makeDirStruct() throws IOException
	{
		Request req =request;
		String sep = File.separator;
		String stWorkplace = DbConfig.defaultConfig().getWorkplace();
		
		String stBase = stWorkplace+sep+req.getGuid();
		String stLib = stBase + sep + req.getLibName();
		String stSrc = stLib + sep + "src";
		String stPla = stLib + sep + req.getLauncher().getArch().toString();
		if(!Directory.exists(stWorkplace))
			Directory.make(stWorkplace);
		Directory.make(stBase);
		Directory.make(stLib);
		Directory.make(stSrc);
		Directory.make(stPla);
		req.writeCodeToDir(stSrc);
		Launcher l = req.getLauncher();
		String pos ="";
		if(l.getDim()==Dim.V2D)
			pos+="2d";
		else
			pos+="3d";
		if(l.getPrecision()==Precision.DOUBLE)
			pos+="dp";
		if(l.getParallel()==Parallel.SERIAL)
		{
			makePosDir(stPla+File.separator+pos);
		}
		else
		{
			makePosDir(stPla+File.separator+pos+"_host");
			makePosDir(stPla+File.separator+pos+"_node");
		}
	}
	public void makeDefaultDirStruct() throws IOException 
	{
		Request req =request;
		String sep = File.separator;
		//String stBase = Config.currentConfig().getWorkplace()+sep+req.getGuid();
		String stWorkplace = DbConfig.defaultConfig().getWorkplace();
		
		String stBase = stWorkplace+sep+req.getGuid();
		String stLib = stBase + sep + req.getLibName();
		String stSrc = stLib + sep + "src";
		String stPla = stLib + sep + req.getLauncher().getArch().toString();
		if(!Directory.exists(stWorkplace))
			Directory.make(stWorkplace);
		Directory.make(stBase);
		Directory.make(stLib);
		Directory.make(stSrc);
		Directory.make(stPla);
		req.writeCodeToDir(stSrc);
		for(String pos:stPos)
		{
			makePosDir(stPla+File.separator+pos);
		}
	}
	private void makePosDir(String pos) throws IOException
	{
		String sep = File.separator;
		udf.io.Directory.make(pos);
		File file =new File(pos + sep + USER_NT);
		if(!file.exists())
		{
			file.createNewFile();
			FileWriter fw = new FileWriter(file,false);
			String slist = request.getCodeListString(CodeType.C) + " " + request.getCodeListString(CodeType.CPP);
			String hlist = request.getCodeListString(CodeType.H);
			String ts = "CSOURCES= ";
			if(slist!= " ")
				ts += "$(SRC)" + slist;
			ts += "\nHSOURCES= ";
			if(hlist!="")
				ts += "$(SRC)" + hlist;
			ts += "\nVERSION=" + pos;
			if(pos.endsWith("node"))
				ts += "\nPARALLEL_NODE=" + request.getLauncher().getParallelType().toString();
			else
				ts +="\\nPARALLEL_NODE=none";
			ts += "\nGPU_SUPPORT=off";
			fw.write(ts);
			fw.flush();
			fw.close();
		}
		
		FluentConfig fc = FluentConfig.Load(request.getVersion());
		Path sp = Paths.get(fc.getMakefilePath());
		Path so = Paths.get(pos + File.separator, "makefile");
		Files.copy(sp,so,StandardCopyOption.REPLACE_EXISTING);		
	}
	
}
