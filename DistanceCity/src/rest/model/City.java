package rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class City {
    
    private long id;
    private String name;
    private String longitude;
    private String latitude;
    
    public City() {
    }
    
    public City(long id, String name, String longitude, String latitude){
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    
    

}
