package edu.ntudp.Martseniuk.L4;

import java.sql.*;

public class StudentQuery {
    public static void main(String[] args) {
        String query = "SELECT * FROM student_records WHERE MONTH(date_of_birth) = 7";

        try {
            Connection connection = DriverManager.getConnection(
                    DatabaseParameters.url,
                    DatabaseParameters.user,
                    DatabaseParameters.password
            );

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while(result.next()) {
                System.out.println(
                        result.getString("student_id") + " || " +
                                result.getString("last_name") + " || " +
                                result.getString("first_name") + " || " +
                                result.getString("middle_name") + " || " +
                                result.getString("date_of_birth") + " || " +
                                result.getString("grade_book_num")
                );
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}