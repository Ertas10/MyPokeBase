package com.mypokebase.detalhes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mypokebase.Classes.SkillsDataClass;
import com.mypokebase.Classes.TypesDataClass;
import com.mypokebase.R;

public class MovesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moves_details);
        Bundle b = getIntent().getExtras();
        int position = (int)b.get("Position");
        SkillsDataClass move = SkillsDataClass.moves.get(position);
        TextView moveName = findViewById(R.id.MoveNameDetail);
        TextView moveCategory = findViewById(R.id.MoveCategoryDetail);
        TextView moveType = findViewById(R.id.MoveTypeDetail);
        TextView movePower = findViewById(R.id.MovePowerDetail);
        TextView movePP = findViewById(R.id.MovePPDetail);
        TextView moveAccuracy = findViewById(R.id.MoveAccuracyDetail);
        moveName.setText(move.getEname());
        moveCategory.setText(TypesDataClass.translateCategory(move.getCategory()));
        moveType.setText(TypesDataClass.translateType(move.getType()));
        movePower.setText("" + move.getPower());
        movePP.setText("" + move.getPp());
        moveAccuracy.setText("" + move.getAccuracy());
    }
}
