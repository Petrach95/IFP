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

import it.betacom.model.Docente;
import it.betacom.service.DocenteService;

@Path("docenti")
public class DocenteResource {

	private DocenteService docenteService = new DocenteService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDocentes() {
		// caricamento dati
		List<Docente> docenti = docenteService.findAll();
		if (!docenti.isEmpty())
			return Response.ok(docenti).build(); // 200
		else
			return Response.status(Response.Status.NOT_FOUND).build(); // 404 NOT FOUND
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDocenteById(@PathParam("id") long id) {
		Docente docente = null;
		try {
			docente = docenteService.fetch(id);
			return Response.ok(docente).build();
		} catch (NotFoundException e) {
			JSONObject message = new JSONObject();
			message.put("message", e.getMessage());
			return Response.status(Response.Status.NOT_FOUND).entity(message.toString()).build();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createDocente(Docente docente) {
		boolean result = docenteService.create(docente);
		if(result) 
			return Response.ok().status(Response.Status.CREATED).build();
		
		return Response.notModified().build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateDocente(@PathParam("id") long id, Docente docente) {
		if (id != docente.getId()) 
			return Response.notModified().build();
		
		boolean result = docenteService.update(docente);
		if(result) 
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		
		return Response.notModified().build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteDocente(@PathParam("id") long id) {
		
		boolean result = docenteService.delete(id);
		if(result) 
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		
		return Response.notModified().build();
	}
}
