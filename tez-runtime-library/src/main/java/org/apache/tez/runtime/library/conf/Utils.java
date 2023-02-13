/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.tez.runtime.library.conf;

import org.apache.hadoop.classification.InterfaceAudience.Private;
import org.apache.tez.dag.api.EdgeProperty;

@Private
class Utils {

    /**
     * Modify the EdgeProperty to set the history text if available
     *
     * @param edgeConfig   Edge config
     * @param edgeProperty Edge property to be be modified
     */
    static void setEdgePropertyHistoryText(HadoopKeyValuesBasedBaseEdgeConfig edgeConfig,
                                           EdgeProperty edgeProperty) {
        String inputHistoryText = edgeConfig.getInputHistoryText();
        if (inputHistoryText != null) {
            edgeProperty.getEdgeDestination().setHistoryText(inputHistoryText);
        }

        String outputHistoryText = edgeConfig.getOutputHistoryText();
        if (outputHistoryText != null) {
            edgeProperty.getEdgeSource().setHistoryText(outputHistoryText);
        }
    }
}
