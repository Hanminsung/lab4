package org.myactivity.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    Button button;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Create a textView to show the string data received. Connect with view by id
        textView1=(TextView) findViewById(R.id.textView1);
        textView2=(TextView) findViewById(R.id.textView2);
        textView3=(TextView) findViewById(R.id.textView3);

        Intent intent=getIntent(); //Received intent received
        Bundle bundle=new Bundle(); //Create a bundle
        bundle =intent.getExtras(); //Receive a bundle in an Intent

        //Get string data in bundle
        String name=bundle.getString("name");
        String gender=bundle.getString("gender");
        String msg=bundle.getString("msg");

        textView1.setText(":"+name);
        textView2.setText(":"+gender);
        textView3.setText(":"+msg);

        button=(Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) //Finish activity on button click
            {
                finish();
            }
        });
    }
}