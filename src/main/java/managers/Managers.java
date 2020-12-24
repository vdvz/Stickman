package managers;

public class Managers {

    public Managers(){
    }
    private static final UserManager_I userManager = UserManager.getInstance();
    private static final GameManager_I gameManager = GameManager.getInstance();
    private static final FriendManager_I friendManager = FriendManager.getInstance();

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
