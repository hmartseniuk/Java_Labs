package edu.ntudp.Martseniuk.L2.controller;

import edu.ntudp.Martseniuk.L2.model.*;

import java.util.List;

public class FacultyCreator extends BaseCreator<Faculty> {
    private StudentCreator studentCreator;

    public FacultyCreator() {
        this.studentCreator = new StudentCreator();
    }

    public Faculty createFaculty(String facultyName, Human dean, String[][] departmentData) {
        Faculty faculty = new Faculty(facultyName, dean);

        for (String[] deptInfo : departmentData) {
            String deptName = deptInfo[0];
            Human deptHead = new Human("Завідувач", "Кафедри", "Петрович", Sex.MALE);
            Department department = new Department(deptName, deptHead);

            for (int i = 1; i < deptInfo.length; i++) {
                String groupName = deptInfo[i];
                Human groupHead = new Human("Куратор", "Групи", "Іванович", Sex.MALE);
                Group group = new Group(groupName, groupHead);

                List<Student> students = studentCreator.createMultipleStudents(5, groupName);
                for (Student student : students) {
                    group.addStudent(student);
                }

                department.addGroup(group);
            }

            faculty.addDepartment(department);
        }

        return faculty;
    }

    @Override
    public Faculty create() {
        Human dean = new Human("Декан", "Факультету", "Вікторович", Sex.MALE);
        String[][] departments = {
                {"Кафедра програмної інженерії", "ПІ-21", "ПІ-22"}
        };
        return createFaculty("Факультет інформаційних технологій", dean, departments);
    }
}
