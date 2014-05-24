/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;



/**
 *
 * @author allegea
 */
public class CamelTrading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
           String line;
           StringBuilder out = new StringBuilder();
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
               line = in.readLine();
                String[] min = line.split("[\\+]");
                String[] max = line.split("[\\*]");
                //System.out.println(Arrays.toString(min));
                long minC =0;
                
                for(int i=0;i<min.length;i++)
                {
                    char[] current = min[i].toCharArray();
                    long aux = 1;
                    for(int j=0;j<min[i].length();j++){
                        long aux2=0;
                        while(j<min[i].length() && Character.isDigit(current[j])){
                            aux2=aux2*10+(current[j++]-48);
                        }
                        aux=aux*aux2;
                        
                    }
                    //System.out.println(aux+" - "+minC);
                    minC=minC+aux;
                }
                
                long maxC=1;
                 //System.out.println(minC+"\n\n");
                for(int i=0;i<max.length;i++)
                {
                    char[] current = max[i].toCharArray();
                    long aux = 0;
                    for(int j=0;j<max[i].length();j++){
                        long aux2=0;
                        while(j<max[i].length() && Character.isDigit(current[j])){
                            aux2=aux2*10+(current[j++]-48);
                        }
                        aux=aux+aux2;
                        
                    }
                    //System.out.println(aux+" - "+maxC);
                    maxC=maxC*aux;
                }
               
               // System.out.println(maxC);
                out.append("The maximum and minimum are ").append(maxC).append(" and ").append(minC).append(".\n");
            }
              
            System.out.print(out);
        in.close();
        System.exit(0);
        
    }
}
