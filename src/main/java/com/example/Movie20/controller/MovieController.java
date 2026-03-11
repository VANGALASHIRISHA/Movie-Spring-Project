package com.example.Movie20.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Movie20.Model.Movie20;
import com.example.Movie20.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	private final MovieService mvs;
	
	public MovieController(MovieService mvs)
	{
		this.mvs=mvs;
	}
	@PostMapping("/addMovie")
	public Movie20 saveMovie(@RequestBody Movie20 movie)
	{
		return mvs.saveMovie(movie);
	}
	
	@GetMapping("/list")
	public List<Movie20> getMv()
	{
	return mvs.getAllMovies();
	}
	@GetMapping("/{id}")
	public Movie20 getMvId(@PathVariable Long id)
	{
	return mvs.getMvById(id);
	}
	@PutMapping("/{id}")
	public Movie20 updateMovie(@PathVariable Long id,@RequestBody Movie20 mv)
	{
		return mvs.updateMv(id,mv);
	}
	@DeleteMapping("/{id}")
	
	public String deleteMovie(@PathVariable Long id)
	{
		return mvs.deleteMv(id);
	}
	
	
}

