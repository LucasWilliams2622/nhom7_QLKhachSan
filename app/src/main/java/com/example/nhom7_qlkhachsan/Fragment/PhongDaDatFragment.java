package com.example.nhom7_qlkhachsan.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nhom7_qlkhachsan.Adapter.BookedRoomAdapter;
import com.example.nhom7_qlkhachsan.Model.AppRoom;
import com.example.nhom7_qlkhachsan.R;

import java.util.ArrayList;


public class PhongDaDatFragment extends Fragment {
    RecyclerView recyclerBookedRoom;
    BookedRoomAdapter bookedRoomAdapter;
    ArrayList<AppRoom> list = new ArrayList<AppRoom>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_phong_da_dat,container,false);
        recyclerBookedRoom = view.findViewById(R.id.recyclerBookedRoom);

        list = new ArrayList<AppRoom>();
        bookedRoomAdapter = new BookedRoomAdapter(getContext(),list);
//        recyclerBookedRoom.setAdapter(bookedRoomAdapter);

        return view;
    }

}