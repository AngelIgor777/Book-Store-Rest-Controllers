package com.project.backend.entity.characters;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class EventSummary {
    private String resourceURI;
    private String name;
}

