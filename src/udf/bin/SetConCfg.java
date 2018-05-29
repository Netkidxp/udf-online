package udf.bin;
import udf.compile.DbConfig;
public class SetConCfg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int i = args.length;
			if(args.length < 3)
				System.out.println("usage:cmd con_str user_id user_password!");
			else
			{
				DbConfig c =new DbConfig();
				c.setDb_con_str(args[0]);
				c.setDb_con_usr(args[1]);
				c.setDb_con_pwd(args[2]);
				c.writeDefault();
			}
	}

}
