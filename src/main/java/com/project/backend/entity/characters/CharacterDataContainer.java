package com.project.backend.entity.characters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CharacterDataContainer {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<Character> results;
}
