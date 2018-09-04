package com.non.rda.service;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import com.non.rda.entity.ReferenceData;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(ReferenceDataService.NAME)
public class ReferenceDataServiceBean implements ReferenceDataService {
    @Inject
    private Persistence persistence;

    @Override
    public ReferenceData getReferenceDataByCode(String code) {
        Transaction tx = persistence.createTransaction();
        EntityManager entityManager = persistence.getEntityManager();
        Query query = entityManager
                .createQuery("select e from crm$ReferenceData e where e.referenceCode = :code order by e.sortOrder");
        query.setParameter("code", code);
        ReferenceData referenceData = (ReferenceData) query.getFirstResult();
        tx.end();
        return referenceData;
    }

    @Override
    public List<ReferenceData> getReferenceDataListByCategory(String category)
    {
        Transaction tx = persistence.createTransaction();
        EntityManager entityManager = persistence.getEntityManager();
        Query query = entityManager.createQuery("select e from crm$ReferenceData e where e.referenceCategory = :category order by e.sortOrder");
        query.setParameter("category", category);
        List<ReferenceData> referenceValues = query.getResultList();
        return referenceValues;
    }

    @Override
    public List<ReferenceData> getReferenceDataListByParent(ReferenceData parent)
    {
        Transaction tx = persistence.createTransaction();
        EntityManager entityManager = persistence.getEntityManager();
        Query query = entityManager.createQuery("select e from crm$ReferenceData e where e.referenceCategory.parent.id = :parentId order by e.sortOrder");
        query.setParameter("parentId", parent.getId());
        List<ReferenceData> referenceValues = query.getResultList();
        return referenceValues;

    }

}