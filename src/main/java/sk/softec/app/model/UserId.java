package sk.softec.app.model;

public class UserId {
	
	private String companyCode;
	private long id;
	
	public UserId(String companyCode, long id) {
		this.companyCode = companyCode;
		this.id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public long getId() {
		return id;
	}

	
// uncomment following methods to remove memory leak
/*
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserId other = (UserId) obj;
		if (companyCode == null) {
			if (other.companyCode != null)
				return false;
		} else if (!companyCode.equals(other.companyCode))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyCode == null) ? 0 : companyCode.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
*/
}
