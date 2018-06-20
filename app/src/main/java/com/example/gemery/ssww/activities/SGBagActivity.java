package com.example.gemery.ssww.activities;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.gemery.groupradioaddfragment.R;

import butterknife.ButterKnife;

public class SGBagActivity  extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_gbag_search);
        ButterKnife.bind(this);
    }
}
