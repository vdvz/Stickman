import static org.junit.jupiter.api.Assertions.assertEquals;

import DB.FRIEND_DB;
import DB.FRIEND_DB_I;
import DB.USER_DB;
import DB.USER_DB_I;
import exceptions.NoResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import proto_files.DangerStickman;
import proto_files.UserMessages;
import server.RequestExecutor;
import server.RequestExecutor_I;
import server.Server;
import user.User;

import java.sql.SQLException;

public class FirstTest {

    USER_DB_I userDB = new USER_DB();
    FRIEND_DB_I friendDB = new FRIEND_DB();
    RequestExecutor_I executor = new RequestExecutor();

    DangerStickman.PacketWrapper loadUserRequest = DangerStickman.PacketWrapper.newBuilder()
            .setUser(DangerStickman.PacketWrapper.UserWrapper.newBuilder()
                    .setLoadUserRequest(UserMessages.LoadUserRequest.newBuilder()
                            .setAndroidId("test")
                            .build())
                    .build())
            .build();

    DangerStickman.PacketWrapper loadNewUserRequest = DangerStickman.PacketWrapper.newBuilder()
            .setUser(DangerStickman.PacketWrapper.UserWrapper.newBuilder()
                    .setLoadUserRequest(UserMessages.LoadUserRequest.newBuilder()
                            .setAndroidId("test1")
                            .build())
                    .build())
            .build();


    DangerStickman.PacketWrapper updateUserRequest = DangerStickman.PacketWrapper.newBuilder()
            .setUser(DangerStickman.PacketWrapper.UserWrapper.newBuilder()
                    .setUpdateUserRequest(UserMessages.UpdateUserRequest.newBuilder()
                            .setUserId(1)
                            .build())
                    .build())
            .build();



    @BeforeAll
    static void initAll(){
    }

    void testUserDB(){
        try {
            int set_money = 199;
            String set_name = "name";
            User user  = userDB.GetUser("test");
            System.out.println(user.getName());
            System.out.println(user.getMoney());
            user.setMoney(set_money);
            user.setName(set_name);
            userDB.SaveUser(user);
            user  = userDB.GetUser("test");
            assertEquals(set_money, user.getMoney());
            assertEquals(set_name, user.getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //resquests
    @Test
    void newUserRequest(){
        try {
            DangerStickman.PacketWrapper response = executor.executeRequest(loadNewUserRequest);
            System.out.println("Id: " + response.getUser().getUserResponse().getUser().getId());
            System.out.println("Name: " + response.getUser().getUserResponse().getUser().getName());
            System.out.println("Money: " + response.getUser().getUserResponse().getUser().getMoney());
        } catch (NoResponse noResponse) {
            noResponse.printStackTrace();
        }
    }

    @Test
    void loadUserRequest(){
        try {
            DangerStickman.PacketWrapper response = executor.executeRequest(loadUserRequest);
            System.out.println("Id: " + response.getUser().getUserResponse().getUser().getId());
            System.out.println("Name: " + response.getUser().getUserResponse().getUser().getName());
            System.out.println("Money: " + response.getUser().getUserResponse().getUser().getMoney());
        } catch (NoResponse noResponse) {
            noResponse.printStackTrace();
        }
    }

    @Test
    void updateUserRequest(){
        try {
            DangerStickman.PacketWrapper response = executor.executeRequest(updateUserRequest);
            System.out.println("Id: " + response.getUser().getUserResponse().getUser().getId());
            System.out.println("Name: " + response.getUser().getUserResponse().getUser().getName());
            System.out.println("Money: " + response.getUser().getUserResponse().getUser().getMoney());
        } catch (NoResponse noResponse) {
            noResponse.printStackTrace();
        }
    }

}
