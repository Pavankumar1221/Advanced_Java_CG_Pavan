package in.cg.dto;

import java.util.List;

public class PassengerCarResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;

    private List<CarRentalDTO> cars;

    private String message;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public List<CarRentalDTO> getCars() { return cars; }
    public void setCars(List<CarRentalDTO> cars) { this.cars = cars; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}