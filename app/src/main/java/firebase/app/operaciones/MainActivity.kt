package firebase.app.operaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAgregar.setOnClickListener{
            val miIntent = Intent(this,AgregarActivity::class.java)
            startActivity(miIntent)
        }
        buttonVer.setOnClickListener{
            val miIntent = Intent(this,VerActivity::class.java)
            startActivity(miIntent)
        }
        buttonBuscar.setOnClickListener{
            val miIntent = Intent(this,BuscarActivity::class.java)
            startActivity(miIntent)
        }





    }
}