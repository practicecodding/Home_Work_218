package com.hamidul.home_work_2181;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextView toolbar;
    Animation toolbarAnimation;
    TextView asset;
    Button next;
    EditText edGold,edSilver,edBank,edHajj,edOut_of_loan,edInbestments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Home_Work_218.1

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //======================================================================================================================

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        toolbar = findViewById(R.id.toolbar);
        edGold = findViewById(R.id.gold);
        edSilver = findViewById(R.id.silver);
        edBank = findViewById(R.id.bank);
        edHajj = findViewById(R.id.hajj);
        edOut_of_loan = findViewById(R.id.out_of_loan);
        edInbestments = findViewById(R.id.inbestments);
        next = findViewById(R.id.next);
        toolbarAnimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.toolbar_animation);
        //=================================================================================================

        toolbar.startAnimation(toolbarAnimation);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toolbar.startAnimation(toolbarAnimation);

            }
        });

        edGold.addTextChangedListener(input);
        edSilver.addTextChangedListener(input);
        edBank.addTextChangedListener(input);
        edHajj.addTextChangedListener(input);
        edOut_of_loan.addTextChangedListener(input);
        edInbestments.addTextChangedListener(input);

    }

    private TextWatcher input = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String gold = edGold.getText().toString();
            String silver = edSilver.getText().toString();
            String bank = edBank.getText().toString();
            String hajj = edHajj.getText().toString();
            String out_of_loan = edOut_of_loan.getText().toString();
            String inbestments = edInbestments.getText().toString();

            next.setEnabled(!gold.isEmpty() && !silver.isEmpty() && !bank.isEmpty() && !hajj.isEmpty() && !out_of_loan.isEmpty() && !inbestments.isEmpty());

            //next.setEnabled(gold.length() > 0 && silver.length() >0 && bank.length() >0 && hajj.length() >0 && out_of_loan.length() >0 && inbestments.length() >0);


        }

        @Override
        public void afterTextChanged(Editable s) {

            if (s.toString().length() >0 && s.toString().startsWith("0")) {
                s.clear();
            }

        }
    };

}