package com.komodgn.snack.convention

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? {
    return add("implementation", dependencyNotation)
}

fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? {
    return add("debugImplementation", dependencyNotation)
}

fun DependencyHandler.implementationProject(path: String): Dependency? {
    return add("implementation", project(path))
}

