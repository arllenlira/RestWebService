package rest.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import rest.model.Contact;
import rest.service.ContactService;
import rest.service.ContactServiceImpl;


@Path("/contact")
public class ContactResource {
    
    ContactService contactService = new ContactServiceImpl();

    @Context
    UriInfo uriInfo;
 
    @Context
    Request request;    
     
    @GET
    @Path("contactsJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> contactListJSON(@QueryParam("response") String response) {        
        List<Contact> listContact = new ArrayList<Contact>();
        
        listContact = contactService.getContactList();
        
        return listContact;
    }
    
    @GET
    @Path("contactsXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Contact> contactListXML(@QueryParam("response") String response) {        
        List<Contact> listContact = new ArrayList<Contact>();
        
        listContact = contactService.getContactList();
        
        return listContact;
    }

}
