import java.util.HashMap;
import java.util.Map;

public class GameManager {

    private static final GameManager Instance = new GameManager();
    public static GameManager getInstance(){ return Instance;}
    private  GameManager(){}

    private final Map<Integer, Game> OnlineGames = new HashMap<>();

    Game GetGame(int id){
        return null;
    }



}
