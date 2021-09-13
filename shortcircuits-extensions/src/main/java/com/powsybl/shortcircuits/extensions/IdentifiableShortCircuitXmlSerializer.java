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
import com.powsybl.iidm.network.Identifiable;

import javax.xml.stream.XMLStreamException;
import java.io.InputStream;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
@AutoService(ExtensionXmlSerializer.class)
public class IdentifiableShortCircuitXmlSerializer<I extends Identifiable<I>> implements ExtensionXmlSerializer<I, IdentifiableShortCircuit<I>> {
    @Override
    public boolean hasSubElements() {
        return false;
    }

    @Override
    public InputStream getXsdAsStream() {
        return  getClass().getResourceAsStream("/xsd/identifiableShortCircuit.xsd");
    }

    @Override
    public String getNamespaceUri() {
        return "http://www.itesla_project.eu/schema/iidm/ext/identifiable_short_circuit/1_0";
    }

    @Override
    public String getNamespacePrefix() {
        return "isc";
    }

    @Override
    public void write(IdentifiableShortCircuit identifiableShortCircuit, XmlWriterContext context) throws XMLStreamException {
        XmlUtil.writeDouble("ipMax", identifiableShortCircuit.getIpMax(), context.getWriter());
        XmlUtil.writeDouble("ipMin", identifiableShortCircuit.getIpMin(), context.getWriter());
    }

    @Override
    public IdentifiableShortCircuit read(I identifiable, XmlReaderContext context) throws XMLStreamException {
        double ipMax = XmlUtil.readDoubleAttribute(context.getReader(), "ipMax");
        double ipMin = XmlUtil.readDoubleAttribute(context.getReader(), "ipMin");
        identifiable.newExtension(IdentifiableShortCircuitAdder.class)
                .withIpMax(ipMax)
                .withIpMin(ipMin)
                .add();
        return identifiable.getExtension(IdentifiableShortCircuit.class);
    }

    @Override
    public String getExtensionName() {
        return "identifiableShortCircuit";
    }

    @Override
    public String getCategoryName() {
        return "network";
    }

    @Override
    public Class<? super IdentifiableShortCircuit> getExtensionClass() {
        return IdentifiableShortCircuit.class;
    }
}
