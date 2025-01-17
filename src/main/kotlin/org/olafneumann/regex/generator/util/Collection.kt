package org.olafneumann.regex.generator.util

fun Collection<Any>.toIndexedString(prefix: String = ""): String =
    this
        .mapIndexed { index, recognizerMatch -> index to recognizerMatch }
        .joinToString(separator = "\n", prefix = prefix) { "${it.first}: ${it.second}" }

