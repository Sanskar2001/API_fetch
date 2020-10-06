package com.san22.api_fetch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

class rvAdapter extends RecyclerView.Adapter<rvAdapter.myViewHolder> {
    ArrayList<user>data= new ArrayList();
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
    String url= data.get(position).imageurl;
      Picasso.get().load(url).centerCrop().into(holder.imageView);
    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        public myViewHolder(View itemview) {
            super(itemview);
             imageView=itemview.findViewById(R.id.imageView);
        }

    }
    public void sendtoadapter(ArrayList<user> list)
    {
        this.data=list;
        notifyDataSetChanged();

    }
}
