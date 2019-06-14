package com.example.gautam.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    EditText e1;
    EditText e2;
    int a;
    int b;
    TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        tx=findViewById(R.id.textView);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i( "MyApplication2App", "OnStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i( "MyApplication2App", "OnRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i( "MyApplication2App",  "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(  "MyApplication2App", "OnDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i( "MyApplication2App", "OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i( "MyApplication2App", "OnResume");

    }

    @Override
    public void onClick(View v) {
        if (!e1.getText().toString().equals("") && !e1.getText().toString().equals("")){
            a = Integer.parseInt(e1.getText().toString());
            b = Integer.parseInt(e2.getText().toString());
        }

        if(v.getId()==R.id.button1)
            tx.setText(""+(a+b));
        if(v.getId()==R.id.button2)
            tx.setText(""+(a-b));
        if(v.getId()==R.id.button3)
            tx.setText(""+(a*b));
        if(v.getId()==R.id.button4)
            tx.setText(""+(a/b));
    }
}
