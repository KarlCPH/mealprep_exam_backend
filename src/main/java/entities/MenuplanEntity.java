package entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
//@NamedQuery(name = "MenuplanEntity.deleteAllRows", query = "DELETE from MenuplanEntity")
public class MenuplanEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToMany(cascade = CascadeType.PERSIST)
    private Long id;
    private String shoppingList;
    private String listOfDayplans;

    public MenuplanEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(String shoppingList) {
        this.shoppingList = shoppingList;
    }

    public String getListOfDayplans() {
        return listOfDayplans;
    }

    public void setListOfDayplans(String listOfDayplans) {
        this.listOfDayplans = listOfDayplans;
    }
}
