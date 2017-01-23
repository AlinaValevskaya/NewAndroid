package com.example.user.assist;


import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.assist.model.Theme;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {
    OnClickCallBack callBack;

    public MyAdapter(OnClickCallBack callBack) {
        this.callBack = callBack;
    }

    ArrayList <Theme> arrayList = new ArrayList<>();



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.item, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.bind(arrayList.get(position),callBack);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public void setArr(ArrayList<Theme> arr) {
        arrayList = arr;
        notifyDataSetChanged();
    }




    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        void bind(final Theme text, final OnClickCallBack callBack){
            textView.setText(text.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBack.clickElement(text.getId());
                }
            });
        }

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
    public interface OnClickCallBack{

        void clickElement(int id);
    }
}
