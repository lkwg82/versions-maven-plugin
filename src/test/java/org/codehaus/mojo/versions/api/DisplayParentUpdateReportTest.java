package org.codehaus.mojo.versions.api;

import com.thoughtworks.xstream.XStream;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DisplayParentUpdateReportTest {
    @Test
    public void testToXmlAndFromXml() {
        final XStream xStream = new XStream();

        DisplayParentUpdateReport report = new DisplayParentUpdateReport();
        report.setCurrentVersion("a");
        report.setLatestVersion(null);
        report.setParentGroupId("gr");
        report.setParentArtifactId("gr");

        String xml = xStream.toXML(report);

        DisplayParentUpdateReport report2 = (DisplayParentUpdateReport) xStream.fromXML(xml);

        String xml2 = xStream.toXML(report2);

        assertEquals(xml, xml2);
    }
}
