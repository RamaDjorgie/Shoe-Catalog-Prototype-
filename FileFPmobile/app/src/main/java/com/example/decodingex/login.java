package com.example.decodingex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    //Deklarasi Variable
    private EditText PassInput;
    private CheckBox ShowPass;
    Button login;
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        PassInput = findViewById(R.id.editText1);
        ShowPass = findViewById(R.id.showPass);
        username = findViewById(R.id.editText);
        password = findViewById(R.id.editText1);
        login = findViewById(R.id.butom2);


        //Set onClickListener, untuk menangani kejadian saat Checkbox diklik
        ShowPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ShowPass.isChecked()) {
                    //Saat Checkbox dalam keadaan Checked, maka password akan di tampilkan
                    PassInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //Jika tidak, maka password akan di sembuyikan
                    PassInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        TextView btn = (TextView) findViewById(R.id.textView5);
        TextView btn1 = (TextView) findViewById(R.id.textView4);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this, register.class);
                startActivity(i);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(login.this, "Maaf Fitur Belum ada", Toast.LENGTH_SHORT).show();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("user") && password.getText().toString().equals("user")) {
                    Toast.makeText(login.this, "Welcome Back !", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(login.this, MainActivity.class);
                    startActivity(i);
                }
                else if (username.getText().toString().equals("") && password.getText().toString().equals("")){
                    Toast.makeText(login.this, "Masukan Dulu", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(login.this, "Login anda gagal, periksa kembali", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}





