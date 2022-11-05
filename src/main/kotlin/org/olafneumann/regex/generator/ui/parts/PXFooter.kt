package org.olafneumann.regex.generator.ui.parts

import org.olafneumann.regex.generator.ui.model.DisplayModel
import org.olafneumann.regex.generator.output.PatternUrlGenerator
import org.olafneumann.regex.generator.ui.HtmlView
import org.olafneumann.regex.generator.ui.utils.HtmlHelper
import org.olafneumann.regex.generator.ui.components.LinkHandler

class PXFooter {
    private val anchorRegex101 = LinkHandler(
        HtmlHelper.getElementById(HtmlView.ID_ANCHOR_REGEX101),
        PatternUrlGenerator("Regex101", "https://regex101.com/?regex=%1\$s&flags=g%2\$s&delimiter=/")
    )
    private val anchorRegexr = LinkHandler(
        HtmlHelper.getElementById(HtmlView.ID_ANCHOR_REGEXR),
        PatternUrlGenerator("Regexr", "https://regexr.com/?expression=%1\$s&text=")
    )

    fun applyModel(model: DisplayModel) {
        val currentPattern = model.patternRecognizerModel.regularExpression.pattern
        val options = model.patternRecognizerModel.options

        anchorRegex101.setPattern(currentPattern, options)
        anchorRegexr.setPattern(currentPattern, options)
    }
}