package com.alpinaskin.anadolubankodev.repository;

import com.alpinaskin.anadolubankodev.model.Agency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AgencyRepository {
    private final SessionFactory sessionFactory;

    public List<Agency> getAll() {
            Session session = sessionFactory.openSession();
            return session.createQuery("select a from Agency a", Agency.class).list();
    }

    public Agency getOne(int agencyId) {
        Session session = sessionFactory.openSession();
        return session.createQuery("select a from Agency a where a.id = :agencyId", Agency.class)
                .setParameter("agencyId", agencyId)
                .getSingleResult();
    }
}
