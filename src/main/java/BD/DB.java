package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;

public class DB implements DB_I{

    private static final DB Instance = new DB();
    public static DB getInstance(){
        return Instance;
    }

    private static final int POOL_SIZE = 3;
    private final String username = "user";//mb make as constants in outer class
    private final String password = "pw";
    private final String server = "localhost";
    private final String port = "8098";
    private final Queue<MyConnection_I> ConnectionsPool = new LinkedList<>();

    private DB(){
        try {
            for(int i=0; i<POOL_SIZE; ++i){
                ConnectionsPool.add(createConnection());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private MyConnection_I createConnection() throws SQLException {
        Connection Connection;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.username);
        connectionProps.put("password", this.password);
        Connection = DriverManager.getConnection(
                "jdbc:mysql://" + this.server + ":" + this.port + "/",
                connectionProps);
        System.out.println("Connected to database");
        assert Connection != null;
        return new MyConnection(Connection);
    }

    public synchronized MyConnection_I getConnection(){
        while(ConnectionsPool.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return ConnectionsPool.poll();
    }

    public synchronized void releaseConnection(MyConnection_I connection){
        connection.release();
        ConnectionsPool.add(connection);
        notify();
    }

}
