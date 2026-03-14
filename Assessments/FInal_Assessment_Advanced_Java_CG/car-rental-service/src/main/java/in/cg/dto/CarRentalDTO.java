package in.cg.dto;

public class CarRentalDTO {

    private Long id;
    private String carName;
    private String carType;
    private double price;

    public CarRentalDTO() {}

    public CarRentalDTO(Long id, String carName, String carType, double price) {
        this.id = id;
        this.carName = carName;
        this.carType = carType;
        this.price = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCarName() { return carName; }
    public void setCarName(String carName) { this.carName = carName; }

    public String getCarType() { return carType; }
    public void setCarType(String carType) { this.carType = carType; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}