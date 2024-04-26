package kz.kstu.ilkov.coursework.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class User implements Cloneable {
    private Long id;
    private String name;
    private String surname;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
