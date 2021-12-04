package com.example.counterhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText;
    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.counter_text);
        mEditText = findViewById(R.id.editText);

        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("text_visible");
            if (isVisible) {
                String mCountStr = savedInstanceState.getString("text", "0");
                //Tu dois initialiser la valeur de mCount par la valeur précédente
                // sinon, lorsque tu clique sur le bouton de comptage il commencera par 0
                mCount = Integer.parseInt(mCountStr);
                mShowCount.setText(mCountStr);
                mShowCount.setVisibility(View.VISIBLE);
            }
        }
    }

    public void launchCounter(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if (mShowCount.getVisibility() == View.VISIBLE) {
            outState.putBoolean("text_visible", true);
            outState.putString("text", mShowCount.getText().toString());}
    }
  }
