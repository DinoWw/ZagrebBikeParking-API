package hr.bikeapp.be.comm;

class PinNotFoundException extends RuntimeException {
	PinNotFoundException(Long id) {
		super("Could not find pin " + id);
	}
}
