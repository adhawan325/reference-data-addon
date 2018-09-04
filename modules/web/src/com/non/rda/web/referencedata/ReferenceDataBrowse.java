package com.non.rda.web.referencedata;

import com.haulmont.cuba.gui.components.ButtonsPanel;
import com.haulmont.cuba.gui.components.EntityCombinedScreen;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.TreeTable;
import com.non.rda.entity.ReferenceData;

import javax.inject.Inject;
import java.util.Map;

public class ReferenceDataBrowse extends EntityCombinedScreen {
    @Inject
    private TreeTable<ReferenceData> table;

    @Inject
    private ButtonsPanel buttonsPanel;

    @Override
    public void init(Map<String, Object> params) {
        table.sort("referenceCategory", Table.SortDirection.ASCENDING);
        if( params.get("referenceCategory") != null ) {
            String query = "select e from crm$ReferenceData e where e.referenceCategory like '" + params.get("referenceCategory") + ".%'";
            table.getDatasource().setQuery(query);
            table.getDatasource().refresh();
            table.setMultiSelect(true);
            buttonsPanel.setEnabled(false);
        }
        super.init(params);
    }
}