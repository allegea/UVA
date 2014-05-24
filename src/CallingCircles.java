/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Alejandro E. Garces
 */
public class CallingCircles {

    public static int size = 0;
    public static int label;
    public static boolean[] explored;
    public static ArrayList<Integer> answer;
    
    public static void DFS(ArrayList[] nodes, int s, int[] pos)
    {
        
        explored[s]=true;
        answer.add(s);
        if(nodes[s]!=null)
        {
            for(Object i:nodes[s])
            {
                int u = Integer.parseInt(i.toString());
                if(!explored[u])
                    DFS(nodes,u,pos);
            }
            
        }
        
        pos[size++]=s;
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           ArrayList[] nodes;
           ArrayList[] nodesR;
           HashMap<String,Integer> NameToPos;
           HashMap<Integer,String> PosToName;
           int[] pos1,pos2;
           int pos=0,u,v;
           int current = 0;
           boolean nofirst = false;
           
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
            while (true) 
            {
                String[] input = in.readLine().split("[ ]+");
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               if(n==0 && m == 0)
                   break;
               
               if(nofirst)
               {
                   System.out.println();
               }
               nofirst = true;
               nodes = new ArrayList[n];
               nodesR = new ArrayList[n];
               pos1 = new int[n];
               pos2 = new int[n];
               explored = new boolean[n];
               NameToPos = new HashMap<String,Integer>();
               PosToName = new HashMap<Integer,String>();
               answer = new ArrayList<Integer>();
               label = 0;
               pos = 0;
               size =0;
               
               for(int i=0;i<m;i++)
               {
                   input = in.readLine().split("[ ]+");
                   if(NameToPos.containsKey(input[0]))
                       u = NameToPos.get(input[0]);
                    else 
                   {
                       u = pos;
                       NameToPos.put(input[0], pos);
                       PosToName.put(pos++, input[0]);
                   }
                   
                   if(NameToPos.containsKey(input[1]))
                       v = NameToPos.get(input[1]);
                    else 
                   {
                       v = pos;
                       NameToPos.put(input[1], pos);
                       PosToName.put(pos++, input[1]);
                   }
                   
                   if(nodes[u]==null)
                       nodes[u] = new ArrayList<Integer>();
                   nodes[u].add(v);
                   
                   if(nodesR[v]==null)
                       nodesR[v] = new ArrayList<Integer>();
                   nodesR[v].add(u);
                   
                  
                   
               }
               
               
               for(int i=n-1;i>=0;i--)
               {
                   if(!explored[i])
                   {
                       DFS(nodesR,i,pos1);
                   }
               }
               
               explored = new boolean[n];
               size = 0;
               System.out.println("Calling circles for data set "+(++current)+":");
               for(int i=n-1;i>=0;i--)
               {
                   if(!explored[pos1[i]])
                   {
                       answer = new ArrayList<Integer>();
                       DFS(nodes,pos1[i],pos2);
                       for(int j=0;j<answer.size()-1;j++)
                           System.out.print(PosToName.get(answer.get(j))+", ");
                       System.out.println(PosToName.get(answer.get(answer.size()-1)));
                   }
               }
               
               /*System.out.println(Arrays.toString(nodes));
               System.out.println(Arrays.toString(nodesR));
               System.out.println(NameToPos);
               System.out.println(PosToName+" --");*/
               
                
            }

        in.close();
        System.exit(0);
        
    }
}
