import java.util.LinkedList;
import java.util.List;

public class Game {
    private GAME_STATUS status;

    private final List<Player> Players = new LinkedList<>();

    private final int Id;

    private int Damage = 0;
    private int Gravity = 0;
    private int Speed = 0;
    private int Bounce = 0;

    public void setDamage(int damage) {
        Damage = damage;
    }
    public void setGravity(int gravity) {
        Gravity = gravity;
    }
    public void setSpeed(int speed) {
        Speed = speed;
    }
    public void setBounce(int bounce) {
        Bounce = bounce;
    }

    Game(int game_id) {
        Id = game_id;
    }
    /*User or id_user*/
    Player GetPlayer(int player_id){
        return null;
    }

    void PlayerDisconnected(int player_id){
    }

    void CalculateDamage(){
    }

    void UpdatePlayerPosition(int player_id, Player player/*, new position*/){
    }

    public void AddPlayer(User user){
        //Invoke constructor
        //put player to players
    }

    public Game build(){
        return null;
    }

    public void start(){

    }

    public boolean hasUser(int user_id){
        return Players.stream().anyMatch(e -> e.getId() == user_id);
    }

    public GAME_STATUS getStatus() {
        return status;
    }

    public void setStatus(GAME_STATUS status) {
        this.status = status;
    }

    public int getId() {
        return Id;
    }
}