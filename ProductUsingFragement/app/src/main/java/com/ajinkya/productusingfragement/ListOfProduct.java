package com.ajinkya.productusingfragement;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class ListOfProduct extends Fragment {

    private ListView mListView;

//    private AdapterProduct mAdapterProduct;
//    private ArrayList<Product> mArrListProduct;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_of_product, container, false);
        setHasOptionsMenu(true);

        mListView = view.findViewById(R.id.list_view);
//        mArrListProduct = new ArrayList<>();
//        mAdapterProduct = new AdapterProduct(mArrListProduct);


//        mListView.setAdapter(mAdapterProduct);
//        mListView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        return view;
        //return inflater.inflate(R.layout.list_of_product, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.PlusMenu) ;
        {
            Intent intent = new Intent(getActivity(), AddProductFragement.class);
            startActivity(intent);
            return super.onOptionsItemSelected(item);
        }
    }
}
