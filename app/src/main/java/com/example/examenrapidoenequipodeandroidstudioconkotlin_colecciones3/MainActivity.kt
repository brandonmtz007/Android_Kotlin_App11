package com.example.examenrapidoenequipodeandroidstudioconkotlin_colecciones3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {



    private lateinit var recyclerView: RecyclerView

    private lateinit var fruitAdapter: FruitAdapter



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        val fruits = generateFruits()

        fruitAdapter = FruitAdapter(fruits)



        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = fruitAdapter

    }



    private fun generateFruits(): List<Fruit> {

        // Simulated data

        val luchador1 = Fruit("Místico", "Ignacio Uribe Alvirde es un luchador profesional mexicano " +
                "conocido por su trabajo en México en el Consejo Mundial de Lucha Libre, donde alcanzó el estatus de estrella nacional " +
                "con el nombre de Místico desde 2004 a 2010", R.drawable.luchador1)

        val luchador2 = Fruit("Pénta El Zero M", "Penta Zero M es un luchador profesional mexicano enmascarado," +
                " más conocido bajo el nombre de Pentagón Jr. quien trabaja actualmente en All Elite Wrestling y a través de su relación de " +
                "trabajo que también trabaja regularmente para Lucha Libre AAA Worldwide", R.drawable.luchador2)

        val luchador3 = Fruit("Octagón", "Juan Carlos López Escalera es un luchador profesional y actor " +
                "mexicano mejor conocido por su nombre artístico Octagón. A lo largo de su carrera, ha " +
                "trabajado en el Consejo Mundial de Lucha Libre y en la Asistencia Asesoría y Administración " +
                "desde 1992 hasta su salida en 2014.", R.drawable.luchador3)

        val luchador4 = Fruit("Gran Guerrero", "Gran Guerrero es un luchador profesional mexicano, " +
                "enmascarado que trabaja actualmente para el Consejo Mundial de Lucha Libre. Originalmente fue " +
                "presentado al mundo de la lucha libre bajo el nombre de Último Guerrero Jr. en 2009 por Último Guerrero, " +
                "con la historia de que era su hijo", R.drawable.luchador4)

        val luchador5 = Fruit("Último Guerrero", "José Gutiérrez Hernández es un luchador profesional " +
                "mexicano, más conocido bajo el nombre de Último Guerrero. José trabaja actualmente en el " +
                "Consejo Mundial de Lucha Libre, donde también es parte del Departamento de Programación.", R.drawable.luchador5)




        return listOf(luchador1, luchador2, luchador3, luchador4, luchador5)

    }

}
data class Fruit(val name: String, val description: String, val imageResId: Int)
class FruitAdapter(private val fruits: List<Fruit>) :

    RecyclerView.Adapter<FruitAdapter.FruitViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {

        val view = LayoutInflater.from(parent.context)

            .inflate(R.layout.item_fruit, parent, false)

        return FruitViewHolder(view)

    }



    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {

        val fruit = fruits[position]

        holder.imageViewFruit.setImageResource(fruit.imageResId)

        holder.textViewName.text = fruit.name

        holder.textViewDescription.text = fruit.description

    }



    override fun getItemCount(): Int {

        return fruits.size

    }



    inner class FruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageViewFruit: ImageView = itemView.findViewById(R.id.imageViewFruit)

        val textViewName: TextView = itemView.findViewById(R.id.textViewName)

        val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)

    }

}