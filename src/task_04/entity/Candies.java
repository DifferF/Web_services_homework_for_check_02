package task_04.entity;

public class Candies {

   private String art;
   private String weight;
   private String shelf_life;
   private String price;
   private String title;
   private String trademark;

    public Candies(String art, String weight, String shelf_life, String price, String title, String trademark) {
        this.art = art;
        this.weight = weight;
        this.shelf_life = shelf_life;
        this.price = price;
        this.title = title;
        this.trademark = trademark;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getShelf_life() {
        return shelf_life;
    }

    public void setShelf_life(String shelf_life) {
        this.shelf_life = shelf_life;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }
}
