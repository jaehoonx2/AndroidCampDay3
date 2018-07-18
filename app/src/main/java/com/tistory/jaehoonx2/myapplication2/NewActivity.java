package com.tistory.jaehoonx2.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewActivity extends AppCompatActivity {

    Button add, cancel;
    EditText word_new, meaning_new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.tistory.jaehoonx2.myapplication2.R.layout.activity_new);

        add = (Button) findViewById(com.tistory.jaehoonx2.myapplication2.R.id.add);
        cancel = (Button) findViewById(com.tistory.jaehoonx2.myapplication2.R.id.cancel);

        word_new = (EditText) findViewById(com.tistory.jaehoonx2.myapplication2.R.id.word_new);
        meaning_new = (EditText) findViewById(com.tistory.jaehoonx2.myapplication2.R.id.meaning_new);
    }

    public void onClick(View v){
        if(v.getId() == com.tistory.jaehoonx2.myapplication2.R.id.add){
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("word", word_new.getText().toString());
            intent.putExtra("meaning", meaning_new.getText().toString());

            setResult(RESULT_OK, intent);
            finish();
        }
        else {
            finish();
        }
    }
}
