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

import com.mypokebase.Classes.ItemsDataClass;
import com.mypokebase.R;

import java.util.ArrayList;

public class item_list extends AppCompatActivity {
    ArrayList <ItemsDataClass> items;
    ListView listView;
    ItemListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        items = (ArrayList<ItemsDataClass>) bundle.getSerializable("Items");
        setContentView(R.layout.activity_item_list);
        listView = findViewById(R.id.ItemsListmanager);
        adapter = new ItemListAdapter();
        listView.setAdapter(adapter);
    }

    class ItemListAdapter extends BaseAdapter implements View.OnClickListener{
        LayoutInflater layoutInflater;

        public ItemListAdapter(){
            layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public void onClick(View v) {

        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null)
                convertView = layoutInflater.inflate(R.layout.zitems, null);
            TextView itemName = convertView.findViewById(R.id.ItemNameList);
            itemName.setText(items.get(position).getEname());
            convertView.setTag(new Integer(position));
            convertView.setClickable(true);
            convertView.setOnClickListener(this);
            return convertView;
        }
    }
}
