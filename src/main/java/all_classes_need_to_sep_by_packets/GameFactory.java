package all_classes_need_to_sep_by_packets;

public class GameFactory implements GameFactory_I{

    public Game createGame(Room room){
        Game game = new Game(AvailableGameIDs.getFreeID());
        game.setBounce(room.getBounce());
        game.setDamage(room.getDamage());
        game.setGravity(room.getGravity());
        game.setSpeed(room.getSpeed());
        room.getUsersInRoom().forEach(game::AddPlayer);
        return game.build();
    }

}
