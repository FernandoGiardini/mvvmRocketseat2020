package br.com.rockseat.rockseatmvvm

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.rockseat.rockseatmvvm.address.AddressViewModel
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var textViewCep: TextView
    private lateinit var textViewStreet: TextView
    private lateinit var textViewCity: TextView
    private lateinit var textViewUF: TextView

    private val viewModel by viewModel<AddressViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewCep = findViewById(R.id.textViewCep)
        textViewStreet = findViewById(R.id.textViewStreet)
        textViewCity = findViewById(R.id.textViewCity)
        textViewUF= findViewById(R.id.textViewUF)

        textViewCep.setOnFocusChangeListener{ _, hasFocus ->
            if(!hasFocus){
                //make request
                viewModel.getAddress(textViewCep.text.toString())
            }
        }

        //observar LiveData da ViewModel
        viewModel.liveData.observe(this) {
            textViewStreet.text = it.street
            textViewCity.text = it.city
            textViewUF.text = it.state
        }

    }
}