package com.agoda.generator.annotations

import com.agoda.mobile.consumer.domain.experiments.ExperimentId


annotation class ExperimentTarget(val values: Array<ExperimentId> = [])