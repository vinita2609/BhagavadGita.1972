package com.example.viiniimevada.bhagavad_gtasitis.Book2;



import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.viiniimevada.bhagavad_gtasitis.R;
import com.github.barteksc.pdfviewer.PDFView;


public class Book2Pdf extends AppCompatActivity {

    PDFView Book2;
    private Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book2_pdf);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Book2 = (PDFView) findViewById(R.id.pdfbook2);

        Book2.fromAsset("SB5.1-1975.pdf").load();


    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        MenuItem item = menu.findItem(R.id.item1);

        // Associate searchable configuration with the SearchView
        *//*SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        android.support.v7.widget.SearchView searchView =
                (android.support.v7.widget.SearchView) menu.findItem(R.id.item1).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));*//*



        return
                super.onCreateOptionsMenu(menu);
    }*/

/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                File outputFile = new File(Environment.getExternalStoragePublicDirectory
                        (Environment.DIRECTORY_DOWNLOADS), "SB5.1-1975.pdf");
                Uri uri = FileProvider.getUriForFile(Book2Pdf.this, Book2Pdf.this.getPackageName() + ".provider", outputFile);


                Intent share = new Intent();
                share.setAction(Intent.ACTION_SEND);
                share.setType("application/pdf");
                share.putExtra(Intent.EXTRA_STREAM, uri);
                share.setPackage("com.whatsapp");

                this.startActivity(share);
                Toast.makeText(this, "Share via WhatsApp", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Intent i = new Intent(this,AboutActivity.class);
                this.startActivity(i);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }


        //android:background="#f5b94f"
    }*/




}