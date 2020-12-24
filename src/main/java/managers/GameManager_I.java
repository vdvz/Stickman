package managers;

import game.Game;

public interface GameManager_I {

    Game GetGame(int id);

    void AddGame(Game game);

}
