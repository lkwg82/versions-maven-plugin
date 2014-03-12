package org.codehaus.mojo.versions.api;

import org.apache.maven.artifact.versioning.ArtifactVersion;

public class IncompatibleParentAndProjectMavenVersion {
    private final ArtifactVersion parentVersion;
    private final ArtifactVersion projectVersion;

    public IncompatibleParentAndProjectMavenVersion(ArtifactVersion parentVersion, ArtifactVersion projectVersion) {
        this.parentVersion = parentVersion;
        this.projectVersion = projectVersion;
    }
}
