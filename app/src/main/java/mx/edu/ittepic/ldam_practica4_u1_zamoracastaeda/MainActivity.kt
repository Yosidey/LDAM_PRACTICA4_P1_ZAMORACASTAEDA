package mx.edu.ittepic.ldam_practica4_u1_zamoracastaeda

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val siPermiso = 1
    var mensajeEnvio =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ActivityCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.SEND_SMS
                ) !=
                PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.SEND_SMS,android.Manifest.permission.READ_PHONE_STATE,android.Manifest.permission.READ_CALL_LOG), siPermiso
            )
        }

        button3.setOnClickListener {
            startActivity(Intent(this, Main2Activity::class.java))
        }
        button4.setOnClickListener {
            startActivity(Intent(this, Main3Activity::class.java))
        }

        button5.setOnClickListener {
            startActivity(Intent(this, Main4Activity::class.java))
        }

    }

    override fun onRequestPermissionsResult(
            requestCode: Int, permissions: Array<out String>,
            grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == siPermiso) {
        }

    }



}

