import java.util.ArrayList;
import java.util.List;

public class Room {
    private final int Id;
    private User Admin = null;
    private final List<User> UsersInRoom = new ArrayList<>();

    private int Damage = 0;
    private int Gravity = 0;
    private int Speed = 0;
    private int Bounce = 0;

    Room(int room_id, User user){
        Id = room_id;
        Admin = user;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    public int getGravity() {
        return Gravity;
    }

    public void setGravity(int gravity) {
        Gravity = gravity;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public int getBounce() {
        return Bounce;
    }

    public void setBounce(int bounce) {
        Bounce = bounce;
    }

    public User getAdmin() {
        return Admin;
    }

    public void setAdmin(User admin) {
        Admin = admin;
    }

    void AddingUser(User user){
    }

    void RemovingUser(User user){
    }

    void PickNewAdmin(){
    }

    boolean IsUserAdmin(User user){
        return false;
    }

    public int getId() {
        return Id;
    }
}
