package com.alpinaskin.anadolubankodev.repository;

import com.alpinaskin.anadolubankodev.model.Policy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PolicyRepository {
    private final SessionFactory sessionFactory;

    public List<Policy> getAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("select p from Policy p", Policy.class).list();
    }

    public List<Policy> getAllByAccountId(int accountId){
        Session session = sessionFactory.openSession();
        return session.createQuery("select p from Policy p where p.accountId = :accountId", Policy.class)
                .setParameter("accountId", String.valueOf(accountId) )
                .list();
    }

}
