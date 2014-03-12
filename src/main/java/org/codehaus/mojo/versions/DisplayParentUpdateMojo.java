package org.codehaus.mojo.versions;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.metadata.ArtifactMetadataRetrievalException;
import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.apache.maven.artifact.versioning.InvalidVersionSpecificationException;
import org.apache.maven.artifact.versioning.VersionRange;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.codehaus.mojo.versions.api.DisplayParentUpdateReport;
import org.codehaus.mojo.versions.rewriting.ModifiedPomXMLEventReader;
import org.codehaus.mojo.versions.utils.ObjectToXmlWriter;

import javax.xml.stream.XMLStreamException;
import java.io.File;

/**
 * write report if parent pom have newer versions available.
 *
 * @author Stephen Connolly
 * @goal display-parent-update
 * @requiresProject true
 * @requiresDirectInvocation false
 * @since 2.1
 */
public class DisplayParentUpdateMojo
    extends UpdateParentMojo
{
    /**
     * file to write xml report to
     *
     * @parameter expression="${xmlReport}" defaultValue="null"
     */
    private File xmlReport;

    public void setXmlReport(File xmlReport) {
        this.xmlReport = xmlReport;
    }

    protected void update( ModifiedPomXMLEventReader pom )
        throws MojoExecutionException, MojoFailureException, XMLStreamException
    {
        if (hasParentPom() && !isPartOfReactorProject()) {
            String currentVersion = getProject().getParent().getVersion();
            String version = currentVersion;

            if (parentVersion != null) {
                version = parentVersion;
            }

            VersionRange versionRange;
            try {
                versionRange = VersionRange.createFromVersionSpec(version);
            } catch (InvalidVersionSpecificationException e) {
                throw new MojoExecutionException("Invalid version range specification: " + version, e);
            }

            Artifact artifact = artifactFactory.createDependencyArtifact(getProject().getParent().getGroupId(),
                    getProject().getParent().getArtifactId(),
                    versionRange, "pom", null, null);

            ArtifactVersion latestVersion;
            try {
                latestVersion = findLatestVersion(artifact, versionRange, null, false);
            } catch (ArtifactMetadataRetrievalException e) {
                throw new MojoExecutionException(e.getMessage(), e);
            }

            final Artifact parentArtifact = getProject().getParentArtifact();

            DisplayParentUpdateReport report = new DisplayParentUpdateReport(parentArtifact, currentVersion, latestVersion.toString());

            ObjectToXmlWriter.writeXmlReport(xmlReport, report);
        }
    }

    private boolean isPartOfReactorProject() {
        return reactorProjects.contains(getProject().getParent());
    }

    private boolean hasParentPom() {
        return getProject().getParent() != null;
    }
}
