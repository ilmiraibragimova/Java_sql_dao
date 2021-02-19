package server.dao;

import server.modals.Employ;

import java.sql.*;

public class DaoConnect {
    private Employ employ;
    Connection connection = get_connect();



    public DaoConnect(Employ employ) {
        this.employ = employ;
    }

    private static Connection get_connect() {
        Connection connection;
        String dbuser = "postgres";
        String dbpass = "9060651419";
        String connect = "jdbc:postgresql://localhost:5432/postgres";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connect, dbuser, dbpass);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return (connection);
        }

    public  void updateBase() throws SQLException {

        // language=SQL
          final String SQL_INSERT_USER =
                "INSERT INTO mytest(family, name, ochestvo, tel, adres) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
        preparedStatement.setString(1, employ.getFamily());
        preparedStatement.setString(2, employ.getName());
        preparedStatement.setString(3, employ.getOtch());
        preparedStatement.setString(4, employ.getTel());
        preparedStatement.setString(5, employ.getAdres());
        preparedStatement.execute();
    }
    public  void removeBase()  {
        // language=SQL
        final String SQL_REMOVE_USER =
                "DELETE FROM mytest WHERE family = ? AND name = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_REMOVE_USER);
            preparedStatement.setString(1, employ.getFamily());
            preparedStatement.setString(2, employ.getName());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Нет такого сотрудника");

        }
    }
    public  void removeBaseFromId() throws SQLException {
        // language=SQL
        final String SQL_REMOVE_USER =
                "DELETE FROM mytest WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_REMOVE_USER);
            preparedStatement.setInt(1, employ.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Нет такого сотрудника");
            System.out.println(e);
        }
    }

    public  void print_from_base() throws SQLException {
        //language=SQL
        final String SQL_SELECT_USER =
                "SELECT family, name, ochestvo, tel, adres, " +
                        "nameotdel FROM mytest LEFT JOIN podraz  on mytest.id = podraz.idEmp" +
                        " WHERE family = ? AND name = ?";


        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER);
        preparedStatement.setString(1, employ.getFamily());
        preparedStatement.setString(2, employ.getName());
        try {
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            System.out.println("ФИО " + result.getString("family") +
                            " " + result.getString("name") +
                            " " + result.getString("ochestvo"));
            System.out.println("Телефон " + result.getString("tel") +
                " Адрес " + result.getString("adres"));
            System.out.println("Подразделение " + result.getString("nameotdel"));

        } catch (SQLException e) {
            System.out.println("Нет такого сотрудника");
        }


    }
    public  void print_from_base_all() throws SQLException {
        //language=SQL
        final String SQL_SELECT_USER =
                "SELECT family, name, ochestvo, " +
                        "nameotdel FROM mytest LEFT JOIN podraz  on mytest.id = podraz.idEmp" +
                        " WHERE  podraz.numotdel = ?";


        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER);
        preparedStatement.setInt(1, employ.getId());
        try {
            ResultSet result = preparedStatement.executeQuery();
            System.out.println("Отдел " + employ.getId());
            while (result.next()) {
                System.out.println(result.getString("family") +
                        " " + result.getString("name") +
                        " " + result.getString("ochestvo"));
            }

        } catch (SQLException e) {
            System.out.println("Нет такого отдела");
            System.out.println(e);

        }


    }

}
