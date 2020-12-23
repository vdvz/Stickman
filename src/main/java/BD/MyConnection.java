package BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection implements MyConnection_I{

    private final Connection Connection;
    private Statement statement = null;
    MyConnection(Connection connection){
        Connection = connection;
    }

    @Override
    public boolean execute(String sql) {
        if(statement == null) {
            try {
                statement = Connection.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public int executeUpdate(String sql) {
        if(statement == null) {
            try {
                statement = Connection.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return 0;
    }

    @Override
    public ResultSet executeQuery(String sql) {
        if(statement == null) {
            try {
                statement = Connection.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }

    public void release(){
        try {
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        statement = null;
    }

}
