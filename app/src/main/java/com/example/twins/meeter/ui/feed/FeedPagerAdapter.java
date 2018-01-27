package com.example.twins.meeter.ui.feed;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.twins.meeter.R;
import com.example.twins.meeter.ui.activityMain.ListAnimalListener;
import com.example.twins.meeter.ui.list_animal.ListAnimalFragment;

import static com.example.twins.meeter.Constants.ALL_ANIMAL;
import static com.example.twins.meeter.Constants.CAT_ANIMAL;
import static com.example.twins.meeter.Constants.DOG_ANIMAL;

/**
 * Created by twins on 28.01.2018.
 */

public class FeedPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private ListAnimalListener listAnimalListener;

    public FeedPagerAdapter(Context context, FragmentManager fm, ListAnimalListener listAnimalListener) {
        super(fm);
        mContext = context;
        this.listAnimalListener = listAnimalListener;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        ListAnimalFragment listAnimalFragment;
        switch (position) {
            case 0:
                listAnimalFragment = ListAnimalFragment.newInstance(ALL_ANIMAL);
                break;
            case 1:
                listAnimalFragment = ListAnimalFragment.newInstance(CAT_ANIMAL);
                break;
            case 2:
                listAnimalFragment = ListAnimalFragment.newInstance(DOG_ANIMAL);
                break;
            default:
                listAnimalFragment = ListAnimalFragment.newInstance(ALL_ANIMAL);

        }
        listAnimalFragment.setListener(listAnimalListener);
        return listAnimalFragment;
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 3;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.all);
            case 1:
                return mContext.getString(R.string.cat);
            case 2:
                return mContext.getString(R.string.dog);
            default:
                return null;
        }
    }

}
