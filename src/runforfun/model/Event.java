package runforfun.model;

import java.util.Date;

public class Event {
	
	public enum SportType {
		RUNING
	}
	
	private String location;
	private String website;
	private String results_page;
	private String name;
	private Date date;
	private SportType type;
	private String entries;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getResults_page() {
		return results_page;
	}
	public void setResults_page(String results_page) {
		this.results_page = results_page;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public SportType getType() {
		return type;
	}
	public void setType(SportType type) {
		this.type = type;
	}
	public String getEntries() {
		return entries;
	}
	public void setEntries(String entries) {
		this.entries = entries;
	}
}
