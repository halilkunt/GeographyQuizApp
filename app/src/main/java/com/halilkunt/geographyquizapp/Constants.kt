package com.halilkunt.geographyquizapp

object Constants{

    fun getQuestions(): ArrayList<Question>{

        val questionList = ArrayList<Question>()

        val question5 = Question(
                5,
                "What country does this flag belong to?",
                 R.drawable.argentinaflag,
                "Argentina", "Uruguay", "Mexico", "Brazil",
                1)

        val question2 = Question(
                2,
                "What is the capital of Turkey?",
                 R.drawable.emptyimage,
                "İstanbul", "Ankara", "Bursa", "İzmir",
                2)
        val question12 = Question(
                12,
                "What is the capital of India?",
                R.drawable.emptyimage,
                "Mumbai", "Delhi", "Bangalore", "Pune",
                2)
        val question4 = Question(
                4,
                "What is the capital of Maine?",
                R.drawable.emptyimage,
                "Bangor", "Portland", "Augusta", "Lewiston",
                3)
        val question9 = Question(
                9,
                "What is the capital of Saudi Arabia?",
                R.drawable.emptyimage,
                "Riyadh", "Abha", "Medina", "Mecca",
                1)
        val question17 = Question(
                17,
                "What is the capital of Mozambique??",
                R.drawable.emptyimage,
                "Beira", "Tete", "Chiomoio", "Maputo",
                4)
        val question16 = Question(
                16,
                "What is the capital of Namibia?",
                R.drawable.emptyimage,
                "Khorixas", "Windhoek", "Cape Town", "Rundu",
                2)
        val question6 = Question(
                6,
                "What is the capital of Spain?",
                R.drawable.emptyimage,
                "Barcelona", "Valencia", "Villareal", "Madrid",
                4)
        val question7 = Question(
                7,
                "What is the capital of England?",
                R.drawable.emptyimage,
                "London", "Manchester", "Liverpool", "Cambridge",
                1)
        val question10 = Question(
                10,
                "What is the capital of Switzerland?",
                R.drawable.emptyimage,
                "Zurih", "Cenevre", "Bern", "Basel",
                3)
        val question14 = Question(
                14,
                "What is the capital of Wales?",
                R.drawable.emptyimage,
                "Swansea", "Newport", "Cardiff", "Brecon",
                3)
        val question13 = Question(
                13,
                "What country does this flag belong to?",
                R.drawable.walesflag,
                "Mexico", "Switzerland", "Wales", "England",
                3)
        val question18 = Question(
                18,
                "What country does this flag belong to?",
                R.drawable.sudanflag,
                "Sudan", "Saudi Arabia", "Egypt", "South Africa",
                1)
        val question20 = Question(
                20,
                "What country does this flag belong to?",
                R.drawable.qatarflag,
                "New Zealand", "Uruguay", "Chile", "Qatar",
                4)
        val question3 = Question(
                3,
                "What country does this flag belong to?",
                R.drawable.netherlandsflag,
                "France", "Netherlands", "Germany", "Italy",
                2)
        val question1 = Question(
                1,
                "What country does this flag belong to?",
                R.drawable.germanyflag,
                "Germany", "France", "Italy", "Sweden",
                1)
        val question8 = Question(
                8,
                "What country does this flag belong to?",
                R.drawable.uruguayflag,
                "Argentina", "Uruguay", "Mexico", "Brazil",
                2)
        val question19 = Question(
                19,
                "What country does this flag belong to?",
                R.drawable.peuertoricoflag,
                "Panama", "Colombia", "Mexico", "Puerto Rico",
                4)
        val question11 = Question(
                11,
                "What country does this flag belong to?",
                R.drawable.jamaicaflag,
                "Haiti", "Jamaica", "Peru", "Panama",
                2)
        val question15 = Question(
                15,
                "What country does this flag belong to?",
                R.drawable.swedenflag,
                "Sweden", "Switzerland", "Wales", "New zealand",
                1)
        val question21 = Question(
                21,
                "What country has this land?",
                R.drawable.bulgarialand,
                "Romania", "Bulgaria", "Georgia", "Azerbaijan",
                2)
        val question22 = Question(
                22,
                "What country has this land?",
                R.drawable.franceland,
                "England", "Italy", "Germany", "France",
                4)
        val question23 = Question(
                23,
                "What country has this land?",
                R.drawable.spianland,
                "Morocco", "Algeria", "Spain", "Portugal",
                3)
        val question24 = Question(
                24,
                "What country has this land?",
                R.drawable.tajikistanland,
                "Romania", "Tajikistan", "Georgia", "Azerbaijan",
                2)
        val question25 = Question(
                25,
                "What country has this land?",
                R.drawable.netherlandsland,
                "Netherlands", "Germany", "Iceland", "Switzerland",
                1)

        questionList.add(question1)
        questionList.add(question2)
        questionList.add(question3)
        questionList.add(question4)
        questionList.add(question5)
        questionList.add(question6)
        questionList.add(question7)
        questionList.add(question8)
        questionList.add(question9)
        questionList.add(question10)
        questionList.add(question11)
        questionList.add(question12)
        questionList.add(question13)
        questionList.add(question14)
        questionList.add(question15)
        questionList.add(question16)
        questionList.add(question17)
        questionList.add(question18)
        questionList.add(question19)
        questionList.add(question20)
        questionList.add(question21)
        questionList.add(question22)
        questionList.add(question23)
        questionList.add(question24)
        questionList.add(question25)




        return questionList
    }
}