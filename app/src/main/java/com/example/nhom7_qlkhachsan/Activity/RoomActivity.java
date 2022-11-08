package com.example.nhom7_qlkhachsan.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nhom7_qlkhachsan.Model.AppRoom;
import com.example.nhom7_qlkhachsan.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RoomActivity extends AppCompatActivity {
    private EditText  edtStartDay, edtEndDay;
    private TextView edtIdRoom, edtNameRoom, edtTypeRoom, edtPriceRoom;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        edtIdRoom = findViewById(R.id.edtIdRoom);
        edtNameRoom = findViewById(R.id.edtNameRoom);
        edtTypeRoom = findViewById(R.id.edtTypeRoom);
        edtPriceRoom = findViewById(R.id.edtPriceRoom);
        edtStartDay = findViewById(R.id.edtStartDay);
        edtEndDay = findViewById(R.id.edtEndDay);

    }
    public void getData(){
        db.collection("room")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
//                            ArrayList<AppRoom> list = new ArrayList<>();
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Map<String,Object> map = document.getData();
//                                String idRoom = map.get("idRoom").toString();
//                                String idRoom = map.get("idRoom").toString();
//                                String idRoom = map.get("idRoom").toString();
//                                String idRoom = map.get("idRoom").toString();
//                                String idRoom = map.get("idRoom").toString();
//
//// private String idRoom,nameRoom,typeRoom,priceRoom,startDay,endDay;
//                                AppCourse course = new AppCourse(-1,1,code,name,time,room);
//                                course.setCourseId(document.getId());
//                                list.add(course);
//                            }
//                            getSupportFragmentManager()
//                                    .beginTransaction()
//                                    .replace(R.id.frm, CourseFragment.newInstance(list))
//                                    .commit();
                        }
                    }
                });
    }
    public void onSaveClick(View view) {
        String idRoom = edtIdRoom.getText().toString();
        String nameRoom = edtNameRoom.getText().toString();
        String typeRoom = edtTypeRoom.getText().toString();
        String priceRoom = edtPriceRoom.getText().toString();
        String startDay = edtStartDay.getText().toString();
        String endDay = edtEndDay.getText().toString();

// Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("idRoom", idRoom);
        user.put("nameRoom", nameRoom);
        user.put("typeRoom", typeRoom);
        user.put("priceRoom", priceRoom);
        user.put("startDay", startDay);
        user.put("endDay", endDay);


// Add a new document with a generated ID
        db.collection("room")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(RoomActivity.this, "Inserted success", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RoomActivity.this, "Faied", Toast.LENGTH_SHORT).show();
                    }
                });
    }
//    @Override
//    public void onCancelClick(View view course) {
//        edtcode.setText(course.getCode());
//        edtname.setText(course.getName());
//        edttime.setText(course.getTime());
//        edtroom.setText(course.getRoom());
//        appCourse=course;

}