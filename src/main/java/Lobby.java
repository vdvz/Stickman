import exceptions.NoAvailableIDException;
import exceptions.NoSuchRoomException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lobby {
    final int countOfReturningRooms = 10;
    static final int maxIdRoom = 5000;
    private static final Lobby Instance = new Lobby();
    public static Lobby getInstance(){ return Instance;}
    private  Lobby(){}

    static final int[] IDS = new int[maxIdRoom];

    private static int getNextFreeId() throws NoAvailableIDException {
        for( int i = 0; i<maxIdRoom; i++){
            if(IDS[i]== 0 ){
                IDS[i] = 1;
                return i;
            }
        }
        throw new NoAvailableIDException();
    }
    private static void freeID(int id){
        IDS[id] = 0;
    }

    private final Map<Integer, Room> AvailableRoom = new HashMap<>();

    private final GameFactory GameFactory = new GameFactory();

    private void AddRoom(Room room){
        AvailableRoom.put(room.getId(), room);
    }

    Room GetRoom(int room_id) throws NoSuchRoomException {
        Room room = AvailableRoom.get(room_id);
        if(room!=null) return room;
        else throw new NoSuchRoomException();
    }

    List<Room> GetAvailableRooms(){
        return AvailableRoom.values().stream().limit(countOfReturningRooms).collect(Collectors.toList());
    }

    Room CreateNewRoom(User user) throws NoAvailableIDException {
        Room room = new Room(getNextFreeId(), user);
        AddRoom(room);
        return room;
    }

    void RemoveRoom(Room room){
        int room_id = room.getId();
        AvailableRoom.remove(room_id);

        freeID(room_id);
    }

    void StartRoom(int room_id) throws NoSuchRoomException {
        Game game = GameFactory.createGame(GetRoom(room_id));
        game.start();
        GameManager.getInstance().AddGame(game);
    }

}
