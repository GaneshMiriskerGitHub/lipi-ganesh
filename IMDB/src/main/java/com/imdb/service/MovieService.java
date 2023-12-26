package com.imdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.imdb.entity.Movie;
import com.imdb.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;
	

	public String addMovie(@RequestBody Movie movie) throws Exception {
		movieRepository.save(movie);
		return "new movie is successfully added";
	}


	public List<Movie> getAllMovies() throws Exception {
		return movieRepository.findAll();
	}

	
	public Movie getMovieById(Integer id) throws Exception {
		return movieRepository.findById(id).orElseThrow();
	}

	
	public String deleteMovieById(Integer id) throws Exception {
		movieRepository.deleteById(id);
		return "movie is deleted";
	}

	
	public String updateMovie(@RequestBody Movie movie) throws Exception {
		int did = movie.getMovieId();
		movieRepository.deleteById(did);
		movie.setMovieId(did);
		movieRepository.save(movie);
		return "movie is updated";
	}


	public List<Movie> getMovieByTitle(String title) throws Exception {
		return movieRepository.getMovieByTitle(title);
	}

	
	
}
