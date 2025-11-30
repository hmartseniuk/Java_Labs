package edu.ntudp.Martseniuk.L3;

import edu.ntudp.Martseniuk.L2.controller.UniversityCreator;
import edu.ntudp.Martseniuk.L2.model.University;
import edu.ntudp.Martseniuk.L2.view.UniversityPrinter;

public class Run {
    public static void main(String[] args) {
        System.out.println("=== Демонстрація серіалізації університету в JSON ===\n");

        // Створення університету
        UniversityCreator creator = new UniversityCreator();
        University university = creator.createTypicalUniversity();

        // Виведення інформації про університет
        System.out.println("--- Оригінальний університет ---");
        UniversityPrinter.printStatistics(university);

        // Створення JsonManager
        JsonManager jsonManager = new JsonManager();

        // Запис у файл
        String filePath = "University.json";
        System.out.println("\n--- Запис у JSON файл ---");
        jsonManager.writeUniversityToJson(university, filePath);

        // Читання з файлу
        System.out.println("\n--- Читання з JSON файлу ---");
        University loadedUniversity = jsonManager.readUniversityFromJson(filePath);

        // Перевірка еквівалентності
        System.out.println("\n--- Перевірка еквівалентності ---");
        boolean areEqual = university.equals(loadedUniversity);
        System.out.println("Університети еквівалентні: " + areEqual);

        if (areEqual) {
            System.out.println("✓ Серіалізація та десеріалізація пройшли успішно!");
        } else {
            System.out.println("✗ Помилка: університети не еквівалентні");
        }

        // Виведення статистики завантаженого університету
        System.out.println("\n--- Завантажений університет ---");
        UniversityPrinter.printStatistics(loadedUniversity);

        // Демонстрація конвертації в JSON рядок
        System.out.println("\n--- Приклад JSON рядка (перші 500 символів) ---");
        String jsonString = jsonManager.universityToJsonString(university);
        System.out.println(jsonString.substring(0, Math.min(500, jsonString.length())) + "...");
    }
}