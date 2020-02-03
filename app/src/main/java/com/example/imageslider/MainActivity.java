package com.example.imageslider;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    private CardFragment cardFragment;
    private RecurringFragment recurringFragment;

    private int[] tabIcons = {
            R.drawable.bottom_dot,
            R.drawable.bottom_dot,
            R.drawable.bottom_dot
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Adding Fragments
        adapter.addFrag(new CardFragment());
        adapter.addFrag(new RecurringFragment());
        adapter.addFrag(new CardFragment());

        //Adapter Setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);

        LinearLayout tabStrip = ((LinearLayout)tabLayout.getChildAt(0));
        for (int i = 0; i < tabStrip.getChildCount(); i++)
        {
            tabStrip.getChildAt(i).setOnTouchListener(new View.OnTouchListener()
            {
                @Override
                public boolean onTouch(View v, MotionEvent event)
                {
                    return true;
                }
            });
        }

//        viewPager.setOffscreenPageLimit(2);
//        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
//        {
//            @Override
//            public void onPageSelected(int position)
//            {
//                tabLayout.getTabAt(position).select();
//            }
//        });
    }

}
