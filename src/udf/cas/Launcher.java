package udf.cas;
import udf.common.*;
public class Launcher {
	public Dim getDim() {
		return dim;
	}
	public void setDim(Dim dim) {
		this.dim = dim;
	}
	public Parallel getParallel() {
		return parallel;
	}
	public void setParallel(Parallel parallel) {
		this.parallel = parallel;
	}
	public Precision getPrecision() {
		return precision;
	}
	public void setPrecision(Precision precision) {
		this.precision = precision;
	}
	private Launcher(Arch arch,Dim dim, Parallel parallel, Precision precision) {
		super();
		this.arch = arch;
		this.dim = dim;
		this.parallel = parallel;
		this.precision = precision;
	}
	public Arch getArch() {
		return arch;
	}
	public void setArch(Arch arch) {
		this.arch = arch;
	}
	private Arch arch;
	private Dim dim;
	private Parallel parallel;
	private Precision precision;
}
