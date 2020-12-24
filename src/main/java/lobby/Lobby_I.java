package lobby;

import exceptions.NoSuchRoomException;

import java.util.List;

public interface Lobby_I {

    Room GetRoom(int room_id) throws NoSuchRoomException;

    List<Room> GetAvailableRooms();

    Room CreateNewRoom();

}