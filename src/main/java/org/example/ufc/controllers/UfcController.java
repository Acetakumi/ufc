package org.example.ufc.controllers;

import org.example.ufc.models.api.RankingResponse;
import org.example.ufc.models.entities.Fighter;
import org.example.ufc.services.UfcServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ufc")
public class UfcController {

    @GetMapping("/fighters")
    public ArrayList<Fighter> fetchAllFighters() {
       UfcServices ufcServices = new UfcServices();
       return ufcServices.fetchFighters();
    }

    @GetMapping("/rank")
    public List<RankingResponse> fetchAllRankings() {
        UfcServices ufcServices = new UfcServices();
        return ufcServices.fetchAllRankings();
    }

    @GetMapping("/ranksByWeightClass")
    public RankingResponse fetchAllRankings(@RequestParam String weightClass) {
        UfcServices ufcServices = new UfcServices();
        return ufcServices.rankingsByWeightClass(weightClass);
    }

    @GetMapping("/findChampionbyWeightClass")
    public Fighter findChampionbyWeightClass(@RequestParam String weightClass) {
        UfcServices ufcServices = new UfcServices();
        return ufcServices.findChampionByWeightClass(weightClass);
    }
}
