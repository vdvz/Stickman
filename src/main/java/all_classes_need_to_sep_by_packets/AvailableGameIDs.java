package all_classes_need_to_sep_by_packets;

public class AvailableGameIDs {

    private static final int MAX_IDS = 1000;
    private static int[] IDS = new int[MAX_IDS];

    public static synchronized int getFreeID(){
        return 0;
    }

    public static synchronized void freeID(int id){

    }
}
