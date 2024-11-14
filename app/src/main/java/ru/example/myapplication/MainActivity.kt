package ru.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.RadioButton
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import ru.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val naviky = arrayListOf(false, false, false)
        var age = 0
        var bah = false
        var strDate = "0 0 0"
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        binding.Btn.setOnClickListener(){
            naviky[0]=binding.CB1.isChecked
            naviky[1] = binding.CB2.isChecked
            naviky[2] = binding.CB3.isChecked
            if((binding.RB[0] as RadioButton).isChecked){
                age = 0
            }
            else if((binding.RB[1] as RadioButton).isChecked){
                age = 1
            }
            else if ((binding.RB[2] as RadioButton).isChecked){
                age = 2
            }
            bah = binding.Sw.isChecked

            Snackbar.make(binding.root , "Желаемое время $strDate", Snackbar.LENGTH_SHORT).show()


        }
        binding.CV.setOnDateChangeListener{view, year, month,day ->
            strDate = "$day, ${month+1}, $year"
        }
    }
}