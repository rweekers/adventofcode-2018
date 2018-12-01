package nl.orangeflamingo.adventofcode2018

internal object Utils

fun resourceAsListOfString(fileName: String): List<String> =
        Utils.javaClass.getResource(fileName).openStream().bufferedReader()
                .readLines()