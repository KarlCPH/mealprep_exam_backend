package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "IngredientEntity")
@Table(name = "ingredient")
//@NamedQuery(name = "IngredientEntity.deleteAllRows", query = "DELETE from IngredientEntity ")
public class IngredientEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ingredient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private ItemEntity item;
    private int amount;

    public IngredientEntity() {
    }

    public IngredientEntity(ItemEntity item, int amount) {
        this.item = item;
        this.amount = amount;
    }




    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IngredientEntity)) return false;
        IngredientEntity that = (IngredientEntity) o;
        return amount == that.amount &&

                Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash( item, amount);
    }



}
