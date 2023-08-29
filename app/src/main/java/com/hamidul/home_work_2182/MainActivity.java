package com.hamidul.home_work_2182;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Home_Work_218.2

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //======================================================================================================================

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textToSpeech = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String s1 = editText.getText().toString();
                button.setEnabled(!s1.isEmpty());
                if (s1.length()==0){
                    textToSpeech.stop();
                }
                if (i1<i2){
                    textToSpeech.stop();
                }
                else {
                    textToSpeech.stop();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                float income = Integer.parseInt(editText.getText().toString());
                float tax;

                if (income<=350000){
                    Toast.makeText(MainActivity.this, "No Tax", Toast.LENGTH_SHORT).show();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        textToSpeech.speak("আপনার আয় 350000 টাকার মধ্যে তাই আপনাকে কোনো কর প্রধান করতে হবে না ।",TextToSpeech.QUEUE_FLUSH,null,null);
                    }
                }
                else if (income<=450000){
                    tax = (float) ((income-350000)*0.05);
                    Toast.makeText(MainActivity.this, tax+"TK", Toast.LENGTH_SHORT).show();
                    textToSpeech.speak("আপনার "+tax+" টাকা কর প্রধান করতে হবে",TextToSpeech.QUEUE_FLUSH,null,null);

                }
                else if (income<=750000){
                    tax = (float) (5000 + (income-450000)*0.1);
                    Toast.makeText(MainActivity.this, tax+"TK", Toast.LENGTH_SHORT).show();
                    textToSpeech.speak("আপনার"+tax+" টাকা কর প্রথান করতে হবে",TextToSpeech.QUEUE_FLUSH,null,null);
                }
                else if (income<=1150000){
                    tax = (float) (5000 + 30000 + (income-750000)*0.15);
                    Toast.makeText(MainActivity.this, tax+"TK", Toast.LENGTH_SHORT).show();
                    textToSpeech.speak("আপনার"+tax+"টাকা কর প্রধান করতে হবে",TextToSpeech.QUEUE_FLUSH,null, null);
                }
                else if (income<=1650000){
                    tax = (float) (5000 + 30000 + 60000 + (income-1150000)*0.2);
                    Toast.makeText(MainActivity.this, tax+"TK", Toast.LENGTH_SHORT).show();
                    textToSpeech.speak("আপনার"+tax+"টাকা কর প্রধান করতে হবে",TextToSpeech.QUEUE_FLUSH,null, null);
                }
                else {
                    tax = (float) (5000 + 30000 + 60000 + 100000 + (income-1650000)*0.25);
                    Toast.makeText(MainActivity.this, tax+"TK", Toast.LENGTH_SHORT).show();
                    textToSpeech.speak("আপনার"+tax+"টাকা কর প্রধান করতে হবে",TextToSpeech.QUEUE_FLUSH,null, null);
                }

            }
        });

    }

    public void onPause(){
        textToSpeech.stop();
        super.onPause();
    }



}