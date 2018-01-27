package com.example.twins.meeter.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.twins.meeter.R;
import com.facebook.FacebookSdk;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FacebookSdk.sdkInitialize(getApplicationContext());

//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_favorites:
                                Toast.makeText(MainActivity.this, "click action_favorites", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.action_likes:
                                Toast.makeText(MainActivity.this, "click action_favorites", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.action_setting:
                                Toast.makeText(MainActivity.this, "click action_favorites", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
    }
}
