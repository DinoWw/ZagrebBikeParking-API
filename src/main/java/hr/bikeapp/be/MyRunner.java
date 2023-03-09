package hr.bikeapp.be;

/*
import hr.bikeapp.be.comm.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    private final PinRepository repository;

    public MyRunner(PinRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        repository.save(new Pin("Pin1", "DinoWw", 12.3, 1234.23333));
        repository.save(new Pin("Pin2", "DinoWw", 124, 2.2345));
        repository.save(new Pin("Pin3", "DinoWw", 123.45, 13.34));
        repository.save(new Pin("Pin4", "DinoWw", 13.3532, 541.123));
        repository.save(new Pin("Pin3", "DinoWw", 9.341, 84.24));

        repository.findAll().forEach((city) -> {
            logger.info("{}", city);
        });
    }
}

/*

@Bean
public CommandLineRunner demo(PinRepository pinRepository) {
	return (args) -> {
		// save a few customers
		pinRepository.save(new Pin("Pin1", "DinoWw", 12.3, 1234.23333));
		pinRepository.save(new Pin("Pin2", "DinoWw", 124, 2.2345));
		pinRepository.save(new Pin("Pin3", "DinoWw", 123.45, 13.34));
		pinRepository.save(new Pin("Pin4", "DinoWw", 13.3532, 541.123));
		pinRepository.save(new Pin("Pin3", "DinoWw", 9.341, 84.24));

		// fetch all customers
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Pin customer : pinRepository.findAll()) {
			log.info(customer.toString());
		}
		log.info("");

		// fetch an individual customer by ID
		Pin pin = pinRepository.findById(1);
		log.info("Customer found with findById(1):");
		log.info("--------------------------------");
		log.info(pin.toString());
		log.info("");

		// fetch customers by last name
		log.info("Customer found with findByLastName('Bauer'):");
		log.info("--------------------------------------------");
		pinRepository.findByTitle("Pin3").forEach(bauer -> {
			log.info(bauer.toString());
		});
		// for (Customer bauer : repository.findByLastName("Bauer")) {
		// log.info(bauer.toString());
		// }
		log.info("");
	};
}
*/