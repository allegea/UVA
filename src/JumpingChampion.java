/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author Alejandro E. Garces
 */
public class JumpingChampion {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
         BitSet criba = new BitSet();
         criba.set(0);
         criba.set(1);
         for(int i=2;i*i<=1000000;i++)
             if(!criba.get(i))
                 for(int j=i*2;j<=1000000;j+=i)
                     criba.set(j);
         
         
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                String[] val = in.readLine().split("[ ]+");
                int inf = Integer.parseInt(val[0]);
                int sup = Integer.parseInt(val[1]);
                int i=0;
                int bef=0;
                int max=0;
                for(i=inf;i<=sup;i++){
                    if(!criba.get(i)){
                        bef=i;
                        break;
                    }
                }
                
                HashMap<Integer,Integer> sets = new HashMap<Integer,Integer>();
                
                int fre=1;
                
                for(int j=i+1;j<=sup;j++)
                {
                    if(!criba.get(j))
                    {
                        fre=1;
                        int x = j-bef;
                        bef=j;
                        if(sets.containsKey(x)){
                            fre+=sets.get(x);
                        }
                        
                        sets.put(x, fre);
                        if(fre>max)
                            max=fre;
                    }
                    
                }
                //System.out.println(sets);
                //System.out.println("max "+max);
                
                if(sets.isEmpty()){
                    System.out.println("No jumping champion");
                }else{
                    int maxx=0;
                    Set<Integer> keys = sets.keySet();
                    //System.out.println(keys);
                    boolean found = false;
                    for(int ent:keys){
                       // System.out.println(sets.get(ent));
                        if(sets.get(ent)==max){
                            if(found){
                           System.out.println("No jumping champion");
                           maxx=-1;
                           break;
                            }else{
                               
                                found = true;
                                maxx=ent;
                            }
                            
                        }
                    }
                    if(maxx!=-1)
                    System.out.println("The jumping champion is "+maxx);
                    
                }
                
              
               
                
            }

        in.close();
        System.exit(0);
        
    }
}
