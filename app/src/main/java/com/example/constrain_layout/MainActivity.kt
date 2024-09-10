package com.example.constrain_layout

import android.app.Activity
import android.app.ActivityManager
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.constrain_layout.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btn1.setOnClickListener{
            Toast.makeText(this, "This is a toast message", Toast.LENGTH_SHORT).show()
        }
        binding.btn2.setOnClickListener{
            Snackbar.make(it,"This Is my Snackbar message",Snackbar.LENGTH_SHORT).show()
        }
        binding.btn3.setOnClickListener{

            AlertDialog.Builder(this).apply {
                setTitle("Do you want to exit this screen")
                setPositiveButton("Yes"){_,_->
                    finish()
                    Toast.makeText(this@MainActivity, "Positive", Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("No"){_,_->
                    Toast.makeText(this@MainActivity, "Negative", Toast.LENGTH_SHORT).show()
                }
                setCancelable(false)
                show()
            }
        }
    }
}