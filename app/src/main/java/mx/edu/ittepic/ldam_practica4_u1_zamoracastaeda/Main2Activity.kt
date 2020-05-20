package mx.edu.ittepic.ldam_practica4_u1_zamoracastaeda

import android.database.sqlite.SQLiteException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setTitle("Mensajes Autocontestadora")
        leerMensajes()
        button.setOnClickListener {
            if(editText.text.toString().isEmpty()){
            }else{
                try {
                    var baseDatos = BaseDatos(this,"mensajes",null,1)
                    var insertar = baseDatos.writableDatabase
                    var SQL = "INSERT INTO MENSAJES VALUES('${editText.text.toString()}','deseado')"
                    insertar.execSQL(SQL)
                    baseDatos.close()

                }catch (err: SQLiteException){
                    Toast.makeText(this, err.message, Toast.LENGTH_LONG)
                        .show()
                }
            }


            if(editText2.text.toString().isEmpty()){
            }else{
                try {
                    var baseDatos = BaseDatos(this,"mensajes",null,1)
                    var insertar = baseDatos.writableDatabase
                    var SQL = "INSERT INTO MENSAJES VALUES('${editText2.text.toString()}','nodeseado')"
                    insertar.execSQL(SQL)
                    baseDatos.close()
                }catch (err: SQLiteException){
                    Toast.makeText(this, err.message, Toast.LENGTH_LONG)
                        .show()
                }
            }

            leerMensajes()
            editText.setText("")
            editText2.setText("")
        }

        button2.setOnClickListener {
            finish()
        }
    }

    fun leerMensajes(){
        textView7.setText(leerUltimosMensajeDeseado())
        textView8.setText(leerUltimosMensajeNODeseado())
    }

    fun leerUltimosMensajeDeseado() : String{
        //leer mensajes
        var ultimoMensaje = ""
        try{
            val cursor = BaseDatos(this,"mensajes",null,1)
                .readableDatabase
                .rawQuery("SELECT * FROM MENSAJES where deseado = 'deseado'",null)

            if(cursor.moveToFirst()){
                do{
                    ultimoMensaje = cursor.getString(0)
                }while(cursor.moveToNext())
            }else{
                ultimoMensaje = "Lista vacia"
            }

        }catch (err:SQLiteException){
            Toast.makeText(this,err.message,Toast.LENGTH_LONG)
                .show()
        }
        return ultimoMensaje
    }

    fun leerUltimosMensajeNODeseado() : String{
        //leer mensajes
        var ultimoMensaje = ""
        try{
            val cursor = BaseDatos(this,"mensajes",null,1)
                .readableDatabase
                .rawQuery("SELECT * FROM MENSAJES where deseado = 'nodeseado'",null)

            if(cursor.moveToFirst()){
                do{
                    ultimoMensaje = cursor.getString(0)
                }while(cursor.moveToNext())
            }else{
                ultimoMensaje = "Lista vacia"
            }

        }catch (err:SQLiteException){
            Toast.makeText(this,err.message,Toast.LENGTH_LONG)
                .show()
        }
        return ultimoMensaje
    }


}
