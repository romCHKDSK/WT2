package domain;
public class Product {
    private String info;
    private String name;
    private int price;
    private String material;
    private String color;
    private int voltage;

    public Product(String info, String name, int price, String material, String color, int voltage) {
        setInfo(info);
        setName(name);
        setPrice(price);
        setMaterial(material);
        setColor(color);
        setVoltage(voltage);
    }


    /** 
     * Converts the object to it's string representation
     * @return String String representation of the object
     */
    @Override
    public String toString() {
        return String.format("%s %s %d$ %s %s %dv", info, name, price, material, color, voltage);
    }

    /**
     * Get product's information
     * @return String Product's information
     */
    public String getInfo() {
        return info;
    }

    /**
     * Set product's information
     * @param info Product's new information
     */
    public void setInfo(String info) {
        this.info = info;
    }

    
    /** 
     * Get product's name
     * @return String product's name
     */
    public String getName() {
        return name;
    }

    
    /** 
     * Set product's name
     * @param name Product's new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get product's price
     * @return int Product's price
     */
    public int getPrice() {
        return price;
    }

    /** 
     * Set product's price
     * @param price Product's new price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /** 
     * Get product's material
     * @return String Product's material
     */
    public String getMaterial() {
        return material;
    }
    
    /** 
     * Set product's material
     * @param material Product's new material
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Get product's color
     * @return String Product's color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set product's color
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Get product's working voltage
     * @return int Product's working voltage
     */
    public int getVoltage() {
        return voltage;
    }

    
    /**
     * Set product's working voltage
     * @param voltage Product's working voltage
     */
    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
}

