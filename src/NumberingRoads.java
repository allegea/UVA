/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.StringTokenizer;



/**
 *
 * @author allegea
 */
public class NumberingRoads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
           String line;
           StringBuilder out = new StringBuilder();
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           int act =1;
            while ((line = in.readLine()) != null) 
            {
               
                //String[] nu = line.split("[ ]+");
                //int streets = Integer.parseInt(nu[0]);
                //int numbers = Integer.parseInt(nu[1]);
                StringTokenizer nu = new StringTokenizer(line);
                int streets = Integer.parseInt(nu.nextToken());
                float numbers = Float.parseFloat(nu.nextToken());
                if(streets+numbers==0)break;
                
                
                
                if(numbers*27>=streets)
                {
                    float x = streets/numbers;
                    int y=(int)x;
                    if(y==x)out.append("Case ").append(act++).append(": ").append(y-1).append("\n");
                    else out.append("Case ").append(act++).append(": ").append(y).append("\n");
                    
                }
                else out.append("Case ").append(act++).append(": impossible\n");
                
            }

            System.out.print(out);
        in.close();
        System.exit(0);
        
    }
}
