package com.bluehat.cbp_psu_behrend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bluehat.cbp_psu_behrend.floorPlan.interactions.Gyroscope;
import com.bluehat.cbp_psu_behrend.floorPlan.BuildingSelection;
import com.bluehat.cbp_psu_behrend.floorPlan.interactions.MapRotation;
import com.bluehat.cbp_psu_behrend.floorPlan.interactions.MapTouchMove;
import com.bluehat.cbp_psu_behrend.pathFinder.PathFinder;

public class CBPApp extends AppCompatActivity {

    //For gyroscope override functions
    Gyroscope gyroscope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_main);

        //Enable touch interaction on floor plan
        enabletouchInteraction();

        //Enable gyrosocpe sensor
        enableMapRotation();

        //Enable "about app" button
        enableAboutButton();

        //Enable building selection & the rest of the program
        enablebuildingMenu();

        //Enable app exit button
        exitApp();
    }

    private void enableAboutButton() {
        ImageButton aboutButton = (ImageButton)findViewById(R.id.aboutApp);

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchScreen = new Intent(CBPApp.this, aboutAppScreen.class);
                startActivity(switchScreen);
            }
        });
    }

    private void enabletouchInteraction() {
        ImageView floorPlanImage = (ImageView)findViewById(R.id.floorPlanIMG);
        MapTouchMove touchSensor = new MapTouchMove(floorPlanImage);
    }

    private void enableMapRotation() {
        MapRotation rotater = new MapRotation();
        ImageView floorPlanImage = (ImageView)findViewById(R.id.floorPlanIMG);
        gyroscope = new Gyroscope(this);

        rotater.floorPlanRotate(floorPlanImage, gyroscope);
    }

    private void enablebuildingMenu() {
        ImageButton submit = (ImageButton) findViewById(R.id.roomConfirm);

        EditText startingRoom = (EditText) findViewById(R.id.startRoom);
        startingRoom.setInputType(InputType.TYPE_CLASS_NUMBER);
        EditText endingRoom = (EditText) findViewById(R.id.endRoom);
        endingRoom.setInputType(InputType.TYPE_CLASS_NUMBER);

        Button text = (Button) findViewById(R.id.path);

        PathFinder pathFinder = new PathFinder(startingRoom, endingRoom, submit, text);

        Spinner buildingList = findViewById(R.id.buildingSelection);
        Spinner floorSelection = findViewById(R.id.floorSelection);

        TextView floorSelectionBar = (TextView)findViewById(R.id.floorSelectionBorder);
        ImageView floorPlanImage = (ImageView)findViewById(R.id.floorPlanIMG);

        TextView instructionText = (TextView)findViewById(R.id.instructionText);

        BuildingSelection buildingMenu = new BuildingSelection(buildingList, floorSelection, floorSelectionBar, instructionText, floorPlanImage,this, pathFinder);
    }

    //Functions for Gyroscope
    @Override
    protected void onPostResume() {
        super.onPostResume();
        gyroscope.register();
    }
    @Override
    protected void onPause() {
        super.onPause();
        gyroscope.unregister();
    }

    //Functions for Exit button
    private void exitApp() {
        Button exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}
