package com.imdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imdb.entity.Movie;
import com.imdb.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@GetMapping("/")
	public String greetUser(@RequestParam("name") String name) {
		return "Hi " + "lipiee😊 " + name;
	}

	@PostMapping("movie/addMovie")
	public String addMovie(@RequestBody Movie movie) throws Exception {
		System.out.println("********* controller class ***********");
		return movieService.addMovie(movie);
	}

	@GetMapping("/movie/getAllMovies")
	public List<Movie> getAllMovies() throws Exception {
		return movieService.getAllMovies();
	}

	@GetMapping("/movie/getMovieById/{id}")
	public Movie getMovieById(@PathVariable("id") Integer id) throws Exception {
		return movieService.getMovieById(id);
	}

	@GetMapping("/movie/deleteById/{id}")
	public String deleteMovieById(@PathVariable("id") Integer id) throws Exception {
		return movieService.deleteMovieById(id);
	}

	@PostMapping("/movie/updateMovie")
	public String updateMovie(@RequestBody Movie movie) throws Exception {
		return movieService.updateMovie(movie);
	}

	@GetMapping("/movie/getMovieByTitle/{title}")
	public List<Movie> getMovieByTitle(@PathVariable("title") String title) throws Exception {
		return movieService.getMovieByTitle(title);
	}

}
