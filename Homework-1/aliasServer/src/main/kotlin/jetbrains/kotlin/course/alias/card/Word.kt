// Define the package related to cards in the game
package jetbrains.kotlin.course.alias.card

// The '@JvmInline' annotation tells the Kotlin compiler to generate an inline class,
// which is a class that is repped by a single value and optimised for performance in JVM bytecode
@JvmInline

// Defines a value class 'Word' that holds a single string value repping a word
value class Word(val word: String)



// KEY NOTE TO KNOW
//  JVM bytecode is the intermediate representation of code that is executed by the Java Virtual Machine (JVM).
//  It is a low-level, platform-independent set of instructions generated when Java source code is compiled by the Java compiler (javac)