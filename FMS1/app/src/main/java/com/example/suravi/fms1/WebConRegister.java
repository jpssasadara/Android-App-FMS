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
 * Created by suravi on 8/29/2018.
 */
public class WebConRegister {

        Context contex;
        WebConRegister(Context contex){
            this.contex=contex;
        }
        // public static void myConnection(String webUrl, ArrayList value){//1
        public static String myConnection(String webUrl, String fn, String ln, String nic, String pn, String address, String email, String un, String pw, String rpw) {//2

            if (pw.equals(rpw)) {
                //http connector
                try {
         /*   HttpClient httpClient=new DefaultHttpClient();/*request respond circle eka build krnna.request eka giyada....
            ekata hari responce eka awada.....*/

                    //post or get method da kyla method eka baanwa..post eke url watennethi hinda godak safe

                    //     HttpPost post=new HttpPost(webUrl);//ynna one koheda,ynna one values mnwada kynna one.methanadi thana witharak denwa
                    //     post.setEntity(new UrlEncodedFormEntity(value));/*ywana value eka set krnwa,but me httpPost ekedi body eke data
                    //     ywana nisa eka encode krla ywnna one*/
                    //  HttpResponse response=httpClient.execute(post);/*client eken yawala adaala respons eka response ekata gnnawa.
                    //   response eka aniwaryen web server eken ewnwa*/
//read the response as follows
                    //    HttpEntity entity=response.getEntity();//reponse eken gani
                    //  InputStream is=entity.getContent();
                    //BufferedReader reader=new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);


                    //StringBuilder sb=new StringBuilder();//json object ek unath read krnwa
                    //String line=null;
                    //while((line=reader.readLine())!=null){

                    //  sb.append(line);
                    //}
                    //is.close();*/
                    //NEW ONE..............................................................................................................................................

                    URL url = new URL(webUrl);//yanna one thane denwa
                    URLConnection con = url.openConnection();//wifi connectionda khomada kyla blaa open krnwa
                    con.setDoOutput(true);//output ekk enakan balan innawa


                    OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
            /*uda eka kalin eke post eken krpu wademai krnne.output stream kyna pure java eka web wlata convert krnna constructor ekedi con.pass krnawa*/
                    String data = URLEncoder.encode("fn", "UTF-8") + "=" + URLEncoder.encode(fn, "UTF-8") + "&" +
                            URLEncoder.encode("ln", "UTF-8") + "=" + URLEncoder.encode(ln, "UTF-8") + "&" +
                            URLEncoder.encode("nic", "UTF-8") + "=" + URLEncoder.encode(nic, "UTF-8") + "&" +
                            URLEncoder.encode("pn", "UTF-8") + "=" + URLEncoder.encode(pn, "UTF-8") + "&" +
                            URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8") + "&" +
                            URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                            URLEncoder.encode("un", "UTF-8") + "=" + URLEncoder.encode(un, "UTF-8")+"&"+
                            URLEncoder.encode("pw", "UTF-8") + "=" + URLEncoder.encode(pw, "UTF-8")+"&"+
                            URLEncoder.encode("rpw", "UTF-8") + "=" + URLEncoder.encode(rpw, "UTF-8");
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
            }else {
                return " Error : Check Re Entered PassWord !!!!";

            }


        }
    }
//String myurl="https://192.168.43.165:8080/MyAndroidweb/Myfirst";

