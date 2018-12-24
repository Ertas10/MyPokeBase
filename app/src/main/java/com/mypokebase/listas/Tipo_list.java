package com.mypokebase.listas;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mypokebase.Classes.TypesDataClass;
import com.mypokebase.R;

import java.util.ArrayList;

public class Tipo_list extends AppCompatActivity {
    ArrayList<TypesDataClass> types;
    ListView listView;
    TypesListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        types = (ArrayList<TypesDataClass>) bundle.getSerializable("Types");
        setContentView(R.layout.activity_tipo_list);
        listView = findViewById(R.id.TiposListmanager);
        adapter = new TypesListAdapter();
        listView.setAdapter(adapter);
    }

    class TypesListAdapter extends BaseAdapter implements View.OnClickListener{
        LayoutInflater layoutInflater;
        public TypesListAdapter(){
            layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public void onClick(View v) {

        }

        @Override
        public int getCount() {
            return types.size();
        }

        @Override
        public Object getItem(int position) {
            return types.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null)
                convertView = layoutInflater.inflate(R.layout.ztipos, null);
            TextView typesName = convertView.findViewById(R.id.TiposNameList);
            typesName.setText(types.get(position).getEname());
            convertView.setTag(new Integer(position));
            convertView.setClickable(true);
            convertView.setOnClickListener(this);
            return convertView;
        }
    }
}
