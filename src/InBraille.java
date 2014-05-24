/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class InBraille {

	static String[][] toBraille = new String[10][3];
	
	static int found(String[] x)
	{
		boolean found = false;
		for(int i=0;i<10;i++)
		{	found = true;
			for(int j=0;j<3;j++)
				found&=x[j].equals(toBraille[i][j]);
			if(found)return i;
		}
                return -1;
	}
   public static void main(String[] args) throws IOException{
		String[] a = ".* *. *. ** ** *. ** ** *. .*".split("[ ]+"); 
		String[] b = "** .. *. .. .* .* *. ** ** *.".split("[ ]+"); 
		String[] c = ".. .. .. .. .. .. .. .. .. ..".split("[ ]+");
		for(int i=0;i<10;i++)
		{
			toBraille[i][0] = a[i];
			toBraille[i][1] = b[i];
			toBraille[i][2] = c[i];
		}
		
		String l1,l2,l3;
		String[][] inputs;
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n = Integer.parseInt(in.readLine());
			if(n == 0)break;
			if(in.readLine().charAt(0) == 'S')
			{
				char[] num = in.readLine().toCharArray();
				int m = num.length;
				l1 = l2 = l3 = "";
				for(int i=0;i<m;i++)
				{
					l1+=toBraille[num[i]-'0'][0]+" ";
					l2+=toBraille[num[i]-'0'][1]+" ";
					l3+=toBraille[num[i]-'0'][2]+" ";
				}
				
				System.out.println(l1.trim());
				System.out.println(l2.trim());
				System.out.println(l3.trim());
			
			}
			else
			{
				a = in.readLine().split("[ ]+");
				b = in.readLine().split("[ ]+");
				c = in.readLine().split("[ ]+");
				int m = a.length;
				int[] pos = new int[a.length];
				inputs = new String[a.length][3];
				
				for(int i=0;i<m;i++)
				{
					inputs[i][0] = a[i];
					inputs[i][1] = b[i];
					inputs[i][2] = c[i];
				}
				l1 = "";
				for(int i=0;i<m;i++)
				l1+=found(inputs[i]);
				
				System.out.println(l1);

			}
		}
         in.close();
         System.exit(0);
     }
}
