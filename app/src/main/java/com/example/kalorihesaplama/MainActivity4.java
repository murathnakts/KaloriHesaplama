package com.example.kalorihesaplama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity4 extends AppCompatActivity {

    private String username;
    private TextView isim,mail,cinsiyet,kiloboy,kalori;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        username = getIntent().getStringExtra("username");
        isim = findViewById(R.id.isim);
        mail = findViewById(R.id.mail);
        cinsiyet = findViewById(R.id.cinsiyet);
        kiloboy = findViewById(R.id.kiloboy);
        kalori = findViewById(R.id.kalori);
        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kalorihesaplama-3d363-default-rtdb.firebaseio.com/");

        myRef.child("Person").child(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                isim.setText(String.valueOf(snapshot.child("Adı Soyadı").getValue()));
                mail.setText(String.valueOf(snapshot.child("E-mail").getValue()));
                cinsiyet.setText(String.valueOf(snapshot.child("Cinsiyet").getValue()));
                kiloboy.setText(String.valueOf(snapshot.child("Kilo-Boy").getValue()));
                kalori.setText(String.valueOf(snapshot.child("Toplam Kalori").getValue()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}