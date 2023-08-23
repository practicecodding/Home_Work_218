package com.hamidul.home_work_2181;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView toolbar;
    Animation toolbarAnimation;
    TextView asset;
    Button next;
    EditText gold,silver,bank,hajj,out_of_loan,inbestments;

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
        gold = findViewById(R.id.gold);
        silver = findViewById(R.id.silver);
        bank = findViewById(R.id.bank);
        hajj = findViewById(R.id.hajj);
        out_of_loan = findViewById(R.id.out_of_loan);
        inbestments = findViewById(R.id.inbestments);
        toolbarAnimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.toolbar_animation);
        //=================================================================================================

        toolbar.startAnimation(toolbarAnimation);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                toolbar.startAnimation(toolbarAnimation);

            }
        });



    }
}