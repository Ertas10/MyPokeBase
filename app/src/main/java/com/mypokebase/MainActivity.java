package com.mypokebase;

import android.content.Context;
import android.content.Intent;
import android.os.storage.StorageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.mypokebase.Classes.ItemsDataClass;
import com.mypokebase.Classes.PokemonDataClass;
import com.mypokebase.Classes.SkillsDataClass;
import com.mypokebase.Classes.TypesDataClass;
import com.mypokebase.detalhes.ItemActivity;
import com.mypokebase.detalhes.MovesActivity;
import com.mypokebase.detalhes.PokemonActivity;
import com.mypokebase.detalhes.TypesActivity;
import com.mypokebase.listas.Moves_list;
import com.mypokebase.listas.Pokemon_list;
import com.mypokebase.listas.Tipo_list;
import com.mypokebase.listas.item_list;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference dataRef;
    FirebaseStorage storage;
    StorageReference storageRef;
    ArrayList<PokemonDataClass> pokemons;
    ArrayList<ItemsDataClass> items;
    ArrayList<TypesDataClass> types;
    ArrayList<SkillsDataClass> moves;
    String value;
    JSONObject data;
    Button pokemonButton;
    Button movesButton;
    Button itemsButton;
    Button typesButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReferenceFromUrl("gs://mypokebase-95b63.appspot.com");

        database = FirebaseDatabase.getInstance();
        dataRef = database.getReference();
        dataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> data2 = (Map<String, String>) dataSnapshot.getValue();
                data = new JSONObject(data2);
                pokemons = PokemonDataClass.JSONToPokemonList(data);
                items = ItemsDataClass.JSONToItemList(data);
                types = TypesDataClass.JSONToTypeList(data);
                moves = SkillsDataClass.JSONToSkillList(data);
                TypesDataClass.types = types;
                PokemonDataClass.pokemons = pokemons;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        pokemonButton = findViewById(R.id.button_pokemon);
        movesButton = findViewById(R.id.button_moves);
        itemsButton = findViewById(R.id.button_items);
        typesButton = findViewById(R.id.button_types);
        pokemonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pokemons != null) {
                    Intent intent = new Intent(MainActivity.this, Pokemon_list.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Getting pokemons, make sure you have an internet connection", new Integer(3)).show();
                }
            }
        });
        movesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moves != null) {
                    Intent intent = new Intent(MainActivity.this, Moves_list.class);
                    Bundle b = new Bundle();
                    b.putSerializable("Moves", moves);
                    intent.putExtras(b);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Getting moves, make sure you have an internet connection", new Integer(3)).show();
                }
            }
        });
        itemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(items != null) {
                    Intent intent = new Intent(MainActivity.this, item_list.class);
                    Bundle b = new Bundle();
                    b.putSerializable("Items", items);
                    intent.putExtras(b);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Getting items, make sure you have an internet connection", new Integer(3)).show();
                }
            }
        });
        typesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(types != null) {
                    Intent intent = new Intent(MainActivity.this, Tipo_list.class);
                    Bundle b = new Bundle();
                    b.putSerializable("Types", types);
                    intent.putExtras(b);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Getting types, make sure you have an internet connection", new Integer(3)).show();
                }
            }
        });
    }
}
