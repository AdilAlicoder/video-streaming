package com.example.video_app;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class video_adapter extends RecyclerView.Adapter<video_adapter.ViewHolder>{
    private List<videos> listData;
    private Context context;
    public video_adapter(Context applicationContext, List<videos> listData) {
        this.listData = listData;
        this.context=applicationContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_set, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
         videos ld=listData.get(position);
        holder.txtid.setText(ld.getTitile());
        Picasso.get().load(ld.getImageurl()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videos a=listData.get(position);
                Intent intent=new Intent(context,video_view.class);
                intent.putExtra("title",a.getTitile());
                intent.putExtra("imageurl",a.getVideurl());
                intent.putExtra("dis",a.getDic());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtid;
        private ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            txtid=(TextView)itemView.findViewById(R.id.txt);
            imageView=itemView.findViewById(R.id.img);
        }
    }

}

