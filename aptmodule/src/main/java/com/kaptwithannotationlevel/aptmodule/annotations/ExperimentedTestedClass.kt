package com.agoda.generator.annotations

import com.kaptwithannotationlevel.aptmodule.annotations.ExperimentDesc
import javax.lang.model.element.Element
import javax.lang.model.type.TypeMirror


class ExperimentedTestedClass(val typeElement: Element, val values: Array<ExperimentDesc>) {

    val type: TypeMirror
        get() = typeElement.asType()
}