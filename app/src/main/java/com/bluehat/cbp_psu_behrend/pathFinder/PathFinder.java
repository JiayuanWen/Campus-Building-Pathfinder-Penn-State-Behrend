package com.bluehat.cbp_psu_behrend.pathFinder;

import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bluehat.cbp_psu_behrend.pathFinder.gridMaps.burkeGraph;

// The situation with malfunctioning path finding is way worse than we imagined.
// Had to reprogram the entire package from scratch. Instead of showing guide lines
// , the floorplans are labeled and the algorithm tells you which label to go.
// Due to time constrain, we could not implement the algorithm properly on time,
// hopefully it can still give some insight into what we're trying to achieve.

public class PathFinder {
    Integer start;
    Integer end;

    String startRoom;
    String destRoom;

    String building;

    public PathFinder(EditText startingRoom, EditText endingRoom, ImageButton submit, Button text) {
        startingRoom.setInputType(InputType.TYPE_CLASS_NUMBER);
        endingRoom.setInputType(InputType.TYPE_CLASS_NUMBER);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (startingRoom != null) {
                    startRoom = startingRoom.getText().toString();
                }
                if (endingRoom != null) {
                    destRoom = endingRoom.getText().toString();
                }

                if (startRoom != null && destRoom != null) {
                    roomSection(startRoom, destRoom);

                    switch (building) {
                        case "Burke Center":
                            burkeGraph a = new burkeGraph(start, end, text);
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    private void roomSection(String startRoom, String destRoom) {
        if (Integer.parseInt(startRoom) >= 1 && Integer.parseInt(startRoom) <= 2) {
            start = 1;
        }
        if (Integer.parseInt(startRoom) >= 7 && Integer.parseInt(startRoom) <= 15) {
            start = 13;
        }
        if (Integer.parseInt(startRoom) == 17) {
            start = 14;
        }
        if (Integer.parseInt(startRoom) >= 101 && Integer.parseInt(startRoom) <= 107) {
            start = 5;
        }
        if (Integer.parseInt(startRoom) >= 108 && Integer.parseInt(startRoom) <= 113) {
            start = 4;
        }
        if (Integer.parseInt(startRoom) >= 117 && Integer.parseInt(startRoom) <= 125) {
            start = 6;
        }
        if (Integer.parseInt(startRoom) >= 127 && Integer.parseInt(startRoom) <= 133) {
            start = 7;
        }
        if (Integer.parseInt(startRoom) >= 153 && Integer.parseInt(startRoom) <= 176) {
            start = 11;
        }
        if (Integer.parseInt(startRoom) >= 135 && Integer.parseInt(startRoom) <= 152) {
            start = 10;
        }
        if (Integer.parseInt(startRoom) == 180) {
            start = 12;
        }
        if (Integer.parseInt(startRoom) >= 201 && Integer.parseInt(startRoom) <= 208) {
            start = 17;
        }
        if (Integer.parseInt(startRoom) >= 209 && Integer.parseInt(startRoom) <= 211) {
            start = 18;
        }
        if (Integer.parseInt(startRoom) == 213) {
            start = 23;
        }
        if (Integer.parseInt(startRoom) >= 271 && Integer.parseInt(startRoom) <= 296) {
            start = 19;
        }
        if (Integer.parseInt(startRoom) >= 214 && Integer.parseInt(startRoom) <= 243) {
            start = 20;
        }
        if (Integer.parseInt(startRoom) >= 244 && Integer.parseInt(startRoom) <= 270) {
            start = 24;
        }

        if (Integer.parseInt(destRoom) >= 1 && Integer.parseInt(destRoom) <= 2) {
            end = 1;
        }
        if (Integer.parseInt(destRoom) >= 7 && Integer.parseInt(destRoom) <= 15) {
            end = 13;
        }
        if (Integer.parseInt(destRoom) == 17) {
            end = 14;
        }
        if (Integer.parseInt(destRoom) >= 101 && Integer.parseInt(destRoom) <= 107) {
            end = 5;
        }
        if (Integer.parseInt(destRoom) >= 108 && Integer.parseInt(destRoom) <= 113) {
            end = 4;
        }
        if (Integer.parseInt(destRoom) >= 117 && Integer.parseInt(destRoom) <= 125) {
            end = 6;
        }
        if (Integer.parseInt(destRoom) >= 127 && Integer.parseInt(destRoom) <= 133) {
            end = 7;
        }
        if (Integer.parseInt(destRoom) >= 153 && Integer.parseInt(destRoom) <= 176) {
            end = 11;
        }
        if (Integer.parseInt(destRoom) >= 135 && Integer.parseInt(destRoom) <= 152) {
            end = 10;
        }
        if (Integer.parseInt(destRoom) == 180) {
            end = 12;
        }
        if (Integer.parseInt(destRoom) >= 201 && Integer.parseInt(destRoom) <= 208) {
            end = 17;
        }
        if (Integer.parseInt(destRoom) >= 209 && Integer.parseInt(destRoom) <= 211) {
            end = 18;
        }
        if (Integer.parseInt(destRoom) == 213) {
            end = 23;
        }
        if (Integer.parseInt(destRoom) >= 271 && Integer.parseInt(destRoom) <= 296) {
            end = 19;
        }
        if (Integer.parseInt(destRoom) >= 214 && Integer.parseInt(destRoom) <= 243) {
            end = 20;
        }
        if (Integer.parseInt(destRoom) >= 244 && Integer.parseInt(destRoom) <= 270) {
            end = 24;
        }
    }
}
