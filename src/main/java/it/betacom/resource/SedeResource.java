package it.betacom.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import it.betacom.model.Sede;
import it.betacom.service.SedeService;

@Path("sedi")
public class SedeResource {

	private SedeService sedeService = new SedeService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSedes() {
		// caricamento dati
		List<Sede> sedi = sedeService.findAll();
		if (!sedi.isEmpty())
			return Response.ok(sedi).build(); // 200
		else
			return Response.status(Response.Status.NOT_FOUND).build(); // 404 NOT FOUND
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSedeById(@PathParam("id") long id) {
		Sede sede = null;
		try {
			sede = sedeService.fetch(id);
			return Response.ok(sede).build();
		} catch (NotFoundException e) {
			JSONObject message = new JSONObject();
			message.put("message", e.getMessage());
			return Response.status(Response.Status.NOT_FOUND).entity(message.toString()).build();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createSede(Sede sede) {
		boolean result = sedeService.create(sede);
		if(result) 
			return Response.ok().status(Response.Status.CREATED).build();
		
		return Response.notModified().build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSede(@PathParam("id") long id, Sede sede) {
		if (id != sede.getId()) 
			return Response.notModified().build();
		
		boolean result = sedeService.update(sede);
		if(result) 
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		
		return Response.notModified().build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteSede(@PathParam("id") long id) {
		
		boolean result = sedeService.delete(id);
		if(result) 
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		
		return Response.notModified().build();
	}
}
