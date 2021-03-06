package com.example.voting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    String extraText1 = "0";
    String extraText2 = "0";
    String extraText3 = "0";
    Spinner sp;
    TextView tv1,tv2;
    TextView tv1tmp,tv2tmp,tv3tmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        tv1tmp = findViewById(R.id.textViewVotes1);
        tv2tmp = findViewById(R.id.textViewVotes2);
        tv3tmp = findViewById(R.id.textViewVotes3);
        Intent intent = getIntent();
        extraText1 = String.valueOf(intent.getIntExtra("can1votes", 0));
        extraText2 = String.valueOf(intent.getIntExtra("can2votes", 0));
        extraText3 = String.valueOf(intent.getIntExtra("can3votes", 0));
        tv1tmp.setText(extraText1);
        tv2tmp.setText(extraText2);
        tv3tmp.setText(extraText3);

    }
    public void vote(View view) {
        System.out.println("Hello");
        Intent activity2Intent = new Intent(getApplicationContext(), VotingSystem.class);
        startActivity(activity2Intent);
    }




    protected void onDestroy(){

        super.onDestroy();
        Log.d("Main activity", "onDestroy: 1");

    }

    protected void onPause(){
        super.onPause();
        Log.d("Main activity", "onPause: 1");

    }

    protected void onStart(){
        super.onStart();
        Log.d("Main activity", "onStart: 1");

    }

    protected void onStop(){

        super.onStop();
        Log.d("Main Activity", "onStop: 1");
    }

    protected void onRestart(){
        super.onRestart();

        Log.d("Main Activity", "onRestart: 1");
    }

    protected void onResume(){
        super.onResume();

        Log.d("Main Activity", "onResume:1 ");
    }
}