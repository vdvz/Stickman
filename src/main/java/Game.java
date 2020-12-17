public class Game {
    enum GameStatus{
        RUNNING,
        START,
        AWAIT_USER,
        RESULT,
        DELETE
    }

    private GameStatus status;

    private Player player1;
    private Player player2;


    void NewUserConnected(User user){

    }

    void UserDisconnected(User user){

    }

    Player GetPlayer(User user){
        return null;
    }

    void CalculateDamage(){

    }

    void UpdatePosition(Player player/*, new position*/){

    }


}
