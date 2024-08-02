package com.project.backend.entity.characters;

import com.project.backend.entity.characters.CharacterSummary;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterList {
    private int available;
    private int returned;
    private String collectionURI;
    private List<CharacterSummary> items;
}