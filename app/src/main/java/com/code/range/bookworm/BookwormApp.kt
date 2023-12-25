package com.code.range.bookworm

import android.app.Application
import com.code.range.bookworm.di.AppModule
import com.code.range.bookworm.di.AppModuleImpl

class BookwormApp: Application() {

    companion object {
        lateinit var appModule: AppModule
    }
    override fun onCreate() {
        super.onCreate()
    }

}