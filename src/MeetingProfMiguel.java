/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Alejandro E. Garces
 */
public class MeetingProfMiguel {

    public static class Info{

        public Info(String a, String b, String c, String d, int e) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
        String a;
        String b;
        String c;
        String d;
        int e;

        @Override
        public String toString() {
            return a+"*"+b+"*"+c+"*"+d+"*"+e;
        }
        
       
        
    }
    
    static int INF = Integer.MAX_VALUE/2;
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         HashMap<String,Integer> mapNames;
         ArrayList<String> names;
         ArrayList<Info> readed;
         ArrayList<String> cities;
           String line;
           int[][] idY;
           int[][] idM;
           int N;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
                int lin = Integer.parseInt(in.readLine());
                if(lin == 0)break;
                
                mapNames = new HashMap<String,Integer>();
                 names = new ArrayList<String>();
                  readed = new ArrayList<Info>();
                  N = 0;
                  
                  for(int i=0;i<lin;i++)
                  {
                      String[] input = in.readLine().split("[ ]+");
                      if(!mapNames.containsKey(input[2]))
                      {
                          names.add(input[2]);
                          mapNames.put(input[2], N++);
                      }
                      if(!mapNames.containsKey(input[3]))
                      {
                          names.add(input[3]);
                          mapNames.put(input[3], N++);
                      }
                      
                      readed.add(new Info(input[0], input[1], input[2], input[3], Integer.parseInt(input[4])));
                  }
                
                  idY = new int[N][N];
                  idM = new int[N][N];
                  
                  for(int i=0;i<N;i++)
                  {
                      Arrays.fill(idY[i], INF);
                      Arrays.fill(idM[i], INF);
                  }
                  
                  for(Info x: readed)
                  {
                      int u = mapNames.get(x.c);
                      int v = mapNames.get(x.d);
                      if(x.a.equals("Y"))
                      {
                          idY[u][v] = Math.min(x.e,idY[u][v]);
                          if(x.b.equals("B"))
                              idY[v][u] = Math.min(x.e,idY[v][u]);
                          
                      }else{
                          idM[u][v] = Math.min(x.e,idM[u][v]);
                          if(x.b.equals("B"))
                              idM[v][u] = Math.min(x.e,idM[v][u]);
                      }
                  }
                  
                  for(int i=0;i<N;i++)
                  {
                      idM[i][i] = 0;
                      idY[i][i] = 0;
                  }
                  
                  for(int k=0;k<N;k++)
                      for(int i=0;i<N;i++)
                          for(int j=0;j<N;j++)
                          {
                              idY[i][j]=Math.min(idY[i][j], idY[i][k]+idY[k][j]);
                              idM[i][j]=Math.min(idM[i][j], idM[i][k]+idM[k][j]);
                          }
                  
                  
                  int min = INF;

                  String[] input = in.readLine().split("[ ]+");
    
                  if(!mapNames.containsKey(input[0]) ||!mapNames.containsKey(input[1]))
                  {
                      if(input[0].equals(input[1]))
                      System.out.println("0 "+input[0]);
                      else System.out.println("You will never meet.");
                      continue;
                  }
                  int u = mapNames.get(input[0]);
                  int v = mapNames.get(input[1]);
                  int pos = -1;
                  cities = new ArrayList<String>();
                          for(int j=0;j<N;j++)
                          {
                             // if(idY[u][j] == INF || idM[v][j] == INF)continue;
                              
                              if(min>idY[u][j]+ idM[v][j])
                              {
                                 min= idY[u][j]+ idM[v][j];
                                 pos = j;
                              }
                              
                          }
                  if(pos ==-1){
                      System.out.println("You will never meet.");  
                      continue;
                  }
                     
                          for(int j=0;j<N;j++)
                          {
                              //if(idY[u][j] == INF || idM[v][j] == INF)continue;
                              
                              if(min == idY[u][j]+ idM[v][j])
                              {
                                 cities.add(names.get(j));
                              }
                              
                          }

                     Collections.sort(cities);
                     String answer = ""+min;
                     for(int i=0;i<cities.size();i++)
                         answer+=" "+cities.get(i);
                     System.out.println(answer);


                
            }

        in.close();
        System.exit(0);
        
    }
}
