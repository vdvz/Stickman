import exceptions.NoAvailableIDException;
import exceptions.NoSuchRoomException;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lobby implements Updatable_I{
    final int countOfReturningRooms = 10;
    static final int maxIdRoom = 5000;
    private static final Lobby Instance = new Lobby();
    public static Lobby getInstance(){ return Instance;}
    private  Lobby(){
        IntStream.range(0, maxIdRoom).boxed().forEach(IDS::add);
    }

    static final ArrayBlockingQueue<Integer> IDS = new ArrayBlockingQueue(maxIdRoom);

    private static int getNextFreeId() throws NoAvailableIDException {
        if(IDS.isEmpty()) throw new NoAvailableIDException();
        return IDS.poll();
    }
    private static void freeID(int id){
        IDS.add(id);
    }

    private final Map<Integer, Room> AvailableRoom = new ConcurrentHashMap<>();

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

    @Override
    public void update() {
        AvailableRoom.entrySet().stream().filter(e -> e.getValue().getStatus().equals(ROOM_STATUS.FOR_DELETE))
                .forEach(e->RemoveRoom(e.getValue()));
    }
}
