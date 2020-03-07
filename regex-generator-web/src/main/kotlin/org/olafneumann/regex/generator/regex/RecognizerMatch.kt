package org.olafneumann.regex.generator.regex

import org.olafneumann.regex.generator.util.HasRange

class RecognizerMatch(
    ranges: List<IntRange>,
    val inputPart: String,
    val recognizer: Recognizer
) : HasRange {
    val ranges: List<IntRange>
    override val first: Int
    override val last: Int
    override val length: Int

    init {
        if (ranges.isEmpty()) {
            throw IllegalArgumentException("RecognizerMatch without ranges is not allowed.")
        }
        this.ranges = ranges.sortedWith(compareBy({ it.first }, { it.last }))
        this.first = this.ranges[0].first
        this.last = this.ranges[this.ranges.size - 1].last
        this.length = last - first + 1
    }

    // TODO remove this method!!!!
    fun intersect(other: RecognizerMatch): Boolean =
        ranges.flatMap { thisRange -> other.ranges.map { otherRange -> thisRange to otherRange } }
            .any { it.first.intersect(it.second).isNotEmpty() }

    fun hasSameRangesAs(other: RecognizerMatch): Boolean {
        if (ranges.size != other.ranges.size) {
            return false
        }
        return ranges.mapIndexed { index, range -> range == other.ranges[index] }
            .all { it }
    }

    override fun equals(other: Any?): Boolean =
        other is RecognizerMatch
                && recognizer == other.recognizer
                && hasSameRangesAs(other)

    override fun toString(): String =
        "[$first+$length] (${recognizer.name}: ${recognizer.outputPattern}) $inputPart"

    override fun hashCode(): Int {
        var result = inputPart.hashCode()
        result = 31 * result + recognizer.hashCode()
        result = 31 * result + ranges.hashCode()
        result = 31 * result + first
        result = 31 * result + last
        result = 31 * result + length
        return result
    }
}


