package in.cg.beans;

public class Address {

    private int houseNo;
    private String streetName;
    private String cityName;

    public Address(int houseNo, String streetName, String cityName) {
    	this.houseNo=houseNo;
    	this.streetName=streetName;
    	this.cityName=cityName;
    }

    public void display() {
        System.out.println(houseNo + " " + streetName + " " + cityName);
    }
}