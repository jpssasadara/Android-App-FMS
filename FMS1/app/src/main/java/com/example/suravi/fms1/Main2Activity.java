package com.example.suravi.fms1;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView fn;
    TextView ln;
    TextView nic;
    TextView pn;
    TextView address;
    TextView email;
    TextView un;
    TextView pw;
    TextView rpw;
    Button submit;
    Button login;
    //String myurlAddData = "http://192.168.43.165/fms1/RegApp.php";
    String myurlAddData = "http://192.168.43.165/FmsFarmSide6/Farm-Management-System-IOT/module/fms1/RegApp.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fn = (TextView)findViewById(R.id.fn);
        ln = (TextView)findViewById(R.id.ln);
        nic = (TextView)findViewById(R.id.nic);
        pn = (TextView)findViewById(R.id.pn);
        address = (TextView)findViewById(R.id.address);
        email = (TextView)findViewById(R.id.email);
        un = (TextView)findViewById(R.id.un);
        pw = (TextView)findViewById(R.id.pw);
        rpw = (TextView)findViewById(R.id.rpw);
        submit=(Button)findViewById(R.id.submit);
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(Main2Activity.this,MainActivity.class);
                startActivity(in);
                Main2Activity.this.finish();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask task = new MyTask();
                task.execute(myurlAddData);
                if(!pw.getText().toString().equals(rpw.getText().toString())){
                    rpw.setText("");
                }
                else {
                    fn.setText("");
                    ln.setText("");
                    nic.setText("");
                    pn.setText("");
                    address.setText("");
                    email.setText("");
                    un.setText("");
                    rpw.setText("");
                    ln.setText("");
                    pw.setText("");
                }
            }
        });
    }


// For Add data
    private class MyTask extends AsyncTask<String, Void, String> {


/*1.string String........,2.void pre request eke ewaa,3.String doIn ge */

    @Override
    protected String doInBackground(String... abc)

    {

        //data cpacket continue ywna eka

        String output = "";

        for (String s1 : abc) {

            output = sendDetails(s1);
        }
        return output;
        //return sendDetails(abc[0]); // mema kotasa unath pramanawath

    }

    private String sendDetails(String url) {

        WebConRegister wc = new WebConRegister(Main2Activity.this);





        String my = wc.myConnection(url, fn.getText().toString(), ln.getText().toString(), nic.getText().toString()
                , pn.getText().toString(), address.getText().toString(),
                email.getText().toString(),un.getText().toString()
                ,pw.getText().toString(),rpw.getText().toString());//meya void ekk return krnne
        return my;

    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(Main2Activity.this, s, Toast.LENGTH_LONG).show();


    }
}
}
