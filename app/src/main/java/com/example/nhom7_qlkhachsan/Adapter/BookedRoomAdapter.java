package com.example.nhom7_qlkhachsan.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhom7_qlkhachsan.Model.AppRoom;
import com.example.nhom7_qlkhachsan.R;

import java.util.ArrayList;

public class BookedRoomAdapter extends RecyclerView.Adapter<BookedRoomAdapter.ViewHolder>{

    private Context context;
    private ArrayList<AppRoom> list;

    public BookedRoomAdapter(Context context, ArrayList<AppRoom> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_recycler_booked_room,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    EditText txtEndDay,txtStartDay;
    Button btnHuyPhong;
    TextView tvTenPhong,tvMaPhong,tvLoaiPhong,tvGiaPhong;
    ImageView ivRoom;
    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtEndDay = itemView.findViewById(R.id.txtEndDay);
            txtStartDay = itemView.findViewById(R.id.txtStartDay);
            btnHuyPhong = itemView.findViewById(R.id.btnHuyPhong);
            tvTenPhong = itemView.findViewById(R.id.tvTenPhong);
            tvMaPhong = itemView.findViewById(R.id.tvMaPhong);
            tvLoaiPhong = itemView.findViewById(R.id.tvLoaiPhong);
            tvGiaPhong = itemView.findViewById(R.id.tvGiaPhong);
            ivRoom = itemView.findViewById(R.id.ivRoom);

        }
    }


}
