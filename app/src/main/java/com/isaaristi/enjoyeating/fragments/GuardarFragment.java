package com.isaaristi.enjoyeating.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaaristi.enjoyeating.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuardarFragment extends Fragment {

    public static GuardarFragment instance() {
        return new GuardarFragment();
    }

    public GuardarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guardar, container, false);
    }

}
