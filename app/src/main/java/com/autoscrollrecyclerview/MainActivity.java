package com.autoscrollrecyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.autoscrollrecyclerview.adapter.SplashImageAdapter;
import com.autoscrollrecyclerview.model.ImageName;
import com.autoscrollrecyclerview.utils.MyCustomLayoutManager;
import com.autoscrollrecyclerview.utils.SpacesItemDecoration;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public Integer person_image[] = {R.drawable.sb,
            R.drawable.sa, R.drawable.sc, R.drawable.sd, R.drawable.se,
            R.drawable.sf, R.drawable.sg, R.drawable.sh, R.drawable.si,
            R.drawable.sj, R.drawable.sk, R.drawable.sl, R.drawable.sb,
            R.drawable.sa, R.drawable.sc, R.drawable.sd, R.drawable.se,
            R.drawable.sb, R.drawable.sa, R.drawable.sc, R.drawable.sd,
            R.drawable.se};
    NestedScrollView scrollView;
    LinearLayout ll_main;
    FrameLayout frameLayout;
    RecyclerView rvSplash;
    SplashImageAdapter splashImageAdapter;
    ArrayList<ImageName> listItems;
    RelativeLayout rl_logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSplash = findViewById(R.id.rv_splash);
        ll_main = findViewById(R.id.ll_main);
        frameLayout = findViewById(R.id.fl_splash_screen);
        rl_logo = findViewById(R.id.rl_logo);
        rvSplash.setClickable(false);
        listItems = listItems();
        rvSplash = findViewById(R.id.rv_splash);
        final MyCustomLayoutManager myCustomLayoutManager = new MyCustomLayoutManager(2, MyCustomLayoutManager.VERTICAL, MainActivity.this);
        rvSplash.setLayoutManager(myCustomLayoutManager);
        splashImageAdapter = new SplashImageAdapter(listItems, MainActivity.this);
        rvSplash.setHasFixedSize(true);
        rvSplash.setAdapter(splashImageAdapter);
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        rvSplash.addItemDecoration(decoration);


        for (int i = 7; i < person_image.length; ) {
            final int finalI = i;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    myCustomLayoutManager.smoothScrollToPosition(rvSplash, null, (finalI));
                }
            }, 5000);

            i += 2;
        }
    }

    private ArrayList<ImageName> listItems() {
        ArrayList<ImageName> list = new ArrayList<>();
        for (Integer aPerson_image : person_image) {
            ImageName listItem = new ImageName();
            listItem.setPersonImage(aPerson_image);
            list.add(listItem);
        }
        return list;
    }

}
