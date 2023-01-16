import java.sql.SQLException;

public class Slots extends Database{

    Slots(){
        setTableName("slots");
        setColumns(new String[] {"name","arrival_time","depart_time","stay_duration"});
        setColumnData(new String[4]);
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
