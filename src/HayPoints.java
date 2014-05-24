/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author allegea
 */
public class HayPoints {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) /*throws IOException*/ {
        //Scanner in = new Scanner(new File("pruebas.txt"));
  
        Scanner in = new Scanner(System.in);
        int diccionary = in.nextInt();
        int[] value = new int[diccionary];
        int cases = in.nextInt();
        ArrayList<String> dicc = new ArrayList<String>();
        for(int i=0;i<diccionary;i++)
        {
            dicc.add(in.next());
            value[i]=in.nextInt();
            //System.out.println(dicc.get(i)+" "+value[i]);
        }
        
        for(int i=0;i<cases;i++)
        {
            long cash = 0;
            String now;
            while(!(now=in.next()).equals("."))            
            {
                int index = dicc.indexOf(now);
                if(index!=-1) cash+=value[index];
            }
            
            
            System.out.println(cash);
        }

        
        System.exit(0);
    }
}
