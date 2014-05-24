/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Alejandro E. Garces
 */
public class Lotto {

    public static class VectorInt implements Comparable{

       public int[] vecto = new int[6];
       public String y;
        public VectorInt(String x){
           y = x.trim();
            String[] split = y.split("[ ]+");
            for(int i=0;i<6;i++)
                vecto[i] = Integer.parseInt(split[i]);
            
        }
        /*public VectorInt(int[] aux){
            System.arraycopy(aux, 0, vecto, 0, 6);
        }*/
        
        @Override
        public int compareTo(Object o) {
            
            for(int i=0;i<6;i++){
                if(this.vecto[i]>((VectorInt)o).vecto[i])
                    return 1;
                else if(this.vecto[i]<((VectorInt)o).vecto[i])
                    return -1;
            }

            return 0;
            
        }
        
        
    }

    /**
     * @param args the command line arguments
     */
    
static int[] posSteps;
static int n;

static void BT(String answer, int currN)
{
	if(currN > n)return;
	if(currN == n)System.out.println(answer.trim());
	for(int i=0;i<posSteps.length;i++)
		BT(answer+posSteps[i]+' ', currN+posSteps[i]);
}
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        posSteps = new int[]{1,2};
        n = 6;
        BT("",0);
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));     
    
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           String concat;
           String sort;
           boolean first = true;
            while (true) 
            {
                String[] read = in.readLine().split("[ ]+");
                int n=Integer.parseInt(read[0]);
                if(n==0)
                    break;
                
                if(!first){
                       System.out.println();
                   }
                first = false;
                
                ArrayList<VectorInt> output = new ArrayList<VectorInt>();
                
                for(int i=0;i<(1<<n);i++)
                {
                   if(Integer.bitCount(i)!=6)
                   continue;

                   concat = "";
                   for(int j=0;j<n;j++)
                   {
                       if((i&(1<<j))!=0){
                           concat+=" "+read[j+1];

                       }
                           
                   }
                   //System.out.println(Arrays.toString(out));
                   //answer.put(sort, concat);
                   output.add(new VectorInt(concat));
                }
                
                Collections.sort(output);
                for(int i=0;i<output.size();i++)
                    System.out.println(output.get(i).y);
                /*Entry<String,String> aux;
                 while(!answer.isEmpty())
                {
                    aux = answer.pollFirstEntry();
                    System.out.println(aux.getValue().trim());
                }*/
               // System.out.println(answer);*/
                
            }

        in.close();
        System.exit(0);
        
    }
}
