import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

// Reads lines from the given input txt file.

fun readInput(parent: String, name: String) = File("src$parent", "$name.txt").readLines()
fun readInputAsInt(parent: String, name: String) = File("src$parent", "$name.txt").readLines().map { it -> it.toInt() }

// Converts string to md5 hash. 
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
