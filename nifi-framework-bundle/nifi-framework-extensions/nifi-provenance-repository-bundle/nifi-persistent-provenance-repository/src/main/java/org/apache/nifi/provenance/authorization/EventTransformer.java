/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.nifi.provenance.authorization;

import java.util.Optional;

import org.apache.nifi.provenance.PlaceholderProvenanceEvent;
import org.apache.nifi.provenance.ProvenanceEventRecord;

/**
 * An interface for transforming a Provenance Event for which the user is not authorized to access
 */
public interface EventTransformer {

    Optional<ProvenanceEventRecord> transform(ProvenanceEventRecord unauthorizedEvent);

    /**
     * An EventTransformer that transforms any event into an Empty Optional
     */
    EventTransformer EMPTY_TRANSFORMER = event -> Optional.empty();

    /**
     * An EventTransformer that transforms any event into a Placeholder event
     */
    EventTransformer PLACEHOLDER_TRANSFORMER = event -> Optional.of(new PlaceholderProvenanceEvent(event));

}
