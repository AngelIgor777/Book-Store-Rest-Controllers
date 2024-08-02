package com.project.backend.runner;

import com.project.backend.action_methods.Communication;
import com.project.backend.configuration.MainConfig;
import com.project.backend.entity.characters.Character;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

        Communication communication = context.getBean("communication", Communication.class);
        List<Character> allEmployees = communication.getAllCharacters();
        System.out.println(allEmployees);
    }
}
