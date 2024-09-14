//package com.example.di
//
//import android.app.Activity
//import androidx.annotation.DrawableRes
//import com.example.MainActivity
//import javax.inject.Inject
//
//internal class MainAppComponentResolver @Inject constructor() : MainAppComponentResolver {
//
//    private val mainActivityClassReference by lazy {
//        MainActivity::class.java
//    }
//
//    override fun provideComponent(): Class<out Activity> = mainActivityClassReference
//
//    @DrawableRes
//    override fun provideAppIconRes(): Int = R.drawable.ic_notification_jobandtalent
//}
