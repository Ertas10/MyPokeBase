package com.mypokebase.listas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mypokebase.Classes.SkillsDataClass;
import com.mypokebase.Classes.TypesDataClass;
import com.mypokebase.R;
import com.mypokebase.detalhes.MovesActivity;

import java.util.ArrayList;

public class Moves_list extends AppCompatActivity {
    ArrayList<SkillsDataClass> moves;
    ListView listView;
    MovesListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moves = SkillsDataClass.moves;
        setContentView(R.layout.activity_moves_list);
        listView = findViewById(R.id.MovesListmanager);
        adapter = new MovesListAdapter();
        listView.setAdapter(adapter);
    }

    class MovesListAdapter extends BaseAdapter implements View.OnClickListener{
        LayoutInflater layoutInflater;

        public  MovesListAdapter(){
            layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount(){return moves.size();}

        @Override
        public Object getItem(int position) {return moves.get(position);}

        @Override
        public long getItemId(int position) {return 0;}

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if(convertView == null)
                convertView = layoutInflater.inflate(R.layout.zmoves, null);
            TextView moveName = convertView.findViewById(R.id.ItemNameList);
            TextView moveType = convertView.findViewById(R.id.ItemtypeList);
            moveName.setText(moves.get(position).getEname());
            moveType.setText(TypesDataClass.translateType(moves.get(position).getType()));
            convertView.setTag(new Integer(position));
            convertView.setClickable(true);
            convertView.setOnClickListener(this);
            return convertView;
        }

        @Override
        public void onClick(View v) {
            int position = (int)v.getTag();
            Intent intent = new Intent(Moves_list.this, MovesActivity.class);
            intent.putExtra("Position", position);
            startActivity(intent);
        }
    }
}
