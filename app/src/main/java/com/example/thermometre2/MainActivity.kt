package com.example.thermometre2

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.icu.number.NumberFormatter.DecimalSeparatorDisplay
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity(),SensorEventListener {
    lateinit var temperatureSensor:Sensor
    lateinit var manager: SensorManager
    lateinit var txtDisplayTemp: TextView
    lateinit var txtcouleur:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.txtDisplayTemp= findViewById<TextView>(R.id.txtTempC1)
        this.txtcouleur = findViewById<TextView>(R.id.txtIndication)

        this.manager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        this.temperatureSensor=manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        manager.registerListener(this, temperatureSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        if (p0 != null) {
            val temperature = p0.values[0]
            txtDisplayTemp.text = temperature.toString()

            updateColorIndicator(temperature)
        };

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("Not yet implemented")
    }
    private fun updateColorIndicator(temperature: Float) {
        val blue = kotlin.math.max(0, 255 - (temperature * 2).toInt())
        val green = kotlin.math.min(255, (temperature * 2).toInt())
        val red = 0


        val color = android.graphics.Color.rgb(red, green, blue)
        txtcouleur.setBackgroundColor(color)
    }

}