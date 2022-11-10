package com.example.nhom7_qlkhachsan.Activity;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.example.nhom7_qlkhachsan.Fragment.DatPhongFragment;
import com.example.nhom7_qlkhachsan.MainActivity;
import com.example.nhom7_qlkhachsan.Model.AppRoom;
import com.example.nhom7_qlkhachsan.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    long check = 1;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText edt_username = findViewById(R.id.edt_username_login);
        EditText edt_password = findViewById(R.id.edt_password_lgoin);
        Button btn_login = findViewById(R.id.btn_login);
        Button btn_register = findViewById(R.id.btnGoRegister);
        ImageView ivShowPass = findViewById(R.id.ivShowPass);


//        ThuThuDAO thuThuDAO = new ThuThuDAO(this);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();

            }


        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
               startActivity(intent);

            }
        });

        ivShowPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check++;
                if (check % 2 == 0) {
                    edt_password.setInputType(1);
                    Log.d(">>>>>>>>>", "check " + check);
                } else {
                    //edt_password.setInputType();

                    //  edt_password.setInputType(Integer.parseInt("textPassword"));
                }

            }
        });
    }

    public void getData(){
        db.collection("admin")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<String> list = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                list.add(document.getId());
                            }
                            Log.d(TAG, list.toString());
                            Toast.makeText(LoginActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }
                        else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                            Toast.makeText(LoginActivity.this, "Đăng nhập không thành công!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}