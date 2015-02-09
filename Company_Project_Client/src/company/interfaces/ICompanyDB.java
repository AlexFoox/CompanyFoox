package company.interfaces;


	public interface ICompanyDB {
	boolean createCompany(String C_Name,String C_Site, String C_Specialization,String C_AmountEmployes,String C_Password);
/*	String viewAll(String question);*/
	String []getAnySingleQuery(String strQuery);
	}

