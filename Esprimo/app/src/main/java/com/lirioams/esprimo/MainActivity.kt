package com.lirioams.esprimo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.lirioams.esprimo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btVerificar.setOnClickListener{
            if (binding.etNumero.text.isNotEmpty()){
                val numero = binding.etNumero.text.toString().toInt()

                if(esPrimo(numero)){
                    binding.tvResultado.text = getString(R.string.si_primo, numero, "!")
                }else{
                    binding.tvResultado.text = getString(R.string.no_primo, numero)
                }
            }else{
                binding.tvResultado.text = ""
                Toast.makeText(this, resources.getString(R.string.ingresa_valor), Toast.LENGTH_SHORT).show()
                binding.etNumero.error = getString(R.string.valor_requerido)
                binding.etNumero.requestFocus()
            }
        }
    }

    fun esPrimo(numero: Int): Boolean{
        if(numero<=1) return false
        for(i in 2 until numero){
            if(numero % i == 0) return false
        }
        return true
    }
}