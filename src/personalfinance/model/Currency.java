package personalfinance.model;

import personalfinance.exception.ModelException;

public class Currency extends Common {
	private String title;
	private String code;
	private double rate;
	private boolean isOn;
	private boolean isBase;
	
	public Currency() {}
	public Currency(String title, String code, double rate, boolean isOn, boolean isBase) throws ModelException {
		if(title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
		if(code.length() == 0) throw new ModelException(ModelException.CODE_EMPTY);
		if(rate <= 0) throw new ModelException(ModelException.RATE_INCORRECT);
		this.title = title;
		this.code = code;
		this.rate = rate;
		this.isOn = isOn;
		this.isBase = isBase;
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
		return isOn;
	}
	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
	public boolean isBase() {
		return isBase;
	}
	public void setBase(boolean isBase) {
		this.isBase = isBase;
	}
	@Override
	public String toString() {
		return "Currency [title=" + title + ", code=" + code + ", rate=" + rate + ", isOn=" + isOn + ", isBase="
				+ isBase + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + (isBase ? 1231 : 1237);
		result = prime * result + (isOn ? 1231 : 1237);
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
