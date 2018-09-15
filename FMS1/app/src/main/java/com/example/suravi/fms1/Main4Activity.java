package com.example.suravi.fms1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Main4Activity extends AppCompatActivity {
    EditText nTV;
    Button nBtn;

    Calendar c;
    DatePickerDialog dpd;

    EditText name;
    EditText code;
    EditText id;
    EditText date;
    EditText qun;
    Button order;
    String url = "http://192.168.43.165/FmsFarmSide6/Farm-Management-System-IOT/module/fms1/AddOrder.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        nTV= (EditText) findViewById(R.id.date);
        nBtn = (Button) findViewById(R.id.dat);

        name= (EditText) findViewById(R.id.name);
        code= (EditText) findViewById(R.id.code);
        id= (EditText) findViewById(R.id.id);
        date= (EditText) findViewById(R.id.date);
        qun= (EditText) findViewById(R.id.qun);
        order = (Button) findViewById(R.id.order);

        Intent i = getIntent();

        if (i!=null) {
            String stringData1= i.getStringExtra("key1");
            name.setText(stringData1);

            String stringData2= i.getStringExtra("key2");
            code.setText(stringData2);
        }

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask task = new MyTask();
                task.execute(url);

                name.setText("");
                code.setText("");
                id.setText("");
                date.setText("");
                qun.setText("");
                order.setText("");

            }
        });

        nBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(Main4Activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int nYear, int nMonth, int nDay) {
                        nTV.setText(nDay+"/"+(nMonth+1)+"/"+nYear);
                    }
                },day,month,year);
                dpd.show();
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

            WebConMakeOrder wc = new WebConMakeOrder();

            String my = wc.myConnection(url, date.getText().toString(), code.getText().toString(), qun.getText().toString()
                    , id.getText().toString());//meya void ekk return krnne
            return my;

        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(Main4Activity.this, s, Toast.LENGTH_LONG).show();


        }
    }
}

