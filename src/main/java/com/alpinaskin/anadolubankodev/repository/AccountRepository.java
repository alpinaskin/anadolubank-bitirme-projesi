package com.alpinaskin.anadolubankodev.repository;

import com.alpinaskin.anadolubankodev.model.Account;
import com.alpinaskin.anadolubankodev.model.Agency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AccountRepository {

    private final SessionFactory sessionFactory;

    public List<Account> getAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("select a from Account a", Account.class).list();
    }

    public Account getOne(int accountId) {
        Session session =sessionFactory.openSession();
        return session.createQuery("select a from Account a where a.id = :accountId", Account.class)
                .setParameter("accountId", accountId)
                .getSingleResult();
    }
}
