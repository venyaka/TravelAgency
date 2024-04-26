package kz.kstu.ilkov.coursework.util;

import kz.kstu.ilkov.coursework.config.Consts;
import kz.kstu.ilkov.coursework.entity.Client;
import kz.kstu.ilkov.coursework.entity.Tour;
import kz.kstu.ilkov.coursework.entity.TourAgent;
import kz.kstu.ilkov.coursework.service.impl.ClientServiceImpl;
import kz.kstu.ilkov.coursework.service.impl.FileServiceImpl;
import kz.kstu.ilkov.coursework.service.impl.TourServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static ClientServiceImpl clientService = new ClientServiceImpl();
    private static TourServiceImpl tourService = new TourServiceImpl();
    private static FileServiceImpl fileService = new FileServiceImpl();
    public static void start() {
        ArrayList<Tour> tourList = Generator.generateTours(2);
        ArrayList<Client> clientList = Generator.generateClients();
        TourAgent tourAgent = new TourAgent();

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println(
                    "Меню:" + "\n"
             + "1. Вывести список всех Туров" + "\n"
             + "2. Вывести список всех Клиентов" + "\n"
             + "3. Сериализовать клиента" + "\n"
             + "4. Десериализовать клиента" + "\n"
             + "5. Клонировать клиента" + "\n"
             + "6. Купить тур" + "\n"
             + "7. Пометить тур Горящим" + "\n"
             + "8. Выход" + "\n"
            );
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Reporter.print(tourList);
                    break;
                case 2:
                    Reporter.printClients(clientList);
                    break;
                case 3:
                    System.out.print("Выберите пользователя: ");
                    Reporter.printClients(clientList);
                    Long clientId = scanner.nextLong();
                    tourAgent.writeClientsFile(clientService.findClientById(clientList, clientId));
                    break;
                case 4:
                    System.out.println(tourAgent.readClientsFile());
                    break;
                case 5:
                    System.out.print("Выберите пользователя: ");
                    Reporter.printClients(clientList);
                    clientId = scanner.nextLong();
                    Client cloneClient = tourAgent.cloneClient(clientService.findClientById(clientList, clientId));
                    cloneClient.setId(Consts.newClientId());
                    clientList.add(cloneClient);
                    System.out.println(cloneClient);
                    break;
                case 6:
                    System.out.print("Выберите пользователя: ");
                    Reporter.printClients(clientList);
                    clientId = scanner.nextLong();

                    System.out.print("Выберите тур: ");
                    Reporter.print(tourList);
                    int tourtId = scanner.nextInt();

                    clientList.get(clientId.intValue()).buyTour(tourService.findById(tourList, tourtId));
                    break;
                case 7:
                    System.out.print("Выберите тур: ");
                    Reporter.print(tourList);
                    tourtId = scanner.nextInt();
                    tourAgent.makeTourIsFire(tourService.findById(tourList, tourtId));
                    break;
                case 8:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Некорректный ввод.");
            }
        } while (choice != 8);
    }
}

