public class Pair {
	private Double key;
	private Double value;

	public Pair(double key, double value) {
		this.key = key;
		this.value = value;
	}

	public Double getKey() {
		return key;
	}

	public void setKey(Double key) {
		this.key = key;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}