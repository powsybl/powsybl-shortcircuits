package com.powsybl.shortcircuits;

import com.powsybl.commons.extensions.AbstractExtendable;
import com.powsybl.security.LimitViolation;
import com.powsybl.security.NetworkMetadata;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Results of a short-circuit computation.
 * Will contain an exhaustive list of computed short-circuit current values,
 * and a list of {@link LimitViolation}s.
 */
public class ShortCircuitAnalysisResult extends AbstractExtendable<ShortCircuitAnalysisResult> {

    private NetworkMetadata networkMetadata;

    private final List<FaultResult> faultResults;

    private final List<LimitViolation> limitViolations;

    public ShortCircuitAnalysisResult(List<FaultResult> faultResults, List<LimitViolation> limitViolations) {
        this.faultResults = Objects.requireNonNull(faultResults);
        this.limitViolations = Objects.requireNonNull(limitViolations);
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

    public ShortCircuitAnalysisResult setNetworkMetadata(NetworkMetadata networkMetadata) {
        this.networkMetadata = networkMetadata;
        return this;
    }

}
