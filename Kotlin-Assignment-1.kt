package com.example.kotlinassignment

import java.io.File
import java.util.*

fun convert (number : Float, unit1 :Int):Float
{
        val units = mapOf("1" to 1000, "2" to 0.001, "3" to 100, "4" to 0.01, "5" to 10, "6" to 0.1, "7" to 100000, "8" to 0.00001)
        return number * units[unit1.toString()]!!.toFloat()
}

fun logEntry(num : Float, outputString: String, numConvert : Float)
{
        File("Log_File.txt").appendText(Calendar.getInstance().time.toString() + ": $num $outputString$numConvert \n")

}

fun displayMenu()
{
        println("Hello... Welcome to the Unit Convertor!")
        println("Please choose anyone of the following option.")
        println("Press 1 to convert km into m")
        println("Press 2 to convert m into km")
        println("Press 3 to convert m into cm")
        println("Press 4 to convert cm into m")
        println("Press 5 to convert cm into mm")
        println("Press 6 to convert mm into cm")
        println("Press 7 to convert km into cm")
        println("Press 8 to convert cm into km")
        println("Press 9 to print the log.")
        println("Press 0 to quit the program.")
        println()
}

fun readLog()
{
        println()
        println("Log File:")
        val fileName = "Log_File.txt"
        val file = File(fileName)
        //since the purpose of this part of the code is just to print the log file, no need to bring the whole file into an array of string unnecessary memory used as the log is only needed to be printed.
        //so one line read and printed at a time
        file.forEachLine {
                println(it)
        }
        println(); println()

}

fun main()
{
        while (true)
        {
                displayMenu()
                print("Choose your option: ")
                val choice = readLine()!!.toInt()   //!! to ensure input is not null

                val outputString = listOf("", "km to m: ", "m to km: ", "m to cm: ", "cm to m: ", "cm to mm: ", "mm to cm: ", "km to cm: ", "cm to km: ")
                var numConvert : Float
                var number : Float?

                when (choice)
                {
                        0 -> {
                                println("Quitting......"); println()
                                break
                        }
                        9 -> {
                                readLog()
                                continue
                        }
                        in 1..8 -> {
                                print("Please write the number to convert: ")
                                number = readLine()!!.toFloat()
                                numConvert = convert(number, choice)
                        }
                        else -> {
                                println("Wrong option selected. Please try again.")
                                println(); println()
                                continue
                        }
                }
                println("$number ${outputString[choice]}$numConvert")
                logEntry(number, outputString[choice], numConvert)
                println(); println()
        }
        println("Thank You for using Unit Converter")
}