package com.example.suravi.fms1;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText un;
    EditText pw;
    Button login;
    Button register;
    String url="http://192.168.43.165/fms1/LogApp.php";
    String url2="http://192.168.43.165/FmsFarmSide2/module/Items/select.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        un=(EditText)findViewById(R.id.un);
        pw=(EditText)findViewById(R.id.pw);
        login=(Button)findViewById(R.id.login);
        register=(Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(in);
                MainActivity.this.finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTaskview task = new MyTaskview();
                task.execute(url);
            }
        });
    }



    //For View data
    private class MyTaskview extends AsyncTask<String, Void, String> {

/*1.string String........,2.void pre request eke ewaa,3.String doIn ge */

        @Override
        protected String doInBackground(String... abc)

        {
            //data cpacket continue ywna eka
            String output = "";

            for (String s1 : abc) {

                try {
                    output = viewDetails(s1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return output;
            //return sendDetails(abc[0]); // mema kotasa unath pramanawath

        }

        private String viewDetails(String url) throws IOException {

            WebConLogin wc = new WebConLogin();
            String my = wc.myconnection2(url,un.getText().toString(),pw.getText().toString());
            return my;

        }

        @Override
        protected void onPostExecute(String s) {
            if(s.equals("Log in")) {
                //Intent in = new Intent(MainActivity.this, Main3Activity.class);
                //in.putExtra("key1", s);
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                //startActivity(in);
                MyTaskview2 task = new MyTaskview2();
                task.execute("http://192.168.43.165/FmsFarmSide2/module/Items/select.php");
            }
            else{
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            }
        }
    }



    //For View data
    private class MyTaskview2 extends AsyncTask<String, Void, String> {


/*1.string String........,2.void pre request eke ewaa,3.String doIn ge */

        @Override
        protected String doInBackground(String... abc)

        {
            //data cpacket continue ywna eka
            String output = "";

            for (String s1 : abc) {

                output = viewDetails(s1);
            }
            return output;
            //return sendDetails(abc[0]); // mema kotasa unath pramanawath

        }

        private String viewDetails(String url) {

            WebConItemList wc = new WebConItemList();
            String my = wc.myview(url);
            return my;

        }

        @Override
        protected void onPostExecute(String s) {

            Intent in = new Intent(MainActivity.this,Main3Activity.class);
            in.putExtra("key1",s);
            startActivity(in);
        }
    }
}

