package all_classes_need_to_sep_by_packets;

import user.User;

import java.util.NoSuchElementException;

public interface UserManager_I {


    //Добавляет юзера в список онлайн юзеров

    void AddToOnline(User user);

    //Возвращает юзера если он онайн иначе кидает exceptions.NoUserException
    User GetUser(int user_id) throws NoSuchElementException;
}
