/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    import java.io.*;
a

    /**
     *
     * @author allegea
     */
    public class PrimeFactors {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) throws IOException{

            //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));

             BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

               
               /*line = in.readLine();
               int cases = Integer.parseInt(line);
               int act = 0;*/
                while (true) 
                {
                    String line = in.readLine();
                    
                    int number = Integer.parseInt(line);
                    if(number==0)break;
                    
                   StringBuffer result= new StringBuffer();
                   result.append(line);
                   result.append(" = ");
                   
                   boolean first=true;
                   if(number<0)
                   {

                        
                        result.append(-1);
                       first=false;
                       number*=-1;
                   }
                   

                   for(int p=2;p*p<=number;p++)
                   {
                       while(number%p==0)
                       {
                           if(first)
                              first=false;
                                
                          
                           else        
                           result.append(" x ");
                           result.append(p);
                           number/=p;
                       }
                   }

                   if(number>1)
                   {
                       if(first==false)
                          result.append(" x ");  
                       result.append(number);  
                   }

                   System.out.println(result);

                }

            in.close();
            System.exit(0);

        }


    }
