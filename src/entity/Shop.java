
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Shop implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private int income;
    private int countPurchases;

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getCountPurchases() {
        return countPurchases;
    }

    public void setCountPurchases(int countPurchases) {
        this.countPurchases = countPurchases;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
