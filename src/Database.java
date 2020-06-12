import java.sql.*;
public class Database {
    private Connection connection = null;
    public Database() throws Exception {
        makeConnection();
    }
    private void makeConnection() throws Exception {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/OOP",
                    "postgres",
                    "");//there should be password
        } catch (Exception e) {
            System.out.println("Sorry, something went wrong!");
            e.printStackTrace();
        }
    }
    public Board createBoard() throws SQLException {
        Board board = new Board();
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM board;");
            while (resultSet.next()) {
                if (resultSet.getString("type").equals("property")) {
                    String name = resultSet.getString("name");
                    double cost = resultSet.getDouble("cost");
                    String type = resultSet.getString("color");
                    Property newProp = new Property(name, cost, "property", type);
                    board.addCell(newProp);
                }
                else {
                    String name = resultSet.getString("name");
                    double cost = resultSet.getDouble("cost");
                    SpecialField newSP = new SpecialField(name, "special", cost);
                    board.addCell(newSP);
                }
            }
        }
        return board;
    }

}

