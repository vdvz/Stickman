package managers;

import exceptions.NoSuchUserException;
import user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;


public class UserManager implements Updatable_I, UserManager_I{

    private static final UserManager Instance = new UserManager();
    public static UserManager_I getInstance(){ return Instance;};
    public UserManager(){}

    //LIST - хранит всех онлайн юзеров
    private final Map<Integer, User> OnlineUsers = new ConcurrentHashMap<>();

    @Override
    //Добавляет юзера в список онлайн юзеров
    public void AddToOnline(User user){
        OnlineUsers.put(user.getId(), user);
    }

    @Override
    public void UserDisconnected(int user_id){
    }

    @Override
    public User GetUser(int user_id) throws NoSuchUserException{
        try {
            return OnlineUsers.entrySet().stream().filter(e -> e.getKey().equals(user_id)).findFirst().get().getValue();
        }catch (NoSuchElementException e){
            throw new NoSuchUserException();
        }
    }

    @Override
    public void update() {

    }
}

