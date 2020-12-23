package DB;

import java.sql.ResultSet;

public interface MyConnection_I {

    boolean execute(String sql);

    int executeUpdate(String sql);

    ResultSet executeQuery(String sql);

    void release();

}
