package com.project.backend.entity.comics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComicDataContainer {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<Comic> results;
}
