package com.bignerdranch.android.criminalintent.controller;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bignerdranch.android.criminalintent.controller.databinding.FragmentCrimeBinding;
import com.bignerdranch.android.criminalintent.model.Crime;

public class CrimeFragment extends Fragment {
    private FragmentCrimeBinding mBinding;
    private Crime mCrime;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initFragmentCrimeView(inflater, container);
    }

    private View initFragmentCrimeView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        mBinding = FragmentCrimeBinding.inflate(inflater, container, false);

        mBinding.crimeTitleHint.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBinding.crimeDetailsLabel.setText(mCrime.getDate().toString());
        mBinding.crimeDetailsLabel.setEnabled(false);
        mBinding.crimeSolved.setOnCheckedChangeListener(this::onCheckedChanged);

        return mBinding.getRoot();
    }

    private void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mCrime.setSolved(isChecked);
    }
}
