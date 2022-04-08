package com.bluehat.cbp_psu_behrend.floorPlan;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bluehat.cbp_psu_behrend.R;

public class FloorSelection extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private String building = "-";
    private int floor = 0;
    TextView floorSelectionBar;
    ImageView floorPlanImage;
    Context context_carrier;

    public FloorSelection(Spinner floorSelection, TextView floorSelectionBar, ImageView floorPlamIMG, Context context, String building) {
        ArrayAdapter<CharSequence> floorListGetter;

        this.floorSelectionBar = floorSelectionBar;
        this.building = building;
        this.context_carrier = context;
        this.floorPlanImage = floorPlamIMG;

        switch (building) {
            case "Burke Center":
                floorListGetter = ArrayAdapter.createFromResource(context, R.array.floorList_burke, android.R.layout.simple_spinner_item);
                floorSelectionBar.setVisibility(View.VISIBLE);

                break;

            case "Nick Building":
                floorListGetter = ArrayAdapter.createFromResource(context, R.array.floorList_nick, android.R.layout.simple_spinner_item);
                floorSelectionBar.setVisibility(View.VISIBLE);

                break;

            case "Reed Union":
                floorListGetter = ArrayAdapter.createFromResource(context, R.array.floorList_reed, android.R.layout.simple_spinner_item);
                floorSelectionBar.setVisibility(View.VISIBLE);

                break;

            case "Witkowski Building":
                floorListGetter = ArrayAdapter.createFromResource(context, R.array.floorList_witkowski, android.R.layout.simple_spinner_item);
                floorSelectionBar.setVisibility(View.VISIBLE);

                break;

            case "Junker Center":
                floorListGetter = ArrayAdapter.createFromResource(context, R.array.floorList_junker, android.R.layout.simple_spinner_item);
                floorSelectionBar.setVisibility(View.VISIBLE);

                break;

            case "Lilley Library":
                floorListGetter = ArrayAdapter.createFromResource(context, R.array.floorList_lilley, android.R.layout.simple_spinner_item);
                floorSelectionBar.setVisibility(View.VISIBLE);

                break;

            default:
                floorListGetter = ArrayAdapter.createFromResource(context, R.array.floorList_null, android.R.layout.simple_spinner_item);
                floorSelectionBar.setVisibility(View.INVISIBLE);

                break;
        }

        floorListGetter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        floorSelection.setAdapter(floorListGetter);
        floorSelection.setOnItemSelectedListener(this);
    }

    public void floorSelect(Spinner floorSelection, TextView floorSelectionBar, ImageView floorPlamIMG, Context context, String building) {

    }

    private void setFloorPlanIMG() {
        int imageSourceID = 0;

        switch (building) {
            case "-":
                imageSourceID = context_carrier.getResources().getIdentifier("blank", "drawable", context_carrier.getPackageName());
                break;

            case "Burke Center":
                imageSourceID = context_carrier.getResources().getIdentifier(("burke_"+Integer.toString(floor)), "drawable", context_carrier.getPackageName());
                break;

            case "Reed Union":
                imageSourceID = context_carrier.getResources().getIdentifier(("reed_"+Integer.toString(floor)), "drawable", context_carrier.getPackageName());
                Toast.makeText(context_carrier,"Pathfinding is currently not avaliable for this floor", Toast.LENGTH_LONG).show();
                break;

            default:
                imageSourceID = context_carrier.getResources().getIdentifier("placeholder", "drawable", context_carrier.getPackageName());
                Toast.makeText(context_carrier,"Pathfinding is currently not avaliable for this floor", Toast.LENGTH_LONG).show();
        }

        floorPlanImage.setImageResource(imageSourceID);
    }

    //Functions for dropdown menus
    @Override
    public void onItemSelected(AdapterView<?> list, View view, int index, long l) {
        AdapterView<?> floorList = list;

        // Set current floor if a building is selected
        switch (building) {
            case "-": //Building not selected
                break;
            default: //Building selected
                floor = Integer.parseInt(floorList.getItemAtPosition(index).toString());
        }

        // Set text color white
        ((TextView) floorList.getChildAt(0)).setTextColor(Color.WHITE);

        // Set floor plan image
        setFloorPlanIMG();
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
