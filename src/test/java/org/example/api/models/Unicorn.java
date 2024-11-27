package org.example.api.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Unicorn {
    private String name;
    private String tail_colour;
    @SerializedName("_id")
    private String id;

}
