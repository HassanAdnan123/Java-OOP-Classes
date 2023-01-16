import java.sql.SQLException;

public class Location extends Database{

    Location(){
        setTableName("location");
        setColumns(new String[] {"city_name","country_name"});
        setColumnData(new String[2]);
    }

    void add() throws SQLException {

        super.add();
    }

    void view() throws SQLException {
        super.view();
    }
    void update() throws SQLException {
        super.update();
    }

    void delete() throws SQLException {
        super.delete();
    }
}
