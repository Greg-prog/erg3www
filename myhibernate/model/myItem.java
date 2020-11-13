package myhibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class myItem implements Serializable {
    private static final long serialVersionUID = 1L ;

    @Id
    @Column(name="items_id")
    private String items_id;

    @Column(name = "item_name")
    private String item_name;

    @Column(name = "item_color")
    private String item_color;

    @Column(name = "item_description")
    private String item_description;


    public void setBarcode(String items_id)    {
        this.items_id =items_id;
    }
    public String getBarcode() {
        return items_id;
    }
    public String getName() {
        return item_name;
    }
    public void setName(String item_name) {
        this.item_name =item_name;
    }
    public String getColor() {
        return item_color;
    }
    public void setColor(String item_color) {
        this.item_color = item_color;
    }
    public String getDescription() {
        return item_description;
    }
    public void setDescription(String item_description) {
        this.item_description = item_description;
    }
}