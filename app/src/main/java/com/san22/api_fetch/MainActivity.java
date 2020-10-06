package com.san22.api_fetch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
   rvAdapter myAdapter=new rvAdapter();
   List<user>mylist=new ArrayList<user>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv=findViewById(R.id.rv);
        Call<List<user>> userlist=client.getService().getitems();
        userlist.enqueue(new Callback<List<user>>() {
            @Override
            public void onResponse(Call<List<user>> call, Response<List<user>> response) {
               List<user> list=response.body();
                Log.i("SUCCESS","OK");
                setRv(rv,list);

            }

            @Override
            public void onFailure(Call<List<user>> call, Throwable t) {
                String error=t.toString();
                Log.i("FAILURE",error);

            }
        });


    }

    private void setRv(RecyclerView rv,List<user>list) {
        ArrayList<user> mylist=new ArrayList();
        mylist.addAll(list);
        myAdapter.sendtoadapter(mylist);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(myAdapter);
    }
}