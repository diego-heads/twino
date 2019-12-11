package io.diegoheads.twino;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class OperatorService {

	@Autowired
	private OperatorRepository operatorRepository;

	public List<Operator> getAllOperators(Sort sort) {
		List<Operator> operators = new ArrayList<>();
		operatorRepository.findAll(sort).forEach(operators::add);
		return operators;
	}

	public Optional<Operator> getOperator(String username) {
		return operatorRepository.findById(username);
	}

	public void addOperator(Operator operator) {
		operatorRepository.save(operator);
	}

	public void updateOperator(Operator operator) {
		operatorRepository.save(operator);
	}

	public void deleteOperator(String username) {
		operatorRepository.deleteById(username);
	}

}
