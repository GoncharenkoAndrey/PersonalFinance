package personalfinance.model;

import personalfinance.exception.ModelException;

public class Currency extends Common {
	private String title;
	private String code;
	private double rate;
	private boolean on;
	private boolean base;
	
	public Currency() {}
	public Currency(String title, String code, double rate, boolean on, boolean base) throws ModelException {
		if(title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
		if(code.length() == 0) throw new ModelException(ModelException.CODE_EMPTY);
		if(rate <= 0) throw new ModelException(ModelException.RATE_INCORRECT);
		this.title = title;
		this.code = code;
		this.rate = rate;
		this.on = on;
		this.base = base;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public boolean isOn() {
		return on;
	}
	public void setOn(boolean on) {
		this.on = on;
	}
	public boolean isBase() {
		return base;
	}
	public void setBase(boolean base) {
		this.base = base;
	}
	@Override
	public String toString() {
		return "Currency [title=" + title + ", code=" + code + ", rate=" + rate + ", isOn=" + on + ", isBase="
				+ base + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + (base ? 1231 : 1237);
		result = prime * result + (on ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currency other = (Currency) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	@Override
	public String getValueForComboBox() {
		return title;
	}
	public double getRateByCurrency(Currency currency) {
		return rate / currency.rate;
	}
}
