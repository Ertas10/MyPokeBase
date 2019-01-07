package com.mypokebase.detalhes;

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

public class TypesActivity extends AppCompatActivity {

    ListView strong, weak, neutral, ineffective;
    TypesListAdapter strongAdapter, weakAdapter, neutralAdapter, ineffectiveAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_detail);
        Bundle b = getIntent().getExtras();
        int position = (int)b.get("position");
        TypesDataClass type = TypesDataClass.types.get(position);
        TextView typeName = findViewById(R.id.typeNameDetail);
        typeName.setText(type.getEname());
        strong = findViewById(R.id.strongAgainstList);
        weak = findViewById(R.id.weakAgainstList);
        neutral = findViewById(R.id.neutralList);
        ineffective = findViewById(R.id.ineffectiveList);

        strongAdapter = new TypesListAdapter(type.getStrongAgainst(), (TextView) findViewById(R.id.textView16));
        weakAdapter = new TypesListAdapter(type.getWeakAgainst(), (TextView) findViewById(R.id.textView18));
        neutralAdapter = new TypesListAdapter(type.getNeutral(), (TextView) findViewById(R.id.textView19));
        ineffectiveAdapter = new TypesListAdapter(type.getIneffective(), (TextView) findViewById(R.id.textView20));

        strong.setAdapter(strongAdapter);
        weak.setAdapter(weakAdapter);
        neutral.setAdapter(neutralAdapter);
        ineffective.setAdapter(ineffectiveAdapter);

        SetListViewSize(strong);
        SetListViewSize(weak);
        SetListViewSize(neutral);
        SetListViewSize(ineffective);
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

    public class TypesListAdapter extends BaseAdapter implements View.OnClickListener{
        LayoutInflater layoutInflater;
        ArrayList<String> types;

        public TypesListAdapter(ArrayList<String> typesList, TextView text){
            layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            types = typesList;
            if(types == null) {
                types = new ArrayList<>();
                text.setVisibility(View.INVISIBLE);
            }
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
            TextView typeName = convertView.findViewById(R.id.TiposNameList);
            typeName.setText(types.get(position));
            convertView.setTag(new Integer(position));
            convertView.setClickable(true);
            convertView.setOnClickListener(this);
            return convertView;
        }
    }
}
