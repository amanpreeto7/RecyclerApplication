package com.o7solutions.recyclerapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.o7solutions.recyclerapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ClickInterface {
    lateinit var binding: ActivityMainBinding
    lateinit var recyclerClass: RecyclerClass
    lateinit var layoutManager: LinearLayoutManager
    lateinit var  gridLayoutManager: GridLayoutManager
    var stringArray = mutableListOf<String>("Ameesha", "Shabnam", "Shivani","Navjot")
    var studentArray = ArrayList<Student>()

    lateinit var studentRecycler : StudentRecycler
    lateinit var newAdapter : NewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerClass = RecyclerClass(stringArray, this)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        gridLayoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.layoutManager = layoutManager

        studentArray.add(Student(id=0, name = "Nitish", sClass = "Android"))
        studentArray.add(Student(id=1, name = "Rupesh", sClass = "Android"))
        studentArray.add(Student(id=2, name = "Jaidev", sClass = "Android"))
        studentArray.add(Student(id=3, name = "Gaurav", sClass = "Android"))
        studentArray.add(Student(id=3, name = "Gaurav", sClass = "Android"))
        studentArray.add(Student(id=3, name = "Gaurav", sClass = "Android"))
        studentArray.add(Student(id=3, name = "Gaurav", sClass = "Android"))
        studentArray.add(Student(id=3, name = "Gaurav", sClass = "Android"))
        studentArray.add(Student(id=3, name = "Gaurav", sClass = "Android"))
        studentArray.add(Student(id=3, name = "Gaurav", sClass = "Android"))

        studentRecycler = StudentRecycler(studentArray)
        newAdapter = NewAdapter(studentArray)
        binding.recyclerView.adapter = newAdapter

        binding.recyclerView.addOnScrollListener(object  : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(layoutManager.findLastVisibleItemPosition() == (studentArray.size-1)){
                    studentArray.add(Student(id=120, name = "Nitish", sClass = "Android"))
                    studentArray.add(Student(id=121, name = "Rupesh", sClass = "Android"))
                    studentArray.add(Student(id=234, name = "Jaidev", sClass = "Android"))
                    studentArray.add(Student(id=334, name = "Gaurav", sClass = "Android"))
                    newAdapter.notifyDataSetChanged()
                }
            }
        })
      //  binding.recyclerView.adapter = studentRecycler

    }

    override fun onItemClick(string: String) {
        System.out.println("in click interface $string")
    }
}