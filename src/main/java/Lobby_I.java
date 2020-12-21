import java.util.List;

public interface Lobby_I {

    Room GetRoom(int room_id);

    List<Room> GetAvailableRooms();

    Room CreateNewRoom();

}