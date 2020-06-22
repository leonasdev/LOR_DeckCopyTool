package com.example.lor_deckcopytool.ui.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lor_deckcopytool.R;
import com.example.lor_deckcopytool.SharedPref;

public class SettingFragment extends Fragment {
    private Switch myswitch;
    SharedPref sharedPref;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_setting, container, false);
        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        sharedPref = new SharedPref(getActivity());
        if(sharedPref.loadNightState()) {
            getActivity().setTheme(R.style.DarkTheme);
        }
        else getActivity().setTheme(R.style.AppTheme);
        myswitch = view.findViewById(R.id.switch1);
        if(sharedPref.loadNightState()) {
            myswitch.setChecked(true);
        }
        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    sharedPref.setNightModeState(true);
                }
                else {
                    sharedPref.setNightModeState(false);
                }
                getActivity().recreate();
            }
        });
    }
}