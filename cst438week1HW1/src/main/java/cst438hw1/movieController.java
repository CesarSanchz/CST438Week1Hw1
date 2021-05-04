package cst438hw1;


import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class movieController {
	
	@Autowired
	movieRepo movieRepo;
	
	
	@GetMapping("/movies")
	public String getAllMovies(Model model) {
		List<movieRate>  movie_list = movieRepo.findAllMovieRatingsOrderByTitleDateDesc(); 
		model.addAttribute("movieRate", movie_list);
		
		return "movies_list";
	}
	
	@GetMapping("/movies/new")
	public String createMovie(Model model) {
		movieRate movieRate = new movieRate();
		model.addAttribute("movieRate", movieRate);
		return "movie_form";
	}
	
	@PostMapping("/movies")
	public String processMovieForm(@Valid movieRate movieRate, BindingResult result, Model modle) {
		
		if(result.hasErrors()) {
			System.out.print("Error");
			return "movie_form";
		}
		movieRate.setTime(new java.util.Date().toString());
		movieRepo.save(movieRate);
		
		return "movie_show";
	}

}