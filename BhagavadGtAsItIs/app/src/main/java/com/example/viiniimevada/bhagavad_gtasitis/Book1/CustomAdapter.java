package com.example.viiniimevada.bhagavad_gtasitis.Book1;

import android.content.Context;
;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.viiniimevada.bhagavad_gtasitis.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomHolder> {
    List<BookContent> pojoTwoList;
    Context mcontext;



    public CustomAdapter(List<BookContent> pojoTwoList, Context mcontext )
    {

        this.mcontext = mcontext;
        this.pojoTwoList = pojoTwoList;
    }

    class CustomHolder extends RecyclerView.ViewHolder{
      /*  public final View mview;*/
        private TextView view1;
        private TextView view2;
        private TextView view3;
        private TextView view4;
        private TextView view5;






        public CustomHolder(@NonNull View itemView) {

            super(itemView);
            view1 = itemView.findViewById(R.id.content1);
            view2 = itemView.findViewById(R.id.content2);
            view3 = itemView.findViewById(R.id.content3);
            view4 = itemView.findViewById(R.id.content4);
            view5 = itemView.findViewById(R.id.content5);


            /*mview = itemView;*/



        }
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_chapter_tab,viewGroup,false);
        return new CustomAdapter.CustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder viewHolder, int postion) {



        viewHolder.view1.setText(pojoTwoList.get(postion).getSanskrit());
        viewHolder.view2.setText(pojoTwoList.get(postion).getEnglish());
        viewHolder.view3.setText(pojoTwoList.get(postion).getWordByWordMeaning());
        viewHolder.view4.setText(pojoTwoList.get(postion).getTranslation());
        viewHolder.view5.setText(pojoTwoList.get(postion).getPurpose());








/*        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));

        builder.build().load(rlist.get(postion).())
                .into(viewHolder.coverimaege);*/

    }

    @Override
    public int getItemCount() {
        return pojoTwoList.size();
    }
}



