package com.project.backend.entity.characters;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ComicList {
    private int available;
    private int returned;
    private String collectionURI;
    private List<ComicSummary> items;
}
