package com.agoda.generator.annotations

import com.agoda.generator.visitor.AppendExperimentsVariantBVisitor
import com.agoda.generator.visitor.DefaultVisitor
import com.kaptwithannotationlevel.aptmodule.annotations.ExperimentDesc
import com.kaptwithannotationlevel.aptmodule.annotations.VariantB
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.asClassName
import javax.lang.model.element.AnnotationMirror
import javax.lang.model.element.TypeElement

class AnnotationProvider {


    fun get(it: AnnotationMirror, values: Array<ExperimentDesc>): AnnotationSpec {
        val element = it.annotationType.asElement() as TypeElement
        val builder = AnnotationSpec.builder(element.asClassName())
        val member = CodeBlock.builder()
        val visitor = when (it.annotationType.asElement().simpleName.toString()) {
            VariantB::class.simpleName -> AppendExperimentsVariantBVisitor(member, it.elementValues.toList()
                    .flatMap {
                        listOf(it.second)
                    }, values)
            else -> DefaultVisitor(member)
        }

        for (executableElement in it.elementValues.keys) {
            val name = executableElement.simpleName.toString()
            if (name != "value") {
                CodeBlock.builder().add("%L = ", name)
            }
            val value = it.elementValues[executableElement]!!
            value.accept(visitor, name)
            builder.addMember(member.build())
        }

        return builder.build()
    }

    fun get(values: Array<ExperimentDesc>): CodeBlock {
        val member = CodeBlock.builder()
        var index = 0
        for (executableElement in values) {
            if (index > 0) {
                member.add(",\n${executableElement.javaClass}.$executableElement")
            } else {
                member.add("${executableElement.javaClass}.$executableElement")
                index++
            }
        }
        return member.build()
    }


}