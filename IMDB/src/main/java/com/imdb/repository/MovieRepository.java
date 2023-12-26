package com.imdb.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.imdb.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	@Query("SELECT m FROM Movie m WHERE LOWER(m.title) = LOWER(:title)")
	public List<Movie> getMovieByTitle(String title) throws Exception;

}
