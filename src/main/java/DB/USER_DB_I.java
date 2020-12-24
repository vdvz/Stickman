package DB;

public interface USER_DB_I {

    User GetUser(String android_id);

    boolean SaveUser(User user);

}
