package com.example.buoi_14_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LearnIntentResult extends AppCompatActivity {
    Button btnClickSendResult;
    EditText etTextPersonName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_intent_result);

        btnClickSendResult = findViewById(R.id.btn_click);
        etTextPersonName = findViewById(R.id.et_text_person_name);

        btnClickSendResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("dulieu", etTextPersonName.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}