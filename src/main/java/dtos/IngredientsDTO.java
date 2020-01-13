package dtos;

import entities.IngredientEntity;

import java.util.Objects;

public class IngredientsDTO {
    private String itemName;
    private int amount;

    public IngredientsDTO(IngredientEntity ingredient) {
        this.itemName = ingredient.getItem().getName();
        this.amount = ingredient.getAmount();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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
        if (!(o instanceof IngredientsDTO)) return false;
        IngredientsDTO that = (IngredientsDTO) o;
        return
                amount == that.amount &&
                Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, amount);
    }

    @Override
    public String toString() {
        return "IngredientsDTO{" +
                "itemName='" + itemName + '\'' +
                ", itemPricePrKg="  +
                ", itemStorage="  +
                ", amount=" + amount +
                '}';
    }
}
