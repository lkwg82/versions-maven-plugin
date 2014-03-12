package org.codehaus.mojo.versions.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DependencyUpdates {
    private final Map<String,List<ArtifactUpdate>> updatePerSectionMap = new HashMap<String, List<ArtifactUpdate>>(2);

    public void addUpdate(String section, ArtifactUpdate update){
        if ( !updatePerSectionMap.containsKey(section)){
            updatePerSectionMap.put(section, new ArrayList<ArtifactUpdate>());
        }
        updatePerSectionMap.get(section).add(update);
    }

    public Map<String, List<ArtifactUpdate>> getUpdatePerSectionMap() {
        return updatePerSectionMap;
    }
}
