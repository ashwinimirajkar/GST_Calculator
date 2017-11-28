package com.awesome.gst_calculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button _btnOne;
    private Button _btnTwo;
    private Button _btnThree;
    private Button _btnFour;
    private Button _btnFive;
    private Button _btnSix;
    private Button _btnSeven;
    private Button _btnEight;
    private Button _btnNine;
    private Button _btnZero;
    private Button _btnPoint;
    private FrameLayout _btnClear;
    private TextView _finalPrice;
    private TextView _beforeTaxPrice;
    private Spinner _GSTTaxes;
    private double _finalValue;
    private TextView _tvFinalPrice;
    private TextView _tvBeforeTax;
    private ImageView _dots;
    private static int _count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        Typeface mFontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesomeicon.ttf");
        Typeface mOdin = Typeface.createFromAsset(getAssets(), "odin.otf");
        Typeface mDosisMedium = Typeface.createFromAsset(getAssets(), "dosis-medium.ttf");
        Typeface mDosisSemiBold = Typeface.createFromAsset(getAssets(), "dosis-semibold.ttf");

        _dots = (ImageView) findViewById(R.id.im_dots);

        TextView mClear = (TextView) findViewById(R.id.tv_clearValue);
        mClear.setTypeface(mFontAwesomeFont);
        _tvFinalPrice = (TextView) findViewById(R.id.tv_finalPrice);
        _tvFinalPrice.setTypeface(mOdin);
        TextView mTvGST = (TextView) findViewById(R.id.tv_GST);
        mTvGST.setTypeface(mOdin);
        _tvBeforeTax = (TextView) findViewById(R.id.tv_beforeTax);
        _tvBeforeTax.setTypeface(mOdin);

        RelativeLayout mClearValue = (RelativeLayout) findViewById(R.id.layout_clearValue);

        _finalPrice = (TextView) findViewById(R.id.tv_finalPriceNo);
        _finalPrice.setTypeface(mDosisSemiBold);

        _beforeTaxPrice = (TextView) findViewById(R.id.tv_beforeTaxNo);
        _beforeTaxPrice.setTypeface(mDosisSemiBold);
        _beforeTaxPrice.setInputType(0);

        _btnOne = (Button) findViewById(R.id.btn_one);
        _btnOne.setTypeface(mDosisMedium);

        _btnTwo = (Button) findViewById(R.id.btn_two);
        _btnTwo.setTypeface(mDosisMedium);

        _btnThree = (Button) findViewById(R.id.btn_three);
        _btnThree.setTypeface(mDosisMedium);

        _btnFour = (Button) findViewById(R.id.btn_four);
        _btnFour.setTypeface(mDosisMedium);

        _btnFive = (Button) findViewById(R.id.btn_five);
        _btnFive.setTypeface(mDosisMedium);

        _btnSix = (Button) findViewById(R.id.btn_six);
        _btnSix.setTypeface(mDosisMedium);

        _btnSeven = (Button) findViewById(R.id.btn_seven);
        _btnSeven.setTypeface(mDosisMedium);

        _btnEight = (Button) findViewById(R.id.btn_eight);
        _btnEight.setTypeface(mDosisMedium);

        _btnNine = (Button) findViewById(R.id.btn_nine);
        _btnNine.setTypeface(mDosisMedium);

        _btnZero = (Button) findViewById(R.id.btn_zero);
        _btnZero.setTypeface(mDosisMedium);

        _btnPoint = (Button) findViewById(R.id.btn_point);
        _btnPoint.setTypeface(mDosisMedium);

        _btnClear = (FrameLayout) findViewById(R.id.layout_clear);

        _GSTTaxes = (Spinner) findViewById(R.id.sp_listOfTaxes);
        ArrayAdapter<CharSequence> mAdapter = ArrayAdapter.createFromResource(this,
                R.array.tax_array, android.R.layout.simple_spinner_item);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _GSTTaxes.setAdapter(mAdapter);

        _btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _beforeTaxPrice.setText(_beforeTaxPrice.getText() + "1");
                _btnOne.setBackgroundResource(R.drawable.outer_shadow);
                _btnFour.setBackgroundResource(R.drawable.right_border);

                new Handler().postDelayed(new Runnable() {

                    public void run() {
                        _btnOne.setBackgroundResource(R.drawable.bottom_right_border);
                        _btnFour.setBackgroundResource(R.drawable.bottom_right_border);
                    }
                }, 200);

                calculateFinalPrice();
            }
        });

        _btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _beforeTaxPrice.setText(_beforeTaxPrice.getText() + "2");
                _btnTwo.setBackgroundResource(R.drawable.outer_shadow);
                _btnOne.setBackgroundResource(R.drawable.number_bottom_border);
                _btnFive.setBackgroundResource(R.drawable.right_border);

                new Handler().postDelayed(new Runnable() {

                    public void run() {
                        _btnTwo.setBackgroundResource(R.drawable.bottom_right_border);
                        _btnOne.setBackgroundResource(R.drawable.bottom_right_border);
                        _btnFive.setBackgroundResource(R.drawable.bottom_right_border);
                    }
                }, 200);

                calculateFinalPrice();
            }
        });

        _btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _beforeTaxPrice.setText(_beforeTaxPrice.getText() + "3");
                _btnThree.setBackgroundResource(R.drawable.outer_shadow);
                _btnSix.setBackgroundResource(0);
                _btnTwo.setBackgroundResource(R.drawable.keyboard_bottom_border);

                new Handler().postDelayed(new Runnable() {

                    public void run() {
                        _btnThree.setBackgroundResource(R.drawable.keyboard_bottom_border);
                        _btnSix.setBackgroundResource(R.drawable.keyboard_bottom_border);
                        _btnTwo.setBackgroundResource(R.drawable.bottom_right_border);
                    }
                }, 200);

                calculateFinalPrice();
            }
        });

        _btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _beforeTaxPrice.setText(_beforeTaxPrice.getText() + "4");
                _btnFour.setBackgroundResource(R.drawable.outer_shadow);
                _btnSeven.setBackgroundResource(R.drawable.right_border);

                new Handler().postDelayed(new Runnable() {

                    public void run() {
                        _btnFour.setBackgroundResource(R.drawable.bottom_right_border);
                        _btnSeven.setBackgroundResource(R.drawable.bottom_right_border);
                    }
                }, 200);

                calculateFinalPrice();
            }
        });

        _btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _beforeTaxPrice.setText(_beforeTaxPrice.getText() + "5");
                _btnFive.setBackgroundResource(R.drawable.outer_shadow);
                _btnEight.setBackgroundResource(R.drawable.right_border);
                _btnFour.setBackgroundResource(R.drawable.keyboard_bottom_border);

                new Handler().postDelayed(new Runnable() {

                    public void run() {
                        _btnFive.setBackgroundResource(R.drawable.bottom_right_border);
                        _btnEight.setBackgroundResource(R.drawable.bottom_right_border);
                        _btnFour.setBackgroundResource(R.drawable.bottom_right_border);
                    }
                }, 200);

                calculateFinalPrice();
            }
        });

        _btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _beforeTaxPrice.setText(_beforeTaxPrice.getText() + "6");
                _btnSix.setBackgroundResource(R.drawable.outer_shadow);
                _btnNine.setBackgroundResource(0);
                _btnFive.setBackgroundResource(R.drawable.keyboard_bottom_border);

                new Handler().postDelayed(new Runnable() {

                    public void run() {
                        _btnSix.setBackgroundResource(R.drawable.keyboard_bottom_border);
                        _btnNine.setBackgroundResource(R.drawable.keyboard_bottom_border);
                        _btnFive.setBackgroundResource(R.drawable.bottom_right_border);
                    }
                }, 200);

                calculateFinalPrice();
            }
        });

        _btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _beforeTaxPrice.setText(_beforeTaxPrice.getText() + "7");
                _btnSeven.setBackgroundResource(R.drawable.outer_shadow);

                new Handler().postDelayed(new Runnable() {

                    public void run() {
                        _btnSeven.setBackgroundResource(R.drawable.bottom_right_border);
                    }
                }, 200);

                calculateFinalPrice();
            }
        });

        _btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _beforeTaxPrice.setText(_beforeTaxPrice.getText() + "8");
                _btnEight.setBackgroundResource(R.drawable.outer_shadow);
                _btnSeven.setBackgroundResource(R.drawable.number_bottom_border);

                new Handler().postDelayed(new Runnable() {

                    public void run() {
                        _btnEight.setBackgroundResource(R.drawable.bottom_right_border);
                        _btnSeven.setBackgroundResource(R.drawable.bottom_right_border);
                    }
                }, 200);

                calculateFinalPrice();
            }
        });

        _btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _beforeTaxPrice.setText(_beforeTaxPrice.getText() + "9");
                _btnNine.setBackgroundResource(R.drawable.outer_shadow);
                _btnEight.setBackgroundResource(R.drawable.number_bottom_border);

                new Handler().postDelayed(new Runnable() {

                    public void run() {
                        _btnNine.setBackgroundResource(R.drawable.keyboard_bottom_border);
                        _btnEight.setBackgroundResource(R.drawable.bottom_right_border);
                    }
                }, 200);

                calculateFinalPrice();
            }
        });

        _btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _beforeTaxPrice.setText(_beforeTaxPrice.getText() + "0");
                _btnZero.setBackgroundResource(R.drawable.outer_shadow);
                _btnTwo.setBackgroundResource(R.drawable.right_border);
                _btnPoint.setBackgroundResource(0);

                new Handler().postDelayed(new Runnable() {

                    public void run() {
                        _btnZero.setBackgroundResource(R.drawable.right_border);
                        _btnTwo.setBackgroundResource(R.drawable.bottom_right_border);
                        _btnPoint.setBackgroundResource(R.drawable.right_border);
                    }
                }, 150);

                calculateFinalPrice();
            }
        });

        _btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(_count == 0){
                    if(_beforeTaxPrice.length() == 0){
                        _beforeTaxPrice.setText(_beforeTaxPrice.getText() + "0.");
                        _count++;
                    }else{
                        _beforeTaxPrice.setText(_beforeTaxPrice.getText() + ".");
                        _count++;
                    }
                }

                _btnPoint.setBackgroundResource(R.drawable.outer_shadow);
                _btnOne.setBackgroundResource(R.drawable.right_border);

                new Handler().postDelayed(new Runnable() {

                    public void run() {
                        _btnPoint.setBackgroundResource(R.drawable.right_border);
                        _btnOne.setBackgroundResource(R.drawable.bottom_right_border);
                    }
                }, 150);

                calculateFinalPrice();
            }
        });

        _btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(_beforeTaxPrice.getText().length() != 0){
                    String str = _beforeTaxPrice.getText().toString();
                    str = str.substring(0, str.length() - 1);
                    _beforeTaxPrice.setText(str);
                }

                if(_beforeTaxPrice.getText().length() == 0){
                    _finalPrice.setText("");
                    _count = 0;
                }

                if(_beforeTaxPrice.getText().length() !=0) {
                    String mString = _beforeTaxPrice.getText().toString();
                    if(mString.contains(".")){
                        _count ++;
                    }else{
                        _count = 0;
                    }
                }

                calculateFinalPrice();

                _btnClear.setBackgroundResource(R.drawable.outer_shadow);
                _btnThree.setBackgroundResource(0);
                _btnZero.setBackgroundResource(0);

                new Handler().postDelayed(new Runnable() {

                    public void run() {
                        _btnClear.setBackgroundResource(0);
                        _btnThree.setBackgroundResource(R.drawable.keyboard_bottom_border);
                        _btnZero.setBackgroundResource(R.drawable.right_border);
                    }
                }, 150);
            }
        });

        mClearValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _beforeTaxPrice.setText("");
                _finalPrice.setText("");
                _count = 0;
            }
        });

        _GSTTaxes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                calculateFinalPrice();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        _dots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(MainActivity.this, _dots);
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Intent intent = new Intent(getApplicationContext(), HelpActivity.class);
                        startActivity(intent);
                        return true;
                    }
                });
                popup.show();
            }
        });
    }

    private void calculateFinalPrice(){
        String beforeTaxPrice = _beforeTaxPrice.getText().toString().trim();
        if(!TextUtils.isEmpty(beforeTaxPrice)) {
            double value = Double.parseDouble(beforeTaxPrice);
            String s = _GSTTaxes.getSelectedItem().toString();
            String p = s.substring(0, s.length() - 1);
            char sign = s.charAt(0);
            if(sign == '-'){
                _tvFinalPrice.setText("P R I C E    W I T H O U T    T A X");
                _tvBeforeTax.setText("PRICE WITH TAX");
            }else{
                _tvFinalPrice.setText("P R I C E    W I T H    T A X");
                _tvBeforeTax.setText("PRICE WITHOUT TAX");
            }

            double percentageGST = Double.parseDouble(p);
            _finalValue = value + ((value * percentageGST) / 100);
            _finalValue = Double.parseDouble(new DecimalFormat("#.###").format(_finalValue));
            String stringValue = Double.toString(_finalValue);

            int mFinalPriceLength = stringValue.length();

            if(mFinalPriceLength <= 10){
                _finalPrice.setTextSize(TypedValue.COMPLEX_UNIT_SP,60);
            }else if(mFinalPriceLength > 10 && mFinalPriceLength <=13){
                _finalPrice.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
            }else if(mFinalPriceLength > 13 && mFinalPriceLength <=16) {
                _finalPrice.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
            }else{
                _finalPrice.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
            }

            _finalPrice.setText("\u20B9 " + stringValue);


        }else{
            String s = _GSTTaxes.getSelectedItem().toString();
            char sign = s.charAt(0);
            if(sign == '-'){
                _tvFinalPrice.setText("P R I C E    W I T H O U T    T A X");
                _tvBeforeTax.setText("PRICE WITH TAX");
            }else{
                _tvFinalPrice.setText("P R I C E    W I T H    T A X");
                _tvBeforeTax.setText("PRICE WITHOUT TAX");
            }
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setMessage("Are you sure you want to Exit GST Calculator?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog mAlertDialog = mBuilder.create();
        mAlertDialog.show();
    }
}
