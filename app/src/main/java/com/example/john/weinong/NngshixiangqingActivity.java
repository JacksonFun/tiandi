package com.example.john.weinong;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.john.weinong.dbService.Work;

import java.util.ArrayList;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

/**
 * Created by john on 2018/10/25.
 */

public class NngshixiangqingActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NongshiphotoxiangqingAdapter mAdapter;
    private String workobjectid;
    private ArrayList<String> images=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nongshiphotolayout);
        recyclerView=(RecyclerView)findViewById(R.id.nongshiphotoxiangqingRecycview);
        Intent intent=getIntent();
       workobjectid=intent.getStringExtra("workobjectid");

        BmobQuery<Work> query = new BmobQuery<Work>();
        query.getObject(workobjectid, new QueryListener<Work>() {

            @Override
            public void done(Work object, BmobException e) {
                if(e==null){

                    for(int i=0;i<object.getPhoto().size();i++)
                    {
                        images.add(object.getPhoto().get(i).getFileUrl());

                    }
                    recyclerView.setLayoutManager(new GridLayoutManager(NngshixiangqingActivity.this, 3));
                    mAdapter = new NongshiphotoxiangqingAdapter(NngshixiangqingActivity.this,images);
                    recyclerView.setAdapter(mAdapter);
                }else{

                }
            }

        });



    }
}
