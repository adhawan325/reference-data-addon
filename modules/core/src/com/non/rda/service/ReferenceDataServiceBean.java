package com.non.rda.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.non.rda.entity.ReferenceData;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(ReferenceDataService.NAME)
public class ReferenceDataServiceBean implements ReferenceDataService {
    @Inject
    private Persistence persistence;
    @Inject
    private DataManager dataManager;

    @Override
    public ReferenceData getReferenceDataByCode(String code) {
        LoadContext<ReferenceData> loadContext = LoadContext.create(ReferenceData.class);
        loadContext.setQuery(new LoadContext.Query("select e from nonrda$ReferenceData e where e.referenceCode = :code order by e.sortOrder").setParameter("code", code).setCacheable(true));
        return dataManager.load(loadContext);
    }

    @Override
    public List<ReferenceData> getReferenceDataListByCategory(String category) {
        LoadContext<ReferenceData> loadContext = LoadContext.create(ReferenceData.class);
        loadContext.setQuery(new LoadContext.Query("select e from nonrda$ReferenceData e where e.referenceCategory = :category order by e.sortOrder").setParameter("category", category).setCacheable(true));
        return dataManager.loadList(loadContext);
    }

    @Override
    public List<ReferenceData> getReferenceDataListByParent(ReferenceData parent) {
        LoadContext<ReferenceData> loadContext = LoadContext.create(ReferenceData.class);
        loadContext.setQuery(new LoadContext.Query("select e from nonrda$ReferenceData e where e.parent.id = :parentId order by e.sortOrder").setParameter("parentId", parent.getId()).setCacheable(true));
        return dataManager.loadList(loadContext);
    }
}