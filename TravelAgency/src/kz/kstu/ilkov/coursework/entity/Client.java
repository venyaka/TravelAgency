package kz.kstu.ilkov.coursework.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client extends User implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private int discount;
    private int countOfBuysTours;
    private List<Tour> tours = new ArrayList<>();
    public String login;

    private transient String password;
    private static final long SerialVersionUID = 1L;

    public boolean buyTour(Tour tour) {
        if (tours.contains(tour))
            return false;

        tours.add(tour);
        countOfBuysTours++;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result;
        return result;
    }

    @Override
    public String toString() {
        return "Пользователь: " + "\n"
                + "Id: " + this.id + "\n"
                + "Имя: " + this.name + "\n"
                + "Фамилия: " + this.surname + "\n"
                + "Количество купленных туров: " + this.countOfBuysTours + "\n"
                + "Скидка на туры: " + this.discount + "%" + "\n"
                + "password: " + this.password + "\n"
                + "login: " + this.login + "\n"
                + "Туры: " + this.tours + "\n\n";
    }

    @Override
    public Client clone() {
        Client client = new Client();
        client.setId(id);
        client.setName(name);
        client.setSurname(surname);
        client.setCountOfBuysTours(countOfBuysTours);
        client.setDiscount(discount);
        client.setLogin(login);
        client.setPassword(password);
        client.setTours(tours);
        return client;
    }
}
