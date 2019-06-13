package com.example.viiniimevada.bhagavad_gtasitis.Book1;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.viiniimevada.bhagavad_gtasitis.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private  static final  String TAG = "MainActivity";

    private Context mContext;

    ArrayList<String> titleArrayList;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  Window w = getWindow();
        setTitle("Chapters");*/

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_actionbar);


        mContext = MainActivity.this;

        titleArrayList = new ArrayList<String>();
/*

        */
/*titleArrayList.add(Constants.Dedication);
        titleArrayList.add(Constants.Foreword);
        titleArrayList.add(Constants.Preface);
        titleArrayList.add(Constants.Introduction);*//*


        titleArrayList.add(Constants.Chapter_1_Observing_the_Armies_on_the_Battlefield_of_Kuruksetra);
        titleArrayList.add(Constants.Chapter_2_Contents_of_the_Gita_Summarized);
        titleArrayList.add(Constants.Chapter_3_Karma_yoga);
        titleArrayList.add(Constants.Chapter_4_Transcendental_Knowledge);
        titleArrayList.add(Constants.Chapter_5_Karma_yoga_Action_in_Krsna_Consciousness);
        titleArrayList.add(Constants.Chapter_6_Sankhya_yoga);
        titleArrayList.add(Constants.Chapter_7_Knowledge_of_the_Absolute);
        titleArrayList.add(Constants.Chapter_8_Attaining_the_Supreme);
        titleArrayList.add(Constants.Chapter_9_The_Most_Confidential_Knowledge);
        titleArrayList.add(Constants.Chapter_10_The_Opulence_of_the_Absolute);
        titleArrayList.add(Constants.Chapter_11_The_Universal_Form);
        titleArrayList.add(Constants.Chapter_12_Devotional_Service);
        titleArrayList.add(Constants.Chapter_13_Nature_the_Enjoyer_and_Consciousness);
        titleArrayList.add(Constants.Chapter_14_The_Three_Modes_Of_Material_Nature);
        titleArrayList.add(Constants.Chapter_15_The_Yoga_of_the_Supreme_Person);
        titleArrayList.add(Constants.Chapter_16_The_Divine_And_Demoniac_Natures);
        titleArrayList.add(Constants.Chapter_17_The_Divisions_of_Faith);
        titleArrayList.add(Constants.Chapter_18_Conclusion_The_Perfection_of_Renunciation);



        /*Create handle for the RetrofitInstance interface*/


        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<ChapterTitle>> call = service.getAllChapters();
        call.enqueue(new Callback<List<ChapterTitle>>() {
            @Override
            public void onResponse(Call<List<ChapterTitle>> call, Response<List<ChapterTitle>> response) {
                progressDialog.dismiss();
                if(response.body() != null){
                    List<ChapterTitle> data = response.body();
                    Collections.reverse(data);
                    generateDataList(data);
                }
            }

            @Override
            public void onFailure(Call<List<ChapterTitle>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });




    }




    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(final List<ChapterTitle> photoList) {

        recyclerView = findViewById(R.id.title_layout_recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        CustomItemClickListener listener = new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent desIntent = new Intent(mContext,ChapterTabActivity.class);

                desIntent.putExtra("titles",photoList.get(position).getTitle());
                desIntent.putExtra("ChapterId",photoList.get(position).getId());

                startActivity(desIntent);
            }
        };


        TitleAdapter adapter = new TitleAdapter(mContext, photoList, listener);

        recyclerView.setAdapter(adapter);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.chapter_menu, menu);
        MenuItem item = menu.findItem(R.id.shareitem);

        // Associate searchable configuration with the SearchView
        /*SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        android.support.v7.widget.SearchView searchView =
                (android.support.v7.widget.SearchView) menu.findItem(R.id.item1).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));*/



        return
                super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.shareitem:

                Intent myintent = new Intent(Intent.ACTION_SEND);
                myintent.setType("text/plain");
               /* String sharebody = "A";
                String sharesub = "B";*/
                myintent.putExtra(Intent.EXTRA_TEXT, "App url");
                startActivity(Intent.createChooser(myintent, "Share App Via"));

                /*File outputFile = new File(Environment.getExternalStoragePublicDirectory
                        (Environment.DIRECTORY_DOWNLOADS), "SB5.1-1975.pdf");
                Uri uri = FileProvider.getUriForFile(MainActivity.this, MainActivity.this.getPackageName() + ".provider", outputFile);


                Intent share = new Intent();
                share.setAction(Intent.ACTION_SEND);
                share.setType("application/pdf");
                share.putExtra(Intent.EXTRA_STREAM, uri);
                share.setPackage("com.whatsapp");

                this.startActivity(share);
                Toast.makeText(this, "Share via WhatsApp", Toast.LENGTH_SHORT).show();*/
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


        //android:background="#f5b94f"
    }





}
