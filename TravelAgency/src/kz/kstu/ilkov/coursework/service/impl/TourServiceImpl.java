package kz.kstu.ilkov.coursework.service.impl;

import kz.kstu.ilkov.coursework.entity.Tour;
import kz.kstu.ilkov.coursework.service.TourService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TourServiceImpl implements TourService {
    public Tour findById(List<Tour> tourList, long id) {
        for (Tour tour : tourList)
            if (tour.getId() == id)
                return tour;
        return null;
    }

    public ArrayList<Tour> findByRegEx(List<Tour> tourList, String regex) {
        ArrayList<Tour> toursWithRegex = new ArrayList<>();
        for (Tour tour : tourList) {
            String tourDescription = tour.getDescription();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(tourDescription);
            while (matcher.find()) {
                toursWithRegex.add(tour);
                break;
            }
        }
        return toursWithRegex;
    }

    public ArrayList<Tour> replaceNameByRegEx(List<Tour> tourList, String regex, String replacement) {
        ArrayList<Tour> tours = new ArrayList<>();
        for (Tour tour : tourList) {
            if (tour.getName().contains(regex)) {
                StringBuilder tourName = new StringBuilder(tour.getName().replaceAll(regex, replacement));
                tourName.append(" (Изменено)");
                tour.setName(tourName.toString());
                tours.add(tour);
            }
        }
        return tours;
    }
}