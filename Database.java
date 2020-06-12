import java.sql.*;

public class Database {
    private static Database instance;
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/OOP";
    private String username = ""; //username
    private String password = ""; //password

    public Database() throws Exception {
        makeConnection();
    }
    private void makeConnection() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public static Database getInstance() throws Exception {
        if (instance == null) {
            instance = new Database();
        } else if (instance.getConnection().isClosed()) {
            instance = new Database();
        }

        return instance;
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
