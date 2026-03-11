package com.example.Movie20.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Movie20.Model.Movie20;
import com.example.Movie20.repository.MovieRepository;

@Service
public class MovieService {

	private final MovieRepository mv;
	public MovieService (MovieRepository mv)
	{
		this.mv=mv;
	}
		public Movie20 saveMovie(Movie20 movie)
		{
			return mv.save(movie);
	}
		public List<Movie20> getAllMovies(){
			
			return mv.findAll();
		}
		public Movie20 getMvById(Long id)
		{
			return mv.findById(id).orElse(null);
}
		public Movie20 updateMv(Long id,Movie20 updateMovie) {
			Movie20 old=mv.findById(id).orElse(null);
			if(old!=null)
			{
				old.setTittle(updateMovie.getTittle());
				old.setDirector(updateMovie.getDirector());
				old.setYear(updateMovie.getYear());
				return mv.save(old);
			}
			return null;
		}
		public String deleteMv(Long id)
		{
		mv.deleteById(id);
		return "Movie Deleted "+id;
		}
}