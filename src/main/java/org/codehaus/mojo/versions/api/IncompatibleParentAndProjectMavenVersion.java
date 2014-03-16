package org.codehaus.mojo.versions.api;

public class IncompatibleParentAndProjectMavenVersion {
    private String parentVersion;
    private String projectVersion;

    public String getParentVersion() {
        return parentVersion;
    }

    public void setParentVersion(String parentVersion) {
        this.parentVersion = parentVersion;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public void setProjectVersion(String projectVersion) {
        this.projectVersion = projectVersion;
    }
}
