package com.example.suravi.fms1;

/**
 * Created by suravi on 9/11/2018.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
public class WebConItemList {

    public static String myview(String webUrl) {//2


        //http connector
        try {

            //NEW ONE..............................................................................................................................................

            URL url = new URL(webUrl);//yanna one thane denwa
            URLConnection con = url.openConnection();//wifi connectionda khomada kyla blaa open krnwa
            con.setDoOutput(true);//output ekk enakan balan innawa




            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();//json object ek unath read krnwa
            String line = null;
            while ((line = reader.readLine()) != null) {

                sb.append(line);
                break;
            }
            return sb.toString();


        } catch (Exception e) {


            System.out.println(e);
            return "Error : Check your Connection";

        }
    }


}
