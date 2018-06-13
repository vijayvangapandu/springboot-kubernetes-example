package ops.inventory.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Path("/v1")
@Component
public class MoviesResource {

	public static final Logger logger = LoggerFactory.getLogger(MoviesResource.class);

	@POST
	@Path("user/{userId}/photos/{photoId}/presentation-order/{porder}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public void saveMovie(@PathParam("userId") final long userId,
			@PathParam("photoId") final long photoId,
			@PathParam("presentationOrder") int presentationOrder, 
			final @Context HttpHeaders httpHeaders) {

		
	}
	
	@GET
	@Path("/movies")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getMovies(final @Context HttpHeaders httpHeaders) {

		List<Movie> movies = new ArrayList<>();
		
		Movie movie1 = new Movie();
		movie1.name = "Star Wars3";
		movies.add(movie1);
		return movies;
	}
	
	@GET
	@Path("/movies/string")
    public String getMoviesStr(final @Context HttpHeaders httpHeaders) {

		return "Star Wars2";
	}
	
	class Movie {
		String name;
		String title;
		String actor;
	}
	
}
