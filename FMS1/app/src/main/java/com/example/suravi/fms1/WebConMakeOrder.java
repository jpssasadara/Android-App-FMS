package com.example.suravi.fms1;
import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
/**
 * Created by suravi on 9/15/2018.
 */
public class WebConMakeOrder {


    // public static void myConnection(String webUrl, ArrayList value){//1
    public static String myConnection(String webUrl,String date, String code, String amount, String nic) {//2


            //http connector
            try {

                //NEW ONE..............................................................................................................................................

                URL url = new URL(webUrl);//yanna one thane denwa
                URLConnection con = url.openConnection();//wifi connectionda khomada kyla blaa open krnwa
                con.setDoOutput(true);//output ekk enakan balan innawa


                OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
            /*uda eka kalin eke post eken krpu wademai krnne.output stream kyna pure java eka web wlata convert krnna constructor ekedi con.pass krnawa*/
                String data = URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode(date, "UTF-8") + "&" +
                        URLEncoder.encode("code", "UTF-8") + "=" + URLEncoder.encode(code, "UTF-8") + "&" +
                        URLEncoder.encode("amount", "UTF-8") + "=" + URLEncoder.encode(amount, "UTF-8") + "&" +
                        URLEncoder.encode("nic", "UTF-8") + "=" + URLEncoder.encode(nic, "UTF-8");

                writer.write(data);
                writer.flush();//web url ekata flush krla danwa

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
//String myurl="https://192.168.43.165:8080/MyAndroidweb/Myfirst";


