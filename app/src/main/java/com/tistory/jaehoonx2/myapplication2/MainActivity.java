package com.tistory.jaehoonx2.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Word> data = new ArrayList<Word>();
    WordAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.tistory.jaehoonx2.myapplication2.R.layout.activity_main);

        readData();

        listView = (ListView) findViewById(com.tistory.jaehoonx2.myapplication2.R.id.listView);
        adapter = new WordAdapter(this, data);  // 꼭 onCreate 안에서 어댑터
        listView.setAdapter(adapter);
    }

    public void onAdd(View v){
        Intent intent = new Intent(this, NewActivity.class);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        saveData();

    }

    void displayToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    void saveData(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir()+ "file.txt"));

            for(int i = 0; i < data.size(); i++){
                bw.write(data.get(i).getWord() + "-" + data.get(i).getMeaning());
            }
            bw.close();
        } catch (IOException e) {
            displayToast("파일 저장중 에러!");
            e.printStackTrace();
        }
    }

    void readData(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(getFilesDir()+"file.txt"));
            String str = "";
            while((str = br.readLine()) != null){
                String[] word = str.split("-");
                data.add(new Word(word[0], word[1]));
            }
            br.close();

        } catch (FileNotFoundException e) {
            displayToast("파일 없음");
            e.printStackTrace();
        } catch (IOException e) {
            displayToast("파일 읽기 중 에러!");
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == 100){
            if(resultCode == RESULT_OK){
                String word = intent.getStringExtra("word");
                String meaning = intent.getStringExtra("meaning");
                data.add(new Word(word, meaning));
                adapter.notifyDataSetChanged();

                Toast.makeText(getApplicationContext(), "단어가 저장되었습니다", Toast.LENGTH_LONG).show();
            }
        }
    }
}