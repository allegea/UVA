/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;


import java.util.*;

/**
 *
 * @author allegea
 */
public class LetterFrequency {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

           String line;

           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {

                SortedMap<Character,Integer> sm=new TreeMap<Character,Integer>();
                 
               for(char i='a';i<='z';i++)
                   sm.put(i, 0);
               

                char[] message = in.readLine().toLowerCase().toCharArray();
                
                int max=0;
                
                for(int i=0;i<message.length;i++)
                {
                    if(Character.isLetter(message[i]))
                    {
                        int fr = sm.get(message[i])+1;
                        sm.put(message[i], fr );
                        max=max<fr?fr:max;
                        
                    }
                }
                
                
                for(char i='a';i<='z';i++)
                {
                    if(sm.get(i)==max)
                        System.out.print(i);
                }
                System.out.println();
                   
              
                
            }

        in.close();
        System.exit(0);
        
    }
}

/*
 * 
 * public class LetterFrequency {
public static void main(String[] args) throws IOException {
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
int T = Integer.parseInt(in.readLine());
while (T-- > 0) {
int[] freq = new int[256];
String line = in.readLine().toLowerCase();
for (char c : line.toCharArray())
++freq[c];
int max = 0;
for (char c = 'a'; c <= 'z'; ++c)
max = Math.max(max, freq[c]);
String res = "";
for (char c = 'a'; c <= 'z'; ++c)
if (freq[c] == max)
res += c;
System.out.println(res);
}
in.close();
System.exit(0);
}
}
 */