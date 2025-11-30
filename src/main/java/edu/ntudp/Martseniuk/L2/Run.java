package edu.ntudp.Martseniuk.L2;

import edu.ntudp.Martseniuk.L2.controller.UniversityCreator;
import edu.ntudp.Martseniuk.L2.model.University;
import edu.ntudp.Martseniuk.L2.view.UniversityPrinter;

public class Run {
    public static void main(String[] args) {
        System.out.println("=== Система управління університетом ===\n");

        UniversityCreator creator = new UniversityCreator();
        University university = creator.createTypicalUniversity();

        UniversityPrinter.printFullInfo(university);
        UniversityPrinter.printStatistics(university);
        UniversityPrinter.printAllStudentsCompact(university);
    }
}