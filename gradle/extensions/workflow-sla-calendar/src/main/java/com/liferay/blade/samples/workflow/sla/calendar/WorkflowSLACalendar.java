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

package com.liferay.blade.samples.workflow.sla.calendar;

import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.workflow.metrics.sla.calendar.WorkflowMetricsSLACalendar;

import java.time.Duration;
import java.time.LocalDateTime;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Russ Bohl
 */
@Component(property = "sla.calendar.key=custom")
public class WorkflowSLACalendar implements WorkflowMetricsSLACalendar {

	@Override
	public Duration getDuration(
		LocalDateTime startLocalDateTime, LocalDateTime endLocalDateTime) {

		return Duration.between(startLocalDateTime, endLocalDateTime);
	}

	@Override
	public LocalDateTime getOverdueLocalDateTime(
		LocalDateTime nowLocalDateTime, Duration remainingDuration) {

		return nowLocalDateTime.plus(remainingDuration);
	}

	@Override
	public String getTitle(Locale locale) {
		return _language.get(locale, "5 days per week, 8 hours per day");
	}

	@Reference
	private Language _language;

}
