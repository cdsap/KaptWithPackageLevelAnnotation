package com.agoda.generator.entities


data class Meta(val options: Map<String, String>) {
    val path: String? = options["kapt.kotlin.generated"]?.replace("(.*)tmp(/kapt/debug/)kotlinGenerated".toRegex(),
            "$1generated/source$2")
}
