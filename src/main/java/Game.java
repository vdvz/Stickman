public class Game {
    enum GameStatus{
        PROCESS,
        WIN_1,
        WIN_2
    }
    private GameStatus status;

    private Player player1;
    private Player player2;

    Game(User user1, User user2){

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
}