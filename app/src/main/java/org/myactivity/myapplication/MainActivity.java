package org.myactivity.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    RadioButton male;
    RadioButton female;
    CheckBox SMS;
    CheckBox Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //Calling the overridden onCreate function
        setContentView(R.layout.activity_main); //MainActivity Inflation

        //Connect with view by ID
        editText=(EditText)findViewById(R.id.editText);
        male=(RadioButton)findViewById(R.id.Radio1);
        female=(RadioButton)findViewById(R.id.Radio2);
        SMS=(CheckBox)findViewById(R.id.chec1);
        Email=(CheckBox)findViewById(R.id.chec2);
        button=(Button)findViewById(R.id.button1);
        //Check if there is a button click through the OnClickListener
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                String name=editText.getText().toString();
                String gender;
                String msg="";
                //Check radio button checked with isChecked method
                if(male.isChecked())
                    gender="남";
                else
                    gender="여";

                //Check check button checked with isChecked method
                if(SMS.isChecked())
                    msg+="SMS ";
                if(Email.isChecked())
                    msg+=" Email ";
                //Create explicit Intent
                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                Bundle bundle=new Bundle();
                //Add to the string data bundle
                bundle.putString("name",name);
                bundle.putString("gender",gender);
                bundle.putString("msg",msg);
                //Add bundle to intent
                intent.putExtras(bundle);
                //Pass an intent through startActivity
                startActivity(intent);
            }
        });
    }
}