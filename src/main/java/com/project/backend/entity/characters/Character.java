package com.project.backend.entity.characters;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Character {
    private int id;
    private String name;
    private String description;
    private String modified;
    private String resourceURI;
    private List<Url> urls;
    private Image thumbnail;
    private ComicList comics;
    private StoryList stories;
    private EventList events;
    private SeriesList series;
}
