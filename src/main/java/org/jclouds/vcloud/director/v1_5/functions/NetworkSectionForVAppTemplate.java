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
package org.jclouds.vcloud.director.v1_5.functions;

import javax.inject.Singleton;

import org.jclouds.vcloud.director.v1_5.domain.dmtf.ovf.SectionType;
import org.jclouds.vcloud.director.v1_5.domain.dmtf.ovf.NetworkSection;
import org.jclouds.vcloud.director.v1_5.domain.VAppTemplate;
import com.google.common.base.Function;

@Singleton
public class NetworkSectionForVAppTemplate implements Function<VAppTemplate, NetworkSection> {

   @SuppressWarnings("unchecked")
   @Override
   public NetworkSection apply(VAppTemplate from) {
      for (SectionType section : from.getSections()) {
         if (section instanceof NetworkSection) {
            return (NetworkSection) section;
         }
      }
      return null;
   }
}
