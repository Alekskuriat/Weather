package com.example.weather.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.weather.R
import com.example.weather.presenters.UserPresenter
import com.example.weather.presenters.UserPresenterImpl
import com.example.weather.presenters.UserView
import java.lang.StringBuilder

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment(R.layout.fragment_main), UserView, View.OnClickListener {
    private var param1: String? = null
    private var param2: String? = null
    var presenter: UserPresenter? = null
    var button: Button? = null
    var cityView: TextView? = null
    var temperatureView: TextView? = null
    var citiesView: TextView? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter = UserPresenterImpl(this);
        presenter?.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val rootView =  inflater.inflate(R.layout.fragment_main, container, false)

        button = rootView.findViewById(R.id.button)
        cityView = rootView.findViewById(R.id.city_view)
        temperatureView = rootView.findViewById(R.id.temperature_view)
        citiesView = rootView.findViewById(R.id.cities_view)
        button?.setOnClickListener(this)


        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun showResult() {
        Toast.makeText(requireContext(), "Кнопка", Toast.LENGTH_LONG).show()
    }

    override fun onStarted() {
        Toast.makeText(requireContext(), "Старт приложения", Toast.LENGTH_LONG).show()
    }

    override fun displayGivenInTextView(city: String, temperature: String) {
        cityView?.text = city
        temperatureView?.text = temperature
    }

    override fun displayListOfCities(str: StringBuilder) {
        citiesView?.text = str
    }

    override fun onClick(v: View?) {
        presenter?.onUserAction()
        presenter?.displayAction()
    }


}
