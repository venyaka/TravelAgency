package kz.kstu.ilkov.coursework.config;

public class Consts {
    private static long tourId = 0;
    public static long newTourId() {
        tourId = tourId + 1;
        return tourId;
    }

    private static long clientId = 0;
    public static long newClientId() {
        clientId = clientId + 1;
        return clientId;
    }
}
