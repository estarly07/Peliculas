package com.estarly.peliculas.utils

import com.estarly.peliculas.R

class GlobalUtils {
    companion object{
        const val baseUrl  = "https://api.themoviedb.org"
        const val apiKey   = "afa8d95ee641e17726d410fb729bc2b2"
        const val language = "es-ES"
        const val error    = "ERROR"
         val avatars = listOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.r,
        )
        const val movies   = "[{\n" +
                "            \"adult\": false,\n" +
                "            \"backdrop_path\": \"/fOy2Jurz9k6RnJnMUMRDAgBwru2.jpg\",\n" +
                "            \"genre_ids\": [\n" +
                "                16,\n" +
                "                10751,\n" +
                "                35,\n" +
                "                14\n" +
                "            ],\n" +
                "            \"id\": 508947,\n" +
                "            \"original_language\": \"en\",\n" +
                "            \"original_title\": \"Turning Red\",\n" +
                "            \"overview\": \"Thirteen-year-old Mei is experiencing the awkwardness of being a teenager with a twist – when she gets too excited, she transforms into a giant red panda.\",\n" +
                "            \"popularity\": 9626.136,\n" +
                "            \"poster_path\": \"/qsdjk9oAKSQMWs0Vt5Pyfh6O4GZ.jpg\",\n" +
                "            \"release_date\": \"2022-03-10\",\n" +
                "            \"title\": \"Turning Red\",\n" +
                "            \"video\": false,\n" +
                "            \"vote_average\": 7.5,\n" +
                "            \"vote_count\": 1045\n" +
                "        },\n" +
                "        {\n" +
                "            \"adult\": false,\n" +
                "            \"backdrop_path\": \"/iQFcwSGbZXMkeyKrxbPnwnRo5fl.jpg\",\n" +
                "            \"genre_ids\": [\n" +
                "                28,\n" +
                "                12,\n" +
                "                878\n" +
                "            ],\n" +
                "            \"id\": 634649,\n" +
                "            \"original_language\": \"en\",\n" +
                "            \"original_title\": \"Spider-Man: No Way Home\",\n" +
                "            \"overview\": \"Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.\",\n" +
                "            \"popularity\": 7931.213,\n" +
                "            \"poster_path\": \"/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg\",\n" +
                "            \"release_date\": \"2021-12-15\",\n" +
                "            \"title\": \"Spider-Man: No Way Home\",\n" +
                "            \"video\": false,\n" +
                "            \"vote_average\": 8.2,\n" +
                "            \"vote_count\": 10502\n" +
                "        },\n" +
                "        {\n" +
                "            \"adult\": false,\n" +
                "            \"backdrop_path\": \"/ewUqXnwiRLhgmGhuksOdLgh49Ch.jpg\",\n" +
                "            \"genre_ids\": [\n" +
                "                28,\n" +
                "                12,\n" +
                "                35,\n" +
                "                878,\n" +
                "                18\n" +
                "            ],\n" +
                "            \"id\": 696806,\n" +
                "            \"original_language\": \"en\",\n" +
                "            \"original_title\": \"The Adam Project\",\n" +
                "            \"overview\": \"After accidentally crash-landing in 2022, time-traveling fighter pilot Adam Reed teams up with his 12-year-old self on a mission to save the future.\",\n" +
                "            \"popularity\": 4186.781,\n" +
                "            \"poster_path\": \"/wFjboE0aFZNbVOF05fzrka9Fqyx.jpg\",\n" +
                "            \"release_date\": \"2022-03-11\",\n" +
                "            \"title\": \"The Adam Project\",\n" +
                "            \"video\": false,\n" +
                "            \"vote_average\": 7,\n" +
                "            \"vote_count\": 1219\n" +
                "        },\n" +
                "        {\n" +
                "            \"adult\": false,\n" +
                "            \"backdrop_path\": \"/2hGjmgZrS1nlsEl5PZorn7EsmzH.jpg\",\n" +
                "            \"genre_ids\": [\n" +
                "                28,\n" +
                "                53\n" +
                "            ],\n" +
                "            \"id\": 823625,\n" +
                "            \"original_language\": \"en\",\n" +
                "            \"original_title\": \"Blacklight\",\n" +
                "            \"overview\": \"Travis Block is a shadowy Government agent who specializes in removing operatives whose covers have been exposed. He then has to uncover a deadly conspiracy within his own ranks that reaches the highest echelons of power.\",\n" +
                "            \"popularity\": 3050.217,\n" +
                "            \"poster_path\": \"/7gFo1PEbe1CoSgNTnjCGdZbw0zP.jpg\",\n" +
                "            \"release_date\": \"2022-02-10\",\n" +
                "            \"title\": \"Blacklight\",\n" +
                "            \"video\": false,\n" +
                "            \"vote_average\": 5.8,\n" +
                "            \"vote_count\": 196\n" +
                "        },\n" +
                "        {\n" +
                "            \"adult\": false,\n" +
                "            \"backdrop_path\": \"/j2zyoYrWjWyraHMdkqAkSG1MISJ.jpg\",\n" +
                "            \"genre_ids\": [\n" +
                "                80,\n" +
                "                9648,\n" +
                "                53\n" +
                "            ],\n" +
                "            \"id\": 414906,\n" +
                "            \"original_language\": \"en\",\n" +
                "            \"original_title\": \"The Batman\",\n" +
                "            \"overview\": \"In his second year of fighting crime, Batman uncovers corruption in Gotham City that connects to his own family while facing a serial killer known as the Riddler.\",\n" +
                "            \"popularity\": 3020.924,\n" +
                "            \"poster_path\": \"/74xTEgt7R36Fpooo50r9T25onhq.jpg\",\n" +
                "            \"release_date\": \"2022-03-01\",\n" +
                "            \"title\": \"The Batman\",\n" +
                "            \"video\": false,\n" +
                "            \"vote_average\": 7.9,\n" +
                "            \"vote_count\": 2426\n" +
                "        },\n" +
                "        {\n" +
                "            \"adult\": false,\n" +
                "            \"backdrop_path\": \"/tq3klWQevRK0Or0cGhsw0h3FDWQ.jpg\",\n" +
                "            \"genre_ids\": [\n" +
                "                12,\n" +
                "                16,\n" +
                "                35,\n" +
                "                10751,\n" +
                "                14\n" +
                "            ],\n" +
                "            \"id\": 676705,\n" +
                "            \"original_language\": \"fr\",\n" +
                "            \"original_title\": \"Pil's Adventures\",\n" +
                "            \"overview\": \"Pil, a little vagabond girl, lives on the streets of the medieval city of Roc-en-Brume, along with her three tame weasels. She survives of food stolen from the castle of the sinister Regent Tristain. One day, to escape his guards, Pil disguises herself as a princess. Thus she embarks upon a mad, delirious adventure, together with Crobar, a big clumsy guard who thinks she's a noble, and Rigolin, a young crackpot jester. Pil is going to have to save Roland, rightful heir to the throne under the curse of a spell. This adventure will turn the entire kingdom upside down, and teach Pil that nobility can be found in all of us.\",\n" +
                "            \"popularity\": 2847.429,\n" +
                "            \"poster_path\": \"/xy6wQ09rMIN2FfWPHJXCWyRZ3P9.jpg\",\n" +
                "            \"release_date\": \"2021-08-11\",\n" +
                "            \"title\": \"Pil's Adventures\",\n" +
                "            \"video\": false,\n" +
                "            \"vote_average\": 7.4,\n" +
                "            \"vote_count\": 25\n" +
                "        },\n" +
                "        {\n" +
                "            \"adult\": false,\n" +
                "            \"backdrop_path\": \"/3G1Q5xF40HkUBJXxt2DQgQzKTp5.jpg\",\n" +
                "            \"genre_ids\": [\n" +
                "                16,\n" +
                "                35,\n" +
                "                10751,\n" +
                "                14\n" +
                "            ],\n" +
                "            \"id\": 568124,\n" +
                "            \"original_language\": \"en\",\n" +
                "            \"original_title\": \"Encanto\",\n" +
                "            \"overview\": \"The tale of an extraordinary family, the Madrigals, who live hidden in the mountains of Colombia, in a magical house, in a vibrant town, in a wondrous, charmed place called an Encanto. The magic of the Encanto has blessed every child in the family with a unique gift from super strength to the power to heal—every child except one, Mirabel. But when she discovers that the magic surrounding the Encanto is in danger, Mirabel decides that she, the only ordinary Madrigal, might just be her exceptional family's last hope.\",\n" +
                "            \"popularity\": 2760.889,\n" +
                "            \"poster_path\": \"/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg\",\n" +
                "            \"release_date\": \"2021-11-24\",\n" +
                "            \"title\": \"Encanto\",\n" +
                "            \"video\": false,\n" +
                "            \"vote_average\": 7.7,\n" +
                "            \"vote_count\": 5608\n" +
                "        },\n" +
                "        {\n" +
                "            \"adult\": false,\n" +
                "            \"backdrop_path\": \"/33wnBK5NxvuKQv0Cxo3wMv0eR7F.jpg\",\n" +
                "            \"genre_ids\": [\n" +
                "                27,\n" +
                "                53\n" +
                "            ],\n" +
                "            \"id\": 833425,\n" +
                "            \"original_language\": \"en\",\n" +
                "            \"original_title\": \"No Exit\",\n" +
                "            \"overview\": \"Stranded at a rest stop in the mountains during a blizzard, a recovering addict discovers a kidnapped child hidden in a car belonging to one of the people inside the building which sets her on a terrifying struggle to identify who among them is the kidnapper.\",\n" +
                "            \"popularity\": 2171.134,\n" +
                "            \"poster_path\": \"/5cnLoWq9o5tuLe1Zq4BTX4LwZ2B.jpg\",\n" +
                "            \"release_date\": \"2022-02-25\",\n" +
                "            \"title\": \"No Exit\",\n" +
                "            \"video\": false,\n" +
                "            \"vote_average\": 6.5,\n" +
                "            \"vote_count\": 273\n" +
                "        },\n" +
                "        {\n" +
                "            \"adult\": false,\n" +
                "            \"backdrop_path\": \"/yzH5zvuEzzsHLZnn0jwYoPf0CMT.jpg\",\n" +
                "            \"genre_ids\": [\n" +
                "                53,\n" +
                "                28\n" +
                "            ],\n" +
                "            \"id\": 760926,\n" +
                "            \"original_language\": \"en\",\n" +
                "            \"original_title\": \"Gold\",\n" +
                "            \"overview\": \"In the not-too-distant future, two drifters traveling through the desert stumble across the biggest gold nugget ever found and the dream of immense wealth and greed takes hold. They hatch a plan to excavate their bounty, with one man leaving to secure the necessary tools while the other remains with the gold. The man who remains must endure harsh desert elements, ravenous wild dogs, and mysterious intruders, while battling the sinking suspicion that he has been abandoned to his fate.\",\n" +
                "            \"popularity\": 1921.251,\n" +
                "            \"poster_path\": \"/ejXBuNLvK4kZ7YcqeKqUWnCxdJq.jpg\",\n" +
                "            \"release_date\": \"2022-01-13\",\n" +
                "            \"title\": \"Gold\",\n" +
                "            \"video\": false,\n" +
                "            \"vote_average\": 6.5,\n" +
                "            \"vote_count\": 139\n" +
                "        },\n" +
                "        {\n" +
                "            \"adult\": false,\n" +
                "            \"backdrop_path\": \"/7CamWBejQ9JQOO5vAghZfrFpMXY.jpg\",\n" +
                "            \"genre_ids\": [\n" +
                "                28,\n" +
                "                53,\n" +
                "                80\n" +
                "            ],\n" +
                "            \"id\": 928381,\n" +
                "            \"original_language\": \"fr\",\n" +
                "            \"original_title\": \"Sans répit\",\n" +
                "            \"overview\": \"After going to extremes to cover up an accident, a corrupt cop's life spirals out of control when he starts receiving threats from a mysterious witness.\",\n" +
                "            \"popularity\": 1598.361,\n" +
                "            \"poster_path\": \"/9MP21x0OPv0R72obd63tMHssmGt.jpg\",\n" +
                "            \"release_date\": \"2022-02-25\",\n" +
                "            \"title\": \"Restless\",\n" +
                "            \"video\": false,\n" +
                "            \"vote_average\": 5.8,\n" +
                "            \"vote_count\": 182\n" +
                "        },\n" +
                "        {\n" +
                "            \"adult\": false,\n" +
                "            \"backdrop_path\": \"/hJjA3EY7yoT1djGyD20lM3WzgyM.jpg\",\n" +
                "            \"genre_ids\": [\n" +
                "                18,\n" +
                "                9648,\n" +
                "                53\n" +
                "            ],\n" +
                "            \"id\": 619979,\n" +
                "            \"original_language\": \"en\",\n" +
                "            \"original_title\": \"Deep Water\",\n" +
                "            \"overview\": \"Vic and Melinda Van Allen are a couple in the small town of Little Wesley. Their loveless marriage is held together only by a precarious arrangement whereby, in order to avoid the messiness of divorce, Melinda is allowed to take any number of lovers as long as she does not desert her family.\",\n" +
                "            \"popularity\": 1578.577,\n" +
                "            \"poster_path\": \"/6yRMyWwjuhKg6IU66uiZIGhaSc8.jpg\",\n" +
                "            \"release_date\": \"2022-03-18\",\n" +
                "            \"title\": \"Deep Water\",\n" +
                "            \"video\": false,\n" +
                "            \"vote_average\": 5.6,\n" +
                "            \"vote_count\": 248\n" +
                "        },\n" +
                "        {\n" +
                "            \"adult\": false,\n" +
                "            \"backdrop_path\": \"/dK12GIdhGP6NPGFssK2Fh265jyr.jpg\",\n" +
                "            \"genre_ids\": [\n" +
                "                28,\n" +
                "                35,\n" +
                "                80,\n" +
                "                53\n" +
                "            ],\n" +
                "            \"id\": 512195,\n" +
                "            \"original_language\": \"en\",\n" +
                "            \"original_title\": \"Red Notice\",\n" +
                "            \"overview\": \"An Interpol-issued Red Notice is a global alert to hunt and capture the world's most wanted. But when a daring heist brings together the FBI's top profiler and two rival criminals, there's no telling what will happen.\",\n" +
                "            \"popularity\": 1535.312,\n" +
                "            \"poster_path\": \"/wdE6ewaKZHr62bLqCn7A2DiGShm.jpg\",\n" +
                "            \"release_date\": \"2021-11-04\",\n" +
                "            \"title\": \"Red Notice\",\n" +
                "            \"video\": false,\n" +
                "            \"vote_average\": 6.8,\n" +
                "            \"vote_count\": 3323\n" +
                "        },\n" +
                "        {\n" +
                "            \"adult\": false,\n" +
                "            \"backdrop_path\": \"/qBLEWvJNVsehJkEJqIigPsWyBse.jpg\",\n" +
                "            \"genre_ids\": [\n" +
                "                16,\n" +
                "                10751,\n" +
                "                14,\n" +
                "                35,\n" +
                "                12\n" +
                "            ],\n" +
                "            \"id\": 585083,\n" +
                "            \"original_language\": \"en\",\n" +
                "            \"original_title\": \"Hotel Transylvania: Transformania\",\n" +
                "            \"overview\": \"When Van Helsing's mysterious invention, the \\\"Monsterfication Ray,\\\" goes haywire, Drac and his monster pals are all transformed into humans, and Johnny becomes a monster. In their new mismatched bodies, Drac and Johnny must team up and race across the globe to find a cure before it's too late, and before they drive each other crazy.\",\n" +
                "            \"popularity\": 1531.025,\n" +
                "            \"poster_path\": \"/teCy1egGQa0y8ULJvlrDHQKnxBL.jpg\",\n" +
                "            \"release_date\": \"2022-02-25\",\n" +
                "            \"title\": \"Hotel Transylvania: Transformania\",\n" +
                "            \"video\": false,\n" +
                "            \"vote_average\": 7.1,\n" +
                "            \"vote_count\": 520\n" +
                "        }]"

    }
}