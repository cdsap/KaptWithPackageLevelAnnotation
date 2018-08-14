package com.agoda.generator

import com.agoda.generator.annotations.ExperimentTarget
import com.google.auto.service.AutoService
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

@AutoService(Processor::class)
class KakatuaProcessor : AbstractProcessor() {
    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(ExperimentTarget::class.java.name)
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latest()
    }

    override fun process(
            annotations: MutableSet<out TypeElement>?,
            roundEnv: RoundEnvironment?
    ): Boolean {
        Kakatua(processingEnv).init(roundEnv)
        return true
    }
}

