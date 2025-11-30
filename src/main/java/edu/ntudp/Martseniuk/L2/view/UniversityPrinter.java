package edu.ntudp.Martseniuk.L2.view;

import edu.ntudp.Martseniuk.L2.model.*;

import java.util.List;

public class UniversityPrinter {

    public static void printFullInfo(University university) {
        System.out.println("\n========================================");
        System.out.println(university.toString());
        System.out.println("========================================");
        System.out.println("Кількість факультетів: " + university.getFaculties().size());

        for (Faculty faculty : university.getFaculties()) {
            System.out.println("\n" + faculty);
            for (Department dept : faculty.getDepartments()) {
                System.out.println("  " + dept);
                for (Group group : dept.getGroups()) {
                    System.out.println("    " + group);
                }
            }
        }
        System.out.println("========================================\n");
    }

    public static void printAllStudentsCompact(University university) {
        System.out.println("=== ВСІ СТУДЕНТИ (КОМПАКТНИЙ ВИГЛЯД) ===");
        System.out.println("Університет: " + university.getName());
        System.out.println("====================================\n");

        List<Faculty> faculties = university.getFaculties();
        int studentCounter = 0;

        for (Faculty faculty : faculties) {
            List<Department> departments = faculty.getDepartments();
            for (Department department : departments) {
                List<Group> groups = department.getGroups();
                for (Group group : groups) {
                    List<Student> students = group.getStudents();
                    for (Student student : students) {
                        studentCounter++;
                        System.out.printf("%3d. %-30s | %-8s | %-10s | %-30s | %s%n",
                                studentCounter,
                                student.getFullName(),
                                student.getStudentId(),
                                group.getName(),
                                department.getName(),
                                faculty.getName());
                    }
                }
            }
        }

        System.out.println("====================================");
        System.out.println("ВСЬОГО: " + studentCounter + " студентів");
        System.out.println("====================================\n");
    }

    public static void printStatistics(University university) {
        System.out.println("\n=== СТАТИСТИКА ===");

        int totalFaculties = university.getFaculties().size();
        int totalDepartments = 0;
        int totalGroups = 0;
        int totalStudents = 0;

        for (Faculty faculty : university.getFaculties()) {
            totalDepartments += faculty.getDepartments().size();
            for (Department dept : faculty.getDepartments()) {
                totalGroups += dept.getGroups().size();
                for (Group group : dept.getGroups()) {
                    totalStudents += group.getStudents().size();
                }
            }
        }

        System.out.println("Всього факультетів: " + totalFaculties);
        System.out.println("Всього кафедр: " + totalDepartments);
        System.out.println("Всього груп: " + totalGroups);
        System.out.println("Всього студентів: " + totalStudents);
    }
}