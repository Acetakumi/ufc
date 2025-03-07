package org.example.ufc.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ufc.models.api.FighterDTO;
import org.example.ufc.models.api.RankingResponse;
import org.example.ufc.models.entities.Fighter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UfcServices {

    private final String DOMAIN_NAME = "https://api.octagon-api.com";

    public Map<String, FighterDTO> fetchFightersData() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            ObjectMapper mapper = new ObjectMapper();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(DOMAIN_NAME + "/fighters"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return mapper.readValue(
                    response.body(),
                    mapper.getTypeFactory().constructMapType(
                            Map.class,
                            String.class,
                            FighterDTO.class
                    )
            );

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Fighter> fetchFighters() {
        Map<String, FighterDTO> rawFighters = fetchFightersData();
        ArrayList<Fighter> fighters = new ArrayList<>();

        List<Map.Entry<String, FighterDTO>> entries = new ArrayList<>(rawFighters.entrySet());

        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<String, FighterDTO> entry = entries.get(i);
            fighters.add(new Fighter(entry.getKey(), entry.getValue()));
        }

        return fighters;
    }

    public List<RankingResponse> fetchAllRankings() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            ObjectMapper mapper = new ObjectMapper();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(DOMAIN_NAME + "/rankings"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return mapper.readValue(response.body(), new TypeReference<List<RankingResponse>>() {});
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null; // Return empty list if an error occurs
        }
    }

    public  RankingResponse rankingsByWeightClass(String weightClass) {

        List<RankingResponse> rankings = fetchAllRankings();

        for (int i = 0; i < rankings.size(); i++) {
            if (rankings.get(i).getCategoryName().equals(weightClass)) {
                return rankings.get(i);
            }
        }
        return null;
    }

    public  Fighter findChampionByWeightClass(String weightClass) {

        List<RankingResponse> rankings = fetchAllRankings();
        ArrayList<Fighter> fighters = fetchFighters();

        for (int i = 0; i < rankings.size(); i++) {
            if (rankings.get(i).getCategoryName().equals(weightClass)) {
                for (int j = 0; j < fighters.size(); j++) {
                    if (fighters.get(j).getName().equals(rankings.get(i).getChampion().getChampionName())) {
                        return fighters.get(j);
                    }
                }
            }
        } return null;
    }
}
