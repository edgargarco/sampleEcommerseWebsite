package spring.jpa.example.model;

import spring.jpa.example.model.generics.Color;
import spring.jpa.example.model.generics.Tag;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String title;
    @NotNull
    private int quantityInStock;
    private int quantitySold;
    @NotNull
    private double price;
    @NotEmpty
    private String brand;

    private String model;
    @NotEmpty
    private String dimensions;
    @NotEmpty
    private String material;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String imageUrl;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Tag> tagList;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Color> colorList;



    public Product() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<Color> getColorList() {
        return colorList;
    }

    public void setColorList(List<Color> colorList) {
        this.colorList = colorList;
    }

    public void addColor(Color color){
        if (colorList == null){
            colorList = new ArrayList<>();
        }
        boolean exist = false;
        for (Color colorAux: colorList) {
            if (colorAux.getColor().equalsIgnoreCase(color.getColor())){
                exist = true;
                break;
            }
        }
        if (!exist){
            colorList.add(color);
        }
    }
    public void addTag(Tag tag){
        if (tagList == null){
            tagList = new ArrayList<>();
        }
        boolean exist = false;
        for (Tag tagAux: tagList) {
            if (tagAux.getTag().equalsIgnoreCase(tag.getTag())){
                exist = true;
                break;
            }
        }
        if (!exist){
            tagList.add(tag);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", quantitySold=" + quantitySold +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", dimensions='" + dimensions + '\'' +
                ", material='" + material + '\'' +
               // ", colorList=" + colorList +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", tagList=" + tagList +
                '}';
    }
}
