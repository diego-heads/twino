package io.diegoheads.twino;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicationRepository extends PagingAndSortingRepository<LoanApplication, Integer> {

}
