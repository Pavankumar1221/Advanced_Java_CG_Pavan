package in.cg.beans;

public class Address {
	private int houseNo;
	private String streetName;
	private String cityName;
	
	
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
	public void display() {
		System.out.println(houseNo+" "+streetName+" "+cityName);
	}
	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", streetName=" + streetName + ", cityName=" + cityName + "]";
	}
	
	
	
	
}
