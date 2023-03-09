package hr.bikeapp.be.comm;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;

/**

* @author dinoWw

*

*/

@Entity
@Table(name = "pins")
public class Pin {
	
	@Id
	@GeneratedValue(
		strategy=GenerationType.AUTO, 
		generator="native"
	)
	@GenericGenerator(
	    name = "native",
	    strategy = "native"
	)
	private Long id;
	
	@Column(name="title", length=100, nullable=false, unique=false)
	private String title;
	
	@Column(name="author", length=100, nullable=true, unique=false)
	private String author;
	
	@Column(name="approved", nullable=true, unique=false)
	private boolean approved;
	
	@Column(name="coord_x", nullable=false, unique=false)
	private double coordX;
	
	@Column(name="coord_y", nullable=false, unique=false)
	private double coordY;
	
	// @Transient ako bi stvorio var koji sprema listu [x, y] za koordinate kako ju ne bi putao u db
	

	protected Pin() {}
/*
	public Pin(String title, String author, double[] pos) {
		this.title = title;
		this.author = author;
		this.coordX = pos[0];
		this.coordY = pos[1];
	}
*/
	public Pin(String title, String author, double coordX, double coordY) {
		this.title = title;
		this.author = author;
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	@Override
	public String toString() {
	  return String.format(
	      "Pin[id=%d, title='%s', author='%s', pos=['%f', '%f']]",
	      id, title, author, coordX, coordY);
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public boolean getApproved() {
		return approved;
	}
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	/*
	public double[] getPos() {
		double[] pos = {coordX, coordY};
		return pos;
	}
	public void setPos(double[] pos) {
		this.coordX = pos[0];
		this.coordY = pos[1];
	}
	*/
	
	public double getPosX() {
		return coordX;
	}
	public void setPosX(double coordX) {
		this.coordX = coordX;
	}
	public double getPosY() {
		return coordY;
	}
	public void setPosY(double coordY) {
		this.coordY = coordY;
	}
	


}






