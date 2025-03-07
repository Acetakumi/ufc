package org.example.ufc.models.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
public class FighterDTO implements Serializable {
    private String _id;
    private String fighter_id;
    private String name;
    private String height;
    private String weight;
    private String reach;
    private String stance;
    private String dob;
    private int n_win;
    private int n_loss;
    private int n_draw;
    private int sig_str_land_pM;
    private int sig_str_land_pct;
    private int sig_str_abs_pM;
    private int sig_str_def_pct;
    private int td_avg;
    private int td_land_pct;
    private int td_def_pct;
    private int sub_avg;
    private int __v;

}
