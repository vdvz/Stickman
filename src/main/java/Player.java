public class Player extends Player_A{
    private final int id;
    private final String name;
    private int Health = 100;
    private int skin_id;

    private PlayerPosition PlayerPosition;

    Player(int _id, String _name, int _skin_id, boolean isFirstPlayer /*for pick right start position*/){
        id = _id;
        name = _name;
        skin_id = _skin_id;
    }

    public PlayerPosition getPlayerPosition() {
        return PlayerPosition;
    }

    public void setPlayerPosition(PlayerPosition playerPosition) {
        PlayerPosition = playerPosition;
    }

    @Override
    public void addDamage(int damage) {
        Health-=damage;
    }

    @Override
    public void addHealth(int health) {
        Health+=health;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean checkIfPlayerAlive(){
        return Health>0;
    }

}
