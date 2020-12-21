public class Player {
    private final int id;
    private final String name;
    int health = 100;
    int skin_id;

    static final float HeadRadius = 0;
    static final float HandWeight = 0;
    static final float FootWeight = 0;
    static final float TorsoWeight = 0;
    static final float HandHeight = 0;
    static final float FootHeight = 0;
    static final float TorsoHeight = 0;

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

    void setHealth(int health){
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean checkIfPlayerAlive(){
        return false;
    }

}
