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
	public Launcher() {
		// TODO Auto-generated constructor stub
	}
	public Arch getArch() {
		return arch;
	}
	public void setArch(Arch arch) {
		this.arch = arch;
	}
	/**
	 * @return the parallelType
	 */
	public ParallelType getParallelType() {
		return parallelType;
	}
	/**
	 * @param parallelType the parallelType to set
	 */
	public void setParallelType(ParallelType parallelType) {
		this.parallelType = parallelType;
	}
	private Arch arch;
	private Dim dim;
	private Parallel parallel;
	private Precision precision;
	private ParallelType parallelType;
}
