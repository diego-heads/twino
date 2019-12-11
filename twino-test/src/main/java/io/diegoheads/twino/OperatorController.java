package io.diegoheads.twino;

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
public class OperatorController {

	@Autowired
	private OperatorService operatorService;

	@RequestMapping("/operators")
	public List<Operator> getAllOperators(Sort sort) {
		return operatorService.getAllOperators(sort);
	}

	@RequestMapping("/operators/{username}")
	public Optional<Operator> getOperator(@PathVariable String username) {
		return operatorService.getOperator(username);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/operators")
	public void addOperator(@RequestBody Operator operator) {
		operatorService.addOperator(operator);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/operators")
	public void updateLoanApplication(@RequestBody Operator operator) {
		operatorService.updateOperator(operator);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/operators/{username}")
	public void deleteLoanApplication(@PathVariable String username) {
		operatorService.deleteOperator(username);
	}

}
