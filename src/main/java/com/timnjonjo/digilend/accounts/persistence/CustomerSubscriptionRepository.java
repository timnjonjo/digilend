package com.timnjonjo.digilend.accounts.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author TMwaura on 16/02/2022
 * @Project digilend
 */
@Repository
public interface CustomerSubscriptionRepository extends JpaRepository<CustomerSubscription, Long> {
}
