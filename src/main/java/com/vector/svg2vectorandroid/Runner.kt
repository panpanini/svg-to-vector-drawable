package com.vector.svg2vectorandroid


val usage = """
    Provide source directory as first argument for svg files to be converted 
    example: java -jar Svg2VectorAndroid-1.1.2.jar <SourceDirectoryPath>
""".trimIndent()

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        return println(usage)
    }

    if (args.contains("--help")) {
        return println(usage)
    }

    val sourceDirectory = args[0]
    val destinationDirectory = args.getOrNull(1)
    if (sourceDirectory.isNotEmpty()) {
        val processor = if (destinationDirectory != null) {
            SvgFilesProcessor(sourceDirectory, destinationDirectory)
        } else {
            SvgFilesProcessor(sourceDirectory)
        }
        processor.process()
    }
}
