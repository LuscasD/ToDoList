package com.example.todolistandroid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.todolistandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


     private lateinit var binding: ActivityMainBinding
     private  lateinit var  taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        binding.newTaskButton.setOnClickListener{

            newTask().show(supportFragmentManager, "newTaskTag")
        }

        taskViewModel.name.observe(this)
        {
            binding.taskName.text = String.format("Nome da tarefa: %s", it)
        }
        taskViewModel.desc.observe(this)
        {
            binding.taskDesc.text = String.format("Nome da tarefa: %s", it)
        }

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}