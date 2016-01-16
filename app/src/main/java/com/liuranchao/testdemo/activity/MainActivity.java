package com.liuranchao.testdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.igexin.sdk.PushManager;
import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.activity.aidl.AIDLActivity;
import com.liuranchao.testdemo.activity.async_task.AsyncTaskActivity;
import com.liuranchao.testdemo.activity.custom_view.CustomViewMainActivity;
import com.liuranchao.testdemo.activity.file_provider.FileProviderActivity;
import com.liuranchao.testdemo.activity.floating_group.FloatingGroupExpandableListViewActivity;
import com.liuranchao.testdemo.activity.gson.GsonActivity;
import com.liuranchao.testdemo.activity.handler_thread.HandlerThreadActivity;
import com.liuranchao.testdemo.activity.launch_mode.LaunchModelActivity;
import com.liuranchao.testdemo.activity.life_circle.LifeCircleActivity;
import com.liuranchao.testdemo.activity.list_adapter.SimpleAdapterActivity;
import com.liuranchao.testdemo.activity.nfc.NFCActivity;
import com.liuranchao.testdemo.activity.scenes.ScenesActivity;
import com.liuranchao.testdemo.activity.task_affinity.TaskAffinityActivity;

/**
 * 主界面的Activity
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private FragmentManager mFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // 初始化个推
        PushManager.getInstance().initialize(getApplicationContext());

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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_life_circle) {

            startActivity(new Intent(this, LifeCircleActivity.class));

        } else if (id == R.id.nav_floating_group_expandable_list_view) {

            startActivity(new Intent(this, FloatingGroupExpandableListViewActivity.class));

        } else if (id == R.id.nav_async_task) {

            startActivity(new Intent(this, AsyncTaskActivity.class));

        } else if (id == R.id.nav_gson) {

            startActivity(new Intent(this, GsonActivity.class));

        } else if (id == R.id.nav_simple_adapter) {

            startActivity(new Intent(this, SimpleAdapterActivity.class));

        } else if (id == R.id.nav_file_provider) {

            startActivity(new Intent(this, FileProviderActivity.class));

        } else if (id == R.id.nav_aidl) {

            startActivity(new Intent(this, AIDLActivity.class));

        } else if (id == R.id.nav_nfc) {

            startActivity(new Intent(this, NFCActivity.class));

        } else if (id == R.id.nav_task_affinity) {

            startActivity(new Intent(this, TaskAffinityActivity.class));
        } else if (id == R.id.nav_launch_mode) {

            startActivity(new Intent(this, LaunchModelActivity.class));

        } else if (id == R.id.nav_chronometer) {

            startActivity(new Intent(this, ChronometerActivity.class));

        } else if (id == R.id.nav_handler_thread) {

            startActivity(new Intent(this, HandlerThreadActivity.class));

        } else if (id == R.id.nav_scenes) {

            startActivity(new Intent(this, ScenesActivity.class));

        } else if (id == R.id.nav_custom_view) {

            startActivity(new Intent(this, CustomViewMainActivity.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
