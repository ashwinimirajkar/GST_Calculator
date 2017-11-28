package com.awesome.gst_calculator;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_help);

        Typeface mOdin = Typeface.createFromAsset(getAssets(), "odin.otf");
        Typeface mDosisSemiBold = Typeface.createFromAsset(getAssets(), "dosis-semibold.ttf");

        TextView mGST = (TextView) findViewById(R.id.tv_GST);
        mGST.setTypeface(mOdin);
        TextView mGSTInfo = (TextView) findViewById(R.id.tv_GST_info);
        mGSTInfo.setTypeface(mDosisSemiBold);
        TextView mName = (TextView) findViewById(R.id.tv_name);
        mName.setTypeface(mOdin);
        TextView mInfo = (TextView) findViewById(R.id.tv_info);
        mInfo.setTypeface(mDosisSemiBold);
        TextView mGSTProsAndCons = (TextView) findViewById(R.id.tv_GSTProsAndCons);
        mGSTProsAndCons.setTypeface(mOdin);
        TextView  mProsAndCons= (TextView) findViewById(R.id.tv_ProsAndCons);
        mProsAndCons.setTypeface(mDosisSemiBold);

        TextView mGSTRates = (TextView) findViewById(R.id.tv_GST_rates);
        mGSTRates.setTypeface(mOdin);

        TextView mZeroPercentTax = (TextView) findViewById(R.id.tv_zero_percent_tax);
        mZeroPercentTax.setTypeface(mOdin);
        TextView  mZeroPercentTaxProducts= (TextView) findViewById(R.id.tv_zero_percent_tax_products);
        mZeroPercentTaxProducts.setTypeface(mDosisSemiBold);

        TextView mPointTwentyfivePercentTax = (TextView) findViewById(R.id.tv_point_twentyfive_percent_tax);
        mPointTwentyfivePercentTax.setTypeface(mOdin);
        TextView  mPointTwentyfivePercentTaxProducts= (TextView) findViewById(R.id.tv_point_twentyfive_percent_tax_products);
        mPointTwentyfivePercentTaxProducts.setTypeface(mDosisSemiBold);

        TextView mThreePercentTax = (TextView) findViewById(R.id.tv_three_percent_tax);
        mThreePercentTax.setTypeface(mOdin);
        TextView  mThreePercentTaxProducts= (TextView) findViewById(R.id.tv_three_percent_tax_products);
        mThreePercentTaxProducts.setTypeface(mDosisSemiBold);

        TextView mFivePercentTax = (TextView) findViewById(R.id.tv_five_percent_tax);
        mFivePercentTax.setTypeface(mOdin);
        TextView  mFivePercentTaxProductsInfo= (TextView) findViewById(R.id.tv_five_percent_tax_products_info);
        mFivePercentTaxProductsInfo.setTypeface(mDosisSemiBold);
        TextView  mFivePercentTaxProducts= (TextView) findViewById(R.id.tv_five_percent_tax_products);
        mFivePercentTaxProducts.setTypeface(mDosisSemiBold);

        TextView mTwelvePercentTax = (TextView) findViewById(R.id.tv_twelve_percent_tax);
        mTwelvePercentTax.setTypeface(mOdin);
        TextView  mTwelvePercentTaxProductsInfo= (TextView) findViewById(R.id.tv_twelve_percent_tax_products_info);
        mTwelvePercentTaxProductsInfo.setTypeface(mDosisSemiBold);
        TextView  mTwelvePercentTaxProducts= (TextView) findViewById(R.id.tv_twelve_percent_tax_products);
        mTwelvePercentTaxProducts.setTypeface(mDosisSemiBold);

        TextView mEighteenPercentTax = (TextView) findViewById(R.id.tv_eighteen_percent_tax);
        mEighteenPercentTax.setTypeface(mOdin);
        TextView  mEighteenPercentTaxProducts= (TextView) findViewById(R.id.tv_eighteen_percent_tax_products);
        mEighteenPercentTaxProducts.setTypeface(mDosisSemiBold);

        TextView mTwentyeightPercentTax = (TextView) findViewById(R.id.tv_twentyeight_percent_tax);
        mTwentyeightPercentTax.setTypeface(mOdin);
        TextView  mTwentyeightPercentTaxProductsInfo= (TextView) findViewById(R.id.tv_twentyeight_percent_tax_products_info);
        mTwentyeightPercentTaxProductsInfo.setTypeface(mDosisSemiBold);
        TextView  mTwentyeightPercentTaxProducts= (TextView) findViewById(R.id.tv_twentyeight_percent_tax_products);
        mTwentyeightPercentTaxProducts.setTypeface(mDosisSemiBold);
    }
}
