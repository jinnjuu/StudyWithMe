package com.example.studywithme.scheduling

import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.studywithme.R
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_calendar_view_today_acheivement.*


 class View_Today_Acheivement : Fragment() {


//     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//         super.onViewCreated(view, savedInstanceState)
//
//         // 홈에서 골네임 받아오기
//         val Goal_name = view?.findViewById<TextView>(R.id.Goal_name)
//         val args = getArguments()
//         if (args != null) {
//             //val mArgs = arguments
//             var goal_name = args?.getString("goal_name")
//             Log.d("get", goal_name)
//             Goal_name?.setText(goal_name)
//             Log.d("Goal_name_today", Goal_name?.text.toString())
//         }
//         // 홈에서 디데이 받아오기
//         val Goal_day=view?.findViewById<TextView>(R.id.D_day)
//         val args1=getArguments()
//         if (args1 != null) {
//             //val mArgs = arguments
//             var goal_day= args1?.getString("d_day")
//             Log.d("get", goal_day)
//             Goal_day?.setText("D-" + goal_day)
//             Log.d("Goal_day", Goal_day?.text.toString())
//         }

//
//     }


    fun timeGenerator() :String {

        //오늘 날짜 받아오려고 Calendar 클래스의 객체 생성
        val instance = Calendar.getInstance()
        //Calendar 객체의 일자 상수 얻어서 변수에 넣기
        var date = instance.get(Calendar.DATE).toString()
        return date
    }


     var today_date=timeGenerator()
     var yesterday_date_cal : Int = today_date.toInt()-1
     var yesterday_date : String = yesterday_date_cal.toString()
     var tomorrow_date_cal : Int = today_date.toInt()+1
     var tomorrow_date : String = tomorrow_date_cal.toString()





     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         val view: View = inflater.inflate(R.layout.fragment_calendar_view_today_acheivement,container, false)


         val date_view1 = view.findViewById<TextView>(R.id.date_view1)
         val date_view2 = view.findViewById<TextView>(R.id.date_view2)
         val date_view3 = view.findViewById<TextView>(R.id.date_view3)




        date_view1.setText(yesterday_date)
        date_view2.setText(today_date)
        date_view3.setText(tomorrow_date)


        // 프래그먼트 버튼에서 할일별 달성률 프래그먼트로 연결하는 코드
        val view_todo = view.findViewById<Button>(R.id. button_view_todo_acheivement2)
        view_todo.setOnClickListener {
            val fragment = View_Todo_Acheivement() // Fragment 생성
            val fm = fragmentManager
            val fmt = fm?.beginTransaction()
            fmt?.replace(R.id.content, fragment)?.addToBackStack(null)?.commit()
        }

        // 프래그먼트 버튼에서 월별별 달성률 프래그먼트로 연결하는 코드
        val view_month = view.findViewById<Button>(R.id. button_view_month_acheivement2)
        view_month.setOnClickListener {
            val fragment = View_Month_Acheivement() // Fragment 생성
            val fm = fragmentManager
            val fmt = fm?.beginTransaction()
            fmt?.replace(R.id.content, fragment)?.addToBackStack(null)?.commit()
        }


        return view

    }

     override fun onActivityCreated(savedInstanceState: Bundle?) {
         super.onActivityCreated(savedInstanceState)
     }





}

