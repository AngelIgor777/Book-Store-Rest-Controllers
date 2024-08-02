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
public class Image {
    private String path;
    private String extension;
}
