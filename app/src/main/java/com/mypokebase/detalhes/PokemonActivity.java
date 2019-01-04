package com.mypokebase.detalhes;

import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mypokebase.Classes.PokemonDataClass;
import com.mypokebase.Classes.SkillsDataClass;
import com.mypokebase.Classes.TypesDataClass;
import com.mypokebase.MainActivity;
import com.mypokebase.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PokemonActivity extends AppCompatActivity {
    enum ListType{LevelUp, TM, Tutor, PreEv, Egg, Transfer}
    ListView levelUpList, tmList, tutorList, preEvList, eggList, transferList;
    MovesListAdapter levelUpAdapter, tmAdapter, tutorAdapter, preEvAdapter, eggAdapter, transferAdapter;
    ArrayList<Integer> levelUpMoves, tmMoves, tutorMoves, preEvMoves, eggMoves, transferMoves;
    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);
        Bundle b = getIntent().getExtras();
        int position = (int)b.get("Position");
        PokemonDataClass pokemon = PokemonDataClass.pokemons.get(position);
        scrollView = findViewById(R.id.scrollViewPoke);
        levelUpMoves = pokemon.getLevelUpMovesID();
        tmMoves = pokemon.getTmMovesID();
        tutorMoves = pokemon.getTutorMovesID();
        preEvMoves = pokemon.getPreEvolutionMovesID();
        eggMoves = pokemon.getEggMovesID();
        transferMoves = pokemon.getTransferMovesID();
        TextView pokemonName = findViewById(R.id.PokemonNameDetail);
        TextView pokemonNumber = findViewById(R.id.PokemonNumberDetail);
        TextView attackView = findViewById(R.id.attackStatView);
        TextView defenseView = findViewById(R.id.defenseStatView);
        TextView hpView = findViewById(R.id.hpStatView);
        TextView spattackView = findViewById(R.id.spattackStatView);
        TextView spdefenseView = findViewById(R.id.spdefenseStatView);
        TextView speedView = findViewById(R.id.speedStatView);
        TextView types = findViewById(R.id.PokemonTypesDetail);
        ImageView image = findViewById(R.id.pokemonImageViewDetail);
        pokemonName.setText(PokemonDataClass.pokemons.get(position).getEnglishName());
        pokemonNumber.setText(PokemonDataClass.pokemons.get(position).getId());
        attackView.setText(""+pokemon.getAttack());
        defenseView.setText(""+pokemon.getDefense());
        hpView.setText(""+pokemon.getHp());
        spattackView.setText(""+pokemon.getSpAttack());
        spdefenseView.setText(""+pokemon.getSpDefense());
        speedView.setText(""+pokemon.getSpeed());
        image.setImageBitmap(pokemon.getImg());
        ArrayList<String> typesArray = pokemon.getTypesJapanese();
        if(typesArray.size() == 1){
            types.setText(TypesDataClass.translateType(typesArray.get(0)));
        }
        if(typesArray.size() == 2){
            types.setText(TypesDataClass.translateType(typesArray.get(0)) + "/" + TypesDataClass.translateType(typesArray.get(1)));
        }
        levelUpList = findViewById(R.id.levelUpMovesList);
        tmList = findViewById(R.id.tmMoveList);
        tutorList = findViewById(R.id.tutorMovesList);
        preEvList = findViewById(R.id.PreEvolutionMovesList);
        eggList = findViewById(R.id.EggMovesList);
        transferList = findViewById(R.id.TransferMovesList);

        levelUpAdapter = new MovesListAdapter(ListType.LevelUp, levelUpMoves);
        tmAdapter = new MovesListAdapter(ListType.TM, tmMoves);
        tutorAdapter = new MovesListAdapter(ListType.Tutor, tutorMoves);
        preEvAdapter = new MovesListAdapter(ListType.PreEv, preEvMoves);
        eggAdapter = new MovesListAdapter(ListType.Egg, eggMoves);
        transferAdapter = new MovesListAdapter(ListType.Transfer, transferMoves);

        levelUpList.setAdapter(levelUpAdapter);
        tmList.setAdapter(tmAdapter);
        tutorList.setAdapter(tutorAdapter);
        preEvList.setAdapter(preEvAdapter);
        eggList.setAdapter(eggAdapter);
        transferList.setAdapter(transferAdapter);

        SetListViewSize(levelUpList);
        SetListViewSize(tmList);
        SetListViewSize(tutorList);
        SetListViewSize(preEvList);
        SetListViewSize(eggList);
        SetListViewSize(transferList);
    }

    void SetListViewSize(ListView view){
        ViewGroup.LayoutParams params = view.getLayoutParams();
        int count = view.getAdapter().getCount();
        if(count >= 4)
            params.height = 528;
        if(count == 3)
            params.height = (528 / 4) * 3;
        if(count == 2)
            params.height = 528 / 2;
        if(count == 1)
            params.height = 528 / 4;
        if(count == 0)
            params.height = 0;
        view.setLayoutParams(params);
    }

    class MovesListAdapter extends BaseAdapter implements View.OnClickListener{
        LayoutInflater layoutInflater;
        ListType listType;
        ArrayList<Integer> movesID;
        public MovesListAdapter(ListType type, ArrayList<Integer> moves){
            layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.listType = type;
            this.movesID = moves;
            if(movesID == null)
                movesID = new ArrayList<Integer>();
        }

        @Override
        public void onClick(View v) {
            int position = (int)v.getTag();
            Intent intent = new Intent(PokemonActivity.this, MovesActivity.class);
            intent.putExtra("Position", SkillsDataClass.moves.indexOf(SkillsDataClass.FindMoveByID(movesID.get(position))));
            startActivity(intent);
        }

        @Override
        public int getCount() {
            return movesID.size();
        }

        @Override
        public Object getItem(int position) {
            return movesID.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null)
                convertView = layoutInflater.inflate(R.layout.zmovespokemonlist, null);
            TextView name = convertView.findViewById(R.id.MoveNamePokemonList);
            name.setText(SkillsDataClass.FindMoveByID(movesID.get(position)).getEname());
            convertView.setTag(new Integer(position));
            convertView.setClickable(true);
            convertView.setOnClickListener(this);
            return convertView;
        }
    }
}
