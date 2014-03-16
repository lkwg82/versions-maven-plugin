package org.codehaus.mojo.versions.api;

public class DisplayParentUpdateReport {
    private String currentVersion;
    private String latestVersion;
    private String groupId;
    private String parentArtifactId;

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
    }

    public void setParentGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setParentArtifactId(String parentArtifactId) {
        this.parentArtifactId = parentArtifactId;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getParentArtifactId() {
        return parentArtifactId;
    }
}
