package kz.kstu.ilkov.coursework.util;

import kz.kstu.ilkov.coursework.entity.Client;
import kz.kstu.ilkov.coursework.entity.Tour;
import kz.kstu.ilkov.coursework.exception.InvalidMinRaitingException;
import kz.kstu.ilkov.coursework.exception.InvalidTransportTypeException;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Comparator;

public class Reporter {
    public static <Tour> void print(ArrayList<Tour> tourList) {           // Без Выборки
        System.out.print("Cписок туров: \n");
        for (Tour tour : tourList)
            System.out.print(tour);
    }

    public static void print(ArrayList<Tour> tourList, Integer origin, Integer bound) {           // Выборка по цене (от и до)
        try {
            if (origin < 0 || bound < 0)
                throw new InvalidParameterException();

            for (Tour tour : tourList)
                if (tour.getPrice() >= origin && tour.getPrice() <= bound)
                    System.out.print(tour);
            }
        catch (InvalidParameterException e) {
            System.err.println(e + " Недопустимое значение параметра");
        }
    }

    public static void print(ArrayList<Tour> tourList, String transportType) {           // Выборка по типу транспорта
        try {
            boolean isEmpty = true;

            if (isEmpty)
                throw new InvalidTransportTypeException("Введен несуществующий тип транспорта");

            System.out.print("Список туров с типом транспорта '" + transportType + "': \n");
            for (Tour tour : tourList)
                if (tour.getTransportType().equals(transportType))
                    System.out.print(tour);
        }
        catch (InvalidTransportTypeException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void print(ArrayList<Tour> tourList, Double minRaiting) {           // Выборка по рейтингу
        try {
            if (minRaiting < 0 || minRaiting > 5)
                throw new InvalidMinRaitingException("Значение minRaiting не может быть меньше 0 или больше 5");

            System.out.print("Список туров с рейтингом не меньше " + minRaiting + ": \n");
            for (Tour tour : tourList)
                if (tour.getRating() >= minRaiting)
                    System.out.print(tour);
        }
        catch (InvalidMinRaitingException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void printClients(ArrayList<Client> clientList) {           // Без Выборки
        System.out.print("\nПолный список клиентов: \n\n");
        for (Client client : clientList)
            System.out.print(client);
    }

    public static ArrayList<Tour> sortByPrice(ArrayList<Tour> tourList) {           // Сортировка
        System.out.print("-------Сортировка туров по цене с использованием Компаратора (от меньшего к большему)-------");
        Comparator<Tour> comparator = Comparator.comparing(obj -> obj.getPrice());
        tourList.sort(comparator);
        return tourList;
    }
}
