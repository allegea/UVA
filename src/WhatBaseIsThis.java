/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author Alejandro E. Garces
 */
public class WhatBaseIsThis {
    
    public static int minBase(String x){
        
        char[] array = x.toCharArray();
        char max = array[0];
        for(int i=1;i<array.length;i++)
            if(max<array[i])
                max=array[i];
        
        int ret = max-'0';
        if(ret>9)
            ret-=7;
        ret+=1;
        if(ret==1)ret++;
        
        return ret;
    }

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while ((line = in.readLine()) != null) 
            {
                String[] read = line.trim().split("[ ]+");
                int basA = minBase(read[0]);
                int basB= minBase(read[1]);
                
                int i=0,j=0;
                boolean found = false;
                for(i=basA;i<=36 && !found;i++){
                    for(j=basB;j<=36 && !found;j++ ){
                        try{ 
                       BigInteger a = new BigInteger(read[0],i);
                        BigInteger b = new BigInteger(read[1],j);
                        if(a.compareTo(b)==0)
                            found=true;
                        }catch(Exception ex){continue;}
                    }
                }
                
                if(found){
                    System.out.println(read[0]+" (base "+(i-1)+") = "+read[1]+" (base "+(j-1)+")");
                }else System.out.println(read[0]+" is not equal to "+read[1]+" in any base 2..36");
                
            }

        in.close();
        System.exit(0);
        
    }
}
