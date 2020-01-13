package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity(name = "ItemEntity")
@Table(name = "item")
//@NamedQuery(name = "ItemEntity.deleteAllRows", query = "DELETE from ItemEntity ")
public class ItemEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public ItemEntity() {
    }


    public ItemEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemEntity)) return false;
        ItemEntity item = (ItemEntity) o;
        return
                Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
