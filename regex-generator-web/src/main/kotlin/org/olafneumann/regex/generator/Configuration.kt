package org.olafneumann.regex.generator

data class Configuration(
    val groups: Map<String, String> = mapOf(),
    val recognizers: List<Recognizer>
) {
    companion object {
        // val config = js("require('settings.json')") as Configuration
        val config = Configuration(recognizers = listOf(
                Recognizer("number", "([0-9]+)")
        ))
    }
}