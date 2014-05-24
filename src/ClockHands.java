/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 *
 * @author allegea
 */
public class ClockHands {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        //System.Locale.ENGLISH;
        Locale.setDefault(Locale.ENGLISH);
        
        DecimalFormat deci = new DecimalFormat("0.000");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder anss = new StringBuilder();
        while (true) {
            
            float hour, min;
            String[] time = in.readLine().split("[:]");
            hour = Integer.parseInt(time[0]);
            min = Integer.parseInt(time[1]);
            /*StringBuffer time = new StringBuffer(in.readLine());

            float hour, min;
            if (time.length() == 4) {
                hour = Integer.parseInt(time.substring(0, 1));
                min = Integer.parseInt(time.substring(2, time.length()));
            } else {
                hour = Integer.parseInt(time.substring(0, 2));
                min = Integer.parseInt(time.substring(3, time.length()));
            }*/
            if (hour == 0)break;

            

            float tih = (min * (0.5f) + hour * 30);
            float tim = min * 6;
            float ans = Math.abs(tih - tim);
            ans = ans > 180 ? 360 - ans : ans;
            //System.out.printf(Locale.ENGLISH, "%.3f%n", ans);
            anss.append(deci.format(ans)).append("\n");
            //System.out.println(deci.format(ans));
            //anss.append(Locale.ENGLISH, "%.3f%n", ans);
            
        }
        System.out.print(anss);

        in.close();
        System.exit(0);

    }


}
