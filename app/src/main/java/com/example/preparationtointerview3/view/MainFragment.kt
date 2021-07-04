package com.example.preparationtointerview3.view

import android.annotation.SuppressLint
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationSet
import android.view.animation.TranslateAnimation
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.example.preparationtointerview3.databinding.MainFragmentBinding



class MainFragment : BaseFragment<MainFragmentBinding>() {

    lateinit var mCar:View

    @RequiresApi(Build.VERSION_CODES.R)
    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mCar = binding.mCar
        mCar.setOnClickListener(
            View.OnClickListener {
                doAnim()
            }
        )

    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= MainFragmentBinding.inflate(inflater, container, false)

    @RequiresApi(Build.VERSION_CODES.R)
    private fun doAnim() {
        val display = context?.display
        val size = Point()
        display?.getRealSize(size)
        val mAnimation1 = TranslateAnimation(mCar.translationX, size.x.toFloat(), mCar.translationY, -size.y.toFloat()/3)
        mAnimation1.duration = 1000
        val mAnimation2 = TranslateAnimation(mCar.translationX, -size.x.toFloat(), mCar.translationY, -size.y.toFloat()/6)
        mAnimation2.duration = 1000
        mAnimation2.startOffset = 1000

        val mAnimation3 = TranslateAnimation(mCar.translationX, size.x.toFloat(), mCar.translationY, -size.y.toFloat()/3)
        mAnimation3.duration = 1000
        mAnimation3.startOffset = 2000

        val animationSet = AnimationSet(true)

        animationSet.addAnimation(mAnimation1)
        animationSet.addAnimation(mAnimation2)
        animationSet.addAnimation(mAnimation3)

        mCar.startAnimation(animationSet)

    }






}