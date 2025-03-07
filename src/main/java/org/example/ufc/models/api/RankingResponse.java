package org.example.ufc.models.api;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class RankingResponse implements Serializable {
    private String id;
    private String categoryName;
    private Champion champion;
    private List<Fighter> fighters;

    @Data
    public static class Champion implements Serializable {
        private String id;
        private String championName;
    }

    @Data
    public static class Fighter implements Serializable {
        private String id;
        private String name;
    }
}
