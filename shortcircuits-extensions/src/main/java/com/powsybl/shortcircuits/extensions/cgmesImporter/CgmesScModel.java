/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.powsybl.shortcircuits.extensions.cgmesimporter;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.powsybl.triplestore.api.PropertyBags;
import com.powsybl.triplestore.api.QueryCatalog;
import com.powsybl.triplestore.api.TripleStore;

/**
 * @author Luma Zamarreño <zamarrenolm at aia.es>
 * @author José Antonio Marqués <marquesja at aia.es>
 */

public class CgmesScModel {

    public static final String SYNCHRONOUS_MACHINE_SHORT_CIRCUIT_DATA_QUERY_KEY = "SynchronousMachineShortcircuitData";
    public static final String BUS_BAR_SECTION_SHORT_CIRCUIT_DATA_QUERY_KEY = "BusbarSectionShortcircuitData";

    private final TripleStore tripleStore;
    private final QueryCatalog queryCatalog;

    public CgmesScModel(TripleStore tripleStore) {
        this(tripleStore, new QueryCatalog("CGMES-SHORT-CIRCUITS.sparql"));
    }

    public CgmesScModel(TripleStore tripleStore, QueryCatalog queryCatalog) {
        this.tripleStore = Objects.requireNonNull(tripleStore);
        this.queryCatalog = Objects.requireNonNull(queryCatalog);
    }

    private PropertyBags queryTripleStore(String queryKey) {
        String query = queryCatalog.get(queryKey);
        if (query == null) {
            LOG.warn("Query [{}] not found in catalog", queryKey);
            return new PropertyBags();
        }
        return tripleStore.query(query);
    }

    public PropertyBags getSynchronousMachinesShortcircuitData() {
        return queryTripleStore(SYNCHRONOUS_MACHINE_SHORT_CIRCUIT_DATA_QUERY_KEY);
    }

    public PropertyBags getBusbarSectionsShortcircuitData() {
        return queryTripleStore(BUS_BAR_SECTION_SHORT_CIRCUIT_DATA_QUERY_KEY);
    }

    private static final Logger LOG = LoggerFactory.getLogger(CgmesScModel.class);
}

