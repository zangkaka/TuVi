package com.giangdm.tuvi.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.activities.NamSinhActivity;
import com.giangdm.tuvi.database.TuViManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class WomanFragment extends Fragment {

    private TextView contentTxt;
    private TuViManager tuViManager;

    public WomanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tuViManager = new TuViManager(getContext());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_woman, container, false);
        contentTxt = view.findViewById(R.id.woman_content_txt);

        Intent intent = getActivity().getIntent();
        String tuoiId = intent.getStringExtra(NamSinhActivity.KEY_TUOI_ID);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(tuViManager.getTuVi(tuoiId,"0").getTdName());

        contentTxt.setText(tuViManager.getTuVi(tuoiId, "0").getIntro());

        return view;
    }

}
