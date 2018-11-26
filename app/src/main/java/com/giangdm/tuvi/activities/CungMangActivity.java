package com.giangdm.tuvi.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.adapters.CungMangAdapter;
import com.giangdm.tuvi.database.TuViManager2;

public class CungMangActivity extends AppCompatActivity {

    private RecyclerView rclView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cung_mang);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.cung_mang));
        actionBar.setDisplayHomeAsUpEnabled(true);

        rclView = findViewById(R.id.cung_mang_rcl_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rclView.setLayoutManager(manager);
        CungMangAdapter adapter = new CungMangAdapter(this, new TuViManager2(this).getCungMang());
        rclView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
