package org.togglz.core.repository.mem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.togglz.core.Feature;
import org.togglz.core.repository.FeatureState;
import org.togglz.core.repository.StateRepository;


/**
 * 
 * A very simply implementation of {@link StateRepository} entirely on memory. This class is typically only used for
 * integration tests or at development time.
 * 
 * @author Christian Kaltepoth
 * 
 */
public class InMemoryStateRepository implements StateRepository {

    private final Map<String, FeatureState> states = new ConcurrentHashMap<String, FeatureState>();

    public FeatureState getFeatureState(Feature feature) {
        return states.get(feature.name());
    }

    public void setFeatureState(FeatureState featureState) {
        states.put(featureState.getFeature().name(), featureState);
    }

}
