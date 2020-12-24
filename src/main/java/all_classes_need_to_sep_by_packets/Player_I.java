package all_classes_need_to_sep_by_packets;

public interface Player_I {

    String getName();

    int getId();

    PlayerPosition getPlayerPosition();

    void setPlayerPosition(PlayerPosition playerPosition);

    void addDamage(int damage);

    void addHealth(int health);

    boolean checkIfPlayerAlive();

}
