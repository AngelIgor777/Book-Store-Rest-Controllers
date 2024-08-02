package com.project.backend.action_methods;

import com.project.backend.entity.characters.Character;
import com.project.backend.entity.comics.Comic;

import java.util.List;

public interface Communication {
    public List<Character> getAllCharacters();
    public List<Comic> getAllComics();
    public String getUrl(UrlTypes urlType);
}
