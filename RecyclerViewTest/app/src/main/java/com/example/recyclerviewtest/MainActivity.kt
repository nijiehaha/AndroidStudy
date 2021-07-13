package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.listviewtest.Fruit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private val data = listOf<String>("Apple", "Banana", "Orange", "Watermelon",
//        "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
//        "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple",
//        "Strawberry", "Cherry", "Mango",
//    )
    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFruits()
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        val layoutManager = StaggeredGridLayoutManager(
            3,
            StaggeredGridLayoutManager.VERTICAL,
        )
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(fruitList)
        recyclerView.adapter = adapter
    }
    private fun initFruits() {
//        for (name in data) {
//            fruitList.add(Fruit(name, 0))
//        }
        repeat(2) {
            fruitList.add(Fruit(getRandomLengthString("apple")))
            fruitList.add(Fruit(getRandomLengthString("apple")))
            fruitList.add(Fruit(getRandomLengthString("apple")))
            fruitList.add(Fruit(getRandomLengthString("apple")))
            fruitList.add(Fruit(getRandomLengthString("apple")))
            fruitList.add(Fruit(getRandomLengthString("apple")))
            fruitList.add(Fruit(getRandomLengthString("apple")))
            fruitList.add(Fruit(getRandomLengthString("apple")))
            fruitList.add(Fruit(getRandomLengthString("apple")))
            fruitList.add(Fruit(getRandomLengthString("apple")))
            fruitList.add(Fruit(getRandomLengthString("apple")))
            fruitList.add(Fruit(getRandomLengthString("apple")))
            fruitList.add(Fruit(getRandomLengthString("apple")))
            fruitList.add(Fruit(getRandomLengthString("apple")))
            fruitList.add(Fruit(getRandomLengthString("apple")))
            fruitList.add(Fruit(getRandomLengthString("apple")))
            fruitList.add(Fruit(getRandomLengthString("apple")))
            fruitList.add(Fruit(getRandomLengthString("apple")))
        }
    }
    private fun getRandomLengthString(str: String): String {
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(str)
        }
        return builder.toString()
    }
}