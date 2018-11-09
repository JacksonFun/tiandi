package com.example.john.weinong;

/**
 * Created by john on 2018/10/25.
 */
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import java.io.File;
import java.util.ArrayList;

public class NongshiphotoxiangqingAdapter extends RecyclerView.Adapter<NongshiphotoxiangqingAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<String> mImages;
    private LayoutInflater mInflater;

    public NongshiphotoxiangqingAdapter(Context context,ArrayList<String> mImages) {
        mContext = context;
        this.mImages=mImages;
        this.mInflater = LayoutInflater.from(mContext);
    }

    public ArrayList<String> getImages() {
        return mImages;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.adapter_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        Glide.with(mContext).load(mImages.get(position)).into(holder.ivImage);
        holder.ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create_dialog(mImages.get(position));
            }
        });

    }


    @Override
    public int getItemCount() {
        return mImages == null ? 0 : mImages.size();
    }



    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
        }
    }
    private void create_dialog(String url) {
        ImageView imageView;
        final AlertDialog.Builder alertDialog=new AlertDialog.Builder(mContext);
        alertDialog.setCancelable(false);
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        View view=layoutInflater.inflate(R.layout.lookphotolayout,null);
         imageView= view.findViewById(R.id.lookphotoimage);
         Glide.with(mContext).load(url).into(imageView);
        final Dialog dialog=alertDialog.create();

        dialog.show();
        dialog.getWindow().setContentView(view);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.setCancelable(true);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

}
