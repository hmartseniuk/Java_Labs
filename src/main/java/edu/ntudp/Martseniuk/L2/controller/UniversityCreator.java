package edu.ntudp.Martseniuk.L2.controller;

import edu.ntudp.Martseniuk.L2.model.*;

public class UniversityCreator extends BaseCreator<University> {
    private FacultyCreator facultyCreator;

    public UniversityCreator() {
        this.facultyCreator = new FacultyCreator();
    }

    public University createTypicalUniversity() {
        Human rector = new Human("Володимир", "Ректоренко", "Ректорович", Sex.MALE);
        University university = new University(
                "Дніпровський національний університет імені Олеся Гончара",
                rector
        );

        // Факультет прикладної математики
        Human deanMath = new Human("Олександр", "Математик", "Олександрович", Sex.MALE);
        String[][] mathDepartments = {
                {"Кафедра програмної інженерії", "ПІ-21", "ПІ-22", "ПІ-23"},
                {"Кафедра прикладної математики", "ПМ-21", "ПМ-22"}
        };
        Faculty mathFaculty = facultyCreator.createFaculty(
                "Факультет прикладної математики",
                deanMath,
                mathDepartments
        );
        university.addFaculty(mathFaculty);

        // Факультет фізики
        Human deanPhys = new Human("Наталія", "Фізик", "Василівна", Sex.FEMALE);
        String[][] physDepartments = {
                {"Кафедра теоретичної фізики", "ТФ-21", "ТФ-22"},
                {"Кафедра експериментальної фізики", "ЕФ-21"}
        };
        Faculty physFaculty = facultyCreator.createFaculty(
                "Факультет фізики",
                deanPhys,
                physDepartments
        );
        university.addFaculty(physFaculty);

        // Факультет економіки
        Human deanEcon = new Human("Ірина", "Економова", "Михайлівна", Sex.FEMALE);
        String[][] econDepartments = {
                {"Кафедра економічної теорії", "ЕТ-21", "ЕТ-22"},
                {"Кафедра фінансів", "ФІН-21"}
        };
        Faculty econFaculty = facultyCreator.createFaculty(
                "Факультет економіки",
                deanEcon,
                econDepartments
        );
        university.addFaculty(econFaculty);

        return university;
    }

    @Override
    public University create() {
        return createTypicalUniversity();
    }
}
