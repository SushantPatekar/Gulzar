package gulzar.kavi.com.gulzar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.viewpagerindicator.UnderlinePageIndicator;

import java.util.ArrayList;
import java.util.List;

import gulzar.kavi.com.gulzar.adapter.ViewPagerAdapter;
import gulzar.kavi.com.gulzar.utilities.GulzarCofig;
import gulzar.kavi.com.gulzar.youtube.YoutubeViewerActivity;

import static gulzar.kavi.com.gulzar.GulzarApp.memoryData;

/**
 * Created by Sushant.Patekar on 5/26/2017.
 */

public class PoemViewActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ViewPager viewPager;
    PagerAdapter adapter;
    String[] rank;
    String[] country;
    String[] population;
    int[] flag;
    UnderlinePageIndicator mIndicator;
    List<GulzarCofig.Poem> customList=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poemview_activity);
        Toolbar toolbar = getToolbar();
        getNavigationDrawer(toolbar);

        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager);

     /*
        if(GulzarApp.memoryData.getPoemList().get(0).getmTitle().matches("00")){
           customList= GulzarApp.memoryData.getPoemList();customList.remove(0);
        }
        else {*/
            customList=GulzarApp.memoryData.getPoemList();
       // }



        adapter = new ViewPagerAdapter(PoemViewActivity.this,customList );
        viewPager.setAdapter(adapter);

        // ViewPager Indicator
        mIndicator = (UnderlinePageIndicator) findViewById(R.id.indicator);
        mIndicator.setFades(false);
        mIndicator.setViewPager(viewPager);
        viewPager.setCurrentItem(Integer.parseInt(getIntent().getStringExtra(Intent.EXTRA_STREAM)));
        mIndicator.setCurrentItem(Integer.parseInt(getIntent().getStringExtra(Intent.EXTRA_STREAM)));

    }
    private Toolbar getToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        return toolbar;
    }
    private void getNavigationDrawer(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_share, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
           // Toast.makeText(PoemViewActivity.this,""+customList.get(viewPager.getCurrentItem()).getmContent_poem(),Toast.LENGTH_LONG).show();
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
           // sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, ""+customList.get(viewPager.getCurrentItem()).getmSubtitle());
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, ""+customList.get(viewPager.getCurrentItem()).getmContent_poem());
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent = null;

        if (id == R.id.nav_camera) {
            intent = new Intent(PoemViewActivity.this,MainActivity.class);
            startActivity(intent);
           // finish();
        }

        else if (id == R.id.nav_slideshow) {
            intent = new Intent(PoemViewActivity.this,AboutGulzarActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {
            intent = new Intent(PoemViewActivity.this,YoutubeViewerActivity.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
