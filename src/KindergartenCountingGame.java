/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

/**
 *
 * @author allegea
 */
public class KindergartenCountingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));

        Expresiones regulares
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        String line;

        while ((line = in.readLine()) != null) {

//            StringTokenizer read = new StringTokenizer(line);
//            int count = 0;
//            while (read.hasMoreTokens()) {
//                if (read.nextToken().matches("[A-Za-z]*[0-9]*\\S")) // System.out.println("Funciona");
//                {
//                    count++;
//                }
//            }
            //int count = 0;
            if(line.length()==0){
                System.out.println(0);
                continue;
            }
            String[] prueba = line.trim().split("[^a-zA-Z]+");
            //if(prueba[0].equals(" "))System.out.println("fds");
            //for(int i=0;i<prueba.length;i++)
            //System.out.println(prueba[i]+" - "+i);
            System.out.println(prueba.length);
           /* char[] characters = line.toCharArray();
            // boolean let = true;
            
            for (int i = 0; i < characters.length; i++) {
                if (Character.isLetter(characters[i])) {
                    count++;

                    while (i < characters.length && Character.isLetter(characters[i])) {
                        i++;
                    }
                }

            }

            System.out.println(count);*/

        }

        in.close();
        System.exit(0);

    }
}
