package com.example.hw11;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private ArrayList<Todo> todoArrayList;
    private MyAdapter myAdapter;

    private Toast t1,t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = Toast.makeText(this,"최대 15글자 입니다.",Toast.LENGTH_SHORT);
        t2 = Toast.makeText(this,"최대 15글자 입니다.",Toast.LENGTH_LONG);

        Button bt_input = (Button) findViewById(R.id.bt_input);
        final EditText et_input = (EditText) findViewById(R.id.et_input);
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llmanager = new LinearLayoutManager(this);
        rv.setLayoutManager(llmanager);
        todoArrayList = new ArrayList<>();
        myAdapter = new MyAdapter(todoArrayList);
        rv.setAdapter(myAdapter);
        t2.show();
        bt_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todo = et_input.getText().toString();
                Todo newTodo = new Todo(todo);
                //=Todo newTodo = new Todo(et_input.getText().toString());
                todoArrayList.add(newTodo);//생성한 객체를 ArrayList<Todo>타입의 TodoList에 추가
                myAdapter.notifyDataSetChanged();//어댑터에게 데이터셋이 변경되었음을 알려줌
                et_input.setText(null); //EditText에 입력한 문자열은 지워짐
            }
        });
        et_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.show();

            }
        });
    }
}