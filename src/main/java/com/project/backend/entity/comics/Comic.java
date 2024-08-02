package com.project.backend.entity.comics;
import com.project.backend.entity.characters.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comic {
    private int id;
    private int digitalId;
    private String title;
    private double issueNumber;
    private String variantDescription;
    private String description;
    private String modified;
    private String isbn;
    private String upc;
    private String diamondCode;
    private String ean;
    private String issn;
    private String format;
    private int pageCount;
    private List<TextObject> textObjects;
    private String resourceURI;
    private List<Url> urls;
    private SeriesSummary series;
    private List<ComicSummary> variants;
    private List<ComicSummary> collections;
    private List<ComicSummary> collectedIssues;
    private List<ComicDate> dates;
    private List<ComicPrice> prices;
    private Image thumbnail;
    private List<Image> images;
    private CreatorList creators;
    private CharacterList characters;
    private StoryList stories;
    private EventList events;
}