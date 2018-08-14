package com.agoda.generator.visitor

import com.squareup.kotlinpoet.CodeBlock
import javax.lang.model.util.SimpleAnnotationValueVisitor7


class ReplaceIdVisitor constructor(
        private val builder: CodeBlock.Builder
) : SimpleAnnotationValueVisitor7<CodeBlock.Builder, String>(builder) {

    override fun defaultAction(o: Any, name: String) = builder.add(
            CodeBlock.of("%S", "GENERATED_$o"))

}