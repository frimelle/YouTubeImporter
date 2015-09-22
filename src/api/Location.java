package api;

public class Location {
	
	public Location (double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = 0;
	}
	
	private double latitude;
	private double longitude;
	private double altitude;

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getAltitude() {
		return altitude;
	}
}
