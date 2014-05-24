/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.HashSet;
import java.util.Set;



/**
 *
 * @author allegea
 */
public class Turanga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
            while (true) 
            {
               String[] read = in.readLine().split("[ ]+");
               int a=Integer.parseInt(read[0]);
               int b=Integer.parseInt(read[1]);
               if(a==0 && b==0)
                   break;
               Set<Integer> set = new HashSet<Integer>();
			int diff = Math.max(a, b) - Math.min(a, b);
			for (int m = 1; m*m <= diff; ++m) {
				if (diff % m == 0) {
					set.add(m);
					set.add(diff / m);
				}
			}
			System.out.println(set.size());

                
            }

        in.close();
        System.exit(0);
        
    }
}
