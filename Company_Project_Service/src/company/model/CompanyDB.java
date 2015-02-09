package company.model;

import java.util.*;

import javax.persistence.*;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import company.interfaces.ICompanyDB;
public class CompanyDB  implements ICompanyDB{
	@PersistenceContext (unitName="springHibernate",type=PersistenceContextType.EXTENDED)
	EntityManager em;
	@Override
	public String[] getAnySingleQuery(String strQuery) {
		
		String []array = null;
		try {
			Query query=em.createQuery(strQuery);
			List<Object> result=query.getResultList();
			array=new String[result.size()];
			int ind=0;
			for(Object obj: result)
				array[ind++]=obj.toString();
		} catch (Throwable e) {
			array=new String[1];
			array[0]="Sorry, you should learn jpql "+e.getMessage();
		}
		return array;
	}
	

	

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public boolean createCompany(String C_Name, String C_Site,
			String C_Specialization, String C_AmountEmployes, String C_Password) {
		
		boolean result=false;
		
			if(em.find(Company.class, C_Name)==null){
				Company comp =new Company();
				comp.setC_Name(C_Name);
				comp.setC_Site(C_Site);
				comp.setC_Specialization(C_Specialization);
				comp.setC_AmountEmployes(C_AmountEmployes);
				comp.setPassword(C_Password);
				em.persist(comp);
				result=true;
			}
	
		return result;
	}

}
