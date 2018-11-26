package com.giangdm.tuvi.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.adapters.NgayLeAdapter;
import com.giangdm.tuvi.database.TuViManager2;

public class NgayLeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngay_le);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.ngay_le));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView rclView = findViewById(R.id.ngay_le_rcl_view);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rclView.setLayoutManager(manager);
        NgayLeAdapter adapter = new NgayLeAdapter(this, new TuViManager2(this).getNgayLe());
        rclView.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
