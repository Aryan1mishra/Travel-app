package com.example.travellapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var current=0
    lateinit var image:ImageView
    var places= arrayOf("Mumbai","golden temple","Hawa maal","taj mahal","jaipur")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nxt=findViewById<ImageButton>(R.id.next)
        val pre=findViewById<ImageButton>(R.id.previous)
        var myplace=findViewById<TextView>(R.id.Vname)

        nxt.setOnClickListener{
            //i want to see next image
            var currentImageIdString="pic$current"
            var CurrentIdimageInt= this.resources.getIdentifier(currentImageIdString,"id",packageName)
            image=findViewById(CurrentIdimageInt)
            image.alpha=0f

            current=(5+current+1)%5
            var imageToshowString="pic$current"
            var imageToshowInt= this.resources.getIdentifier(imageToshowString,"id",packageName)
            image=findViewById(imageToshowInt)
            image.alpha=1f

            myplace.text=places[current]

        }
        pre.setOnClickListener{

            //want to see previous image
            var currentImageIdString="pic$current"
            var CurrentIdimageInt= this.resources.getIdentifier(currentImageIdString,"id",packageName)
            image=findViewById(CurrentIdimageInt)
            image.alpha=0f

            current=(5+current-1)%5
            var imageToshowString="pic$current"
            var imageToshowInt= this.resources.getIdentifier(imageToshowString,"id",packageName)
            image=findViewById(imageToshowInt)
            image.alpha=1f
            myplace.text=places[current]
        }
    }
}