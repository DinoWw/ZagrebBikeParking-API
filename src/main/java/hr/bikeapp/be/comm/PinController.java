package hr.bikeapp.be.comm;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PinController {

	private final PinRepository repository;

	PinController(PinRepository repository) {
		this.repository = repository;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/pins")
	List<Pin> all() {
		return repository.findAll();
	}

	@GetMapping("/pins/within")
	List<Pin> allWithin(@RequestParam String centerX, @RequestParam String centerY, @RequestParam String distance) {

		double cX = Double.parseDouble(centerX);
		double cY = Double.parseDouble(centerY);
		double d = Double.parseDouble(distance);

		return repository.findByCoordXBetweenAndCoordYBetween(cX - d, cX + d, cY - d, cY + d);
	}
	// end::get-aggregate-root[]

	@PostMapping("/pins")
	Pin newEmployee(@RequestBody Pin newPin) {
		return repository.save(newPin);
	}

	// Single item

	@GetMapping("/pins/{id}")
	Pin one(@PathVariable Long id) {

		return repository.findById(id).orElseThrow(() -> new PinNotFoundException(id));
	}

	@PutMapping("/pins/{id}")
	Pin replaceEmployee(@RequestBody Pin newPin, @PathVariable Long id) {

		return repository.findById(id).map(employee -> {
			employee.setTitle(newPin.getTitle());
			employee.setAuthor(newPin.getAuthor());
			employee.setApproved(newPin.getApproved());
			employee.setPosX(newPin.getPosX());
			employee.setPosY(newPin.getPosY());
			return repository.save(employee);
		}).orElseGet(() -> {
			newPin.setId(id);
			return repository.save(newPin);
		});
	}

	@DeleteMapping("/pins/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}