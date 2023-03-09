package hr.bikeapp.be.comm;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PinRepository extends JpaRepository<Pin, Long> {

	List<Pin> findByCoordXBetweenAndCoordYBetween(double startCoordX, double endCoordX, double startCoordY, double endCoordY);
  //List<Pin> findByTitle(String title);

  //Pin findById(long id);
}