package udf.common;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Serializer<T> {
	private String file;
	public Serializer(String file) {
		super();
		this.file = file;
	}
	public boolean Serialize(T t) {
		try
		{
			File f = new File(file);
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			oos.writeObject(t);  
			oos.flush();  
			oos.close();  
			fos.close();  
			return true;
		}
		catch (IOException e)  
		{  
			e.printStackTrace();  
			return false;
		} 
	}
	public T UnSerialize()
	{
		try
		{
			File f = new File(file);
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis); 
			@SuppressWarnings("unchecked")
			T t = (T)ois.readObject();    
			ois.close();  
			fis.close();  
			return t;
		}
		catch (IOException e)  
		{  
			e.printStackTrace();  
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
}
