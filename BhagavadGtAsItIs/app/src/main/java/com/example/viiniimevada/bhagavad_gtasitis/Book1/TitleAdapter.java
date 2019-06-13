package com.example.viiniimevada.bhagavad_gtasitis.Book1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.viiniimevada.bhagavad_gtasitis.R;

import java.util.List;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.MyViewHolder> {

    private Context mContext;
    private List<ChapterTitle> data;
    private CustomItemClickListener clickListener;

    public TitleAdapter(Context mContext, List<ChapterTitle> titleList, CustomItemClickListener clickListener) {
        this.mContext = mContext;
        this.data = titleList;
        this.clickListener = clickListener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.title_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.titleText.setText(data.get(position).getTitle().replace("_"," "));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{



        TextView titleText;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titleText = (TextView) itemView.findViewById(R.id.title_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    clickListener.onItemClick(view, getAdapterPosition());
                }
            });

        }
    }
}