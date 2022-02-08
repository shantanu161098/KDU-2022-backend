package com.example;

import com.example.service.ActorService;
import com.example.service.FilmService;
import com.example.utils.ObjectUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ActorService actorService = context.getBean("usingActorJpa",ActorService.class);
        FilmService filmService = context.getBean("usingJpa",FilmService.class);
        System.out.println(ObjectUtils.convertToJson(actorService.getActorById(100L)));
        System.out.println(ObjectUtils.convertToJson(actorService.getActorByFirstName("John")));
        System.out.println(ObjectUtils.convertToJson(actorService.getActorByLastName("Cage")));
        System.out.println(ObjectUtils.convertToJson(filmService.getFilmsByActorName("john")));
    }
}
