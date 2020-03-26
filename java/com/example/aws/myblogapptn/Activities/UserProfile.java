package com.example.aws.myblogapptn.Activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aws.myblogapptn.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class UserProfile extends AppCompatActivity {

    private TextView userEmail,userPassword,userPAssword,userName,userPhone,userBlood,useradd,useroccupation;
    private ImageView userImageView, emailImageView, phoneImageView, videoImageView,occuimageview,Bloodimage;
    private ImageView facebookImageView, twitterImageView;
    private final String TAG = this.getClass().getName().toUpperCase();
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private Map<String, String> userMap;
    private String email;
    private String userid;
    private static final String USERS = "users";
    private Button SaveBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        //receive data from login screen
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = rootRef.child(USERS);
        Log.v("USERID", userRef.getKey());

        useroccupation = findViewById(R.id.occupation);
        userName = findViewById(R.id.UserProfile);
        userEmail = findViewById(R.id.regemail);
        userPhone = findViewById(R.id.regPhone);
        useradd = findViewById(R.id.placetxt);
        userBlood = findViewById(R.id.regBlood);
        userPAssword = findViewById(R.id.regPassword);
        SaveBtn = findViewById(R.id.SaveBTN);

        userImageView = findViewById(R.id.user_imageview);
        emailImageView = findViewById(R.id.email_imageview);
        phoneImageView = findViewById(R.id.phone_imageview);
        videoImageView = findViewById(R.id.video_imageview);
        Bloodimage = findViewById(R.id.BloodGrope);
        occuimageview = findViewById(R.id.occupationimageview);
        facebookImageView = findViewById(R.id.facebook_imageview);
        twitterImageView = findViewById(R.id.twitter_imageview);

        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        // Read from the database
        userRef.addValueEventListener(new ValueEventListener() {
            String fname, email, phone, profession, Blood,address;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot keyId: dataSnapshot.getChildren()) {
                    if (keyId.child("email").getValue().equals(email)) {
                        fname = keyId.child("UserName").getValue(String.class);
                        profession = keyId.child("profession").getValue(String.class);
                        address = keyId.child("address").getValue(String.class);
                        phone = keyId.child("phone").getValue(String.class);
                        Blood = keyId.child("Blood").getValue(String.class);
                        break;
                    }
                }

                userName.setText(fname);
                userEmail.setText(email);
                userPhone.setText(phone);
                useroccupation.setText(profession);
                userBlood.setText(Blood);
                useradd.setText(address);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });finish();


    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}
