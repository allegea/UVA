/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *
 * @author Alejandro E. Garces
 */
public class MessageDecoding {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
       // Scanner in = new Scanner(System.in);
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         HashMap<String,Integer> positions = new HashMap<String,Integer>();
         String ceros = "00000000";
         String aux="";
         int count = 0;
         for(int i=1;i<=7;i++)
         {
             for(int j=0;j<(1<<i)-1;j++)
             {
                 aux = Integer.toBinaryString(j);
                  aux= ceros.substring(8-(i-aux.length()))+aux;
                 positions.put(aux, count++);
                 
             }
         }
         
         String line = "";
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
         boolean first = true;
         String mess = "";
            while (line != null) 
            {
                 char[] message;
                if(first)
                message = in.readLine().toCharArray();
                else
                message = line.toCharArray();
                
                //System.out.println(message);
                first = false;
                mess = "";
                String answer = "";
                String input = "";
                while(true)
                {  // System.out.println("dsada");
                    if((line = in.readLine())==null)
                        break;

                    if(line.length()==0)continue;
                   // System.out.println(line+"--"+Character.isDigit(line.charAt(0)));
                    if(Character.isDigit(line.charAt(0)))                    
                    input+=line;
                    else break;
                    //System.out.println(line+"--"+Character.isDigit(line.charAt(0)));
                    //System.out.println("bbb");
                }
                
                 //System.out.println(input+"--");
                String sub = "";
                while(!input.isEmpty())
                {
                    int len = Integer.parseInt(input.substring(0, 3), 2);
                    if(len ==0)break;
                    String end = Integer.toBinaryString((1<<len)-1);
                    input = input.substring(3);
                    //System.out.println(input+" - " +end+" - "+len);
                    while(true)
                    {
                        sub = input.substring(0,len);
                        //System.out.println(input+" - * " + sub + " - "+positions.get(sub));
                        input=input.substring(len);
                        if(sub.endsWith(end))
                            break;
                        answer+=message[positions.get(sub)];
                        
                    }
                    //System.out.println(input+" -+");
                }
                System.out.println(answer);
                //System.out.println(Arrays.toString(message)+" - "+input+" + "+mess);
                
            }

        in.close();
        System.exit(0);
        
    }
}
