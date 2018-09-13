package com.example.suravi.fms1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by suravi on 8/30/2018.
 */
public class WebConLogin {
    public static String myconnection2(String webUrl,String un,String pw) throws IOException {
        URL url = new URL(webUrl);//yanna one thane denwa
        URLConnection con = url.openConnection();//wifi connectionda khomada kyla blaa open krnwa
        con.setDoOutput(true);//output ekk enakan balan innawa

        OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
            /*uda eka kalin eke post eken krpu wademai krnne.output stream kyna pure java eka web wlata convert krnna constructor ekedi con.pass krnawa*/
        String data = URLEncoder.encode("un", "UTF-8") + "=" + URLEncoder.encode(un, "UTF-8") + "&" +
                URLEncoder.encode("pw", "UTF-8") + "=" + URLEncoder.encode(pw, "UTF-8");
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
    }
}
