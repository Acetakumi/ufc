package org.example.ufc.models.entities;

import lombok.Data;
import org.example.ufc.models.api.FighterDTO;

@Data
public class Fighter {
    private String id;
    private String name;
    private String category;
    private Integer draws;
    private String imgUrl;
    private Integer losses;
    private String nickname;
    private Integer wins;
    private String status;
    private String placeOfBirth;
    private String trainsAt;
    private String fightingStyle;
    private Integer age;
    private Double height;
    private Double weight;

    public Fighter(String id, FighterDTO fighterData) {
        this.id = id;
        this.name = fighterData.getName();
        this.category = fighterData.getCategory();
        this.draws = Integer.parseInt(fighterData.getDraws());
        this.imgUrl = fighterData.getImgUrl();
        this.losses = Integer.parseInt(fighterData.getLosses());
        this.nickname = fighterData.getNickname();
        this.wins = Integer.parseInt(fighterData.getWins());
        this.status = fighterData.getStatus();
        this.placeOfBirth = fighterData.getPlaceOfBirth();
        this.trainsAt = fighterData.getTrainsAt();
        this.fightingStyle = fighterData.getFightingStyle();
        this.age = Integer.parseInt(fighterData.getAge());
        this.height = Double.parseDouble(fighterData.getHeight());
        this.weight = Double.parseDouble(fighterData.getWeight());
    }
}
