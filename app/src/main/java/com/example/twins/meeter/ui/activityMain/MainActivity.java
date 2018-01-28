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
import android.widget.TextView;

import com.example.twins.meeter.App;
import com.example.twins.meeter.R;
import com.example.twins.meeter.data.models.AnimalModel;
import com.example.twins.meeter.ui.account.AccountFragment;
import com.example.twins.meeter.ui.favorites.FavoritesFragment;
import com.example.twins.meeter.ui.feed.FeedFragment;
import com.example.twins.meeter.ui.profileAnimal.ProfileAnimalActivity;
import com.example.twins.meeter.ui.settings.SettingsFragment;
import com.facebook.FacebookSdk;

public class MainActivity extends AppCompatActivity implements ListAnimalListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FacebookSdk.sdkInitialize(getApplicationContext());

        final TextView titleView = findViewById(R.id.title_tool_bar);
        (findViewById(R.id.avatar_view)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titleView.setText(R.string.account);
                onShowFragment(AccountFragment.newInstance(), true);
            }
        });
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
                                break;
                            case R.id.action_feed:
                                titleView.setText(R.string.feed);
                                FeedFragment feedFragment = FeedFragment.newInstance();
                                feedFragment.setListener(listAnimalListener);
                                onShowFragment(feedFragment, false);
                                break;
                            case R.id.action_setting:
                                titleView.setText(R.string.settings);
                                onShowFragment(SettingsFragment.newInstance(), false);
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
}
