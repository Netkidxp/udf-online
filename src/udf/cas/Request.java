package udf.cas;
import java.io.IOException;
import java.util.List;

import udf.common.CodeType;
import udf.fluent.*;

/**
 * @author FQH$
 *
 */
public class Request {
	/**
	 * @param version
	 * @param launcher
	 * @param codes
	 * @param libname
	 */
	private Request(Version version, Launcher launcher, List<Code> codes, String libname) {
		super();
		this.guid = Guid();
		this.version = version;
		this.launcher = launcher;
		this.codes = codes;
		this.libName = libname;
	}
	public Request() {
		// TODO Auto-generated constructor stub
		this.guid = Guid();
	}
	private String guid;//id
	private Version version;//版本
	private Launcher launcher;//库基本信息
	private List<Code> codes;//文件列表
	private String libName;//库名称
	public String getGuid() {
		return guid;
	}
	public void setLibName(String libName) {
		this.libName = libName;
	}
	private String Guid()
	{
		return  java.util.UUID.randomUUID().toString();
	}
	public Version getVersion() {
		return version;
	}
	public void setVersion(Version version) {
		this.version = version;
	}
	public Launcher getLauncher() {
		return launcher;
	}
	public void setLauncher(Launcher launcher) {
		this.launcher = launcher;
	}
	public List<Code> getCodes() {
		return codes;
	}
	public void setCodes(List<Code> codes) {
		this.codes = codes;
	}
	public String getLibName() {
		return libName;
	}
	public String getCodeListString(CodeType ct)
	{
		String cs ="";
		for(Code c : codes)
		{
			if(c.getType() == ct)
			{
				cs += " " + c.getName();
			}
		}
		return cs;
	}
	public void writeCodeToDir(String dir) throws IOException 
	{
		for(Code c:codes)
		{
			c.write(dir);
		}
	}
}
