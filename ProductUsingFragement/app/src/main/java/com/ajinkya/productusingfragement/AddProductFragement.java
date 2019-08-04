package com.ajinkya.productusingfragement;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class AddProductFragement extends Fragment {


    public AddProductFragement() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.add_product_fragement, container, false);
    }

    public interface onProductAddedListener{

        public void onProductAdded(Product product);
    }





}
