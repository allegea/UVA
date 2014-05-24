/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class ArmyBuddies { TLE

    public static void main(String[] args) throws IOException{
	
	//Scanner in = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer r;
        StringBuilder output = new StringBuilder();
        BitSet army;
        BitSet armyP;
	while(true)
	{
                r = new StringTokenizer(in.readLine());
                int n = Integer.parseInt(r.nextToken());
                int m = Integer.parseInt(r.nextToken());
		//int n = in.nextInt();
		//int m = in.nextInt();
		if(n == 0 && m == 0)break;
                army = new BitSet();
                armyP = new BitSet();
                army.set(0, n+2, true);
                armyP.set(0, n+2, true);
                
                for(int i=0;i<m;i++)
                {
                    r = new StringTokenizer(in.readLine());
                    int u = Integer.parseInt(r.nextToken());
                    int v = Integer.parseInt(r.nextToken());
                    //int u = in.nextInt();
                    //int v = in.nextInt();
                    int uu = n+1-u;
                    int vv = n+1-v;
                    //System.out.println(uu+" - "+vv);
                    army.set(u, v+1, false);
                     armyP.set(vv, uu+1, false);
                   /* for(int j=0;j<=n+1;j++)System.out.print(" , "+army.get(j));
                    System.out.println();
                    for(int j=0;j<=n+1;j++)System.out.print(" , "+armyP.get(j));
                    System.out.println();*/
                    //int prev = army.previousSetBit(u);
                    int prev = armyP.nextSetBit(uu);
                    int next = army.nextSetBit(v);
                   // System.out.println(prev+" * "+next);
                    prev = n+1-prev; 
                    //while(!army.get(prev))prev--;
                    
                    //System.out.println(prev+" ** "+next);
                    String p  = "";
                    String ne = "";
                    if(prev == 0) p = "*";
                    else p = ""+prev;
                    if(next == n+1) ne = "*";
                    else ne = ""+next;
                   // System.out.println(p+" "+ne);
                    output.append(p).append(" ").append(ne).append("\n");

                }
                output.append("-").append("\n");
                //System.out.println("-");
		
	}
        System.out.println(output);
	in.close();
	System.exit(0);
	}

}
