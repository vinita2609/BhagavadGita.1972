package com.example.viiniimevada.bhagavad_gtasitis.Book1;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.viiniimevada.bhagavad_gtasitis.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapterTabActivity extends AppCompatActivity {

    /**
     *
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    private ScrollView rlayout;
    ProgressDialog progressDialog;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_tab);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        tabLayout = findViewById(R.id.tabs);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

  /*      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        Integer bookId = 2;
        String chapterId = getIntent().getStringExtra("ChapterId");

        setTitle(getIntent().getStringExtra("titles"));

        progressDialog = new ProgressDialog(ChapterTabActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.setCancelable(false);
        progressDialog.show();

        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<BookContent>> call = service.getAllBooks(chapterId);
        call.enqueue(new Callback<List<BookContent>>() {
            @Override
            public void onResponse(Call<List<BookContent>> call, Response<List<BookContent>> response) {
                progressDialog.dismiss();

                if(response.body() != null){

                    mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),response.body());

                    // Set up the ViewPager with the sections adapter.
                    mViewPager = (ViewPager) findViewById(R.id.container);
                    mViewPager.setAdapter(mSectionsPagerAdapter);

                    tabLayout.setupWithViewPager(mViewPager);

                    mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                    tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


                }


            }

            @Override
            public void onFailure(Call<List<BookContent>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(ChapterTabActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });


    }




    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chapter_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_chapter_tab, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.content1);
            TextView textView2 = (TextView) rootView.findViewById(R.id.content2);
            TextView textView3 = (TextView) rootView.findViewById(R.id.content3);
            TextView textView4 = (TextView) rootView.findViewById(R.id.content4);
            TextView textView5 = (TextView) rootView.findViewById(R.id.content5);

            Bundle bundle = getArguments();

            textView.setText(bundle.getString("sanskrit"));
            textView2.setText(bundle.getString("english"));
            textView3.setText(bundle.getString("wbwm"));
            textView4.setText(bundle.getString("trans"));
            textView5.setText(bundle.getString("purp"));


            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private List<BookContent> data;

        public SectionsPagerAdapter(FragmentManager fm, List<BookContent> body) {
            super(fm);
            this.data = body;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
//            return PlaceholderFragment.newInstance(position + 1);

            PlaceholderFragment fragment = new PlaceholderFragment();

            Bundle bundle = new Bundle();
            bundle.putString("sanskrit",data.get(position).getSanskrit());
            bundle.putString("english",data.get(position).getEnglish());
            bundle.putString("wbwm",data.get(position).getWordByWordMeaning());
            bundle.putString("trans",data.get(position).getTranslation());
            bundle.putString("purp",data.get(position).getPurpose());

            fragment.setArguments(bundle);

            return fragment;

        }


        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            position = position + 1;
            return "Verse "+position;
        }
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<BookContent> photoList) {
        recyclerView = findViewById(R.id.recycle1);
        adapter = new CustomAdapter(photoList,this);
        LinearLayoutManager layoutManager  = new LinearLayoutManager (ChapterTabActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
