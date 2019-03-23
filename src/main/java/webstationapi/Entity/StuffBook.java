package webstationapi.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class StuffBook {

    private Long id;

    private int userId;

    private Long idStuff;

    private Double price;
}
