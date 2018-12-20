package com.mypokebase;

import android.os.storage.StorageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.mypokebase.Classes.ItemsDataClass;
import com.mypokebase.Classes.PokemonDataClass;
import com.mypokebase.Classes.SkillsDataClass;
import com.mypokebase.Classes.TypesDataClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference dataRef;
    static ArrayList<PokemonDataClass> pokemons;
    static ArrayList<ItemsDataClass> items;
    static ArrayList<TypesDataClass> types;
    static ArrayList<SkillsDataClass> moves;
    String value;
    JSONObject data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetDatabase();
    }

    private void GetDatabase(){
        database = FirebaseDatabase.getInstance();
        dataRef = database.getReference();
        dataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map<String, String> data2 = (Map<String, String>) dataSnapshot.getValue();
                data = new JSONObject(data2);
                pokemons = PokemonDataClass.JSONToPokemonList(data);
                items = ItemsDataClass.JSONToItemList(data);
                types = TypesDataClass.JSONToTypeList(data);
                moves = SkillsDataClass.JSONToSkillList(data);
                return;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
