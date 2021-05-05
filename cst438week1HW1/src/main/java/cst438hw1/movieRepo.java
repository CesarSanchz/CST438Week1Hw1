package cst438hw1;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface movieRepo  extends CrudRepository<movieRate, Long>{
	
	@Query("select m from movieRate m order by movie_name, time desc")
	List<movieRate> findAllMovieRatingsOrderByTitleDateDesc();

}
