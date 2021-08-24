package com.example.kotlinassignment

import java.io.File
import java.util.*

fun convert (number : Float?, unit1 :String, unitConvert:String):Double
{
        val units = mapOf("km" to 1000.0, "m" to 1.0, "cm" to 0.01, "mm" to 0.001)
        return number!! * units[unit1]!! / units[unitConvert]!!

}

fun logEntry(num : Float, numConvert : Double, unit : String, unitConvert: String)
{
        File("Log_File.txt").appendText(Calendar.getInstance().time.toString() + ": $num $unit is converted to $numConvert $unitConvert. \n")

}

fun main()
{
        while (true)
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
                print("Choose your option: ")
                val choice = readLine()!!   //!! to ensure input is not null

                var unit : String?
                var unitConvert : String?
                var numConvert : Double
                var num : Float

                when (choice)
                {
                        "0" -> {
                                println("Quitting......")
                                println()
                                break
                        }
                        "9" -> {
                                println()
                                println("Log File:")
                                val fileName = "Log_File.txt"
                                val file = File(fileName)
                                //since the purpose of this part of the code is just to print the
                                //log file, no need to bring the whole file into an array of string
                                //unnecessary memory used as the log is only needed to be printed.
                                //so one line read and printed at a time
                                file.forEachLine {
                                        println(it)
                                }

                                println()
                                println()
                                continue
                        }
                        "1" -> {
                                println()
                                print("Please write the number to convert: ")
                                val number = readLine()!!
                                num = number.toFloat()
                                unit = "km"
                                unitConvert = "m"
                                numConvert = convert(num,unit,unitConvert)

                        }
                        "2" -> {
                                println()
                                print("Please write the number to convert: ")
                                val number = readLine()!!
                                num = number.toFloat()
                                unit = "m"
                                unitConvert = "km"
                                numConvert = convert(num,unit,unitConvert)

                        }
                        "3" -> {
                                println()
                                print("Please write the number to convert: ")
                                val number = readLine()!!
                                num = number.toFloat()
                                unit = "m"
                                unitConvert = "cm"
                                numConvert = convert(num,unit,unitConvert)

                        }
                        "4" -> {
                                println()
                                print("Please write the number to convert: ")
                                val number = readLine()!!
                                num = number.toFloat()
                                unit = "cm"
                                unitConvert = "m"
                                numConvert = convert(num,unit,unitConvert)

                        }
                        "5" -> {
                                println()
                                print("Please write the number to convert: ")
                                val number = readLine()!!
                                num = number.toFloat()
                                unit = "cm"
                                unitConvert = "mm"
                                numConvert = convert(num,unit,unitConvert)

                        }
                        "6" -> {
                                println()
                                print("Please write the number to convert: ")
                                val number = readLine()!!
                                num = number.toFloat()
                                unit = "mm"
                                unitConvert = "cm"
                                numConvert = convert(num,unit,unitConvert)

                        }
                        "7" -> {
                                println()
                                print("Please write the number to convert: ")
                                val number = readLine()!!
                                num = number.toFloat()
                                unit = "km"
                                unitConvert = "cm"
                                numConvert = convert(num,unit,unitConvert)

                        }
                        "8" -> {
                                println()
                                print("Please write the number to convert: ")
                                val number = readLine()!!
                                num = number.toFloat()
                                unit = "cm"
                                unitConvert = "km"
                                numConvert = convert(num,unit,unitConvert)

                        }
                        else -> {
                                println("Wrong option selected. Please try again.")
                                println()
                                println()
                                continue
                        }

                }
                println("$num $unit is converted to $numConvert $unitConvert")
                logEntry(num,numConvert,unit,unitConvert)
                println()
                println()


        }

        println("Thank You for using Unit Converter")


}
