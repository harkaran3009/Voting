package com.example.voting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class VotingSystem extends AppCompatActivity implements View.OnClickListener {

    Button btnRegister,btnRegister2;
    Spinner sp;
    TextView tv1,tv2;
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> ids = new ArrayList<String>();
    int candidate1,candidate2,candidate3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegister = (Button) findViewById(R.id.buttonVote) ;
        btnRegister.setOnClickListener(this);
        btnRegister2 = (Button) findViewById(R.id.button2) ;
        btnRegister2.setOnClickListener(this);
    }

    public void mainMenu(View view){
        finish();
    }

    public void onClick(View view)
    {
        System.out.println(view.getId());
        System.out.println("inside onclick");
        switch (view.getId()) {
            case R.id.buttonVote:
                sp = findViewById(R.id.spinner);
                tv1 = findViewById(R.id.editTextTextPersonName2);
                tv2 = findViewById(R.id.editTextTextPersonName3);
                ToggleButton simpleToggleButton = (ToggleButton) findViewById(R.id.toggleButton); // initiate a toggle button
                Boolean ToggleButtonState = simpleToggleButton.isChecked();
                System.out.println(ToggleButtonState);
                String textSpinner = sp.getSelectedItem().toString();
                System.out.println(textSpinner);

                if ((!tv1.equals("")) && (!tv2.equals("")) && ToggleButtonState && (textSpinner.equals("Candidate 1") || textSpinner.equals("Candidate 2") || textSpinner.equals("Candidate 3")))
                {
                    System.out.println("Hello");

                    int duration = Toast.LENGTH_SHORT;
                    Toast toast;

                    if(ids.contains(tv2.getText().toString()))
                    {   System.out.println(tv2.getText().toString());
                        CharSequence text = "User already voted";
                        toast = Toast.makeText(this, text, duration);
                        toast.show();
                    }
                    else if(ids.contains(tv2.getText().toString()) && names.contains(tv1.getText().toString()))
                    {
                        CharSequence text = "User already voted";
                        toast = Toast.makeText(this, text, duration);
                        toast.show();
                    }
                    else
                    {
                        names.add(tv1.getText().toString());
                        ids.add(tv2.getText().toString());
                        if(textSpinner.equals("Candidate 1"))
                        {
                            candidate1 += 1;
                        }
                        else if(textSpinner.equals("Candidate 2"))
                        {
                            candidate2 += 1;
                        }
                        else
                        {
                            candidate3 += 1;
                        }

                        CharSequence text = "Vote Successfully";
                        toast = Toast.makeText(this, text, duration);
                        toast.show();
                    }


                }
                else
                {
                    CharSequence text = "Please provide all values!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(this, text, duration);
                    toast.show();
                }
                break;

            case R.id.button2:
                System.out.println("Inside back menu");
                Intent activity2Intent = new Intent(getApplicationContext(), MainActivity.class);
                activity2Intent.putExtra("can1votes", candidate1);
                activity2Intent.putExtra("can2votes", candidate2);
                activity2Intent.putExtra("can3votes", candidate3);
                startActivity(activity2Intent);
                break;

        }
    }



    // this is final call you receive before you destroy your activity
    protected void onDestroy(){

        super.onDestroy();
        Log.d("Main activity2", "onDestroy: 2");

    }

    protected void onPause(){
        super.onPause();
        Log.d("Main activity2", "onPause: 2");

    }

    protected void onStart(){
        super.onStart();
        Log.d("Main activity2", "onStart: 2");

    }

    protected void onStop(){

        super.onStop();
        Log.d("Main Activity2", "onStop: 2");
    }

    protected void onRestart(){
        super.onRestart();

        Log.d("Main Activity2", "onRestart: 2");
    }

    protected void onResume(){
        super.onResume();

        Log.d("Main Activity2", "onResume:2 ");
    }

}

