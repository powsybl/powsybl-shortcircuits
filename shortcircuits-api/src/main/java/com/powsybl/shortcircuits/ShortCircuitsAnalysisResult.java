/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits;

import com.powsybl.commons.extensions.AbstractExtendable;
import com.powsybl.security.LimitViolation;
import com.powsybl.security.NetworkMetadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Results of a short-circuit computation.
 * Will contain an exhaustive list of computed short-circuit current values,
 * and a list of {@link LimitViolation}s.
 *
 * @author Boubakeur Brahimi
 */
public class ShortCircuitsAnalysisResult extends AbstractExtendable<ShortCircuitsAnalysisResult> {

    private NetworkMetadata networkMetadata;

    private final List<FaultResult> faultResults = new ArrayList<>();

    private final List<LimitViolation> limitViolations = new ArrayList<>();

    public ShortCircuitsAnalysisResult(List<FaultResult> faultResults, List<LimitViolation> limitViolations) {
        this.faultResults.addAll(Objects.requireNonNull(faultResults));
        this.limitViolations.addAll(Objects.requireNonNull(limitViolations));
    }

    /**
     * A list of results, for each fault which have been simulated.
     */
    public List<FaultResult> getFaultResults() {
        return Collections.unmodifiableList(faultResults);
    }

    /**
     * The list of limit violations: for instance when the computed short-circuit current on a given equipment
     * is higher than the maximum admissible value for that equipment.
     */
    public List<LimitViolation> getLimitViolations() {
        return Collections.unmodifiableList(limitViolations);
    }

    public NetworkMetadata getNetworkMetadata() {
        return networkMetadata;
    }

    public ShortCircuitsAnalysisResult setNetworkMetadata(NetworkMetadata networkMetadata) {
        this.networkMetadata = networkMetadata;
        return this;
    }

}
