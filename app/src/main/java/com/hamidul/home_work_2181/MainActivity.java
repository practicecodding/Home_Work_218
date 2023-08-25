package com.hamidul.home_work_2181;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextView toolbar;
    Animation toolbarAnimation;
    TextView asset;
    Button next,result;
    EditText edGold,edSilver,edBank,edHajj,edOut_of_loan,edInvestments;
    EditText edCredit,edDue,edTax;
    LinearLayout getAsset,getLiabilities;
    int back = 0;

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
        edInvestments = findViewById(R.id.investments);
        next = findViewById(R.id.next);
        getAsset = findViewById(R.id.getAsset);
        getLiabilities = findViewById(R.id.getLiabilities);
        edCredit = findViewById(R.id.credit);
        edDue = findViewById(R.id.due);
        edTax = findViewById(R.id.tax);
        result = findViewById(R.id.result);
//        asset = findViewById(R.id.asset);
        toolbarAnimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.toolbar_animation);
        //=================================================================================================

        toolbar.startAnimation(toolbarAnimation);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toolbar.startAnimation(toolbarAnimation);
            }
        });

        edGold.addTextChangedListener(Asset);
        edSilver.addTextChangedListener(Asset);
        edBank.addTextChangedListener(Asset);
        edHajj.addTextChangedListener(Asset);
        edOut_of_loan.addTextChangedListener(Asset);
        edInvestments.addTextChangedListener(Asset);

        edGold.setOnTouchListener(assetColor);
        edSilver.setOnTouchListener(assetColor);
        edBank.setOnTouchListener(assetColor);
        edHajj.setOnTouchListener(assetColor);
        edOut_of_loan.setOnTouchListener(assetColor);
        edInvestments.setOnTouchListener(assetColor);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back = 1;
                getAsset.setVisibility(View.GONE);
                getLiabilities.setVisibility(View.VISIBLE);
                toolbar.setText("Liabilities");

                String credit,due,tax;
                credit = edCredit.getText().toString();
                due = edDue.getText().toString();
                tax = edTax.getText().toString();

                if (credit.length()>0 || due.length()>0 || tax.length()>0){
                    toolbar.setTextColor(Color.parseColor("#673AB7"));
                } else {
                    toolbar.setTextColor(Color.parseColor("#555555"));
                }

            }
        });


        edCredit.setOnTouchListener(liabilitiesColor);
        edDue.setOnTouchListener(liabilitiesColor);
        edTax.setOnTouchListener(liabilitiesColor);

        edCredit.addTextChangedListener(Liabilities);
        edDue.addTextChangedListener(Liabilities);
        edTax.addTextChangedListener(Liabilities);


    }

    private TextWatcher Asset = new TextWatcher() {
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
            String inVestments = edInvestments.getText().toString();

            next.setEnabled(!gold.isEmpty() && !silver.isEmpty() && !bank.isEmpty() && !hajj.isEmpty() && !out_of_loan.isEmpty() && !inVestments.isEmpty());

            //next.setEnabled(gold.length() > 0 && silver.length() >0 && bank.length() >0 && hajj.length() >0 && out_of_loan.length() >0 && inbestments.length() >0);

//            if (edGold.requestFocus() || edSilver.requestFocus() || edBank.requestFocus() || edHajj.requestFocus() || edOut_of_loan.requestFocus() || edInbestments.requestFocus()) {
//
//                asset.setTextColor(Color.parseColor("#673AB7"));
//
//            } else {
//                asset.setTextColor(Color.parseColor("#555555"));
//            }

        }

        @Override
        public void afterTextChanged(Editable s) {

            if (s.toString().length() >0 && s.toString().startsWith("0")) {
                s.delete(0,1);
            }
        }
    };

    private TextWatcher Liabilities = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String credit = edCredit.getText().toString();
            String due = edDue.getText().toString();
            String tax = edTax.getText().toString();

            result.setEnabled(!credit.isEmpty() && !due.isEmpty() && !tax.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

            if (s.toString().length() >0 && s.toString().startsWith("0")) {
                s.delete(0,1);
            }
        }
    };

    private View.OnTouchListener assetColor = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            toolbar.setText("Asset");
            toolbar.setTextColor(Color.parseColor("#673AB7"));
            return false;
        }
    };

    private View.OnTouchListener liabilitiesColor = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            toolbar.setTextColor(Color.parseColor("#673AB7"));
            return false;
        }
    };


    @Override
    public void onBackPressed() {

        if (back==1){
            back = 0;
            getAsset.setVisibility(View.VISIBLE);
            getLiabilities.setVisibility(View.GONE);
            toolbar.setText("Asset");
            toolbar.setTextColor(Color.parseColor("#673AB7"));
        }else {
            super.onBackPressed();
        }
    }
}