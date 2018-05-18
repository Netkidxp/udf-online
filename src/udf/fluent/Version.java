package udf.fluent;

public class Version {
	@Override
	public String toString() {
		return Ver;
	}
	public String getVer() {
		return Ver;
	}
	public void setVer(String ver) {
		Ver = ver;
	}
	public String getLibRelease() {
		return LibRelease;
	}
	public void setLibRelease(String libRelease) {
		LibRelease = libRelease;
	}
	public String getRelease() {
		return Release;
	}
	public void setRelease(String release) {
		Release = release;
	}
	public Version(String ver, String libRelease, String release) {
		super();
		Ver = ver;
		LibRelease = libRelease;
		Release = release;
	}
	public Version() {
		// TODO Auto-generated constructor stub
	}
	private String Ver;
	private String LibRelease;
	private String Release;
}
