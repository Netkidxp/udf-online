package udf.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cmd = "cmd /k ipconfig /all" ;  
	    
		  try {  
		   // ִ�� CMD ����  
		   Process process = Runtime.getRuntime().exec(cmd);  
		     
		   // ���������ж�ȡ�ı�  
		   BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));  
		     
		   // ����һ��д������ָ������ļ�����·��  
		   FileWriter fw = new FileWriter(new File("C:/CmdInfo.txt"));  
		     
		   String line = null;  
		     
		   // ѭ����ȡ  
		   while ((line = reader.readLine()) != null) {  
		    // ѭ��д��  
		    fw.write(line + "\n");  
		   }  
		     
		   // ˢ�������  
		   fw.flush();  
		     
		   // �ر������  
		   fw.close();  
		     
		   // �ر������  
		   process.getOutputStream().close();  
		     
		   System.out.println("����ִ�����!");  
		  } catch (Exception e) {  
		   e.printStackTrace();  
		  }  
	}

}
