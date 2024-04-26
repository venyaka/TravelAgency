package kz.kstu.ilkov.coursework.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tour implements Comparable<Tour>, Comparator<Tour> {
    private long id;
    private String name;
    private String type;
    private String description;
    private int duration;
    private String countryOfDeparture;
    private String countryOfArrival;
    private String transportType;
    private Double rating;
    private Date date;
    private int price;
    private boolean fire;

    @Override
    public String toString() {
        return this.name + ":" + "\n"
                + "Id: " + this.id + "\n"
                + "Тип тура: " + this.type + "\n"
                + "Описание: " + description.substring(0, 100) + "..." + "\n"
                + "Страна отправления: " + this.countryOfDeparture + "\n"
                + "Страна прибытия: " + this.countryOfArrival + "\n"
                + "Длительность тура (дней): " + this.duration + "\n"
                + "Тип транспорта: " + this.transportType + "\n"
                + "Дата: " + (this.date.getDay() < 10 ? "0" + this.date.getDay() : this.date.getDay()) + "." + (this.date.getMonth() < 10 ? "0" + this.date.getMonth() : this.date.getMonth()) + "." + this.date.getYear() + "\n"
                + "Рейтинг: " + new DecimalFormat("#0.0").format(this.rating) + "\n"
                + "Горящий тур: " + (this.fire ? "Да" : "Нет") + "\n"
                + "Цена: " + this.price + " тг" + "\n\n\n";
    }

    @Override
    public int compare(Tour o1, Tour o2) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tour tour = (Tour) o;

        return Objects.equals(id, tour.id);
    }

    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        result = 31 * result + (int) id;
        return result;
    }

    @Override
    public int compareTo(Tour tour) {
        return this.rating.compareTo(tour.rating);
    }
}
