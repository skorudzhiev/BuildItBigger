package com.udacity.gradle.builditbigger.paid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.udacity.gradle.builditbigger.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class JokeFragment extends Fragment {

    public JokeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke, container, false);
        return root;
    }
}
