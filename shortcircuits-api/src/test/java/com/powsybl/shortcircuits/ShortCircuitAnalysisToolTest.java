package com.powsybl.shortcircuits;

import java.util.Collections;

import com.powsybl.tools.AbstractToolTest;
import org.junit.Test;

import com.powsybl.tools.Tool;

public class ShortCircuitAnalysisToolTest extends AbstractToolTest {

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
