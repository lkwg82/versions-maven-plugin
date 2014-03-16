package org.codehaus.mojo.versions.api;

import com.thoughtworks.xstream.XStream;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DisplayDependencyUpdatesReportTest {

    @Test
    public void testToXmlAndFromXml() {
        final XStream xStream = new XStream();

        DisplayDependencyUpdatesReport report = new DisplayDependencyUpdatesReport();

        final ArtifactUpdate.Dependency dependency = new ArtifactUpdate.Dependency();
        dependency.setGroupId("gr");
        dependency.setArtifactId("a");
        dependency.setScope("compile");
        dependency.setVersion("1");
        dependency.setType("jar");

        final ArtifactUpdate update = new ArtifactUpdate();
        update.setDependency(dependency);
        update.setVersionUpdate("2");

        report.addUpdate("Section1", update);

        String xml = xStream.toXML(report);

        DisplayDependencyUpdatesReport report2 = (DisplayDependencyUpdatesReport) xStream.fromXML(xml);

        String xml2 = xStream.toXML(report2);

        assertEquals(xml, xml2);
    }
}
