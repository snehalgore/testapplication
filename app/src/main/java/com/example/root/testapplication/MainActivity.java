package com.example.root.testapplication;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ImageView;
import android.widget.ListView;

import org.lucasr.twowayview.TwoWayView;

import java.util.ArrayList;

import java.util.List;


import in.srain.cube.views.GridViewWithHeaderAndFooter;


public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> imagelist;
    static ArrayList<String> namelist;
    static android.support.v7.widget.SearchView searchimage;
    ArrayList<String> pricelist;
     List<DownloadProductModel> downloadProductModel;
    DownloadProductModel newItem;
    static GridProductAdapter adapter;
    ImageView searchImageview;
    ListView search_list;
    LayoutInflater layoutInflater;
    static View headerView;


    Toolbar toolbar;
    ArrayAdapter<String> search_array_adapter;
    GridViewWithHeaderAndFooter grid;
    TwoWayView twAllCategories;
    ArrayList<String> name_type_list;
    ArrayList<Integer> image_type_list;
    ArrayList<String> price_type_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        grid = (GridViewWithHeaderAndFooter) findViewById(R.id.gridLayout1);
        layoutInflater = LayoutInflater.from(this);
        headerView = layoutInflater.inflate(R.layout.header, null);

        twAllCategories = (TwoWayView) headerView.findViewById(R.id.twAllCategories);
        searchImageview=(ImageView)findViewById(R.id.searchImageview);
        searchimage = (android.support.v7.widget.SearchView) findViewById(R.id.searchimage);
        search_list = (ListView) findViewById(R.id.id_searchListView2);
        name_type_list=new ArrayList<String>();
        image_type_list=new ArrayList<Integer>();
        price_type_list=new ArrayList<String>();


        searchImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchimage.setVisibility(View.VISIBLE);
                searchimage.onActionViewExpanded();
                searchImageview.setVisibility(View.GONE);

                toolbar.setVisibility(View.GONE);

                searchimage.setBackgroundColor(getResources().getColor(
                        R.color.white));


            }
        });
        searchimage.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String text) {



                if (text.length() == 0) {
                    search_list.setVisibility(ListView.GONE);


                } else {
                    for(int i=0;i<namelist.size();i++)
                    {
                        if(namelist.get(i).toLowerCase().contains(text.toLowerCase()))
                        {
                        name_type_list.add(namelist.get(i));
                            image_type_list.add(imagelist.get(i));
                            price_type_list.add(pricelist.get(i));

                        }
                    }
                    search_array_adapter = new CustomSearchAdapter(MainActivity.this,
                            R.layout.search_layout, R.id.textitem, name_type_list
                           );
                  search_list.setAdapter(search_array_adapter);
                    search_list.setVisibility(ListView.VISIBLE);

                }


                return true;

            }

            @Override
            public boolean onQueryTextChange(String text) {

                Log.d("searchText", "text\t" + text);
                if (text.length() == 0) {
                    search_list.setVisibility(ListView.INVISIBLE);
                } else{
                    search_list.setVisibility(ListView.VISIBLE);
                    for(int i=0;i<namelist.size();i++)
                    {
                        if(namelist.get(i).toLowerCase().contains(text.toLowerCase()))
                        {
                            name_type_list.add(namelist.get(i));
                            image_type_list.add(imagelist.get(i));
                            price_type_list.add(pricelist.get(i));
                        }
                    }
                    search_array_adapter = new CustomSearchAdapter(MainActivity.this,
                            R.layout.search_layout, R.id.textitem, name_type_list);
                    search_list.setAdapter(search_array_adapter);
                    search_list.setVisibility(ListView.VISIBLE);

                }



                return true;

            }
        });
        search_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("position","position=="+position);
                   Intent i=new Intent(MainActivity.this,ProductPage.class);
                   i.putExtra("image",image_type_list.get(position));
                i.putExtra("name",name_type_list.get(position));
                i.putExtra("price",price_type_list.get(position));
                startActivity(i);
            }
        });


        imagelist=new ArrayList<Integer>();
        imagelist.add(R.drawable.black_shirt);
        imagelist.add(R.drawable.blue_shirt);
        imagelist.add(R.drawable.check_shirt);
        imagelist.add(R.drawable.green_shirt);
        imagelist.add(R.drawable.navy_shirt);
        imagelist.add(R.drawable.pink_shirt);

        namelist=new ArrayList<>();
        namelist.add("Black Shirt");
        namelist.add("Blue Shirt");
        namelist.add("Check Shirt");
        namelist.add("Green Shirt");
        namelist.add("Navy Shirt");
        namelist.add("Pink Shirt");

        pricelist=new ArrayList<>();
        pricelist.add("Rs.400");
        pricelist.add("Rs.500");
        pricelist.add("Rs.600");
        pricelist.add("Rs.700");
        pricelist.add("Rs.800");
        pricelist.add("Rs.900");
        if (grid.getHeaderViewCount() == 0) {
            grid
                    .addHeaderView(headerView);
        }
        downloadProductModel = new ArrayList<DownloadProductModel>();
        for(int i=0;i<imagelist.size();i++) {
            newItem = new DownloadProductModel(MainActivity.this,imagelist.get(i),namelist.get(i),pricelist.get(i));
            downloadProductModel.add(newItem);
        }
        adapter = new GridProductAdapter(MainActivity.this,
                R.layout.product_grid, downloadProductModel);
        grid.setAdapter(adapter);
        NewArrivalsCategoryAdapter mAdapter = new NewArrivalsCategoryAdapter(MainActivity.this, R.layout.new_arrivals_all_category, downloadProductModel);
        twAllCategories.setAdapter(mAdapter);
    }



    @Override
    public void onBackPressed() {
        Log.d("inif","1"+searchImageview.getVisibility());
        if(searchImageview.getVisibility()==View.GONE)
        {
            Log.d("inif","2"+searchImageview.getVisibility());
        searchImageview.setVisibility(View.VISIBLE);
        searchimage.setVisibility(View.GONE);

        searchimage.onActionViewCollapsed();

        toolbar.setVisibility(View.VISIBLE);}
        else{
            super.onBackPressed();
        }
    }



}
