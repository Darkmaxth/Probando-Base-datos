package firebase.app.operaciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)


        val nombrenew : TextView = findViewById(R.id.AquiName)
        val dninew : TextView = findViewById(R.id.AquiDNI)
        val enfermedadnew : TextView = findViewById(R.id.AquiEnfermedad)

        val bundle : Bundle?= intent.extras

        val nombrex = bundle!!.getString("nombre")
        val dnix = bundle!!.getString("dni")
        val enfermedadx = bundle!!.getString("enfermedad")

        nombrenew.text = nombrex
        dninew.text= dnix
        enfermedadnew.text = enfermedadx
    }
}