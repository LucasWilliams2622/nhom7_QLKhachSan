package com.example.nhom7_qlkhachsan.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nhom7_qlkhachsan.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtUsernameRegister,edtPaaswordRegister,edtRePasswordRegister;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtUsernameRegister = findViewById(R.id.edtUsernameRegister);
        edtPaaswordRegister = findViewById(R.id.edtPasswordRegister);
        edtRePasswordRegister = findViewById(R.id.edtRePasswordRegister);
        btnRegister = findViewById(R.id.btnRegister);

    }
    public void onRegisterClick(View view){
        String email =edtUsernameRegister.getText().toString();
        String password = edtPaaswordRegister.getText().toString();
        String repassword = edtRePasswordRegister.getText().toString();





    }
}