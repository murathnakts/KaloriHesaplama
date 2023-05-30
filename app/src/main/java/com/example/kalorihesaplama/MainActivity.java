package com.example.kalorihesaplama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private EditText txtkullaniciadi,txtsifre;
    private Button btngiris,btnkayit;
    private String kullaniciadi,sifre,dsifre;
    private DatabaseReference myRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtkullaniciadi = findViewById(R.id.txtkullaniciadi);
        txtsifre = findViewById(R.id.txtsifre);
        btnkayit = findViewById(R.id.btnkayit);
        btngiris = findViewById(R.id.btngiris);
        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kalorihesaplama-3d363-default-rtdb.firebaseio.com/");

        btngiris.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                kullaniciadi = txtkullaniciadi.getText().toString();
                sifre = txtsifre.getText().toString();
                if (TextUtils.isEmpty(kullaniciadi) || TextUtils.isEmpty(sifre)){
                    Toast.makeText(MainActivity.this,"Lütfen Tüm Boşlukları Doldurunuz",Toast.LENGTH_SHORT).show();
                }else {
                    myRef.child("Person").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if (snapshot.hasChild(kullaniciadi)) {
                                dsifre = snapshot.child(kullaniciadi).child("Şifre").getValue(String.class);
                                if (dsifre.equals(sifre)) {
                                    Toast.makeText(MainActivity.this,"Giriş Başarılı",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this,MainActivity3.class);
                                    intent.putExtra("username",kullaniciadi);
                                    startActivity(intent);
                                    txtkullaniciadi.setText("");
                                    txtsifre.setText("");
                                }else {
                                    Toast.makeText(MainActivity.this,"Şifre Yanlış",Toast.LENGTH_SHORT).show();
                                    txtkullaniciadi.setText("");
                                    txtsifre.setText("");
                                }
                            }else {
                                Toast.makeText(MainActivity.this,"Kullanıcı Adı Yanlış",Toast.LENGTH_SHORT).show();
                                txtkullaniciadi.setText("");
                                txtsifre.setText("");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }

            }
        });

        btnkayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtkullaniciadi.setText("");
                txtsifre.setText("");
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}
