package com.bluehat.cbp_psu_behrend.floorPlan;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bluehat.cbp_psu_behrend.R;
import com.bluehat.cbp_psu_behrend.pathFinder.PathFinder;

public class BuildingSelection extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private String building = "-";

    private Spinner floorSelection;
    private Context context_carrier;
    private TextView floorSelectionBar;
    private ImageView floorPlanIMG_carrier;
    private TextView instructionText;
    private PathFinder pathFinderObject;

    public BuildingSelection(Spinner buildingSelection, Spinner floorSelection, TextView floorSelectionBar, TextView instructionText, ImageView floorPlanImage, Context context, PathFinder pathFinder) {
        ArrayAdapter<CharSequence> buildingListGetter = ArrayAdapter.createFromResource(context, R.array.buildingList, android.R.layout.simple_spinner_item);
        buildingListGetter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        buildingSelection.setAdapter(buildingListGetter);
        buildingSelection.setOnItemSelectedListener(this);

        this.floorSelection = floorSelection;
        this.floorSelectionBar = floorSelectionBar;
        this.floorPlanIMG_carrier = floorPlanImage;
        this.instructionText = instructionText;
        this.pathFinderObject = pathFinder;
        context_carrier = context;
    }

    private void instruction_Visible() {
        if (building.equals("-")) {
            this.instructionText.setVisibility(View.VISIBLE);
        }
        else {
            this.instructionText.setVisibility(View.INVISIBLE);
        }
    }

    //Functions for dropdown menus
    @Override
    public void onItemSelected(AdapterView<?> list, View view, int index, long l) {

        AdapterView<?> buildingList = list;

        // Set current building name
        building = buildingList.getItemAtPosition(index).toString();
        pathFinderObject.setBuilding(building);

        // Set text color white
        ((TextView) buildingList.getChildAt(0)).setTextColor(Color.WHITE);

        // Unlock floor selection after a building is selected
        instruction_Visible();
        FloorSelection floorMenu = new FloorSelection(this.floorSelection, floorSelectionBar, floorPlanIMG_carrier, context_carrier, building);
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
