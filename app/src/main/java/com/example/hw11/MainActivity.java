package com.example.hw11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private ArrayList<Todo> todoArrayList;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = DBHelper.getInstance(getApplicationContext());
        RecyclerView rv = findViewById(R.id.rv);

        Button bt_input = findViewById(R.id.bt_input);
        final EditText et_input = findViewById(R.id.et_input);

        LinearLayoutManager llmanager = new LinearLayoutManager(this);
        rv.setLayoutManager(llmanager);

        todoArrayList = dbHelper.getAll();
        myAdapter = new MyAdapter(todoArrayList);
        rv.setAdapter(myAdapter);
        bt_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Todo data = new Todo(et_input.getText().toString());
                todoArrayList.add(data);
                dbHelper.insert(data);
                myAdapter.notifyDataSetChanged();

                et_input.clearFocus();
                et_input.setText(null);





                /*String todo = et_input.getText().toString();
                Todo newTodo = new Todo(todo);
                //=Todo newTodo = new Todo(et_input.getText().toString());
                todoArrayList.add(newTodo);//생성한 객체를 ArrayList<Todo>타입의 TodoList에 추가
                myAdapter.notifyDataSetChanged();//어댑터에게 데이터셋이 변경되었음을 알려줌
                et_input.setText(null); //EditText에 입력한 문자열은 지워짐*/
            }
        });

    }
}
