package com.powsybl.shortcircuits;

import com.powsybl.commons.extensions.AbstractExtendable;

import java.util.Objects;

/**
 * Results for one fault computation.
 */
public final class FaultResult extends AbstractExtendable<FaultResult> {

    private final String id;

    private final float threePhaseFaultCurrent;

    public FaultResult(String id, float threePhaseFaultCurrent) {
        this.id = Objects.requireNonNull(id);
        this.threePhaseFaultCurrent = threePhaseFaultCurrent;
    }

    /**
     * ID of the equipment for which a fault has been simulated.
     */
    public String getId() {
        return id;
    }

    /**
     * Value of the 3-phase short-circuit current for this fault.
     */
    public float getThreePhaseFaultCurrent() {
        return threePhaseFaultCurrent;
    }

}
