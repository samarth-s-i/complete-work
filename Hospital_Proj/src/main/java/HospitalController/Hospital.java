package HospitalController;

public class Hospital {
	private int id;
	private String name;
	private String founder;
	private long gst;
	private int year;
	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", founder=" + founder + ", gst=" + gst + ", year=" + year
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder;
	}

	public long getGst() {
		return gst;
	}

	public void setGst(long gst) {
		this.gst = gst;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
