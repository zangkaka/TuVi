package com.giangdm.tuvi.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.adapters.NamSinhAdapter;
import com.giangdm.tuvi.database.TuViManager;

public class NamSinhActivity extends AppCompatActivity implements View.OnClickListener {

    private TuViManager tuViManager;
    private String id;

    public static final String KEY_TUOI_ID = "key_tuoi_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nam_sinh);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        tuViManager = new TuViManager(this);
        Intent intent = getIntent();
        id = intent.getStringExtra(MainActivity.KEY_CONGIAP);
        String title = intent.getStringExtra(MainActivity.KEY_CONGIAP_NAME);
        actionBar.setTitle("Tử Vi " + title);

        RecyclerView rclView = findViewById(R.id.rcl_view);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rclView.setLayoutManager(manager);
        NamSinhAdapter adapter = new NamSinhAdapter(this, tuViManager.getNamSinh(id), this);
        rclView.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {

        int pos = (int) v.getTag();
        switch (v.getId()) {
            case R.id.nam_sinh_layout:
                Intent intent = new Intent(this, DetailActivity.class);
                intent.putExtra(KEY_TUOI_ID, tuViManager.getNamSinh(id).get(pos).getIdTuoi());
                startActivity(intent);
                break;
            default:
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
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
