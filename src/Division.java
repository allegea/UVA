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
public class Division {

    public static boolean[] visited;
    public static int count = 0;
    public static char[] x = "0123456789".toCharArray();
    public static String[] enabled = new String[30240];
    public static HashSet<String> search = new HashSet<String>();
    
    public static void DFS(String answer)
    {
        if(answer.length()==5)
        {
            enabled[count++]=answer;
            search.add(answer);
            return;
        }
        
        for(int i=0;i<10;i++)
        {
            if(!visited[i])
            {
                visited[i]=true;
                DFS(answer+x[i]);
                visited[i]=false;
                        
            }
            
        }
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 

         visited = new boolean[10];
         for(int i=0;i<10;i++){
             visited[i]=true;
             DFS(x[i]+"");
             visited[i]=false;
         }
           boolean first = true;
            while (true) 
            {
               int n= Integer.parseInt(in.readLine());
               if(n==0)
                   break;
               
               if(!first)
               System.out.println();
               
               first=false;
               
               int den;
               int pos;
               count=0;
               String aux;
               HashSet<Character> cou;
               for(int i=0;i<enabled.length;i++)
               {
                   den = Integer.parseInt(enabled[i]);
                   pos = n*den;
                   if(pos>99999)break;
                   aux = String.valueOf(pos);
                   
                   if(search.contains(String.valueOf(pos)))
                   {
                       cou = new HashSet<Character>();
                       boolean cont = true;
                       for(int j=0;j<5 && cont;j++)
                           if(!cou.add(aux.charAt(j)))
                               cont=false;
                       
                       if(!cont)break;
                       for(int j=0;j<5 && cont;j++)
                           if(!cou.add(enabled[i].charAt(j)))
                               cont=false;

                       if(cont)
                       {
                           System.out.println(aux+" / "+enabled[i]+" = "+n);
                           count++;
                       }
                   }
                       
               }
               
               if(count==0)
                   System.out.println("There are no solutions for "+n+".");
           
               
                
            }

        in.close();
        System.exit(0);
        
    }
}
