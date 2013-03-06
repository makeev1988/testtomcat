import javax.sql.DataSource;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alexey
 * Date: 03.03.13
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */
public class GuestBook {

    private DataSource ds;

    GuestBook(DataSource dataSource) throws ClassNotFoundException, SQLException {
        ds = dataSource;
        try (Connection connection = ds.getConnection()){
            Statement stat = connection.createStatement();
            stat.execute(
                    "CREATE TABLE IF NOT EXISTS posts (" +
                            "id INT NOT NULL AUTO_INCREMENT," +
                            "postMessage VARCHAR(255)," +
                            "PRIMARY KEY (id)" +
                            ")");
        }
    }

    public void addRecord(String s) throws SQLException {
        try (Connection connection = ds.getConnection()){
            PreparedStatement prStat = connection.prepareStatement("INSERT INTO posts (postMessage) VALUES (?)");
            prStat.setString(1, s);
            prStat.executeUpdate();
        }
    }

    public List getRecords() throws SQLException {
        List records = new LinkedList();

        try (Connection connection = ds.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT postMessage FROM posts");
            while (resultSet.next()){
                String message = resultSet.getString("postMessage");
                records.add(0, message);
            }
            return records;
        }
    }
}
