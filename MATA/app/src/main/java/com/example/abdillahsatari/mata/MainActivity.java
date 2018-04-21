package com.example.abdillahsatari.mata;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class MainActivity extends ActionBarActivity implements OnCreateOptionMenu {

    BottomBar nBottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nBottomBar = BottomBar.attach(this, savedInstanceState);
        nBottomBar.setItemsFromMenu(R.menu.menu_main, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int i) {
                if (i==R.id.bottombaritemone)
                {
                    TimelineFragment fragment = new TimelineFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
                }
                else if (i==R.id.bottombaritemtwo)
                {
                    MapsFragment fragment = new MapsFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
                }
                else if (i==R.id.bottombaritemthree)
                {
                    AugmentedFragment fragment =  new AugmentedFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
                }
                else if (i==R.id.bottombaritemfour)
                {
                    NewsFragment fragment = new NewsFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
                }

            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });

        nBottomBar.mapColorForTab(0,"#1be99d");
        nBottomBar.mapColorForTab(1,"#1be98c");
        nBottomBar.mapColorForTab(2,"#1ce9a4");
        nBottomBar.mapColorForTab(3,"#1de9b6");
    }

    @Override
    public boolean onCreateOptionmenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
