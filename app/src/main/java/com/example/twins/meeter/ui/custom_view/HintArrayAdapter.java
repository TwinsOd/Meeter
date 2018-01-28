package com.example.twins.meeter.ui.custom_view;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.twins.meeter.R;

/**
 * Created by Twins on 10/12/2017.
 */

public class HintArrayAdapter extends ArrayAdapter {

    public HintArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Object[] objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        if (position == getCount()) {
            ((TextView) v).setText("");
            ((TextView) v).setHint((String) getItem(position));
        }

        return v;
    }

    @Override
    public int getCount() {
        return super.getCount() - 1;
    }
}
