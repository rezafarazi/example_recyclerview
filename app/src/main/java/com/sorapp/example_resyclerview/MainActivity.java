package com.sorapp.example_resyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    //Global Variabls Start
    ArrayList<String> Items=new ArrayList<>();


    //Main Function Start
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initilize();
    }
    //Main Function End



    private void Initilize()
    {
        Items.add("Hello");
        Items.add("Salam");
        Items.add("Selam");
        Items.add("Merheba");
        Items.add("مرحبا");
        Items.add("سلام");

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        adap adaptor=new adap();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptor);

    }



    class adap extends RecyclerView.Adapter<ViewHolder_Item>
    {

        @NonNull
        @Override
        public ViewHolder_Item onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            View view=getLayoutInflater().inflate(R.layout.layout_recyclerview_item,null);
            ViewHolder_Item viewholder=new ViewHolder_Item(view);
            return viewholder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder_Item holder, int position)
        {
            holder.Item.setText(Items.get(position));
        }

        @Override
        public int getItemCount()
        {
            return Items.size();
        }

    }


    class ViewHolder_Item extends RecyclerView.ViewHolder
    {
        private TextView Item;

        public ViewHolder_Item(@NonNull View itemView)
        {
            super(itemView);
            Item=(TextView) itemView.findViewById(R.id.layout_recyclerview_item_textview);
        }
    }



}