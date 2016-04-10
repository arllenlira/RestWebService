package rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DistanceVO {
    
    private String city1;
    private String city2;
    private double distanceKM;
    private double distanceMiles;
    
    public String getCity1() {
        return city1;
    }
    public void setCity1(String city1) {
        this.city1 = city1;
    }
    public String getCity2() {
        return city2;
    }
    public void setCity2(String city2) {
        this.city2 = city2;
    }    
    public double getDistanceKM() {
        return distanceKM;
    }
    public void setDistanceKM(double distanceKM) {
        this.distanceKM = distanceKM;
    }
    public double getDistanceMiles() {
        return distanceMiles;
    }
    public void setDistanceMiles(double distanceMiles) {
        this.distanceMiles = distanceMiles;
    }
    
}
