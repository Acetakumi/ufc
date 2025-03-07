package org.example.ufc.models.api;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FighterDTO implements Serializable {
    private String category;
    private String draws;
    private String imgUrl;
    private String losses;
    private String name;
    private String nickname;
    private String wins;
    private String status;
    private String placeOfBirth;
    private String trainsAt;
    private String fightingStyle;
    private String age;
    private String height;
    private String weight;
    private String octagonDebut;
    private String reach;
    private String legReach;
}
