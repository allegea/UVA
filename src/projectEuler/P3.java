/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uva.projectEuler;
import java.io.*;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;



/**
 *
 * @author allegea
 */
public class P3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
         //BufferedReader in   = new BufferedReader(new FileReader("triangulo.txt"));
        
         //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           
     /*   ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<String> ij = new ArrayList<String>();
        SortedSet<Integer> max = new TreeSet<Integer>();
        
        for(int i=999;i>=100;i--){
            for(int j=999;j>=100;j--){
                numbers.add(j*i);
               ij.add(i+"-"+j);
            }
        }
        int maxP = 0;
        for(int i=numbers.size()-1;i>=0;i--){
            int numer = numbers.get(i);
            char[] numero = String.valueOf(numer).toCharArray();
            
            boolean pal = true;
            for(int j=0;j<=numero.length/2;j++)
                if(numero[j]!=numero[numero.length-1-j]){
                    pal = false;
                    break;
                }
            if(pal){
                //System.out.println(numbers.get(i)+" - "+ij.get(i));
                max.add(numer);
                if(maxP<numer)maxP=numer;
               // break;
            }
        }
        
        System.err.println(max.last()+" "+maxP);*/
        
        ///Ver2
        
       int maxP = 0;
        for(int i=999;i>=100;i--){
            for (int j = 999; j >= 100; j--) {
                int numer = i*j;
                char[] numero = String.valueOf(numer).toCharArray();

                boolean pal = true;
                for (int h = 0; h <= numero.length / 2; h++) {
                    if (numero[h] != numero[numero.length - 1 - h]) {
                        pal = false;
                        break;
                    }
                }
                if (pal) {
                    //System.out.println(numbers.get(i)+" - "+ij.get(i));
                    //max.add(numer);
                    if (maxP < numer) {
                        maxP = numer;
                    }
                    // break;
                }
            }
        }
        
         System.out.println(maxP);
        
        
           
           
                
            

        
    }
    
    
    public static long rev(long n)
        { // This method simply returns a reversed number
		
		String s=""+n;
		StringBuffer sb=new StringBuffer(s);
		sb=sb.reverse();
		s=""+sb;
		
		return Long.parseLong(s);
	}
		
	public static boolean palin(int n)
	{  //This method checks if a number is palin or no
		
		String s1=""+n;
		String s2=""+rev(n);
		if(s1.equals(s2))
			return true;
		
		return false;
	}
}
