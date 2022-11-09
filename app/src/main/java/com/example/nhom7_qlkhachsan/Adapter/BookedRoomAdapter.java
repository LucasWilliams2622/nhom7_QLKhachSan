package com.example.nhom7_qlkhachsan.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhom7_qlkhachsan.Model.AppRoom;
import com.example.nhom7_qlkhachsan.R;

import java.util.ArrayList;

public class BookedRoomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<AppRoom> list;
    EditText txtEndDay,txtStartDay;
    Button btnHuyPhong;
    TextView tvTenPhong,tvMaPhong,tvLoaiPhong,tvGiaPhong;
    ImageView ivRoom;

    public BookedRoomAdapter(Context context, ArrayList<AppRoom> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        view = inflater.inflate(R.layout.item_recycler_booked_room,null);
        txtEndDay = view.findViewById(R.id.txtEndDay);
        txtStartDay = view.findViewById(R.id.txtStartDay);
        btnHuyPhong = view.findViewById(R.id.btnHuyPhong);
        tvTenPhong = view.findViewById(R.id.tvTenPhong);
        tvMaPhong = view.findViewById(R.id.tvMaPhong);
        tvLoaiPhong = view.findViewById(R.id.tvLoaiPhong);
        tvGiaPhong = view.findViewById(R.id.tvGiaPhong);
        ivRoom = view.findViewById(R.id.ivRoom);

        AppRoom room= list.get(position);
        txtEndDay.setText(room.getEndDay());
        txtStartDay.setText(room.getStartDay());
        tvTenPhong.setText(room.getNameRoom());
        tvMaPhong.setText(room.getIdRoom());
        tvLoaiPhong.setText(room.getTypeRoom());
        tvGiaPhong.setText(room.getPriceRoom());

        return view;
    }


}
