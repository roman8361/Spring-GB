package ru.kravchenko.spring.controller;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kravchenko.spring.entite.Sum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Controller
@RequestMapping("/home")
public class HomeWork {

    @Getter
    @Setter
    private static class Human {

        @Nullable
        private String name;

        @Nullable
        private int age;

        @Nullable
        private String sex;

        public Human() { }

        Human(@Nullable final String name) {
            this.name = name;
        }
    }

    @ResponseBody
    @RequestMapping(path = "/sum", method = RequestMethod.GET)
    public Sum sumInt(Model uiModel, @RequestParam final int a, @RequestParam final int b) {
        @NonNull final Sum sum = new Sum(a, b); // очень простой класс, который в конструкторе считает сумму.
        return sum;
    }

    @RequestMapping(path = "/setHuman", method = RequestMethod.POST)
    public void setHuman(@RequestBody final Human human) {
        System.out.println(human.getAge() + " " + human.getName() + " " + human.getSex());
    }

    @ResponseBody
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<Human> listHuman(final Model uiModel) {
        @NonNull final List<Human> list = new ArrayList<>();
        list.add(new Human("Ivan"));
        list.add(new Human("Roman"));
        list.add(new Human("Masan"));
        list.add(new Human("Vovan"));
        return list;
    }

}
