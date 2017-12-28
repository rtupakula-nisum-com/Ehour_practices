package com.nisum.timesheets.rest.ro;

import com.nisum.timesheets.rest.domain.Location;
import com.nisum.timesheets.rest.domain.Region;


public class RestLocation {
	private String location;
	private String region;
	private String country;
	public RestLocation(Location o) {
		super();
		this.location = o.getLocationName();
		Region oRegion = o.getRegion();
		this.region = oRegion.getName();
		this.country = oRegion.getCountry().getCountryName();
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
