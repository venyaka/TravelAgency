package kz.kstu.ilkov.coursework.util;

import kz.kstu.ilkov.coursework.config.Consts;
import kz.kstu.ilkov.coursework.entity.Client;
import kz.kstu.ilkov.coursework.entity.Tour;
import kz.kstu.ilkov.coursework.service.impl.ClientServiceImpl;
import kz.kstu.ilkov.coursework.service.impl.FileServiceImpl;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
public class Generator {
    private static ClientServiceImpl clientService = new ClientServiceImpl();
    private static FileServiceImpl fileService = new FileServiceImpl();

    public static ArrayList<Tour> generateTours(int countOfTour) {
        ArrayList<Tour> tourList = new ArrayList<>();

        for (int i = 0; i < countOfTour; i++) {
            tourList.add(generateTour());
        }
        return tourList;
    }

    public static ArrayList<Client> generateClients() {
        ArrayList<Client> clientList = new ArrayList<>();
        List<List<String>> nameList = fileService.readAllClient();

        for (int i = 0; i < nameList.size(); i++) {
            List<String> names = nameList.get(i);
            clientList.add(clientService.createClient(names.get(0), names.get(1)));
        }
        return clientList;
    }

    public static Tour generateTour() {
        Random random = new Random();
        Tour tour = new Tour();
        List<String> transportTypes = fileService.readAllTransportType();
        List<String> countryNames = fileService.readAllCountry();
        List<String> tourTypes = fileService.findAllTourType();

        tour.setId(Consts.newTourId());

        int randomOfCountries = random.nextInt(countryNames.size());
        String countryOfArrival = countryNames.get(randomOfCountries);
        String countryOfDeparture = countryNames.get(random.nextInt(countryNames.size()));

        if (countryOfDeparture.equals(countryOfArrival))
            if (randomOfCountries < countryNames.size() - 1)
                countryOfDeparture = countryNames.get(randomOfCountries + 1);
            else
                countryOfDeparture = countryNames.get(randomOfCountries - 1);

        tour.setCountryOfArrival(countryOfArrival);
        tour.setCountryOfDeparture(countryOfDeparture);
        tour.setName("Тур в " + countryOfArrival);
        tour.setDescription(fileService.readDescriptionByCountry(countryOfArrival));

        String transportType = transportTypes.get(random.nextInt(3));
        tour.setTransportType(transportType);

        String tourType = tourTypes.get(random.nextInt(3));
        tour.setType(tourType);

        tour.setDuration(random.nextInt(6, 12));

        Date date = new Date(random.nextInt(2024, 2025), random.nextInt(4, 12), random.nextInt(1, 30));
        tour.setDate(date);

        tour.setRating(random.nextDouble(2.0, 5.0));
        tour.setPrice(random.nextInt(80, 120) * 1000);

        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        if (currentDate.getMonth() == date.getMonth())
            tour.setFire(false);
        return tour;
    }
}
