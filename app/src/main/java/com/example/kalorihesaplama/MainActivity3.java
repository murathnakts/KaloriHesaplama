package com.example.kalorihesaplama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity3 extends AppCompatActivity {
    private TextView kt1,kt2,kt3,kt4,kt5,kt6,kt7,kt8,ot1,ot2,ot3,ot4,ot5,ot6,at1,at2,at3,at4,at5,at6,at7,at8;
    private Button kbe1,kbc1,kbe2,kbc2,kbe3,kbc3,kbe4,kbc4,kbe5,kbc5,kbe6,kbc6,kbe7,kbc7,kbe8,kbc8,obe1,obc1,obe2,obc2,obe3,obc3,obe4,obc4,obe5,obc5,obe6,obc6,abe1,abc1,abe2,abc2,abe3,abc3,abe4,abc4,abe5,abc5,abe6,abc6,abe7,abc7,abe8,abc8,btnhesapla;
    private DatabaseReference myRef;
    private String username;
    private int sum;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        username = getIntent().getStringExtra("username");

        kt1 = findViewById(R.id.kt1);
        kbe1 = findViewById(R.id.kbe1);
        kbc1 = findViewById(R.id.kbc1);
        kt2 = findViewById(R.id.kt2);
        kbe2 = findViewById(R.id.kbe2);
        kbc2 = findViewById(R.id.kbc2);
        kt3 = findViewById(R.id.kt3);
        kbe3 = findViewById(R.id.kbe3);
        kbc3 = findViewById(R.id.kbc3);
        kt4 = findViewById(R.id.kt4);
        kbe4 = findViewById(R.id.kbe4);
        kbc4 = findViewById(R.id.kbc4);
        kt5 = findViewById(R.id.kt5);
        kbe5 = findViewById(R.id.kbe5);
        kbc5 = findViewById(R.id.kbc5);
        kt6 = findViewById(R.id.kt6);
        kbe6 = findViewById(R.id.kbe6);
        kbc6 = findViewById(R.id.kbc6);
        kt7 = findViewById(R.id.kt7);
        kbe7 = findViewById(R.id.kbe7);
        kbc7 = findViewById(R.id.kbc7);
        kt8 = findViewById(R.id.kt8);
        kbe8 = findViewById(R.id.kbe8);
        kbc8 = findViewById(R.id.kbc8);
        ot1 = findViewById(R.id.ot1);
        obe1 = findViewById(R.id.obe1);
        obc1 = findViewById(R.id.obc1);
        ot2 = findViewById(R.id.ot2);
        obe2 = findViewById(R.id.obe2);
        obc2 = findViewById(R.id.obc2);
        ot3 = findViewById(R.id.ot3);
        obe3 = findViewById(R.id.obe3);
        obc3 = findViewById(R.id.obc3);
        ot4 = findViewById(R.id.ot4);
        obe4 = findViewById(R.id.obe4);
        obc4 = findViewById(R.id.obc4);
        ot5 = findViewById(R.id.ot5);
        obe5 = findViewById(R.id.obe5);
        obc5 = findViewById(R.id.obc5);
        ot6 = findViewById(R.id.ot6);
        obe6 = findViewById(R.id.obe6);
        obc6 = findViewById(R.id.obc6);
        at1 = findViewById(R.id.at1);
        abe1 = findViewById(R.id.abe1);
        abc1 = findViewById(R.id.abc1);
        at2 = findViewById(R.id.at2);
        abe2 = findViewById(R.id.abe2);
        abc2 = findViewById(R.id.abc2);
        at3 = findViewById(R.id.at3);
        abe3 = findViewById(R.id.abe3);
        abc3 = findViewById(R.id.abc3);
        at4 = findViewById(R.id.at4);
        abe4 = findViewById(R.id.abe4);
        abc4 = findViewById(R.id.abc4);
        at5 = findViewById(R.id.at5);
        abe5 = findViewById(R.id.abe5);
        abc5 = findViewById(R.id.abc5);
        at6 = findViewById(R.id.at6);
        abe6 = findViewById(R.id.abe6);
        abc6 = findViewById(R.id.abc6);
        at7 = findViewById(R.id.at7);
        abe7 = findViewById(R.id.abe7);
        abc7 = findViewById(R.id.abc7);
        at8 = findViewById(R.id.at8);
        abe8 = findViewById(R.id.abe8);
        abc8 = findViewById(R.id.abc8);
        btnhesapla = findViewById(R.id.btnhesapla);
        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kalorihesaplama-3d363-default-rtdb.firebaseio.com/");


        kbe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kt1.getText().toString());
                if (a<9){
                    a = Integer.parseInt(kt1.getText().toString())+1;
                    kt1.setText(String.valueOf(a));
                }
            }
        });
        kbc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kt1.getText().toString());
                if (a>0){
                    a = Integer.parseInt(kt1.getText().toString())-1;
                    kt1.setText(String.valueOf(a));
                }
            }
        });

        kbe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kt2.getText().toString());
                if (a<9){
                    a = Integer.parseInt(kt2.getText().toString())+1;
                    kt2.setText(String.valueOf(a));
                }
            }
        });
        kbc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kt2.getText().toString());
                if (a>0){
                    a = Integer.parseInt(kt2.getText().toString())-1;
                    kt2.setText(String.valueOf(a));
                }
            }
        });

        kbe3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kt3.getText().toString());
                if (a<9){
                    a = Integer.parseInt(kt3.getText().toString())+1;
                    kt3.setText(String.valueOf(a));
                }
            }
        });
        kbc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kt3.getText().toString());
                if (a>0){
                    a = Integer.parseInt(kt3.getText().toString())-1;
                    kt3.setText(String.valueOf(a));
                }
            }
        });


        kbe4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kt4.getText().toString());
                if (a<9){
                    a = Integer.parseInt(kt4.getText().toString())+1;
                    kt4.setText(String.valueOf(a));
                }
            }
        });
        kbc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kt4.getText().toString());
                if (a>0){
                    a = Integer.parseInt(kt4.getText().toString())-1;
                    kt4.setText(String.valueOf(a));
                }
            }
        });

        kbe5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kt5.getText().toString());
                if (a<9){
                    a = Integer.parseInt(kt5.getText().toString())+1;
                    kt5.setText(String.valueOf(a));
                }
            }
        });
        kbc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kt5.getText().toString());
                if (a>0){
                    a = Integer.parseInt(kt5.getText().toString())-1;
                    kt5.setText(String.valueOf(a));
                }
            }
        });

        kbe6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kt6.getText().toString());
                if (a<9){
                    a = Integer.parseInt(kt6.getText().toString())+1;
                    kt6.setText(String.valueOf(a));
                }
            }
        });
        kbc6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kt6.getText().toString());
                if (a>0){
                    a = Integer.parseInt(kt6.getText().toString())-1;
                    kt6.setText(String.valueOf(a));
                }
            }
        });

        kbe7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kt7.getText().toString());
                if (a<9){
                    a = Integer.parseInt(kt7.getText().toString())+1;
                    kt7.setText(String.valueOf(a));
                }
            }
        });
        kbc7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kt7.getText().toString());
                if (a>0){
                    a = Integer.parseInt(kt7.getText().toString())-1;
                    kt7.setText(String.valueOf(a));
                }
            }
        });

        kbe8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kt8.getText().toString());
                if (a<9){
                    a = Integer.parseInt(kt8.getText().toString())+1;
                    kt8.setText(String.valueOf(a));
                }
            }
        });
        kbc8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kt8.getText().toString());
                if (a>0){
                    a = Integer.parseInt(kt8.getText().toString())-1;
                    kt8.setText(String.valueOf(a));
                }
            }
        });
        obe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(ot1.getText().toString());
                if (a<9){
                    a = Integer.parseInt(ot1.getText().toString())+1;
                    ot1.setText(String.valueOf(a));
                }
            }
        });
        obc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(ot1.getText().toString());
                if (a>0){
                    a = Integer.parseInt(ot1.getText().toString())-1;
                    ot1.setText(String.valueOf(a));
                }
            }
        });
        obe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(ot2.getText().toString());
                if (a<9){
                    a = Integer.parseInt(ot2.getText().toString())+1;
                    ot2.setText(String.valueOf(a));
                }
            }
        });
        obc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(ot2.getText().toString());
                if (a>0){
                    a = Integer.parseInt(ot2.getText().toString())-1;
                    ot2.setText(String.valueOf(a));
                }
            }
        });
        obe3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(ot3.getText().toString());
                if (a<9){
                    a = Integer.parseInt(ot3.getText().toString())+1;
                    ot3.setText(String.valueOf(a));
                }
            }
        });
        obc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(ot3.getText().toString());
                if (a>0){
                    a = Integer.parseInt(ot3.getText().toString())-1;
                    ot3.setText(String.valueOf(a));
                }
            }
        });
        obe4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(ot4.getText().toString());
                if (a<9){
                    a = Integer.parseInt(ot4.getText().toString())+1;
                    ot4.setText(String.valueOf(a));
                }
            }
        });
        obc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(ot4.getText().toString());
                if (a>0){
                    a = Integer.parseInt(ot4.getText().toString())-1;
                    ot4.setText(String.valueOf(a));
                }
            }
        });
        obe5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(ot5.getText().toString());
                if (a<9){
                    a = Integer.parseInt(ot5.getText().toString())+1;
                    ot5.setText(String.valueOf(a));
                }
            }
        });
        obc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(ot5.getText().toString());
                if (a>0){
                    a = Integer.parseInt(ot5.getText().toString())-1;
                    ot5.setText(String.valueOf(a));
                }
            }
        });
        obe6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(ot6.getText().toString());
                if (a<9){
                    a = Integer.parseInt(ot6.getText().toString())+1;
                    ot6.setText(String.valueOf(a));
                }
            }
        });
        obc6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(ot6.getText().toString());
                if (a>0){
                    a = Integer.parseInt(ot6.getText().toString())-1;
                    ot6.setText(String.valueOf(a));
                }
            }
        });
        abe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(at1.getText().toString());
                if (a<9){
                    a = Integer.parseInt(at1.getText().toString())+1;
                    at1.setText(String.valueOf(a));
                }
            }
        });
        abc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(at1.getText().toString());
                if (a>0){
                    a = Integer.parseInt(at1.getText().toString())-1;
                    at1.setText(String.valueOf(a));
                }
            }
        });
        abe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(at2.getText().toString());
                if (a<9){
                    a = Integer.parseInt(at2.getText().toString())+1;
                    at2.setText(String.valueOf(a));
                }
            }
        });
        abc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(at2.getText().toString());
                if (a>0){
                    a = Integer.parseInt(at2.getText().toString())-1;
                    at2.setText(String.valueOf(a));
                }
            }
        });
        abe3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(at3.getText().toString());
                if (a<9){
                    a = Integer.parseInt(at3.getText().toString())+1;
                    at3.setText(String.valueOf(a));
                }
            }
        });
        abc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(at3.getText().toString());
                if (a>0){
                    a = Integer.parseInt(at3.getText().toString())-1;
                    at3.setText(String.valueOf(a));
                }
            }
        });
        abe4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(at4.getText().toString());
                if (a<9){
                    a = Integer.parseInt(at4.getText().toString())+1;
                    at4.setText(String.valueOf(a));
                }
            }
        });
        abc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(at4.getText().toString());
                if (a>0){
                    a = Integer.parseInt(at4.getText().toString())-1;
                    at4.setText(String.valueOf(a));
                }
            }
        });
        abe5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(at5.getText().toString());
                if (a<9){
                    a = Integer.parseInt(at5.getText().toString())+1;
                    at5.setText(String.valueOf(a));
                }
            }
        });
        abc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(at5.getText().toString());
                if (a>0){
                    a = Integer.parseInt(at5.getText().toString())-1;
                    at5.setText(String.valueOf(a));
                }
            }
        });
        abe6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(at6.getText().toString());
                if (a<9){
                    a = Integer.parseInt(at6.getText().toString())+1;
                    at6.setText(String.valueOf(a));
                }
            }
        });
        abc6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(at6.getText().toString());
                if (a>0){
                    a = Integer.parseInt(at6.getText().toString())-1;
                    at6.setText(String.valueOf(a));
                }
            }
        });
        abe7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(at7.getText().toString());
                if (a<9){
                    a = Integer.parseInt(at7.getText().toString())+1;
                    at7.setText(String.valueOf(a));
                }
            }
        });
        abc7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(at7.getText().toString());
                if (a>0){
                    a = Integer.parseInt(at7.getText().toString())-1;
                    at7.setText(String.valueOf(a));
                }
            }
        });
        abe8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(at8.getText().toString());
                if (a<9){
                    a = Integer.parseInt(at8.getText().toString())+1;
                    at8.setText(String.valueOf(a));
                }
            }
        });
        abc8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(at8.getText().toString());
                if (a>0){
                    a = Integer.parseInt(at8.getText().toString())-1;
                    at8.setText(String.valueOf(a));
                }
            }
        });
        btnhesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Alınan Kalori").child("Ekmek").setValue(Integer.parseInt(kt1.getText().toString())*60);
                myRef.child("Alınan Kalori").child("Peynir").setValue(Integer.parseInt(kt2.getText().toString())*402);
                myRef.child("Alınan Kalori").child("Zeytin").setValue(Integer.parseInt(kt3.getText().toString())*5);
                myRef.child("Alınan Kalori").child("Domates").setValue(Integer.parseInt(kt4.getText().toString())*19);
                myRef.child("Alınan Kalori").child("Salatalık").setValue(Integer.parseInt(kt5.getText().toString())*20);
                myRef.child("Alınan Kalori").child("Yumurta").setValue(Integer.parseInt(kt6.getText().toString())*155);
                myRef.child("Alınan Kalori").child("Bal").setValue(Integer.parseInt(kt7.getText().toString())*21);
                myRef.child("Alınan Kalori").child("Reçel").setValue(Integer.parseInt(kt8.getText().toString())*17);
                myRef.child("Alınan Kalori").child("Corba").setValue(Integer.parseInt(ot1.getText().toString())*86);
                myRef.child("Alınan Kalori").child("Makarna").setValue(Integer.parseInt(ot2.getText().toString())*314);
                myRef.child("Alınan Kalori").child("Köfte").setValue(Integer.parseInt(ot3.getText().toString())*67);
                myRef.child("Alınan Kalori").child("Patates").setValue(Integer.parseInt(ot4.getText().toString())*164);
                myRef.child("Alınan Kalori").child("Salata").setValue(Integer.parseInt(ot5.getText().toString())*57);
                myRef.child("Alınan Kalori").child("Börek").setValue(Integer.parseInt(ot6.getText().toString())*285);
                myRef.child("Alınan Kalori").child("Çorba").setValue(Integer.parseInt(at1.getText().toString())*86);
                myRef.child("Alınan Kalori").child("Tavuk").setValue(Integer.parseInt(at2.getText().toString())*210);
                myRef.child("Alınan Kalori").child("Et").setValue(Integer.parseInt(at3.getText().toString())*157);
                myRef.child("Alınan Kalori").child("Pilav").setValue(Integer.parseInt(at4.getText().toString())*388);
                myRef.child("Alınan Kalori").child("Ispanak").setValue(Integer.parseInt(at5.getText().toString())*133);
                myRef.child("Alınan Kalori").child("Dolma").setValue(Integer.parseInt(at6.getText().toString())*132);
                myRef.child("Alınan Kalori").child("Kazandibi").setValue(Integer.parseInt(at7.getText().toString())*57);
                myRef.child("Alınan Kalori").child("Sütlaç").setValue(Integer.parseInt(at8.getText().toString())*285);
                myRef.child("Alınan Kalori").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot childSnapshot : snapshot.getChildren()){
                            String childKey = childSnapshot.getKey();
                            Object childData = childSnapshot.getValue();
                            sum += Integer.parseInt(String.valueOf(childData));
                        }
                        myRef.child("Person").child(username).child("Toplam Kalori").setValue(sum);
                        Intent intent = new Intent(MainActivity3.this,MainActivity4.class);
                        intent.putExtra("username",username);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}