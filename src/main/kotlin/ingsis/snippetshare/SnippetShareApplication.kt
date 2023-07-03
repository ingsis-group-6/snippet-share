package ingsis.snippetshare

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.metrics.export.datadog.EnableDatadogMetrics

@SpringBootApplication
@EnableDatadogMetrics
class SnippetShareApplication

fun main(args: Array<String>) {
	runApplication<SnippetShareApplication>(*args)
}
