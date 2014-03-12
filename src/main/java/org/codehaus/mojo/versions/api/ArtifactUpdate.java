package org.codehaus.mojo.versions.api;

import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.apache.maven.model.Dependency;

public class ArtifactUpdate {
    private final Dependency dependency;
    private final ArtifactVersion versionUpdate;

    public ArtifactUpdate(Dependency dependency, ArtifactVersion versionUpdate) {
        this.dependency = dependency;
        this.versionUpdate = versionUpdate;
    }
}
