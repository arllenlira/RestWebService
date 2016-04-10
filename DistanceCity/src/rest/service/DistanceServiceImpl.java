package rest.service;

import rest.dao.DistanceCityDAO;
import rest.dao.DistanceCityDAOImpl;
import rest.model.City;

public class DistanceServiceImpl implements DistanceService{

    DistanceCityDAO dao = new DistanceCityDAOImpl();
    
    @Override
    public double distanceCitiesMetersByName(String city1, String city2) {
        
        City c1 = new City();
        City c2 = new City();
        
        c1 = dao.getByName(city1);
        c2 = dao.getByName(city2);
        
        double c1Latitude = Double.parseDouble(c1.getLatitude());
        double c1Longitude = Double.parseDouble(c1.getLongitude());

        double c2Latitude = Double.parseDouble(c2.getLatitude());
        double c2Longitude = Double.parseDouble(c2.getLongitude());
        
        
        double distanceC1C2 = distanceCitiesMeters(c1Latitude, c1Longitude, c2Latitude, c2Longitude); 
        return distanceC1C2;
    }

    
    private double distanceCitiesMeters(double lat1, double lon1, double lat2, double lon2) {
     
        // Radius of the earth km        
        final int R = 6371; 
     
        //Haversine algorithm to measure distances on the earth
        Double latDistance = deg2rad(lat2 - lat1);
        Double lonDistance = deg2rad(lon2 - lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters
     
        distance = Math.pow(distance, 2);
        return Math.sqrt(distance);
    }
     
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

}
