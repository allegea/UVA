/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class TaxicabNumbers {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));

         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int[] cubes = new int[10000];
         HashSet<Integer> cube = new HashSet<Integer>();
         int lim = 1000100000;
         int i=1;
         while(i*i*i<=lim)
         {
             cubes[i-1]=i*i*i;
             cube.add(cubes[i-1]);
             //System.out.println(i+" - "+cubes[i-1]);
             i++;
         }
        // System.out.println(cube);
         
         
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line = in.readLine()) != null) 
            {
               int n = Integer.parseInt(line);
               int rg = Integer.parseInt(in.readLine());
               
               for(int m=n;m<=n+rg;m++)
               {
                   boolean found = false;
                   int count=0;
                    HashSet<String> pairs = new HashSet<String>();
                    for(int j=0;j<i && cubes[j]<=m/2 && !found;j++)
                    {
                        int res = m-cubes[j];
                        //System.out.println(cubes[j]+" - "+res+" Re "+cube.contains(res));
                        if(cube.contains(res))
                        {
                           //  System.out.println(cubes[j]+" - "+res+" - "+count);
                            pairs.add(Math.min(res, cubes[j])+"*"+Math.max(res, cubes[j]));
                            count++;
                            if(count>1)
                                found=true;
                        }

                    }
                    if(found){
                        System.out.println(m+"***");
                        System.out.println(pairs);
                    }
               }
                
            }

        in.close();
        System.exit(0);
        
    }
}
