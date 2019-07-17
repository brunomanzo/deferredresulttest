package com.deferred.test;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class DeferredDAO extends HibernateDaoSupport {
    @Autowired
    public void setSession(final SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public Foo get(final String bar) {
        final List<Foo> list = (List<Foo>) getHibernateTemplate().findByNamedQueryAndNamedParam("Foo.getByBar",
                new String[] { "bar", },
                new Object[] { bar });
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return DataAccessUtils.singleResult(list);
    }

}
