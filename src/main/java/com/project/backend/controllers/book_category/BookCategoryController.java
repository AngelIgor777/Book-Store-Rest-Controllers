package com.project.backend.controllers.book_category;

import com.project.backend.action_methods.CommunicationImpl;
import com.project.backend.entity.comics.Comic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bookStorage") //http://localhost:8080/bookStorage
public class BookCategoryController {
    CommunicationImpl communicationImpl;

    @Autowired
    public BookCategoryController(CommunicationImpl communicationImpl) {
        this.communicationImpl = communicationImpl;
    }

    @GetMapping("/genres/comics") //http://localhost:8080/bookStorage/genres/comics
    public String bookGenresView(Model model) {
        List<Comic> allComics = communicationImpl.getAllComics();
        model.addAttribute("allComicsList", allComics);
        return "";
    }

}
