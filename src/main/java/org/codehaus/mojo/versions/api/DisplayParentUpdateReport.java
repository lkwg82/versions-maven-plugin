package org.codehaus.mojo.versions.api;

import org.apache.maven.artifact.Artifact;

public class DisplayParentUpdateReport {
    private final Artifact parentArtifact;
    private final String currentVersion;
    private final String latestVersion;

    public DisplayParentUpdateReport(Artifact parentArtifact, String currentVersion, String latestVersion) {
        this.parentArtifact = parentArtifact;
        this.currentVersion = currentVersion;
        this.latestVersion = latestVersion;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public Artifact getParentArtifact() {
        return parentArtifact;
    }
}
