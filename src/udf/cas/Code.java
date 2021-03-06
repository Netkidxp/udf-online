package udf.cas;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import udf.common.*;
public class Code {
	public Code(CodeType type, String code, String name) {
		super();
		this.type = type;
		this.code = code;
		this.name = name;
	}
	private CodeType type;
	private String code;
	private String name;
	public CodeType getType() {
		return type;
	}
	public void setType(CodeType type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean write(String dir) throws IOException
	{
		////////////////////////////////
		File f = new File(dir + File.separator + name + "." + type.toString());
		if(!f.exists())
			f.createNewFile();
		FileWriter fw=new FileWriter(f,false);
		fw.write(code);
		fw.flush();
		fw.close();
		return true;
	}
}
