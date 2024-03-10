package com.example.eletriccar.data.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.eletriccar.data.local.CarrosContract.SQL_DELETE_ENTRIES
import com.example.eletriccar.data.local.CarrosContract.TABLE_CAR


class CarsDbHelper (context: Context): SQLiteOpenHelper(context, DATA_BASE_NAME, null, DATA_VERSION){


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(TABLE_CAR)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
    }

    companion object{
        const val DATA_VERSION = 1
        const val DATA_BASE_NAME = "DbCar.db"

    }
}
