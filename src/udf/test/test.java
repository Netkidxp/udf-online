package udf.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import udf.cas.Code;
import udf.cas.Launcher;
import udf.cas.Request;
import udf.common.Arch;
import udf.common.CodeType;
import udf.common.Dim;
import udf.common.Parallel;
import udf.common.ParallelType;
import udf.common.Precision;
import udf.compile.PreProcessor;
import udf.fluent.Version;

public class test {
	public static void test1()
	{
		String cmd = "cmd /k ipconfig /all" ;  
	    
		  try {  
		   // 执行 CMD 命令  
		   Process process = Runtime.getRuntime().exec(cmd);  
		     
		   // 从输入流中读取文本  
		   BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));  
		     
		   // 构造一个写出流并指定输出文件保存路径  
		   FileWriter fw = new FileWriter(new File("C:/CmdInfo.txt"));  
		     
		   String line = null;  
		     
		   // 循环读取  
		   while ((line = reader.readLine()) != null) {  
		    // 循环写入  
		    fw.write(line + "\n");  
		   }  
		     
		   // 刷新输出流  
		   fw.flush();  
		     
		   // 关闭输出流  
		   fw.close();  
		     
		   // 关闭输出流  
		   process.getOutputStream().close();  
		     
		   System.out.println("程序执行完毕!");  
		  } catch (Exception e) {  
		   e.printStackTrace();  
		  }  
	}
	public static void test2() throws IOException
	{
		String c1 ="#include \"udf.h\"\n"
				+ "DEFINE_CG_MOTION(cg_m1,dt,vel,omega,time,dtime)\n" + 
				"{	\n" + 
				"	vel[0] = 1;\n" + 
				"}";
		Code c = new Code(CodeType.C, c1, "cg");
		Launcher l =new Launcher();
		Version ver =new Version();
		ver.setVer("19.0");
		ver.setLibRelease("1900");
		ver.setRelease("19.0.0");
		l.setArch(Arch.win64);
		l.setDim(Dim.V3D);
		l.setParallel(Parallel.SERIAL);
		l.setPrecision(Precision.FLOAT);
		l.setParallelType(ParallelType.ibmmpi);
		Request req =new Request();
		req.setVersion(ver);
		req.setLibName("haha");
		req.setLauncher(l);
		List<Code> cl = new ArrayList();
		cl.add(c);
		req.setCodes(cl);
		PreProcessor pp =new PreProcessor(req);
		pp.makeDefaultDirStruct();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			test2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
