package com.example.twins.meeter.ui.filter;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;

import com.example.twins.meeter.R;
import com.example.twins.meeter.ui.custom_view.HintArrayAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilterDialogFragment extends Fragment {


    public FilterDialogFragment() {
        // Required empty public constructor
    }

    public static FilterDialogFragment newInstance() {
        return new FilterDialogFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter_dialog, container, false);

        final String[] dataTeam = {"Парень", "Девочка", "Пол"};//last hint
        AppCompatSpinner spinnerTeam = view.findViewById(R.id.sex_spinner);
        HintArrayAdapter adapterTeam = new HintArrayAdapter(getContext(), R.layout.item_position_spinner, dataTeam);
        spinnerTeam.setAdapter(adapterTeam);
        spinnerTeam.setSelection(adapterTeam.getCount());
        spinnerTeam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final String[] dataType = {"Австралийская короткохвостая пастушья собака", "Австралийская овчарка",
                "Афганская борзая", "Аффенпинчер", "Бордоский дог", "Волчья собака Сарлоса", "Длинношёрстный колли",
                "Крашская овчарка", "Мальтезе", "Малый вандейский бассет-гриффон", "Вест-хайленд-уайт-терьер",
                "Кромфорлендер", "Порода"};//last hint
        AppCompatSpinner spinnerType = view.findViewById(R.id.type_spinner);
        HintArrayAdapter adapterType = new HintArrayAdapter(getContext(), R.layout.item_position_spinner, dataType);
        spinnerType.setAdapter(adapterType);
        spinnerType.setSelection(adapterType.getCount());
        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final String[] dataColor = {"Белый", "Серый", "Красный",
                "Голубой", "Синий", "Черный", "Рыжий", "Цвет"};//last hint
        AppCompatSpinner spinnerColor = view.findViewById(R.id.color_spinner);
        HintArrayAdapter adapterColor = new HintArrayAdapter(getContext(), R.layout.item_position_spinner, dataColor);
        spinnerColor.setAdapter(adapterColor);
        spinnerColor.setSelection(adapterColor.getCount());
        spinnerColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        view.findViewById(R.id.ok_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() != null)
                    getActivity().onBackPressed();
            }
        });

        return view;
    }

}
