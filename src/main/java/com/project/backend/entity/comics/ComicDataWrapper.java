package com.project.backend.entity.comics;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComicDataWrapper {
    private int code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private ComicDataContainer data;
    private String etag;
}
