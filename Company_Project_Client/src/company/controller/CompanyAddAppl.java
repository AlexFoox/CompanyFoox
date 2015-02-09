package company.controller;

import java.util.Random;

import org.springframework.context.support.*;

import company.interfaces.ICompanyDB;

public class CompanyAddAppl {
	private static final String COMPANY_PREFIX="Company";
	private static final String SITE_PREFIX="www.";
	private static final String SITE_PREFIX2=".com";
	private static final String SPECIALIZATION_PREFIX="Spec";
	private static final String AMOUNT_PREFIX="Amount";
	private static final int N_SITE = 100;
	private static final int N_COMPANY = 100;
	private static final int N_SPECIALIZATION = 10;
	private static final int MAX_AMOUNT = 1000;
	private static final String PASS_PREFIX = "password";

	private static Random gen = new Random();
	
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx=	new FileSystemXmlApplicationContext("beans.xml");
		
		ICompanyDB db=(ICompanyDB) ctx.getBean("database");
		
		for(int ib=0; ib<N_COMPANY; ib++){
			String C_Name=COMPANY_PREFIX+ib;
			String C_AmountEmployes=AMOUNT_PREFIX+gen.nextInt(MAX_AMOUNT);		
			String C_Site=SITE_PREFIX+gen.nextInt(N_SITE)+ SITE_PREFIX2;
			String C_Specialization=SPECIALIZATION_PREFIX+gen.nextInt(N_SPECIALIZATION);
			String C_Password = PASS_PREFIX +ib;
			db.createCompany(C_Name, C_Site, C_Specialization, C_AmountEmployes, C_Password);
		}
		ctx.close();

	}

}

