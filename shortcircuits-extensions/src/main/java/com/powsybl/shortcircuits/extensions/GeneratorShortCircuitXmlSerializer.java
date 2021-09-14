/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.google.auto.service.AutoService;
import com.powsybl.commons.extensions.ExtensionXmlSerializer;
import com.powsybl.commons.xml.XmlReaderContext;
import com.powsybl.commons.xml.XmlUtil;
import com.powsybl.commons.xml.XmlWriterContext;
import com.powsybl.iidm.network.Generator;

import javax.xml.stream.XMLStreamException;
import java.io.InputStream;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
@AutoService(ExtensionXmlSerializer.class)
public class GeneratorShortCircuitXmlSerializer implements ExtensionXmlSerializer<Generator, GeneratorShortCircuit> {

    @Override
    public boolean hasSubElements() {
        return false;
    }

    @Override
    public InputStream getXsdAsStream() {
        return getClass().getResourceAsStream("/xsd/generatorShortCircuit.xsd");
    }

    @Override
    public String getNamespaceUri() {
        return "http://www.itesla_project.eu/schema/iidm/ext/generator_short_circuit/1_0";
    }

    @Override
    public String getNamespacePrefix() {
        return "gsc";
    }

    @Override
    public void write(GeneratorShortCircuit generatorShortCircuit, XmlWriterContext context) throws XMLStreamException {
        XmlUtil.writeDouble("directSubtransX", generatorShortCircuit.getDirectSubtransX(), context.getWriter());
        XmlUtil.writeDouble("directTransX", generatorShortCircuit.getDirectTransX(), context.getWriter());
        XmlUtil.writeDouble("stepUpTransformerX", generatorShortCircuit.getStepUpTransformerX(), context.getWriter());
    }

    @Override
    public GeneratorShortCircuit read(Generator generator, XmlReaderContext context) throws XMLStreamException {
        double directSubtransX = XmlUtil.readDoubleAttribute(context.getReader(), "directSubtransX");
        double directTransX = XmlUtil.readDoubleAttribute(context.getReader(), "directTransX");
        double stepUpTransformerX = XmlUtil.readDoubleAttribute(context.getReader(), "stepUpTransformerX");
        generator.newExtension(GeneratorShortCircuitAdder.class)
                .withDirectSubtransX(directSubtransX)
                .withDirectTransX(directTransX)
                .withStepUpTransformerX(stepUpTransformerX)
                .add();
        return generator.getExtension(GeneratorShortCircuit.class);
    }

    @Override
    public String getExtensionName() {
        return "generatorShortCircuit";
    }

    @Override
    public String getCategoryName() {
        return "network";
    }

    @Override
    public Class<? super GeneratorShortCircuit> getExtensionClass() {
        return GeneratorShortCircuit.class;
    }
}
