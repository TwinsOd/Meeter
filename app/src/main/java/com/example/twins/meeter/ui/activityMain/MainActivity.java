package com.example.twins.meeter.ui.activityMain;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.twins.meeter.App;
import com.example.twins.meeter.R;
import com.example.twins.meeter.data.models.AnimalModel;
import com.example.twins.meeter.ui.account.AccountFragment;
import com.example.twins.meeter.ui.activitiesStart.LoginActivity;
import com.example.twins.meeter.ui.favorites.FavoritesFragment;
import com.example.twins.meeter.ui.feed.FeedFragment;
import com.example.twins.meeter.ui.filter.FilterDialogFragment;
import com.example.twins.meeter.ui.profileAnimal.ProfileAnimalActivity;
import com.example.twins.meeter.ui.settings.SettingsFragment;
import com.facebook.FacebookSdk;

public class MainActivity extends AppCompatActivity implements ListAnimalListener, View.OnClickListener {

    private TextView titleView;
    private ImageView filterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FacebookSdk.sdkInitialize(getApplicationContext());

        titleView = findViewById(R.id.title_tool_bar);
        (findViewById(R.id.avatar_view)).setOnClickListener(this);
        filterView = (findViewById(R.id.filter_view));
        filterView.setOnClickListener(this);
        final ListAnimalListener listAnimalListener = this;
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_favorites:
                                titleView.setText(R.string.favorite);
                                FavoritesFragment favoritesFragment = FavoritesFragment.newInstance();
                                favoritesFragment.setListener(listAnimalListener);
                                onShowFragment(favoritesFragment, false);
                                filterView.setVisibility(View.GONE);
                                break;
                            case R.id.action_feed:
                                titleView.setText(R.string.feed);
                                FeedFragment feedFragment = FeedFragment.newInstance();
                                feedFragment.setListener(listAnimalListener);
                                onShowFragment(feedFragment, false);
                                filterView.setVisibility(View.VISIBLE);
                                break;
                            case R.id.action_setting:
                                titleView.setText(R.string.settings);
                                onShowFragment(SettingsFragment.newInstance(), false);
                                filterView.setVisibility(View.GONE);
                                break;
                        }
                        return true;
                    }
                });
        bottomNavigationView.setSelectedItemId(R.id.action_feed);
    }

    public void onShowFragment(Fragment fragment, boolean addStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().replace(R.id.container_fragments, fragment);
        if (!addStack) {
            for (int i = 0; i < fragmentManager.getBackStackEntryCount(); ++i) {
                fragmentManager.popBackStack();
            }
        } else {
            fragmentTransaction.addToBackStack(fragment.toString());
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onClickAnimal(AnimalModel animalModel) {
        App.getRepository().setAnimalModel(animalModel);
        Intent intent = new Intent(this, ProfileAnimalActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.avatar_view:
//                titleView.setText(R.string.account);
//                onShowFragment(AccountFragment.newInstance(), true);
//                filterView.setVisibility(View.GONE);
//                Toast.makeText(this, "В стадии разработки", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.filter_view:
                onShowFragment(FilterDialogFragment.newInstance(), true);
                titleView.setText("Фильтры");
                break;
        }
    }


}
