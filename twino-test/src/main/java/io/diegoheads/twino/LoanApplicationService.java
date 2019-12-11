package io.diegoheads.twino;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicationService {

	public static final int NUM = 31;

	@Autowired
	private LoanApplicationRepository loanApplicationRepository;

	public List<LoanApplication> getAllLoanApplications(Sort sort) {
		List<LoanApplication> loanApplications = new ArrayList<>();
		loanApplicationRepository.findAll(sort).forEach(loanApplications::add);
		return loanApplications;
	}

	public Optional<LoanApplication> getLoanApplication(Integer id) {
		return loanApplicationRepository.findById(id);
	}

	public String addLoanApplication(LoanApplication loanApplication) throws ParseException {
		double score = calculateScore(loanApplication);
		loanApplication.setCreditScore((float) score);
		if (score < 2500)
			loanApplication.setResolution("Rejected");
		else if (score > 3500)
			loanApplication.setResolution("Approved");
		else
			loanApplication.setResolution("Manual");
		loanApplicationRepository.save(loanApplication);
		return loanApplication.getResolution();
	}

	public void updateLoanApplication(LoanApplication loanApplication) {
		loanApplicationRepository.save(loanApplication);
	}

	public void deleteLoanApplication(Integer id) {
		loanApplicationRepository.deleteById(id);
	}

	// Method to calculate the Credit Score of the client
	@SuppressWarnings("deprecation")
	private double calculateScore(LoanApplication loanApplication) throws ParseException {
		int firstNameLength = loanApplication.getFirstName().length();
		return PositionSum(loanApplication.getFirstName(), firstNameLength) + 1.5 * loanApplication.getSalary()
				- 3 * loanApplication.getLiability() + (int) birthDate(loanApplication.getBirthDate()).getYear()
				- (int) birthDate(loanApplication.getBirthDate()).getMonth()
				- JulianDay(birthDate(loanApplication.getBirthDate()));
	}

	// Method to calculate the sum of first name letter positions in the alphabet
	private int PositionSum(String str, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + (int) (str.charAt(i) & NUM);
		}
		return sum;
	}

	// Method to handle birth Date
	private Date birthDate(String birth) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse(birth);
		return date;
	}

	// Method to get Julian day of birth
	@SuppressWarnings("deprecation")
	private int JulianDay(Date birthday) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(GregorianCalendar.DAY_OF_MONTH, birthday.getDay());
		gc.set(GregorianCalendar.MONTH, birthday.getMonth());
		gc.set(GregorianCalendar.YEAR, birthday.getYear());
		return gc.get(GregorianCalendar.DAY_OF_YEAR);
	}

}
