package com.agoda.generator.annotations

import com.agoda.mobile.consumer.domain.experiments.ExperimentId
import javax.lang.model.element.Element
import javax.lang.model.type.TypeMirror


class ExperimentedTestedClass(val typeElement: Element, val values: Array<ExperimentId>) {

    val type: TypeMirror
        get() = typeElement.asType()
}