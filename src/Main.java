import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/mydatabase";
        String username = "postgres"; // PostgreSQL kullanıcı adınızı buraya yazın
        String password = "123"; // PostgreSQL şifrenizi buraya yazın

        Connection connection = null;

        try {
            // 1. Veritabanı bağlantısını oluşturun
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // 2. Bir SQL ifadesi oluşturun
            Statement statement = connection.createStatement();

            // 3. SQL sorgusunu çalıştırın
            String sql = "SELECT * FROM employees";
            ResultSet resultSet = statement.executeQuery(sql);

            // 4. Sonuçları okuyun ve ekrana yazdırın
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                double salary = resultSet.getDouble("salary");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Position: " + position);
                System.out.println("Salary: " + salary);
                System.out.println("---------------------------");
            }

            // 5. Kaynakları serbest bırakın
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
