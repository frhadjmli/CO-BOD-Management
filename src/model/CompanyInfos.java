package model;

public class CompanyInfos {
	
      String coName;
    
      String ceoName;
    
      String nationalId;
    
      String coType;
    
      String regDate;

      String street;

	  String alley;
    
      String postCode;
      
      
      public CompanyInfos(String coName, String ceoName, String nationalId, String coType, String regDate, String street,
  			String alley, String postCode) {
  		super();
  		this.coName = coName;
  		this.ceoName = ceoName;
  		this.nationalId = nationalId;
  		this.coType = coType;
  		this.regDate = regDate;
  		this.street = street;
  		this.alley = alley;
  		this.postCode = postCode;
  	}


	public String getCoName() {
		return coName;
	}


	public void setCoName(String coName) {
		this.coName = coName;
	}


	public String getCeoName() {
		return ceoName;
	}


	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}


	public String getNationalId() {
		return nationalId;
	}


	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}


	public String getCoType() {
		return coType;
	}


	public void setCoType(String coType) {
		this.coType = coType;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getAlley() {
		return alley;
	}


	public void setAlley(String alley) {
		this.alley = alley;
	}


	public String getPostCode() {
		return postCode;
	}


	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
      
    
    
	
}
