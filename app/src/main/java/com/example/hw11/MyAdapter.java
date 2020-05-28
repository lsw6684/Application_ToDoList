package com.example.hw11;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Todo> todoList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected ImageButton bt_delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.bt_delete = (ImageButton) itemView.findViewById(R.id.bt_input);
            bt_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //현재 어댑터가 다루고 있는 리스트의 포지션을 가져온다.
                    int position = getAdapterPosition();

                    //삭제된 포지션이 아닌 경우
                    if (position != RecyclerView.NO_POSITION) {
                        todoList.remove(position);
                        notifyDataSetChanged();
                    }
                }
            });

        }
    }

    public MyAdapter(ArrayList<Todo> todoList) {
        this.todoList = todoList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item,
                parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(todoList.get(position).getTodoName());
    }

    @Override
    public int getItemCount() {
        return (null != todoList ? todoList.size() : 0);
    }
}
