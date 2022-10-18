package com.example.tourguideapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ReligionFragment : Fragment() {


    private val religion1: String =
        "Пятиглавая красавица-гора, видимая из разных точек города, расположена в самом его центре.\n" +
                "На пике устроена знаменитая мечеть «Тахты Сулейман», чуть ниже — семь пещер," +
                " а у подножия — баня, построенная еще в Средние Века.\n" +
                "Комплекс Сулайман-Тоо — первая достопримечательность страны, внесенная в список Всемирного наследия ЮНЕСКО."

    private val religion2: String =
        "Дом Бабура, основателя Империи Великих Моголов — еще одна из «визиток» Оша.\n" +
                "Этот религиозный и культурный памятник расположился на крутом склоне горы.\n" +
                "Построенный в 16 веке, он выполнен в традиционном для ислама архитектурном стиле" +
                "и служил, по легенде, местом отдыха и молитв для Захир-ад-дин Мухаммада Бабура."

//    private val religion3: String =
//        "Церковь эта была возведена сразу после ликвидации Кокандского Ханства, в последней четверти XIX столетия.\n" +
//                "Храм Архистратига Божия Михаила в его современном виде построен на месте разрушенного старинного здания."

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_religion, container, false)

        val listInfo = mutableListOf(
            Place(
                R.drawable.religion_11, "Сулайман-Тоо", "Гора", false, religion1,
                "Сулайман Тоо, Ош"
            ),

            Place(
                R.drawable.religion_2, "Дом Бабура", "Mosque", false, religion2,
                "Мавзолей Бабур-Наме"
            ),
        )

        val adapter = PlaceAdapter(listInfo)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.religion_rv)
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