package com.awecode.stockapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.awecode.stockapp.MainActivity;

/**
 * Created by munnadroid on 5/29/17.
 */

public class TestFragment extends Fragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((MainActivity)getActivity()).setToolbarTitle("testing");
    }
}
