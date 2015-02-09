package company.interfaces;



	public interface ICompanyDB{
	boolean createCompany(String C_Name,String C_Site, String C_Specialization,String C_AmountEmployes,String C_Password);
	String []getAnySingleQuery(String strQuery);
/*	String viewAll(String question);*/
	}

