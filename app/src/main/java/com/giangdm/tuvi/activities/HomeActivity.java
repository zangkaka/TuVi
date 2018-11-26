package com.giangdm.tuvi.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.giangdm.tuvi.R;
import com.giangdm.tuvi.constants.Constant;
import com.giangdm.tuvi.database.TuViManager2;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mTuvi, mBangCungMang, mBoiPhuongDong,
            mBoiPhuongTay, mNgayNghiLe, mLeHoiLon, mDanhNgon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        LinearLayout linearLayout = findViewById(R.id.layout_home);
//        Bitmap bg = BitmapFactory.decodeResource(getResources(), R.drawable.bg_home);
//        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bg);
//        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
//        linearLayout.setBackground(bitmapDrawable);

        TuViManager2 tuViManager2 = new TuViManager2(this);

        mTuvi = findViewById(R.id.home_tu_vi_tron_doi_layout);
        mBangCungMang = findViewById(R.id.home_bang_cung_mang_layout);
        mBoiPhuongDong = findViewById(R.id.home_boi_phuong_dong_layout);
        mBoiPhuongTay = findViewById(R.id.home_boi_phuong_tay_layout);
        mNgayNghiLe = findViewById(R.id.home_ngay__nghi_le_layout);
        mLeHoiLon = findViewById(R.id.home_le_hoi_layout);
        mDanhNgon = findViewById(R.id.home_danh_ngon_layout);

        mTuvi.setOnClickListener(this);
        mBangCungMang.setOnClickListener(this);
        mBoiPhuongDong.setOnClickListener(this);
        mBoiPhuongTay.setOnClickListener(this);
        mNgayNghiLe.setOnClickListener(this);
        mLeHoiLon.setOnClickListener(this);
        mDanhNgon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        long now = System.currentTimeMillis();
        if (new Constant().isOverThreashold(now)) {
            switch (v.getId()) {
                case R.id.home_tu_vi_tron_doi_layout:
                    intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.home_bang_cung_mang_layout:
                    intent = new Intent(this, CungMangActivity.class);
                    startActivity(intent);
                    break;
                case R.id.home_boi_phuong_dong_layout:
                    intent = new Intent(this, PhuongDongActivity.class);
                    startActivity(intent);
                    break;
                case R.id.home_boi_phuong_tay_layout:
                    intent = new Intent(this, PhuongTayActivity.class);
                    startActivity(intent);
                    break;
                case R.id.home_ngay__nghi_le_layout:
                    intent = new Intent(this, NgayLeActivity.class);
                    startActivity(intent);
                    break;
                case R.id.home_le_hoi_layout:
                    intent = new Intent(this, LeHoiActivity.class);
                    startActivity(intent);
                    break;
                case R.id.home_danh_ngon_layout:
                    intent = new Intent(this, DanhNgonActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }
        new Constant().timestamp = now;
    }
}
