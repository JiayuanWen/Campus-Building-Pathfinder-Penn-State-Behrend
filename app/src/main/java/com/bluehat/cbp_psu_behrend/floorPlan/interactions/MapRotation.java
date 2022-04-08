package com.bluehat.cbp_psu_behrend.floorPlan.interactions;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bluehat.cbp_psu_behrend.floorPlan.interactions.Gyroscope;

public class MapRotation extends AppCompatActivity {
    private Gyroscope gyroscope;
    private double currentZRotation = 0;

    public MapRotation() {

    }

    public void floorPlanRotate(ImageView floorPlanIMG, Gyroscope gyroscope) {
        gyroscope.setListener(new Gyroscope.Listener() {

            @Override
            public void onRotation(double rotationX, double rotationY, double rotationZ) {
                currentZRotation = currentZRotation + rotationZ*9;
                floorPlanIMG.setRotation((float)(currentZRotation));
            }
        });
    }
}