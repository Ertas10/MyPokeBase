package com.mypokebase;

import android.os.storage.StorageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetDatabase();
    }

    private void GetDatabase(){

    }
}
