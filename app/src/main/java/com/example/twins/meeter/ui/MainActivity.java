package com.example.twins.meeter.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.twins.meeter.R;
import com.facebook.FacebookSdk;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FacebookSdk.sdkInitialize(getApplicationContext());

//      Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//      startActivity(intent);
        final TextView titleView = findViewById(R.id.title_tool_bar);
        titleView.setText(R.string.favorite);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_favorites:
                                titleView.setText(R.string.favorite);
                                break;
                            case R.id.action_likes:
                                titleView.setText(R.string.feed);
                                break;
                            case R.id.action_setting:
                                titleView.setText(R.string.settings);
                                break;
                        }
                        return true;
                    }
                });
    }
}
