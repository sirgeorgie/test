package com.company.test.screen.blank;

import com.company.test.entity.Person;
import io.jmix.ui.component.Button;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.slf4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@UiController("BlankScreen")
@UiDescriptor("blank-screen.xml")
public class BlankScreen extends Screen {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BlankScreen.class);

    @Subscribe("Click")
    public void onClickClick(Button.ClickEvent event) {
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person(20,"Aleesha","Brennan", Person.Gender.FEMALE));
        listPerson.add(new Person(25,"Fynn","Ball",Person.Gender.MALE));
        listPerson.add(new Person(18,"Fraser","Nash", Person.Gender.MALE));
        listPerson.add(new Person(35,"Garry","Shepherd",Person.Gender.MALE));
        listPerson.add(new Person(22,"Kirstie","Wiley",Person.Gender.FEMALE));
        listPerson.add(new Person(40,"Zakaria","Stott",Person.Gender.FEMALE));
        listPerson.add(new Person(50,"Layla-Rose","Burn",Person.Gender.FEMALE));

        //sorts the list of persons by Firstname and Lastname
        Collections.sort(listPerson);

        log.info("List result:" + listPerson);

        //Grouping the list of persons by gender
        Map<Person.Gender, List<Person>> personPerTypes = listPerson.stream()
                .collect(groupingBy(Person::getGender));

        log.info("Map: "+personPerTypes);

        //Find a collection of persons that are older than or equal to 30.
        List<Person> listAge30plus = listPerson.stream()
                .filter(p -> p.getAge() >= 30)
                .collect(Collectors.toList());

        log.info("List result Age>30:" + listAge30plus);
    }
}