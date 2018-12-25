package com.mypokebase.listas;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mypokebase.Classes.PokemonDataClass;
import com.mypokebase.MainActivity;
import com.mypokebase.R;
import com.mypokebase.detalhes.PokemonActivity;

import java.io.Console;
import java.util.ArrayList;

public class Pokemon_list extends AppCompatActivity {
    ArrayList<PokemonDataClass> pokemons;
    ListView listView;
    PokemonListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pokemons = PokemonDataClass.pokemons;
        setContentView(R.layout.activity_pokemon_list);
        listView = findViewById(R.id.PokemonListmanager);
        adapter = new PokemonListAdapter();
        listView.setAdapter(adapter);
    }

    class PokemonListAdapter extends BaseAdapter implements View.OnClickListener{
        LayoutInflater layoutInflater;

        public PokemonListAdapter(){
            layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return pokemons.size();
        }

        @Override
        public Object getItem(int position) {
            return pokemons.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null)
                convertView = layoutInflater.inflate(R.layout.zpokemon, null);
            TextView pokemonName = convertView.findViewById(R.id.PokemonNameList);
            TextView pokemonNumber = convertView.findViewById(R.id.PokemonNumberList);
            ImageView thm = convertView.findViewById(R.id.PokemonImageList);
            pokemonName.setText(pokemons.get(position).getEnglishName());
            pokemonNumber.setText(pokemons.get(position).getId());
            thm.setImageBitmap(pokemons.get(position).getThm());
            convertView.setTag(new Integer(position));
            convertView.setClickable(true);
            convertView.setOnClickListener(this);
            return convertView;
        }

        @Override
        public void onClick(View v) {

        }
    }
}
