package udf.io;

import java.io.File;

public class Directory {
	public static boolean exists(String dir)
	{
		File f = new File(dir);
		return f.exists();
	}
	public static boolean make(String dir)
	{
		if(!exists(dir))
		{
			File f = new File(dir);
			return f.mkdir();
		}
		else
			return false;
	}
	public static boolean makeForced(String dir)
	{
		if(exists(dir))
		{
			boolean res = remove(dir);
			if(!res)
				return false;
		}
		return make(dir);
	}
	public static boolean remove(String dir)
	{
		File f = new File(dir);
		if(!f.isDirectory())
			return false;
		if(clear(dir))
		{
			return f.delete();
		}
		else
			return false;
	}
	public static boolean clear(String dir) {  
	       boolean flag = false;  
	       File file = new File(dir);  
	       if (!file.exists()) {  
	         return flag;  
	       }  
	       if (!file.isDirectory()) {  
	         return flag;  
	       }  
	       String[] tempList = file.list();  
	       File temp = null;  
	       for (int i = 0; i < tempList.length; i++) {  
	          if (dir.endsWith(File.separator)) {  
	             temp = new File(dir + tempList[i]);  
	          } else {  
	              temp = new File(dir + File.separator + tempList[i]);  
	          }  
	          if (temp.isFile()) {  
	             temp.delete();  
	          }  
	          if (temp.isDirectory()) {  
	             clear(dir + File.separator + tempList[i]);//先删除文件夹里面的文件  
	             remove(dir + File.separator + tempList[i]);//再删除空文件夹  
	             flag = true;  
	          }  
	       }  
	       return flag;  
	     }  
}
