package com.example.tourguideapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MonumentFragment : Fragment() {

    private val monument1: String =
        "В самом центре города, на проспекте Ленина, расположен величественный памятник Владимиру Ильичу.\n" +
                "Как и во многих других городах Кыргызстана, монументы и мемориалы советской эпохе в Оше сохранились."

    private val monument2: String =
        "Еще одна локация, на фоне которой любят фотографироваться гости города — величественный памятник Манасу.\n" +
                "Манас по прозвищу Великодушный — герой эпосов, национальный лидер," +
                " объединивший под своим началом множество местных племен."

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_monument, container, false)

        val listInfo = mutableListOf(
            Place(
                R.drawable.monument1, "Памятник Ленину", "Цент города", false, monument1,
                "Памятник В.И. Ленину"
            ),

            Place(
                R.drawable.monument2, "Манас", "Памятник", false, monument2,
                "Manas Statue"
            )
        )

        val adapter = PlaceAdapter(listInfo)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.monument_rv)

        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(view?.context)

        recyclerView?.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )

        return view
    }

}