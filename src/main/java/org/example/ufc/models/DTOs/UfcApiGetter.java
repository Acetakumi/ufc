package org.example.ufc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UfcApiGetter implements Serializable {

    private boolean success;
    private int count;
    private List<Fighter> fighters;
    private boolean hasNextPage;
    private int nextPage;
    private int previousPage;
    private int lastPage;
}
