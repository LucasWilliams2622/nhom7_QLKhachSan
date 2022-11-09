package com.example.nhom7_qlkhachsan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.nhom7_qlkhachsan.Activity.LoginActivity;
import com.example.nhom7_qlkhachsan.Fragment.DatPhongFragment;
import com.example.nhom7_qlkhachsan.Fragment.HoTroKHFragment;
import com.example.nhom7_qlkhachsan.Fragment.PhongDaDatFragment;
import com.example.nhom7_qlkhachsan.Fragment.ServiceFragment;
import com.google.android.material.navigation.NavigationView;
//dz ziet
public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    FrameLayout frameLayout;
    Toolbar toolBar;
    NavigationView navigationView;
    View headerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.DrawerLayout);
        frameLayout = findViewById(R.id.frameLayout);
        toolBar = findViewById(R.id.toolBar);
        navigationView = findViewById(R.id.navigationView);
        headerLayout = navigationView.getHeaderView(0);
        TextView tvTen = headerLayout.findViewById(R.id.tvTen);
        setSupportActionBar(toolBar);
        ActionBar actionBar =  getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId()){
                    case R.id.mDichVu:
                        fragment = new ServiceFragment();
                        break;
                    case R.id.mDatPhong:
                        fragment = new DatPhongFragment();
                        break;
                    case R.id.mPhongDaDat:
                        fragment = new PhongDaDatFragment();
                        break;
                    case R.id.mTuVanKH:
                        fragment = new HoTroKHFragment();
                        break;
//                    case R.id.mTop10:
//                        fragment = new Top10Fragment();
//                        break;
//                    case R.id.mDoanhThu:
//                        fragment = new DoanhThuFragment();
//                        break;
//                    case R.id.mDoiMatKhau:
//                        showDialogChangePass();
                    //ahahahah
//                        break;
                    case R.id.mDangXuat:
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);

                    default:
                        fragment = new ServiceFragment();
                        break;
                }
                if (fragment!=null)
                {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, fragment)
                            .commit();
                    toolBar.setTitle(item.getTitle());
                }



                drawerLayout.closeDrawer(GravityCompat.START);

                return false;
            }
        });
//sơn aaaaa

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() ==  android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);

    }
}