package com.example.kotlinassignment

import java.io.File
import java.lang.Exception
import java.util.*

object multiply{
        fun times(num1 : Float, num2 : Float): Float{
                return num1.times(num2)
        }
}

fun convert (number : Float, unit1 :Int):Float
{
        val units = mapOf("1" to 1000, "2" to 0.001, "3" to 100, "4" to 0.01, "5" to 10, "6" to 0.1, "7" to 100000, "8" to 0.00001)
        val multiplier = multiply
        return multiplier.times(number, units[unit1.toString()]!!.toFloat())
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

object filewriter{
        val fileName = "Log_File.txt"
        fun write(output: String): Boolean {
                try{
                        File(fileName).appendText(Calendar.getInstance().time.toString() + ": $output \n")
                        return true
                }
                catch (e : Exception){
                        return false
                }
        }
}

object fileReader{
        val fileName = "Log_File.txt"
        fun printlog(){
                File(fileName).forEachLine{
                        println(it)
                }
                println(); println()
        }
}

fun checkInput1(InputString: String): List<String>{
        var choice = InputString

        while (choice == ""){
                print("Choose your option: ")
                choice = readLine()!!
        }

        try{
                choice.toInt()
                return listOf("true", choice)
        }
        catch (e: Exception){
                println("Characters not allowed")
                println(); println()
                return listOf("false", "")
        }
}

fun checkInput2(InputString: String): List<String>{
        var choice = InputString

        while (choice == ""){
                print("Please write the number to convert: ")
                choice = readLine()!!
        }

        try{
                choice.toFloat()
                return listOf("true", choice)
        }
        catch (e: Exception){
                println("Characters not allowed")
                println(); println()
                return listOf("false", "")
        }
}

fun main()
{
        val writelog = filewriter
        val readlog = fileReader

        val outputString = listOf("", "km to m: ", "m to km: ", "m to cm: ", "cm to m: ", "cm to mm: ", "mm to cm: ", "km to cm: ", "cm to km: ")
        var numConvert : Float
        var number : Float?
        var choiceNum: Int

        while (true)
        {
                displayMenu()
                print("Choose your option: ")
                var choice = readLine()!!
                val checkResult = checkInput1(choice)
                if (checkResult[0] == "false"){
                     continue
                }

                choiceNum = checkResult[1].toInt()
                when (choiceNum)
                {
                        0 -> {
                                println("Quitting......"); println()
                                break
                        }
                        9 -> {
                                readlog.printlog()
                                continue
                        }
                        in 1..8 -> {
                                print("Please write the number to convert: ")
                                val numTemp = readLine()!!
                                val checkResult2 = checkInput2(numTemp)
                                if (checkResult2[0] == "false"){
                                        continue
                                }

                                number = checkResult2[1].toFloat()
                                numConvert = convert(number, choiceNum)
                        }
                        else -> {
                                println("Wrong option selected. Please try again.")
                                println(); println()
                                continue
                        }
                }
                val output = "$number ${outputString[choiceNum]}$numConvert"
                if (writelog.write(output))
                {
                        println(output)
                }
                else{
                        println("Log could not be updated")
                }
                println(); println()
        }
        println("Thank You for using Unit Converter")
}
