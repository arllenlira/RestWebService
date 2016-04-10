package rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import rest.model.City;
import rest.model.DistanceVO;
import rest.service.DistanceService;
import rest.service.DistanceServiceImpl;


@Path("/city")
public class CityResource {
    
    private final static String NAME = "name";
    private final static String LATITUDE = "latitude";
    private final static String LONGITUDE = "longitude";
    
    private final static double KM = 1000; //meters
    private final static double MILES_CONVERSION = 0.6214; //km
            
    private City city = new City(1, "Manaus", "1.000", "1.000");
    
    DistanceService distanceService = new DistanceServiceImpl();

    @Context
    UriInfo uriInfo;
 
    @Context
    Request request;
     
    @GET
    @Path("calculateJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public DistanceVO calculateDistanceJSON(@QueryParam("city1") String city1, @QueryParam("city2") String city2, @QueryParam("response") String response) {
        
        DistanceVO distanceValue=null;
        
        if(city1 == null || city2 ==null){
            System.out.println("Empty value for first or second city.");
            return distanceValue;
        }else{
            
            distanceValue = new DistanceVO();
            
            double distanceKM = distanceService.distanceCitiesMetersByName(city1, city2) / KM; //converting to km
            
            distanceValue.setCity1(city1);
            distanceValue.setCity2(city2);
            distanceValue.setDistanceKM(distanceKM);
            distanceValue.setDistanceMiles(distanceKM * MILES_CONVERSION); //converting to miles
            
        } 
        
        return distanceValue;

    }
    
    @GET
    @Path("calculateXML")
    @Produces(MediaType.APPLICATION_XML)
    public DistanceVO calculateDistanceXML(@QueryParam("city1") String city1, @QueryParam("city2") String city2, @QueryParam("response") String response) {
        
        DistanceVO distanceValue=null;
        
        if(city1 == null || city2 ==null){
            System.out.println("Empty value for first or second city.");
            return distanceValue;
        }else{
            
            distanceValue = new DistanceVO();
            
            double distanceKM = distanceService.distanceCitiesMetersByName(city1, city2) / KM; //converting to km
            
            distanceValue.setCity1(city1);
            distanceValue.setCity2(city2);
            distanceValue.setDistanceKM(distanceKM);
            distanceValue.setDistanceMiles(distanceKM * MILES_CONVERSION); //converting to miles
            
        } 
        
        return distanceValue;

    }


    @GET
    @Path("distanceMiles")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateDistanceMilesKM(@QueryParam("city1") String city1, @QueryParam("city2") String city2, @QueryParam("unit") String unit) {
        
        double distanceKM = 0.0;
        String distanceValue = "";
        
        if(city1 == null || city2 ==null){
            System.out.println("Empty value for first or second city.");
            return "";
        }else{
            distanceKM = distanceService.distanceCitiesMetersByName(city1, city2) / KM; //converting to km
         }

        if(unit != null){

            if(unit.toLowerCase().equals("mi")){
                distanceValue = String.valueOf(distanceKM * MILES_CONVERSION);
            }
            
            if(unit.toLowerCase().equals("km")){
                distanceValue = String.valueOf(distanceKM);
            }
            
        }        
        
        return distanceValue; 
    }
    
    @GET
    @Path("sample")
    @Produces(MediaType.APPLICATION_JSON)
    public City getSampleCity() {
         
        System.out.println("Returning sample city: " + city.getName() +  "Latitude: " +
        city.getLatitude() + " / " + "Longitude: " + city.getLongitude());
         
        return city;
    }
         
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public City postCity(MultivaluedMap<String, String> cityParams) {
         
        String name = cityParams.getFirst(NAME);
        String latitude = cityParams.getFirst(LATITUDE);
        String longitude = cityParams.getFirst(LONGITUDE);
         
        System.out.println("Storing posted " + name + " " + latitude + "  " + longitude);
         
        city.setName(name);
        city.setLatitude(latitude);
        city.setLongitude(longitude);
         
        System.out.println("city info: " + city.getName() + " " + city.getLatitude() + " " + city.getLongitude());
         
        return city;
                         
    }

}
