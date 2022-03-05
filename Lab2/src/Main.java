public class Main {
    public static void main(String[] args)
    {
        Event C1 = new Event("C1", 100, 8, 10);
        Event C2 = new Event("C2", 100, 10, 12);
        Event L1 = new Event("L1", 30, 8, 10);
        Event L2 = new Event("L2", 30, 8, 10);
        Event L3 = new Event("L3", 30, 10, 12);
        Room room401 = new Room("401",30, RoomType.computerlab);
        Room room403 = new Room("403",30, RoomType.computerlab);
        Room room405 = new Room("405",30, RoomType.computerlab);
        Room room309 = new Room("309",100, RoomType.lecturehall);
        System.out.println(C1);
        System.out.println(C2);
        System.out.println(L1);
        System.out.println(L2);
        System.out.println(L3);
        System.out.println(room401);
        System.out.println(room403);
        System.out.println(room405);
        System.out.println(room309);
    }
}
