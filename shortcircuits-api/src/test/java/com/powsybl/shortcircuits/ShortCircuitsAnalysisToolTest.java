/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits;

import java.util.Collections;

import com.powsybl.tools.AbstractToolTest;
import org.junit.Test;

import com.powsybl.tools.Tool;

public class ShortCircuitsAnalysisToolTest extends AbstractToolTest {

    private ShortCircuitAnalysisTool shortCircuitTool;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        shortCircuitTool = new ShortCircuitAnalysisTool();
    }

    @Override
    protected Iterable<Tool> getTools() {
        return Collections.singleton(shortCircuitTool);
    }

    @Test
    public void testGetCommand() {
        assertCommand();
    }

    @Override
    public void assertCommand() {
        assertOption(shortCircuitTool.getCommand().getOptions(), "case-file", true, true);
        assertOption(shortCircuitTool.getCommand().getOptions(), "output-file", false, true);
        assertOption(shortCircuitTool.getCommand().getOptions(), "output-format", false, true);
    }

}
