package com.bluehat.cbp_psu_behrend.floorPlan.interactions;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MapTouchMove {
    private float touchX, touchY;

    public MapTouchMove(ImageView imageView) {
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        touchX = view.getX() - event.getRawX();
                        touchY = view.getY() - event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        view.animate().x(event.getRawX() + touchX).y(event.getRawY() + touchY).setDuration(0).start();
                        break;
                    default:
                        return false;
                }
                return true;
            }

        });
    }
}
