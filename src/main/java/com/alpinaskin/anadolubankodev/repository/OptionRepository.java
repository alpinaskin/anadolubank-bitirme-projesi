package com.alpinaskin.anadolubankodev.repository;

import com.alpinaskin.anadolubankodev.model.Option;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OptionRepository {
    private final SessionFactory sessionFactory;

    public Option getOptionByPolicyId(int policyId){
        Session session = sessionFactory.openSession();
        Option option = session.createQuery("select o from Option o where o.policy_id = :policyId", Option.class)
                .setParameter("policyId", policyId)
                .getSingleResult();
        return option;
    }
}
