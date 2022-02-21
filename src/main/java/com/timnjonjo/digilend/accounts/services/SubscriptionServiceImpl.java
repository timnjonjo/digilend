package com.timnjonjo.digilend.accounts.services;

import com.timnjonjo.digilend.accounts.persistence.CustomerSubscription;
import com.timnjonjo.digilend.accounts.persistence.CustomerSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author TMwaura on 21/02/2022
 * @Project digilend
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final CustomerSubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionServiceImpl(CustomerSubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public void createSubscription(CreateSubscriptionRequest subscriptionRequest) {
        //Check if has the same product
        Optional<CustomerSubscription> optionalCustomerSubscription = subscriptionRepository.findByAccountIdAndProductId(subscriptionRequest.getCustomerAccount().getId(), subscriptionRequest.getLoanProduct().getId());
        if (!optionalCustomerSubscription.isPresent()) {
            throw new IllegalArgumentException("Account Already Exists");
        }
        CustomerSubscription customerSubscription = CustomerSubscription.builder()
                .account(subscriptionRequest.getCustomerAccount())
                .product(subscriptionRequest.getLoanProduct())
                .limitAmount(subscriptionRequest.getCreditLimit())
                .build();

        subscriptionRepository.save(customerSubscription);
    }
}
