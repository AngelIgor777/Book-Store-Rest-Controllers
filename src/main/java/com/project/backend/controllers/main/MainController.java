package com.project.backend.controllers.main;

import com.project.backend.action_methods.CommunicationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookStorage")//базовый адрес для всех подадресов
public class MainController {     //http://localhost:8080/bookStorage

    CommunicationImpl communicationImpl;

    @Autowired
    public MainController(CommunicationImpl communicationImpl) {
        this.communicationImpl = communicationImpl;
    }

    @GetMapping("/main") //http://localhost:8080/bookStorage/main
    public String mainView() {
        return "";
    }

    @GetMapping("/genres") //http://localhost:8080/bookStorage/genres
    public String booksGenresView() {
        return "";
    }
}
