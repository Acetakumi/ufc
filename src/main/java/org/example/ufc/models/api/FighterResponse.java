package org.example.ufc.models.api;

import lombok.Data;

import java.util.Map;

@Data
public class FighterResponse {
    private Map<String, FighterDTO> fighters;
}
