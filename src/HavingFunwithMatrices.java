/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;



/**
 *
 * @author allegea
 */
public class HavingFunwithMatrices {

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
               int n = Integer.parseInt(in.readLine());
               int[][] m= new int[n][n];
               for(int i=0;i<n;i++)
               {
                  char[] number = in.readLine().toCharArray();
                  for(int j=0;j<n;j++)
                      m[i][j]=number[j]-'0';
               }
               
               int inst = Integer.parseInt(in.readLine());
               for(int i=0;i<inst;i++)
               {
                   String[] instruc = in.readLine().split("[ ]");
                   if(instruc[0].equals("row"))
                   {
                       int a = Integer.parseInt(instruc[1])-1;
                       int b = Integer.parseInt(instruc[2])-1;
                       
                       for(int j=0;j<n;j++)
                       {
                           int aux = m[a][j];
                            m[a][j]=m[b][j];
                            m[b][j] = aux;
                       }
                   }
                   else if(instruc[0].equals("col"))
                   {
                       int a = Integer.parseInt(instruc[1])-1;
                       int b = Integer.parseInt(instruc[2])-1;
                       
                       for(int j=0;j<n;j++)
                       {
                           int aux = m[j][a];
                            m[j][a]=m[j][b];
                            m[j][b] = aux;
                       }
                   }
                   else if(instruc[0].equals("inc"))
                   {
                       for(int j=0;j<n;j++)
                       {
                           for(int h=0;h<n;h++)
                           {
                               m[j][h]=(m[j][h]+1)%10;
                           }
                       }
                       
                   }
                   else if(instruc[0].equals("dec"))
                   {
                       for(int j=0;j<n;j++)
                       {
                           for(int h=0;h<n;h++)
                           {
                               m[j][h]--;
                               if(m[j][h]==-1)m[j][h]=9;
                           }
                       }
                       
                   }
                   else
                   {
                       for(int j=0;j<n;j++)
                       {
                           for(int h=n-1;h>=j;h--)
                           {
                               //if(j<=h)
                               {
                               int aux = m[j][h];
                                m[j][h]=m[h][j];
                                m[h][j] = aux;
                               }
                           }
                       }
                      // System.out.println("dsafasf");
                   }
               }
               
               StringBuffer out = new StringBuffer("Case #"+act+"\n");
               for(int i=0;i<n;i++)
               {
                  for(int j=0;j<n;j++)
                      out.append(m[i][j]);
                  out.append("\n");
               }
               System.out.println(out.toString());
               
                
            }

        in.close();
        System.exit(0);
        
    }
}
