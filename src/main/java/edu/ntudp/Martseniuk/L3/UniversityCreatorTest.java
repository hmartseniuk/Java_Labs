package edu.ntudp.Martseniuk.L3;

import com.google.gson.Gson;
import edu.ntudp.Martseniuk.L2.controller.UniversityCreator;
import edu.ntudp.Martseniuk.L2.model.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.File;

import static org.junit.Assert.*;

public class UniversityCreatorTest {

    private static final String TEST_FILE_PATH = "TestUniversity.json";

    @Before
    public void setUp() {
        // Підготовка перед тестом
        System.out.println("=== Початок тесту серіалізації ===");
    }

    @After
    public void tearDown() {
        // Очищення після тесту
        File testFile = new File(TEST_FILE_PATH);
        if (testFile.exists()) {
            testFile.delete();
            System.out.println("Тестовий файл видалено");
        }
        System.out.println("=== Кінець тесту серіалізації ===\n");
    }

    @Test
    public void testUniversityJsonSerialization() {
        // Створення тестового університету
        University oldUniversity = createTestUniversity();

        // Створення JsonManager
        JsonManager jsonManager = new JsonManager(new Gson());

        // Запис університету в JSON файл
        jsonManager.writeUniversityToJson(oldUniversity, TEST_FILE_PATH);

        // Читання університету з JSON файлу
        University newUniversity = jsonManager.readUniversityFromJson(TEST_FILE_PATH);

        // Перевірка еквівалентності
        assertNotNull("Новий університет не повинен бути null", newUniversity);
        assertEquals("Університети повинні бути еквівалентні", oldUniversity, newUniversity);

        // Додаткові перевірки
        assertEquals("Назви університетів повинні співпадати",
                oldUniversity.getName(), newUniversity.getName());
        assertEquals("Кількість факультетів повинна співпадати",
                oldUniversity.getFaculties().size(), newUniversity.getFaculties().size());

        System.out.println("✓ Тест пройдено успішно!");
        System.out.println("✓ oldUniversity == newUniversity");
    }

    @Test
    public void testJsonStringConversion() {
        // Тест конвертації в JSON рядок і назад
        University oldUniversity = createTestUniversity();
        JsonManager jsonManager = new JsonManager();

        // Конвертація в JSON рядок
        String jsonString = jsonManager.universityToJsonString(oldUniversity);
        assertNotNull("JSON рядок не повинен бути null", jsonString);
        assertTrue("JSON рядок не повинен бути порожнім", jsonString.length() > 0);

        // Конвертація назад в об'єкт
        University newUniversity = jsonManager.jsonStringToUniversity(jsonString);
        assertEquals("Університети повинні бути еквівалентні після конвертації",
                oldUniversity, newUniversity);

        System.out.println("✓ Тест конвертації в рядок пройдено успішно!");
    }

    /**
     * Створює тестовий університет з двома підрозділами на кожному рівні
     */
    private University createTestUniversity() {
        // Ректор
        Human rector = new Human("Володимир", "Тестовий", "Ректорович", Sex.MALE);
        University university = new University("Тестовий Університет", rector);

        // Створення двох факультетів
        for (int f = 1; f <= 2; f++) {
            Human dean = new Human("Декан" + f, "Факультетський", "Деканович", Sex.MALE);
            Faculty faculty = new Faculty("Факультет №" + f, dean);

            // Створення двох кафедр на кожному факультеті
            for (int d = 1; d <= 2; d++) {
                Human deptHead = new Human("Завідувач" + d, "Кафедральний", "Петрович", Sex.MALE);
                Department department = new Department("Кафедра №" + f + "." + d, deptHead);

                // Створення двох груп на кожній кафедрі
                for (int g = 1; g <= 2; g++) {
                    Human groupHead = new Human("Куратор" + g, "Груповий", "Іванович", Sex.MALE);
                    Group group = new Group("Група-" + f + d + g, groupHead);

                    // Створення двох студентів у кожній групі
                    for (int s = 1; s <= 2; s++) {
                        Sex sex = (s % 2 == 0) ? Sex.FEMALE : Sex.MALE;
                        String firstName = (sex == Sex.MALE) ? "Студент" + s : "Студентка" + s;
                        String lastName = "Прізвище" + f + d + g + s;
                        String patronymic = (sex == Sex.MALE) ? "Батькович" : "Батьківна";
                        String studentId = String.format("STD%d%d%d%d", f, d, g, s);

                        Student student = new Student(firstName, lastName, patronymic, sex, studentId);
                        group.addStudent(student);
                    }

                    department.addGroup(group);
                }

                faculty.addDepartment(department);
            }

            university.addFaculty(faculty);
        }

        return university;
    }
}
