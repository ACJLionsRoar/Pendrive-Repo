package com.lmntrx.indoornavigation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {


    // ALL MAPS IN GALLERY ARE DRAWN ON FRAGMENTS. EACH TAB IS A FRAGMENT
    public GalleryFragment() {
        // Required empty public constructor
    }


   public  static class Floor1Fragment extends GalleryFragment
    {

        public Floor1Fragment(){

        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {


            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_floor1, container, false);



        }

    }

    public  static class Floor2Fragment extends GalleryFragment
    {
        public Floor2Fragment(){

        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            // Inflate the layout for this fragment

            return inflater.inflate(R.layout.fragment_floor2, container, false);
        }

    }

    public  static class Floor3Fragment extends GalleryFragment
    {
        public Floor3Fragment(){

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_floor3, container, false);
        }
    }

}




