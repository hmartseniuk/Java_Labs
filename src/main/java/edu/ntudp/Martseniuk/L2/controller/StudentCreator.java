package edu.ntudp.Martseniuk.L2.controller;

import edu.ntudp.Martseniuk.L2.model.Sex;
import edu.ntudp.Martseniuk.L2.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentCreator extends BaseCreator<Student> {
    private static int studentCounter = 1;

    public Student createStudent(String firstName, String lastName, String patronymic, Sex sex) {
        String studentId = generateId("STD", studentCounter++);
        return new Student(firstName, lastName, patronymic, sex, studentId);
    }

    @Override
    public Student create() {
        return createStudent("Іван", "Іваненко", "Іванович", Sex.MALE);
    }

    public List<Student> createMultipleStudents(int count, String groupName) {
        List<Student> students = new ArrayList<>();

        String[][][] allNames = {
                {
                        {"Олександр", "Петренко", "Володимирович", "MALE"},
                        {"Марія", "Коваленко", "Петрівна", "FEMALE"},
                        {"Андрій", "Сидоренко", "Олександрович", "MALE"},
                        {"Анна", "Ткаченко", "Сергіївна", "FEMALE"},
                        {"Дмитро", "Бойко", "Олегович", "MALE"}
                },
                {
                        {"Віктор", "Кравченко", "Андрійович", "MALE"},
                        {"Юлія", "Олійник", "Володимирівна", "FEMALE"},
                        {"Ігор", "Мельник", "Павлович", "MALE"},
                        {"Тетяна", "Павленко", "Олександрівна", "FEMALE"},
                        {"Максим", "Савченко", "Юрійович", "MALE"}
                },
                {
                        {"Наталія", "Левченко", "Вікторівна", "FEMALE"},
                        {"Владислав", "Мороз", "Григорович", "MALE"},
                        {"Ірина", "Поліщук", "Романівна", "FEMALE"},
                        {"Артем", "Гриценко", "Дмитрович", "MALE"},
                        {"Вікторія", "Романенко", "Олексіївна", "FEMALE"}
                }
        };

        int groupIndex = createUniqueGroupIndex(groupName, allNames.length);
        String[][] selectedNames = allNames[groupIndex];

        for (int i = 0; i < count && i < selectedNames.length; i++) {
            String[] nameData = selectedNames[i];
            Sex sex = nameData[3].equals("MALE") ? Sex.MALE : Sex.FEMALE;
            students.add(createStudent(nameData[0], nameData[1], nameData[2], sex));
        }

        return students;
    }

    private int createUniqueGroupIndex(String groupName, int maxIndex) {
        int hash = groupName.hashCode();
        hash = hash * 31 + groupName.length();
        hash = hash ^ (hash >>> 15);
        return Math.abs(hash) % maxIndex;
    }
}

