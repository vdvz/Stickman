import java.util.HashMap;
import java.util.Map;

public class Lobby {

    private static final Lobby Instance = new Lobby();
    public static Lobby getInstance(){ return Instance;}
    private  Lobby(){}

    Map<Integer, Room> AvailableRoom = new HashMap<>();

    void AddRoom(Room room){
    }

    Room GetRoom(int room_id ){
        return null;
    }

    void RemoveRoom(Room room){
    }

}
