package com.example.tourguideapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NatureFragment : Fragment() {

    private val nature1: String =
        "Место силы, эстетики и духовности для местного населения и туристов." +
                "\nПосещение долины дает представление о том, как выглядела страна много веков назад," +
                "так как природа тут сохранена практически в первозданном виде."

    private val nature2: String =
        "Преодолев всего несколько десятков километров, можно очутиться в завораживающе " +
                "красивом месте — парке Кыргыз Ата.\n" +
                " Нескончаемые горные пейзажи, сочно-зеленые леса, огромные луга" +
                " — природа здесь не утратила первозданный вид, не испорчена цивилизацией."

    private val nature3: String =
        "Одним из популярных маршрутов для ценителей зеленого туризма является путь «Ош — Долина Абшир-Сай».\n" +
                "Добраться туда можно как на автомобиле, так и на автобусе.\n" +
                "В живописной долине протекает река с одноименным названием," +
                "здесь же расположен уникальное Водопадное ущелье."

    private val nature4: String =
        "Путь проходит через зеленые долины, по сторонам расположены белоглавые вершины гор," +
                " скалы и кажущиеся бескрайними пастбища.\n" +
                " По дороге можно посетить и запечатлеть гигантское Токтогульское водохранилище.\n" +
                "Само же Сары-Челек — красивейшее место с панорамными видами.\n" +
                " Территория заповедная, вблизи обитают олени и другие животные, чувствующие себя там в безопасности.\n"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_nature, container, false)

        val list = mutableListOf(
            Place(
                R.drawable.nature_1, "Allay-Valley", "Allay Mountains", false, nature1,
                "Аллайская Долина"
            ),

            Place(
                R.drawable.nature_2, "Kyrgyz-Ata", "Национальный парк", false, nature2,
                "Кыргыз-Ата"
            ),

            Place(
                R.drawable.nature_3, "Абшир-Ата", "Долина", false, nature3,
                "Абшир Ата, Ош"
            ),

            Place(
                R.drawable.nature_3, "Сары-Челек", "Заповедник", false, nature4,
                "Сары-Челек"
            )
        )

        val adapter = PlaceAdapter(list)

        val rV = view?.findViewById<RecyclerView>(R.id.nature_rv)

        rV?.adapter = adapter

        rV?.layoutManager = LinearLayoutManager(view?.context)

        rV?.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )

        return view
    }
}