package mx.edu.ittepic.ldam_practica4_u1_zamoracastaeda

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatos(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE ENTRANTES(CELULAR VARCHAR(200), MENSAJE VARCHAR(2000))")//no usado
        db.execSQL("CREATE TABLE MENSAJES(MENSAJE VARCHAR(200), deseado VARCHAR(200))")
        db.execSQL("CREATE TABLE LISTANUMEROS(NOMBRE VARCHAR(200), CELULAR VARCHAR(200), deseado VARCHAR(200))")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}