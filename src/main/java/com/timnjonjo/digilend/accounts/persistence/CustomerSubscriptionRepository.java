package com.timnjonjo.digilend.accounts.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author TMwaura on 16/02/2022
 * @Project digilend
 */
@Repository
public interface CustomerSubscriptionRepository extends JpaRepository<CustomerSubscription, Long> {
    Optional<CustomerSubscription> findByAccountIdAndProductId(Long AccountId, Long ProductId);
}
