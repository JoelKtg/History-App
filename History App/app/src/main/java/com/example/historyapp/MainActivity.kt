package com.example.historyapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var figuresArr= listOf(HistoricalPeople(R.drawable.pointing,56,"joemama","handsome")
            , HistoricalPeople(R.drawable.mandela,99,"Nelson Mandela", "Mandela was the first black President of South Africa"),
            HistoricalPeople(R.drawable.pngegg,86, "Nikolas Tesla","Invented electricity" ),
            HistoricalPeople(R.drawable.adolf, 56,"Adolf Hitler", "War Lord")
            )
        var inputField=findViewById<EditText>(R.id.editText)
        val clearBtn=findViewById<Button>(R.id.clearBtn)
        val searchBtn=findViewById<Button>(R.id.searchBtn)
        var figureInfo=findViewById<TextView>(R.id.infoTv)
        var figureIv=findViewById<ImageView>(R.id.figureIv)
        var notFoundIv=findViewById<ImageView>(R.id.notFoundIv)

        notFoundIv.setImageDrawable(null)

        clearBtn.setOnClickListener {
            inputField.text.clear()
            figureInfo.text=" "
            figureInfo.setBackgroundColor(Color.TRANSPARENT)
            figureIv.setImageDrawable(null)
            notFoundIv.setImageDrawable(null)


        }
        searchBtn.setOnClickListener {
            val searchedText=inputField.text.toString()

            if (searchedText.isBlank()){
                Toast.makeText(this, "Input Field Cannot be Empty", Toast.LENGTH_SHORT).show()

            }
            else if (searchedText.toInt()<20||searchedText.toInt()>100){
                Toast.makeText(this, "Age has to be between 20 And 100", Toast.LENGTH_SHORT).show()
            }
            else{
            for( i in figuresArr ){


                if (i.age==searchedText.toInt()){

                    figureIv.setImageResource(i.image)
                    figureInfo.setBackgroundColor(Color.WHITE)
                    figureInfo.text="The historical Figure that Matches The age Provided is is ${i.name} "
                    notFoundIv.setImageDrawable(null)
                    break
                }


                else if (searchedText.toInt()!=i.age ){
                    figureInfo.text="There's no Historical Figure of the age $searchedText"
                    figureIv.setImageDrawable(null)
                    inputField.text.clear()
                    figureInfo.setBackgroundColor(Color.TRANSPARENT)
                    notFoundIv.setImageResource(R.drawable.confused)

                }



            }
        }
        }









    }
}
class HistoricalPeople(val image:Int,val age:Int, val name:String, val fact:String){






}
