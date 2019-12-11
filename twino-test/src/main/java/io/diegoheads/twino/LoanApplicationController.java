package io.diegoheads.twino;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanApplicationController {

	@Autowired
	private LoanApplicationService loanApplicationService;

	@RequestMapping("/applications")
	public List<LoanApplication> getAllLoanApplications(Sort sort) {
		return loanApplicationService.getAllLoanApplications(sort);
	}

	@RequestMapping("/applications/{id}")
	public Optional<LoanApplication> getLoanApplication(@PathVariable Integer id) {
		return loanApplicationService.getLoanApplication(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/applications")
	public String addLoanApplication(@RequestBody LoanApplication loanApplication) throws ParseException {
		return loanApplicationService.addLoanApplication(loanApplication);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/applications")
	public void updateLoanApplication(@RequestBody LoanApplication loanApplication) {
		loanApplicationService.updateLoanApplication(loanApplication);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/applications/{id}")
	public void deleteLoanApplication(@PathVariable Integer id) {
		loanApplicationService.deleteLoanApplication(id);
	}

}
