package company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import company.interfaces.ICompanyDB;


@Controller
@RequestMapping({"/"})
public class CompanyQueryAppl {
	
	@Autowired
	ICompanyDB companyService;
	
	@RequestMapping({"/"})
	public String home() {
		return "home_page";
	}
	
	@RequestMapping({"/input_form"})
	public String query() {
		return "input_form";
	}

	@RequestMapping({"/query_processing"})
	public String queryProcessing(String jpaStr, Model model) {
		;
		String[] result = companyService.getAnySingleQuery(jpaStr);
		StringBuffer buf = new StringBuffer();
		for (String str : result)
			buf.append(str).append("<br>");
		model.addAttribute("myResult", buf.toString());
		return "result_view";
	}

	@RequestMapping({"/add"})
	public String addCompany() {
		return "add_form";
	}
	
	@RequestMapping({"/add_processing"})
	public String addProcessing(String C_Name,String C_Site, String C_Specialization,String C_AmountEmployes,String C_Password) {
		
		boolean flag = companyService.createCompany(C_Name, C_Site, C_Specialization, C_AmountEmployes, C_Password);
		if(flag==true){
		return "success_adding";
		}
		else return "Error";
	}
}

