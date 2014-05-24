/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Alejandro E. Garces
 */

public class  MutantFlatworldExplorers{
	static int[] dir = {0, 1, 2, 3};
	static char[] dirC = {'N', 'E', 'S', 'W'};
	static int[] right = {1, 2, 3, 0};
	static int[] left = {3, 0, 1, 2};
	static int[] forwX = {0, 1, 0, -1};
	static int[] forwY = {1, 0, -1, 0};
	static Set<String> border = new HashSet<String>();
	static int n;
	static int m;
	
	static boolean isInside(int i, int j)
	{
		return i>=0 && i<=n && j>=0 && j<=m;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in =  new BufferedReader( new InputStreamReader(System.in));
		String[] read = in.readLine().split("[ ]+");
		n = Integer.parseInt(read[0]);
		m = Integer.parseInt(read[1]);
		String line = "";
		int xS = 0;
		int yS = 0;
		int pos = 0;
		char[] commands;
		boolean finish = true;
		while((line = in.readLine()) != null && line.length()>0)
		{
			read = line.split("[ ]+");
			xS = Integer.parseInt(read[0]);
			yS = Integer.parseInt(read[1]);
                        for(int i=0;i<4;i++)
                            if(read[2].charAt(0) == dirC[i])
                            {
                                pos = i;
                                break;
                            }
			
			commands = in.readLine().toCharArray();
			finish = true;
			for(int i=0;i<commands.length;i++)
			{
				//System.out.println(xS+" - "+yS+" - "+pos+" - "+commands[i]);
				if(commands[i] == 'F')
				{
					int uu = xS + forwX[pos];
					int vv = yS + forwY[pos];
					if(!isInside(uu, vv))
					{
						if(border.contains(xS+"-"+yS))continue;
						border.add(xS+"-"+yS);
						finish = false;
                                               // System.out.println("Go Out"+" - "+uu+" - "+vv);
						break;
					}
					
					xS = uu;
					yS = vv;
				}else if(commands[i] == 'R')pos = right[pos];
				else pos = left[pos];
			}
			
			System.out.println(xS+" "+yS+" "+dirC[pos]+(!finish?" LOST":""));
		}
		in.close();
		System.exit(0);
	}
}
