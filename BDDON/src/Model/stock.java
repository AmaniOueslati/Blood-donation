/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author amena
 */
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class stock implements Comparable<stock>{
    private  StringProperty typeSang;
    private  IntegerProperty quantite;

    public stock(String typeSang, int quantite) {
        this.typeSang = new SimpleStringProperty(typeSang);
        this.quantite = new SimpleIntegerProperty(quantite);
    }

    public String getTypeSang() {
        return typeSang.get();
    }

    public StringProperty getTypeSangProperty() {
        return typeSang;
    }

    public void setTypeSang(String typeSang) {
        this.typeSang.set(typeSang);
    }

    public int getQuantite() {
        return quantite.get();
    }

    public IntegerProperty getQuantiteProperty() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite.set(quantite);
    }

   @Override
public int compareTo(stock o) {
    return Integer.compare(this.quantite.get(), o.quantite.get());
}

}
