/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liferay.blade.samples.modellistener;

import org.osgi.service.component.annotations.Component;

import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

/**
 * @author Liferay
 */
@Component(immediate = true, service = ModelListener.class)
public class CustomFormRecordListener extends BaseModelListener<DDMFormInstanceRecord> {

	@Override
	public void onBeforeCreate(DDMFormInstanceRecord model) throws ModelListenerException {
		System.out.println(
			"About to add a form record: " + model.getPrimaryKey());

	}

}