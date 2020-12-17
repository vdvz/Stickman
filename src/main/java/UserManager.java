import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class UserManager {

    /*Singleton*/
    private static final UserManager Instance = new UserManager();
    public static UserManager getInstance(){ return Instance;};
    private  UserManager(){}

    //LIST - хранит всех онлайн юзеров
    private final Map<Integer, User> onlineUsers = new HashMap<>();

    //Добавляет юзера в список онлайн юзеров
    private void AddToOnline(User user){

    }

    //Возвращает юзера если он онайн иначе кидает NoUserException
    public User GetUser() throws NoUserException {

        throw new NoUserException();
    }

    //Вызывается каждый раз когда User подключается к серверу -> на основании android_id создает юзера, добавляет в список онлайн
    public void ClientConnected(String android_id){
        //go to database -> create user
        //add to online
    }

    //Вызывается каждый раз когда user отключаетс от сервера -> сохраняет юзера в базу данных, удаляет из списка онлайн
    void ClientDisconnected(Integer user_id){
        //search in online -> remove from online
        //rewrite to database
    }

    //Делает запрос в бд на основании ответа создает юзера
    private User CreateUser(String adroid_id){

        return null;
    }

    void receivePing(int user_id){

    }

    Map<Integer, Integer> receivedPingMsg = new HashMap<>();
    int delayCheckingUserOnline = 10;
    void checkIfUserOnline(){
        receivedPingMsg.forEach((key, value) -> {

        });
    }

}

