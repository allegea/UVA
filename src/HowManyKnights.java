/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */

public class HowManyKnights {

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		//StringTokenizer read;
		while(true)
		{
			int n = in.nextInt();
                        int m = in.nextInt();
                        if(n == 0 && m == 0)break;
                        int value = (int)Math.ceil(n*m/(float)2);
                        if(n ==1 || m == 1) value = n*m;
                        else if(n == 2 || m == 2)
                        {
                            //value = (Math.min((Math.max(n,m) % 4), 2)) * 2 + (Math.max(n,m)/4) * 4;
                             value = n==2?m:n;
                           // System.out.println(value+" --");
                            if(value%4 == 1)value = value+1;
                            else {
                                while(value%4!=0)value++;
                            }
                        }
                         System.out.println(value+" knights may be placed on a "+n+" row "+m+" column board.");
			
		}
		in.close();
		System.exit(0);
	}
}