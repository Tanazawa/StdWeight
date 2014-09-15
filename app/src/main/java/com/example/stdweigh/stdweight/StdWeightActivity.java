package com.example.stdweigh.stdweight;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class StdWeightActivity extends Activity {

    double stdWeight; // 標準体重
    // メッセージ用のテキスト
    String stdWeightTxt;
    String errorMsg;

    // 小数点以下2桁まで表示するフォーマット
    DecimalFormat myFormat = new DecimalFormat("###.##");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_weight);

        // 文字列リソース取得
        Resources res = getResources();
        stdWeightTxt = res.getString(R.string.stdWeight);
        errorMsg = res.getString(R.string.errorMsg);
    }

    public void onClickButton(View view) {
        // 身長が入力されている
        EditText heighText = (EditText) findViewById(R.id.heightText);
        String heightStr = heighText.getText().toString();

        // 結果を表示
        TextView stdWightTextView = (TextView) findViewById(R.id.stdWeightText);

        try {
            // 標準体重計算
            double height = Double.parseDouble(heightStr);
            stdWeight = Math.pow(height / 100, 2) * 22;

            String stdWeightStr = myFormat.format(stdWeight);
            stdWightTextView.setText(stdWeightTxt + stdWeightStr + "Kg");

        } catch (NumberFormatException e) {
            Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show();
        }
    }

}
