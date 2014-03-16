package org.codehaus.mojo.versions.report;

public class ArtifactUpdate {
    private Dependency dependency;
    private String versionUpdate;

    public Dependency getDependency() {
        return dependency;
    }

    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    public String getVersionUpdate() {
        return versionUpdate;
    }

    public void setVersionUpdate(String versionUpdate) {
        this.versionUpdate = versionUpdate;
    }
}
