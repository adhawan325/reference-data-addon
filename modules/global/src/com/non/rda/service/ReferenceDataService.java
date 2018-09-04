package com.non.rda.service;


import com.non.rda.entity.ReferenceData;

import java.util.List;

public interface ReferenceDataService {
    String NAME = "nonrda_ReferenceDataService";

    ReferenceData getReferenceDataByCode(String code);
    List<ReferenceData> getReferenceDataListByCategory(String category);

    List<ReferenceData> getReferenceDataListByParent(ReferenceData parent);
}