package kz.kstu.ilkov.coursework.entity;

import java.io.*;

public class TourAgent extends User {
    public void writeClientsFile(Client client) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Externals.out"));
            out.writeObject(client);
            out.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public Client readClientsFile() {
        Client client = new Client();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Externals.out"));
            client = (Client) in.readObject();
        }
        catch (ClassNotFoundException | IOException e) {
            System.err.println(e);
        }
        return client;
    }

    public void makeTourIsFire(Tour tour) {
        tour.setFire(true);
    }

    public void setClientDiscount(Client client, int discount) {
        client.setDiscount(discount);
    }

    public Client cloneClient(Client client) {
        return (Client) client.clone();
    }
}
