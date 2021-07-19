package com.example.materialtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val fruits = mutableListOf(

        Fruit("Apple", R.drawable.apple),
        Fruit("Apple", R.drawable.apple),
        Fruit("Apple", R.drawable.apple),
        Fruit("Apple", R.drawable.apple),
        Fruit("Apple", R.drawable.apple),
        Fruit("Apple", R.drawable.apple),
        Fruit("Banana", R.drawable.banana),
        Fruit("Apple", R.drawable.apple),
        Fruit("Apple", R.drawable.apple),
        Fruit("Apple", R.drawable.apple),
        Fruit("Apple", R.drawable.apple),
        Fruit("Apple", R.drawable.apple),

    )

    val fruitList = ArrayList<Fruit>()

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolBar)

        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        navView.setCheckedItem(R.id.navCall)
        navView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()
            true
        }

        fab.setOnClickListener {
//            Toast.makeText(this, "FAB clicked", Toast.LENGTH_SHORT).show()
            Snackbar.make(it, "Data deleted", Snackbar.LENGTH_SHORT)
                .setAction("Undo") {
                    Toast.makeText(this, "Data restored", Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        initFruitList()

        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(this, fruitList)
        recyclerView.adapter = adapter

        swipeRefresh.setColorSchemeResources(R.color.white)
        swipeRefresh.setOnRefreshListener {
            refreshFruits(adapter)
        }

    }

    fun refreshFruits(adapter: FruitAdapter) {
        thread {
            Thread.sleep(2000)
            runOnUiThread {
                initFruitList()
                adapter.notifyDataSetChanged()
                swipeRefresh.isRefreshing = false
            }
        }
    }

    fun initFruitList() {
        fruitList.clear()
        repeat(50) {
            val index = (0 until fruits.size).random()
            fruitList.add(fruits[index])
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            android.R.id.home -> drawerLayout.openDrawer(GravityCompat.START)

            R.id.backup -> {

//                Snackbar.make(window.decorView,"aaaaaaaaaaaaaa",Snackbar.LENGTH_LONG).show()

                Toast.makeText(
                    this,
                    "you clicked backup",
                    Toast.LENGTH_LONG
                )
                    .show()
                Log.d(TAG, "onOptionsItemSelected: 1233344")
            }
            R.id.delete -> Toast.makeText(
                this,
                "you clicked delete",
                Toast.LENGTH_SHORT
            )
                .show()
            R.id.settings -> Toast.makeText(
                this,
                "you clicked settings",
                Toast.LENGTH_SHORT
            )
                .show()
        }

        return true
    }

}