package com.adnanabouelenein.boldic.productanddetails;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adnanabouelenein.boldic.R;

public class ProductImagesDetailsFragment extends Fragment {



    public ProductImagesDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_images_details, container, false);
    }
}