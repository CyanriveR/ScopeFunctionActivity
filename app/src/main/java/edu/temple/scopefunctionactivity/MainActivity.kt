package edu.temple.scopefunctionactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val numbers = listOf<Double>(2.0, 2.1, 2.2, 2.2)
        Log.d("function output", getTestDataArray().toString())
        Log.d("output", averageLessThanMedian(numbers).toString())
        // You can test your helper functions by  calling them from onCreate() and
        // printing their output to the Log, which is visible in the LogCat:
        // eg. Log.d("function output", getTestDataArray().toString())

    }


    /* Convert all the helper functions below to Single-Expression Functions using Scope Functions */
    // eg. private fun getTestDataArray() = ...

    // HINT when constructing elaborate scope functions:
    // Look at the final/return value and build the function "working backwards"

    // Return a list of random, sorted integers
    private fun getTestDataArray() = MutableList(10) { Random.nextInt() % 10 }.apply {
        sort()
    }.toList()


    // Return true if average value in list is greater than median value, false otherwise
    private fun averageLessThanMedian(listOfNumbers: List<Double>) = listOfNumbers.let {
        with(listOfNumbers.sorted()) {
            if (size % 2 == 0)
                it.average() < (this[size / 2] + this[(size - 1) / 2]) / 2
            else
                it.average() < this[size / 2]
        }
    }


    // Create a view from an item in a collection, but recycle if possible (similar to an AdapterView's adapter)
    private fun getView(position: Int, recycledView: View?, collection: List<Int>, context: Context) =
        if (recycledView != null) {
            (recycledView as TextView)
        }
        else {
            TextView(context).apply {
                setPadding(5, 10, 10, 0)
                textSize = 22f
            }
        }.apply {
        text= collection[position].toString()
    }
}
