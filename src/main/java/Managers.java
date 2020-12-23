public class Managers {

    public Managers(){
    }

    static final UserManager_I userManager = UserManager.getInstance();
    static final GameManager_I gameManager = GameManager.getInstance();
    static final FriendManager_I friendManager = FriendManager.getInstance();

    public static FriendManager_I getFriendManager() {
        return friendManager;
    }

    public static GameManager_I getGameManager() {
        return gameManager;
    }

    public static UserManager_I getUserManager() {
        return userManager;
    }
}
