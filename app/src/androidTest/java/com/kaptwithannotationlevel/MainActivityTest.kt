package com.kaptwithannotationlevel

import android.support.test.rule.ActivityTestRule
import com.agoda.generator.annotations.ExperimentTarget
import com.kaptwithannotationlevel.aptmodule.annotations.ExperimentDesc
import com.kaptwithannotationlevel.aptmodule.annotations.VariantB
import org.junit.Rule
import org.junit.Test


@ExperimentTarget([ExperimentDesc.VALUE_1])
open class KotlinTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java)


    @Test
    @VariantB([ExperimentDesc.VALUE_2, ExperimentDesc.VALUE_3])
    fun testAssert() {
        assert(true)
    }

   // @Test
   // fun testAssert2() {
   //     assert(true)
   // }

    fun testWithoutAnnotationShouldNotBeIncluded() {

    }

}
