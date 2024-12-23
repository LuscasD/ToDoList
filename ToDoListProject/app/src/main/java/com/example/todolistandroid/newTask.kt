package com.example.todolistandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.todolistandroid.databinding.FragmentNewTaskBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class newTask : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewTaskBinding
    private lateinit var  taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activity = requireActivity()
        taskViewModel = ViewModelProvider(activity).get(taskViewModel::class.java)
        binding.saveButton.setOnClickListener{

            saveAction()

        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun  saveAction(){
        taskViewModel.name.value = binding.name.text.toString()
    }


}