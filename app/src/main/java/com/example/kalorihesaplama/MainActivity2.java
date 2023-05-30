package com.example.kalorihesaplama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {
    private EditText txtcinsiyet,txtisimsoyisim,txtusername,txtkiloboy,txtmail,txtpass;
    private Button btnkaydet;
    private DatabaseReference myRef;
    private String cinsiyet,isimsoyisim,username,kiloboy,mail,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtcinsiyet = findViewById(R.id.txtcinsiyet);
        txtisimsoyisim = findViewById(R.id.txtisimsoyisim);
        txtusername = findViewById(R.id.txtusername);
        txtkiloboy = findViewById(R.id.txtkiloboy);
        txtmail = findViewById(R.id.txtmail);
        txtpass = findViewById(R.id.txtpass);
        btnkaydet = findViewById(R.id.btnkaydet);
        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kalorihesaplama-3d363-default-rtdb.firebaseio.com/");

        btnkaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cinsiyet = txtcinsiyet.getText().toString();
                isimsoyisim = txtisimsoyisim.getText().toString();
                username = txtusername.getText().toString();
                kiloboy = txtkiloboy.getText().toString();
                mail = txtmail.getText().toString();
                pass = txtpass.getText().toString();
                if (TextUtils.isEmpty(cinsiyet) || TextUtils.isEmpty(isimsoyisim) || TextUtils.isEmpty(username) || TextUtils.isEmpty(kiloboy) || TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass)){
                    Toast.makeText(MainActivity2.this,"Lütfen Tüm Boşlukları Doldurunuz",Toast.LENGTH_SHORT).show();

                }else {
                    myRef.child("Person").child(username).child("Adı Soyadı").setValue(isimsoyisim);
                    myRef.child("Person").child(username).child("Cinsiyet").setValue(cinsiyet);
                    myRef.child("Person").child(username).child("Kilo-Boy").setValue(kiloboy);
                    myRef.child("Person").child(username).child("E-mail").setValue(mail);
                    myRef.child("Person").child(username).child("Şifre").setValue(pass);
                    Intent intent3 = new Intent(MainActivity2.this,MainActivity.class);
                    startActivity(intent3);
                    Toast.makeText(MainActivity2.this,"Kayıt Başarılı",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}