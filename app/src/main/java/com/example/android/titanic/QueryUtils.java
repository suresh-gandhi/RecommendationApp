package com.example.android.titanic;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by summi on 23-08-2017.
 */

public final class QueryUtils {

    /* Tag for the log messages*/
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    // TODO: Bring 150 popular movies.
    /* Sample JSON response */
    private static final String SAMPLE_JSON_RESPONSE = "{\"page\":1,\"total_results\":321581,\"total_pages\":16080,\"results\":[{\"vote_count\":4185,\"id\":211672,\"video\":false,\"vote_average\":6.4,\"title\":\"Minions\",\"popularity\":220.212696,\"poster_path\":\"\\/q0R4crx2SehcEEQEkYObktdeFy.jpg\",\"original_language\":\"en\",\"original_title\":\"Minions\",\"genre_ids\":[10751,16,12,35],\"backdrop_path\":\"\\/uX7LXnsC7bZJZjn048UCOwkPXWJ.jpg\",\"adult\":false,\"overview\":\"Minions Stuart, Kevin and Bob are recruited by Scarlet Overkill, a super-villain who, alongside her inventor husband Herb, hatches a plot to take over the world.\",\"release_date\":\"2015-06-17\"},{\"vote_count\":4790,\"id\":321612,\"video\":false,\"vote_average\":6.8,\"title\":\"Beauty and the Beast\",\"popularity\":112.725296,\"poster_path\":\"\\/tWqifoYuwLETmmasnGHO7xBjEtt.jpg\",\"original_language\":\"en\",\"original_title\":\"Beauty and the Beast\",\"genre_ids\":[10751,14,10749],\"backdrop_path\":\"\\/6aUWe0GSl69wMTSWWexsorMIvwU.jpg\",\"adult\":false,\"overview\":\"A live-action adaptation of Disney's version of the classic 'Beauty and the Beast' tale of a cursed prince and a beautiful young woman who helps him break the spell.\",\"release_date\":\"2017-03-16\"},{\"vote_count\":406,\"id\":396422,\"video\":false,\"vote_average\":6.3,\"title\":\"Annabelle: Creation\",\"popularity\":77.516954,\"poster_path\":\"\\/tb86j8jVCVsdZnzf8I6cIi65IeM.jpg\",\"original_language\":\"en\",\"original_title\":\"Annabelle: Creation\",\"genre_ids\":[53,27],\"backdrop_path\":\"\\/o8u0NyEigCEaZHBdCYTRfXR8U4i.jpg\",\"adult\":false,\"overview\":\"Several years after the tragic death of their little girl, a dollmaker and his wife welcome a nun and several girls from a shuttered orphanage into their home, soon becoming the target of the dollmaker's possessed creation, Annabelle.\",\"release_date\":\"2017-08-09\"},{\"vote_count\":2599,\"id\":315635,\"video\":false,\"vote_average\":7.3,\"title\":\"Spider-Man: Homecoming\",\"popularity\":76.109106,\"poster_path\":\"\\/c24sv2weTHPsmDa7jEMN0m2P3RT.jpg\",\"original_language\":\"en\",\"original_title\":\"Spider-Man: Homecoming\",\"genre_ids\":[28,12,878],\"backdrop_path\":\"\\/vc8bCGjdVp0UbMNLzHnHSLRbBWQ.jpg\",\"adult\":false,\"overview\":\"Following the events of Captain America: Civil War, Peter Parker, with the help of his mentor Tony Stark, tries to balance his life as an ordinary high school student in Queens, New York City, with fighting crime as his superhero alter ego Spider-Man as a new threat, the Vulture, emerges.\",\"release_date\":\"2017-07-05\"},{\"vote_count\":3756,\"id\":283995,\"video\":false,\"vote_average\":7.6,\"title\":\"Guardians of the Galaxy Vol. 2\",\"popularity\":58.269522,\"poster_path\":\"\\/y4MBh0EjBlMuOzv9axM4qJlmhzz.jpg\",\"original_language\":\"en\",\"original_title\":\"Guardians of the Galaxy Vol. 2\",\"genre_ids\":[28,12,35,878],\"backdrop_path\":\"\\/aJn9XeesqsrSLKcHfHP4u5985hn.jpg\",\"adult\":false,\"overview\":\"The Guardians must fight to keep their newfound family together as they unravel the mysteries of Peter Quill's true parentage.\",\"release_date\":\"2017-04-19\"},{\"vote_count\":1162,\"id\":281338,\"video\":false,\"vote_average\":6.7,\"title\":\"War for the Planet of the Apes\",\"popularity\":55.454994,\"poster_path\":\"\\/y52mjaCLoJJzxfcDDlksKDngiDx.jpg\",\"original_language\":\"en\",\"original_title\":\"War for the Planet of the Apes\",\"genre_ids\":[18,878,10752],\"backdrop_path\":\"\\/ulMscezy9YX0bhknvJbZoUgQxO5.jpg\",\"adult\":false,\"overview\":\"Caesar and his apes are forced into a deadly conflict with an army of humans led by a ruthless Colonel. After the apes suffer unimaginable losses, Caesar wrestles with his darker instincts and begins his own mythic quest to avenge his kind. As the journey finally brings them face to face, Caesar and the Colonel are pitted against each other in an epic battle that will determine the fate of both their species and the future of the planet.\",\"release_date\":\"2017-07-11\"},{\"vote_count\":1351,\"id\":324852,\"video\":false,\"vote_average\":6.2,\"title\":\"Despicable Me 3\",\"popularity\":54.961275,\"poster_path\":\"\\/5qcUGqWoWhEsoQwNUrtf3y3fcWn.jpg\",\"original_language\":\"en\",\"original_title\":\"Despicable Me 3\",\"genre_ids\":[878,12,16,35,10751],\"backdrop_path\":\"\\/puV2PFq42VQPItaygizgag8jrXa.jpg\",\"adult\":false,\"overview\":\"Gru and his wife Lucy must stop former '80s child star Balthazar Bratt from achieving world domination.\",\"release_date\":\"2017-06-15\"},{\"vote_count\":1406,\"id\":374720,\"video\":false,\"vote_average\":7.4,\"title\":\"Dunkirk\",\"popularity\":43.292505,\"poster_path\":\"\\/bOXBV303Fgkzn2K4FeKDc0O31q4.jpg\",\"original_language\":\"en\",\"original_title\":\"Dunkirk\",\"genre_ids\":[28,18,36,53,10752],\"backdrop_path\":\"\\/fudEG1VUWuOqleXv6NwCExK0VLy.jpg\",\"adult\":false,\"overview\":\"Miraculous evacuation of Allied soldiers from Belgium, Britain, Canada, and France, who were cut off and surrounded by the German army from the beaches and harbor of Dunkirk, France, between May 26 and June 04, 1940, during Battle of France in World War II.\",\"release_date\":\"2017-07-19\"},{\"vote_count\":8968,\"id\":118340,\"video\":false,\"vote_average\":7.9,\"title\":\"Guardians of the Galaxy\",\"popularity\":40.89527,\"poster_path\":\"\\/y31QB9kn3XSudA15tV7UWQ9XLuW.jpg\",\"original_language\":\"en\",\"original_title\":\"Guardians of the Galaxy\",\"genre_ids\":[28,878,12],\"backdrop_path\":\"\\/bHarw8xrmQeqf3t8HpuMY7zoK4x.jpg\",\"adult\":false,\"overview\":\"Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser.\",\"release_date\":\"2014-07-30\"},{\"vote_count\":12,\"id\":460790,\"video\":false,\"vote_average\":5.9,\"title\":\"Starship Troopers: Traitor of Mars\",\"popularity\":38.69347,\"poster_path\":\"\\/dzqEq8Jbvb5SYGoYPqLyIRrt6Cm.jpg\",\"original_language\":\"en\",\"original_title\":\"Starship Troopers: Traitor of Mars\",\"genre_ids\":[28,16,878],\"backdrop_path\":\"\\/u3hiCBwJ2yGCiJb3kOoqXThTQ7Z.jpg\",\"adult\":false,\"overview\":\"Federation trooper Johnny Rico is ordered to work with a group of new recruits on a satellite station on Mars, where giant bugs have decided to target their next attack.\",\"release_date\":\"2017-08-21\"},{\"vote_count\":307,\"id\":353491,\"video\":false,\"vote_average\":5.7,\"title\":\"The Dark Tower\",\"popularity\":38.637079,\"poster_path\":\"\\/i9GUSgddIqrroubiLsvvMRYyRy0.jpg\",\"original_language\":\"en\",\"original_title\":\"The Dark Tower\",\"genre_ids\":[28,37,878,14,27],\"backdrop_path\":\"\\/2n7Zn6WxJ76ccOwnuQHuhSFMbqt.jpg\",\"adult\":false,\"overview\":\"The last Gunslinger, Roland Deschain, has been locked in an eternal battle with Walter O’Dim, also known as the Man in Black, determined to prevent him from toppling the Dark Tower, which holds the universe together. With the fate of the worlds at stake, good and evil will collide in the ultimate battle as only Roland can defend the Tower from the Man in Black.\",\"release_date\":\"2017-08-03\"},{\"vote_count\":10314,\"id\":293660,\"video\":false,\"vote_average\":7.4,\"title\":\"Deadpool\",\"popularity\":37.328031,\"poster_path\":\"\\/inVq3FRqcYIRl2la8iZikYYxFNR.jpg\",\"original_language\":\"en\",\"original_title\":\"Deadpool\",\"genre_ids\":[28,12,35],\"backdrop_path\":\"\\/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg\",\"adult\":false,\"overview\":\"Deadpool tells the origin story of former Special Forces operative turned mercenary Wade Wilson, who after being subjected to a rogue experiment that leaves him with accelerated healing powers, adopts the alter ego Deadpool. Armed with his new abilities and a dark, twisted sense of humor, Deadpool hunts down the man who nearly destroyed his life.\",\"release_date\":\"2016-02-09\"},{\"vote_count\":10061,\"id\":157336,\"video\":false,\"vote_average\":8.1,\"title\":\"Interstellar\",\"popularity\":36.670059,\"poster_path\":\"\\/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg\",\"original_language\":\"en\",\"original_title\":\"Interstellar\",\"genre_ids\":[12,18,878],\"backdrop_path\":\"\\/xu9zaAevzQ5nnrsXN6JcahLnG4i.jpg\",\"adult\":false,\"overview\":\"Interstellar chronicles the adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage.\",\"release_date\":\"2014-11-05\"},{\"vote_count\":1109,\"id\":339846,\"video\":false,\"vote_average\":6,\"title\":\"Baywatch\",\"popularity\":33.859095,\"poster_path\":\"\\/6HE4xd8zloDqmjMZuhUCCw2UcY1.jpg\",\"original_language\":\"en\",\"original_title\":\"Baywatch\",\"genre_ids\":[28,35],\"backdrop_path\":\"\\/tryI7qZHaLMVzMNpLyKHKDiZOLc.jpg\",\"adult\":false,\"overview\":\"Devoted lifeguard Mitch Buchannon butts heads with a brash new recruit. Together, they uncover a local criminal plot that threatens the future of the Bay.\",\"release_date\":\"2017-05-12\"},{\"vote_count\":2117,\"id\":126889,\"video\":false,\"vote_average\":5.7,\"title\":\"Alien: Covenant\",\"popularity\":33.85249,\"poster_path\":\"\\/zecMELPbU5YMQpC81Z8ImaaXuf9.jpg\",\"original_language\":\"en\",\"original_title\":\"Alien: Covenant\",\"genre_ids\":[27,878,53],\"backdrop_path\":\"\\/kMU8trT43p5LFoJ4plIySMOsZ1T.jpg\",\"adult\":false,\"overview\":\"Bound for a remote planet on the far side of the galaxy, the crew of the colony ship 'Covenant' discovers what is thought to be an uncharted paradise, but is actually a dark, dangerous world – which has its sole inhabitant the 'synthetic', David, survivor of the doomed Prometheus expedition.\",\"release_date\":\"2017-05-09\"},{\"vote_count\":8160,\"id\":135397,\"video\":false,\"vote_average\":6.5,\"title\":\"Jurassic World\",\"popularity\":32.498552,\"poster_path\":\"\\/jjBgi2r5cRt36xF6iNUEhzscEcb.jpg\",\"original_language\":\"en\",\"original_title\":\"Jurassic World\",\"genre_ids\":[28,12,878,53],\"backdrop_path\":\"\\/dkMD5qlogeRMiEixC4YNPUvax2T.jpg\",\"adult\":false,\"overview\":\"Twenty-two years after the events of Jurassic Park, Isla Nublar now features a fully functioning dinosaur theme park, Jurassic World, as originally envisioned by John Hammond.\",\"release_date\":\"2015-06-09\"},{\"vote_count\":5430,\"id\":263115,\"video\":false,\"vote_average\":7.5,\"title\":\"Logan\",\"popularity\":32.155655,\"poster_path\":\"\\/gGBu0hKw9BGddG8RkRAMX7B6NDB.jpg\",\"original_language\":\"en\",\"original_title\":\"Logan\",\"genre_ids\":[28,18,878],\"backdrop_path\":\"\\/5pAGnkFYSsFJ99ZxDIYnhQbQFXs.jpg\",\"adult\":false,\"overview\":\"In the near future, a weary Logan cares for an ailing Professor X in a hideout on the Mexican border. But Logan's attempts to hide from the world and his legacy are upended when a young mutant arrives, pursued by dark forces.\",\"release_date\":\"2017-02-28\"},{\"vote_count\":2047,\"id\":315837,\"video\":false,\"vote_average\":5.9,\"title\":\"Ghost in the Shell\",\"popularity\":31.631589,\"poster_path\":\"\\/myRzRzCxdfUWjkJWgpHHZ1oGkJd.jpg\",\"original_language\":\"en\",\"original_title\":\"Ghost in the Shell\",\"genre_ids\":[28,80,18,9648,878,53],\"backdrop_path\":\"\\/dDVqfmCzSy3TKSmiS2pJ9QB5E3P.jpg\",\"adult\":false,\"overview\":\"In the near future, Major is the first of her kind: a human saved from a terrible crash, then cyber-enhanced to be a perfect soldier devoted to stopping the world's most dangerous criminals.\",\"release_date\":\"2017-03-29\"},{\"vote_count\":74,\"id\":390043,\"video\":false,\"vote_average\":5.7,\"title\":\"The Hitman's Bodyguard\",\"popularity\":31.348132,\"poster_path\":\"\\/eEQaKq3urzcfzlHMMckj4lXQWJv.jpg\",\"original_language\":\"en\",\"original_title\":\"The Hitman's Bodyguard\",\"genre_ids\":[28,35],\"backdrop_path\":\"\\/grfqyfygapZkz6Oh8PGxzYwnWR8.jpg\",\"adult\":false,\"overview\":\"The world's top bodyguard gets a new client, a hit man who must testify at the International Court of Justice. They must put their differences aside and work together to make it to the trial on time.\",\"release_date\":\"2017-08-16\"},{\"vote_count\":8993,\"id\":76341,\"video\":false,\"vote_average\":7.2,\"title\":\"Mad Max: Fury Road\",\"popularity\":29.879073,\"poster_path\":\"\\/kqjL17yufvn9OVLyXYpvtyrFfak.jpg\",\"original_language\":\"en\",\"original_title\":\"Mad Max: Fury Road\",\"genre_ids\":[28,12,878,53],\"backdrop_path\":\"\\/phszHPFVhPHhMZgo0fWTKBDQsJA.jpg\",\"adult\":false,\"overview\":\"An apocalyptic story set in the furthest reaches of our planet, in a stark desert landscape where humanity is broken, and most everyone is crazed fighting for the necessities of life. Within this world exist two rebels on the run who just might be able to restore order. There's Max, a man of action and a man of few words, who seeks peace of mind following the loss of his wife and child in the aftermath of the chaos. And Furiosa, a woman of action and a woman who believes her path to survival may be achieved if she can make it across the desert back to her childhood homeland.\",\"release_date\":\"2015-05-13\"}]}";

    /* The constructor is made private because an instance of this class as such does not make sense to the outside world
       as it only contains static methods and variables which can be accessed from outside using the class name.
     */

    private static final String SAMPLE_POPULAR_RESPONSE = "{  \n" +
            "   \"recommendations\":[  \n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/dkA8j5DwUdUT3h658Mt1QgQHTR6.jpg\",\n" +
            "         \"belongs_to_collection\":null,\n" +
            "         \"budget\":30000000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":28,\n" +
            "               \"name\":\"Action\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":35,\n" +
            "               \"name\":\"Comedy\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"http://thehitmansbodyguard.movie\",\n" +
            "         \"id\":390043,\n" +
            "         \"imdb_id\":\"tt1959563\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"The Hitman's Bodyguard\",\n" +
            "         \"overview\":\"The world's top bodyguard gets a new client, a hit man who must testify at the International Court of Justice. They must put their differences aside and work together to make it to the trial on time.\",\n" +
            "         \"popularity\":162.823802,\n" +
            "         \"poster_path\":\"/5CGjlz2vyBhW5xHW4eNOZIdgzYq.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Millennium Films\",\n" +
            "               \"id\":13813\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Cristaldi Pictures\",\n" +
            "               \"id\":41364\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Campbell Grobman Films\",\n" +
            "               \"id\":48738\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Tom de Mol Productions\",\n" +
            "               \"id\":70733\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Nu Boyana Film Studios\",\n" +
            "               \"id\":74795\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Skydance Media\",\n" +
            "               \"id\":82819\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"East Light Media\",\n" +
            "               \"id\":94235\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2017-08-16\",\n" +
            "         \"revenue\":21384504,\n" +
            "         \"runtime\":118,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_639_1\":\"ru\",\n" +
            "               \"name\":\"Pусский\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"Get Triggered\",\n" +
            "         \"title\":\"The Hitman's Bodyguard\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":6.4,\n" +
            "         \"vote_count\":322\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/dkMD5qlogeRMiEixC4YNPUvax2T.jpg\",\n" +
            "         \"belongs_to_collection\":{  \n" +
            "            \"id\":328,\n" +
            "            \"name\":\"Jurassic Park Collection\",\n" +
            "            \"poster_path\":\"/qIm2nHXLpBBdMxi8dvfrnDkBUDh.jpg\",\n" +
            "            \"backdrop_path\":\"/pJjIH9QN0OkHFV9eue6XfRVnPkr.jpg\"\n" +
            "         },\n" +
            "         \"budget\":150000000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":28,\n" +
            "               \"name\":\"Action\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":12,\n" +
            "               \"name\":\"Adventure\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":878,\n" +
            "               \"name\":\"Science Fiction\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":53,\n" +
            "               \"name\":\"Thriller\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"http://www.jurassicworld.com/\",\n" +
            "         \"id\":135397,\n" +
            "         \"imdb_id\":\"tt0369610\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"Jurassic World\",\n" +
            "         \"overview\":\"Twenty-two years after the events of Jurassic Park, Isla Nublar now features a fully functioning dinosaur theme park, Jurassic World, as originally envisioned by John Hammond.\",\n" +
            "         \"popularity\":116.741559,\n" +
            "         \"poster_path\":\"/jjBgi2r5cRt36xF6iNUEhzscEcb.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Universal Studios\",\n" +
            "               \"id\":13\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Amblin Entertainment\",\n" +
            "               \"id\":56\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Legendary Pictures\",\n" +
            "               \"id\":923\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Fuji Television Network\",\n" +
            "               \"id\":3341\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Dentsu\",\n" +
            "               \"id\":6452\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2015-06-09\",\n" +
            "         \"revenue\":1513528810,\n" +
            "         \"runtime\":124,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"The park is open.\",\n" +
            "         \"title\":\"Jurassic World\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":6.5,\n" +
            "         \"vote_count\":8442\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/1SkIz6eBdPWM6k3FOmodo7sbTJw.jpg\",\n" +
            "         \"belongs_to_collection\":null,\n" +
            "         \"budget\":0,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":9648,\n" +
            "               \"name\":\"Mystery\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":14,\n" +
            "               \"name\":\"Fantasy\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":27,\n" +
            "               \"name\":\"Horror\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":53,\n" +
            "               \"name\":\"Thriller\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"https://www.netflix.com/title/80122759\",\n" +
            "         \"id\":351460,\n" +
            "         \"imdb_id\":\"tt1241317\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"Death Note\",\n" +
            "         \"overview\":\"A young man comes to possess a supernatural notebook, the Death Note, that grants him the power to kill any person simply by writing down their name on the pages. He then decides to use the notebook to kill criminals and change the world, but an enigmatic detective attempts to track him down and end his reign of terror.\",\n" +
            "         \"popularity\":103.050532,\n" +
            "         \"poster_path\":\"/fJAvGOitU8y53ByeHnM4avtKFaG.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Vertigo Entertainment\",\n" +
            "               \"id\":829\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Lin Pictures\",\n" +
            "               \"id\":2723\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2017-08-25\",\n" +
            "         \"revenue\":0,\n" +
            "         \"runtime\":101,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"\",\n" +
            "         \"title\":\"Death Note\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":4.6,\n" +
            "         \"vote_count\":491\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/kMU8trT43p5LFoJ4plIySMOsZ1T.jpg\",\n" +
            "         \"belongs_to_collection\":{  \n" +
            "            \"id\":135416,\n" +
            "            \"name\":\"Prometheus Collection\",\n" +
            "            \"poster_path\":\"/gMjiXB5dhV8nN77xXnhTIhARE7a.jpg\",\n" +
            "            \"backdrop_path\":\"/cK83Pq8SJoeSTnLJucr8IWn35KF.jpg\"\n" +
            "         },\n" +
            "         \"budget\":97000000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":27,\n" +
            "               \"name\":\"Horror\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":878,\n" +
            "               \"name\":\"Science Fiction\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":53,\n" +
            "               \"name\":\"Thriller\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"https://alienuniverse.com/alien-covenant\",\n" +
            "         \"id\":126889,\n" +
            "         \"imdb_id\":\"tt2316204\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"Alien: Covenant\",\n" +
            "         \"overview\":\"Bound for a remote planet on the far side of the galaxy, the crew of the colony ship 'Covenant' discovers what is thought to be an uncharted paradise, but is actually a dark, dangerous world – which has its sole inhabitant the 'synthetic', David, survivor of the doomed Prometheus expedition.\",\n" +
            "         \"popularity\":99.82466100000001,\n" +
            "         \"poster_path\":\"/zecMELPbU5YMQpC81Z8ImaaXuf9.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Twentieth Century Fox Film Corporation\",\n" +
            "               \"id\":306\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Scott Free Productions\",\n" +
            "               \"id\":1645\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Brandywine Productions\",\n" +
            "               \"id\":19747\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"TSG Entertainment\",\n" +
            "               \"id\":22213\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"AU\",\n" +
            "               \"name\":\"Australia\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"CA\",\n" +
            "               \"name\":\"Canada\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"NZ\",\n" +
            "               \"name\":\"New Zealand\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"GB\",\n" +
            "               \"name\":\"United Kingdom\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2017-05-09\",\n" +
            "         \"revenue\":232380243,\n" +
            "         \"runtime\":122,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"The path to paradise begins in hell.\",\n" +
            "         \"title\":\"Alien: Covenant\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":5.7,\n" +
            "         \"vote_count\":2282\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/4eOlKrgGDfTncQTwVhm2I4A5Tlo.jpg\",\n" +
            "         \"belongs_to_collection\":null,\n" +
            "         \"budget\":30000000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":28,\n" +
            "               \"name\":\"Action\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":18,\n" +
            "               \"name\":\"Drama\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":80,\n" +
            "               \"name\":\"Crime\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":53,\n" +
            "               \"name\":\"Thriller\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"\",\n" +
            "         \"id\":11702,\n" +
            "         \"imdb_id\":\"tt0120008\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"The Replacement Killers\",\n" +
            "         \"overview\":\"Hired assassin John Lee is asked by Chinatown crime boss Terence Wei to murder the young son of policeman Stan Zedkov. Lee has the boy in his sights, but his conscience gets the better of him, and he spares the child's life. Afraid that Wei will take revenge on his family in China, Lee seeks out expert forger Meg Coburn to obtain the passport he needs to get out of the country, but a band of replacement killers is soon on his trail.\",\n" +
            "         \"popularity\":2.649755,\n" +
            "         \"poster_path\":\"/w3a8vGtEyCPypK1muKOO6h1VLAY.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Columbia Pictures Corporation\",\n" +
            "               \"id\":441\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"1998-02-06\",\n" +
            "         \"revenue\":19204929,\n" +
            "         \"runtime\":87,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"cn\",\n" +
            "               \"name\":\"广州话 / 廣州話\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_639_1\":\"cs\",\n" +
            "               \"name\":\"Český\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"Kill or be replaced.\",\n" +
            "         \"title\":\"The Replacement Killers\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":6.0,\n" +
            "         \"vote_count\":125\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/jzdnhRhG0dsuYorwvSqPqqnM1cV.jpg\",\n" +
            "         \"belongs_to_collection\":{  \n" +
            "            \"id\":9485,\n" +
            "            \"name\":\"The Fast and the Furious Collection\",\n" +
            "            \"poster_path\":\"/mCkqJf4ijbNoBWvJ0RTWZJuhJUA.jpg\",\n" +
            "            \"backdrop_path\":\"/z5A5W3WYJc3UVEWljSGwdjDgQ0j.jpg\"\n" +
            "         },\n" +
            "         \"budget\":250000000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":28,\n" +
            "               \"name\":\"Action\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":80,\n" +
            "               \"name\":\"Crime\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":53,\n" +
            "               \"name\":\"Thriller\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"http://www.fastandfurious.com/\",\n" +
            "         \"id\":337339,\n" +
            "         \"imdb_id\":\"tt4630562\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"The Fate of the Furious\",\n" +
            "         \"overview\":\"When a mysterious woman seduces Dom into the world of crime and a betrayal of those closest to him, the crew face trials that will test them as never before.\",\n" +
            "         \"popularity\":43.601265,\n" +
            "         \"poster_path\":\"/iNpz2DgTsTMPaDRZq2tnbqjL2vF.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Universal Pictures\",\n" +
            "               \"id\":33\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Original Film\",\n" +
            "               \"id\":333\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"One Race Films\",\n" +
            "               \"id\":7154\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2017-04-12\",\n" +
            "         \"revenue\":1238764765,\n" +
            "         \"runtime\":136,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"Family no more\",\n" +
            "         \"title\":\"The Fate of the Furious\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":6.8,\n" +
            "         \"vote_count\":3538\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/tFI8VLMgSTTU38i8TIsklfqS9Nl.jpg\",\n" +
            "         \"belongs_to_collection\":null,\n" +
            "         \"budget\":165000000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":28,\n" +
            "               \"name\":\"Action\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":12,\n" +
            "               \"name\":\"Adventure\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":14,\n" +
            "               \"name\":\"Fantasy\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":878,\n" +
            "               \"name\":\"Science Fiction\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"http://marvel.com/doctorstrange\",\n" +
            "         \"id\":284052,\n" +
            "         \"imdb_id\":\"tt1211837\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"Doctor Strange\",\n" +
            "         \"overview\":\"After his career is destroyed, a brilliant but arrogant surgeon gets a new lease on life when a sorcerer takes him under his wing and trains him to defend the world against evil.\",\n" +
            "         \"popularity\":42.605814,\n" +
            "         \"poster_path\":\"/4PiiNGXj1KENTmCBHeN6Mskj2Fq.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Walt Disney Pictures\",\n" +
            "               \"id\":2\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Marvel Studios\",\n" +
            "               \"id\":420\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2016-10-25\",\n" +
            "         \"revenue\":677718395,\n" +
            "         \"runtime\":115,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"Open your mind. Change your reality.\",\n" +
            "         \"title\":\"Doctor Strange\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":7.1,\n" +
            "         \"vote_count\":5379\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/87hTDiay2N2qWyX4Ds7ybXi9h8I.jpg\",\n" +
            "         \"belongs_to_collection\":null,\n" +
            "         \"budget\":63000000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":18,\n" +
            "               \"name\":\"Drama\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"http://www.foxmovies.com/movies/fight-club\",\n" +
            "         \"id\":550,\n" +
            "         \"imdb_id\":\"tt0137523\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"Fight Club\",\n" +
            "         \"overview\":\"A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \\\"fight clubs\\\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.\",\n" +
            "         \"popularity\":41.498535,\n" +
            "         \"poster_path\":\"/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Regency Enterprises\",\n" +
            "               \"id\":508\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Fox 2000 Pictures\",\n" +
            "               \"id\":711\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Taurus Film\",\n" +
            "               \"id\":20555\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Linson Films\",\n" +
            "               \"id\":54050\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Atman Entertainment\",\n" +
            "               \"id\":54051\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Knickerbocker Films\",\n" +
            "               \"id\":54052\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"DE\",\n" +
            "               \"name\":\"Germany\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"1999-10-15\",\n" +
            "         \"revenue\":100853753,\n" +
            "         \"runtime\":139,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"Mischief. Mayhem. Soap.\",\n" +
            "         \"title\":\"Fight Club\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":8.3,\n" +
            "         \"vote_count\":9154\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/8AUQ7YlJJA9C8kWk8P4YNHIcFDE.jpg\",\n" +
            "         \"belongs_to_collection\":{  \n" +
            "            \"id\":295,\n" +
            "            \"name\":\"Pirates of the Caribbean Collection\",\n" +
            "            \"poster_path\":\"/zT5UKFhq9nk97VGlBbAxlAK8UFN.jpg\",\n" +
            "            \"backdrop_path\":\"/cnKAGbX1rDkAquF2V1wVkptHDJO.jpg\"\n" +
            "         },\n" +
            "         \"budget\":140000000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":12,\n" +
            "               \"name\":\"Adventure\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":14,\n" +
            "               \"name\":\"Fantasy\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":28,\n" +
            "               \"name\":\"Action\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"http://disney.go.com/disneyvideos/liveaction/pirates/main_site/main.html\",\n" +
            "         \"id\":22,\n" +
            "         \"imdb_id\":\"tt0325980\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"Pirates of the Caribbean: The Curse of the Black Pearl\",\n" +
            "         \"overview\":\"Jack Sparrow, a freewheeling 17th-century pirate who roams the Caribbean Sea, butts heads with a rival pirate bent on pillaging the village of Port Royal. When the governor's daughter is kidnapped, Sparrow decides to help the girl's love save her. But their seafaring mission is hardly simple.\",\n" +
            "         \"popularity\":37.879786,\n" +
            "         \"poster_path\":\"/tkt9xR1kNX5R9rCebASKck44si2.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Walt Disney Pictures\",\n" +
            "               \"id\":2\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Jerry Bruckheimer Films\",\n" +
            "               \"id\":130\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2003-07-09\",\n" +
            "         \"revenue\":655011224,\n" +
            "         \"runtime\":143,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"Prepare to be blown out of the water.\",\n" +
            "         \"title\":\"Pirates of the Caribbean: The Curse of the Black Pearl\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":7.5,\n" +
            "         \"vote_count\":6785\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/6bbZ6XyvgfjhQwbplnUh1LSj1ky.jpg\",\n" +
            "         \"belongs_to_collection\":null,\n" +
            "         \"budget\":3300000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":18,\n" +
            "               \"name\":\"Drama\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"http://sonyclassics.com/whiplash/\",\n" +
            "         \"id\":244786,\n" +
            "         \"imdb_id\":\"tt2582802\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"Whiplash\",\n" +
            "         \"overview\":\"Under the direction of a ruthless instructor, a talented young drummer begins to pursue perfection at any cost, even his humanity.\",\n" +
            "         \"popularity\":35.541795,\n" +
            "         \"poster_path\":\"/lIv1QinFqz4dlp5U4lQ6HaiskOZ.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Bold Films\",\n" +
            "               \"id\":2266\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Blumhouse Productions\",\n" +
            "               \"id\":3172\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Right of Way Films\",\n" +
            "               \"id\":32157\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2014-10-10\",\n" +
            "         \"revenue\":13092000,\n" +
            "         \"runtime\":105,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"The road to greatness can take you to the edge.\",\n" +
            "         \"title\":\"Whiplash\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":8.300000000000001,\n" +
            "         \"vote_count\":4115\n" +
            "      }\n" +
            "   ]\n" +
            "}";

    private static final String SAMPLE_RECOMMENDED_RESPONSE = "{  \n" +
            "   \"recommendations\":[  \n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/o8u0NyEigCEaZHBdCYTRfXR8U4i.jpg\",\n" +
            "         \"belongs_to_collection\":{  \n" +
            "            \"id\":402074,\n" +
            "            \"name\":\"Annabelle Collection\",\n" +
            "            \"poster_path\":\"/zJfExJWUgugWziREAikeAW69poY.jpg\",\n" +
            "            \"backdrop_path\":\"/AbTHMNaeUO8rUcRZf5J6MRfZE6v.jpg\"\n" +
            "         },\n" +
            "         \"budget\":15000000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":53,\n" +
            "               \"name\":\"Thriller\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":27,\n" +
            "               \"name\":\"Horror\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"http://annabellemovie.com\",\n" +
            "         \"id\":396422,\n" +
            "         \"imdb_id\":\"tt5140878\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"Annabelle: Creation\",\n" +
            "         \"overview\":\"Several years after the tragic death of their little girl, a dollmaker and his wife welcome a nun and several girls from a shuttered orphanage into their home, soon becoming the target of the dollmaker's possessed creation, Annabelle.\",\n" +
            "         \"popularity\":85.907578,\n" +
            "         \"poster_path\":\"/tb86j8jVCVsdZnzf8I6cIi65IeM.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"New Line Cinema\",\n" +
            "               \"id\":12\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Atomic Monster\",\n" +
            "               \"id\":76907\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2017-08-09\",\n" +
            "         \"revenue\":99600664,\n" +
            "         \"runtime\":109,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"You don't know the real story\",\n" +
            "         \"title\":\"Annabelle: Creation\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":6.4,\n" +
            "         \"vote_count\":503\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/puV2PFq42VQPItaygizgag8jrXa.jpg\",\n" +
            "         \"belongs_to_collection\":{  \n" +
            "            \"id\":86066,\n" +
            "            \"name\":\"Despicable Me Collection\",\n" +
            "            \"poster_path\":\"/xIXhIlZDRmSSfNbpN7kBCm5hg39.jpg\",\n" +
            "            \"backdrop_path\":\"/15IZl405E664QDVxpFJBl7TtLmw.jpg\"\n" +
            "         },\n" +
            "         \"budget\":0,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":878,\n" +
            "               \"name\":\"Science Fiction\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":12,\n" +
            "               \"name\":\"Adventure\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":16,\n" +
            "               \"name\":\"Animation\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":35,\n" +
            "               \"name\":\"Comedy\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":10751,\n" +
            "               \"name\":\"Family\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"http://www.despicable.me\",\n" +
            "         \"id\":324852,\n" +
            "         \"imdb_id\":\"tt3469046\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"Despicable Me 3\",\n" +
            "         \"overview\":\"Gru and his wife Lucy must stop former '80s child star Balthazar Bratt from achieving world domination.\",\n" +
            "         \"popularity\":48.385362,\n" +
            "         \"poster_path\":\"/5qcUGqWoWhEsoQwNUrtf3y3fcWn.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Illumination Entertainment\",\n" +
            "               \"id\":6704\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2017-06-15\",\n" +
            "         \"revenue\":0,\n" +
            "         \"runtime\":96,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"Oh brother.\",\n" +
            "         \"title\":\"Despicable Me 3\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":6.1,\n" +
            "         \"vote_count\":1421\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/zw3fM9KYYhYGsIQUJOyQNbeZSnn.jpg\",\n" +
            "         \"belongs_to_collection\":{  \n" +
            "            \"id\":344830,\n" +
            "            \"name\":\"Fifty Shades Collection\",\n" +
            "            \"poster_path\":\"/oJrMaAhQlV5K9QFhulFehTn7JVn.jpg\",\n" +
            "            \"backdrop_path\":\"/fUHFCnqGHozSiEF8yT7dhE1OKnY.jpg\"\n" +
            "         },\n" +
            "         \"budget\":40000000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":18,\n" +
            "               \"name\":\"Drama\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":10749,\n" +
            "               \"name\":\"Romance\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":53,\n" +
            "               \"name\":\"Thriller\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"https://www.facebook.com/fiftyshadesofgreymovie\",\n" +
            "         \"id\":216015,\n" +
            "         \"imdb_id\":\"tt2322441\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"Fifty Shades of Grey\",\n" +
            "         \"overview\":\"When college senior Anastasia Steele steps in for her sick roommate to interview prominent businessman Christian Grey for their campus paper, little does she realize the path her life will take. Christian, as enigmatic as he is rich and powerful, finds himself strangely drawn to Ana, and she to him. Though sexually inexperienced, Ana plunges headlong into an affair -- and learns that Christian's true sexual proclivities push the boundaries of pain and pleasure.\",\n" +
            "         \"popularity\":5.164266,\n" +
            "         \"poster_path\":\"/jV8wnk3Jgz6f7degmT3lHNGI2tK.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Focus Features\",\n" +
            "               \"id\":10146\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Trigger Street Productions\",\n" +
            "               \"id\":11801\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Michael De Luca Productions\",\n" +
            "               \"id\":27551\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2015-02-11\",\n" +
            "         \"revenue\":571006128,\n" +
            "         \"runtime\":125,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"Are you curious?\",\n" +
            "         \"title\":\"Fifty Shades of Grey\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":5.2,\n" +
            "         \"vote_count\":3111\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/fudEG1VUWuOqleXv6NwCExK0VLy.jpg\",\n" +
            "         \"belongs_to_collection\":null,\n" +
            "         \"budget\":150000000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":28,\n" +
            "               \"name\":\"Action\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":18,\n" +
            "               \"name\":\"Drama\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":36,\n" +
            "               \"name\":\"History\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":53,\n" +
            "               \"name\":\"Thriller\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":10752,\n" +
            "               \"name\":\"War\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"http://www.dunkirkmovie.com/\",\n" +
            "         \"id\":374720,\n" +
            "         \"imdb_id\":\"tt5013056\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"Dunkirk\",\n" +
            "         \"overview\":\"Miraculous evacuation of Allied soldiers from Belgium, Britain, Canada, and France, who were cut off and surrounded by the German army from the beaches and harbor of Dunkirk, France, between May 26 and June 04, 1940, during Battle of France in World War II.\",\n" +
            "         \"popularity\":51.7942,\n" +
            "         \"poster_path\":\"/cUqEgoP6kj8ykfNjJx3Tl5zHCcN.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Canal+\",\n" +
            "               \"id\":5358\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Studio Canal\",\n" +
            "               \"id\":5870\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Warner Bros.\",\n" +
            "               \"id\":6194\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Syncopy\",\n" +
            "               \"id\":9996\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"RatPac-Dune Entertainment\",\n" +
            "               \"id\":41624\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Kaap Holland Film\",\n" +
            "               \"id\":67254\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"NL\",\n" +
            "               \"name\":\"Netherlands\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"FR\",\n" +
            "               \"name\":\"France\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"GB\",\n" +
            "               \"name\":\"United Kingdom\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2017-07-19\",\n" +
            "         \"revenue\":339537551,\n" +
            "         \"runtime\":107,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_639_1\":\"fr\",\n" +
            "               \"name\":\"Français\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_639_1\":\"de\",\n" +
            "               \"name\":\"Deutsch\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"The event that shaped our world\",\n" +
            "         \"title\":\"Dunkirk\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":7.3,\n" +
            "         \"vote_count\":1539\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/m5O3SZvQ6EgD5XXXLPIP1wLppeW.jpg\",\n" +
            "         \"belongs_to_collection\":{  \n" +
            "            \"id\":131295,\n" +
            "            \"name\":\"Captain America Collection\",\n" +
            "            \"poster_path\":\"/2tOgiY533JSFp7OrVlkeRJvsZpI.jpg\",\n" +
            "            \"backdrop_path\":\"/nZSYqitBkAvmoq5IrsGsSWuhSC8.jpg\"\n" +
            "         },\n" +
            "         \"budget\":250000000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":12,\n" +
            "               \"name\":\"Adventure\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":28,\n" +
            "               \"name\":\"Action\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":878,\n" +
            "               \"name\":\"Science Fiction\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"http://marvel.com/captainamericapremiere\",\n" +
            "         \"id\":271110,\n" +
            "         \"imdb_id\":\"tt3498820\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"Captain America: Civil War\",\n" +
            "         \"overview\":\"Following the events of Age of Ultron, the collective governments of the world pass an act designed to regulate all superhuman activity. This polarizes opinion amongst the Avengers, causing two factions to side with Iron Man or Captain America, which causes an epic battle between former allies.\",\n" +
            "         \"popularity\":15.065298,\n" +
            "         \"poster_path\":\"/kSBXou5Ac7vEqKd97wotJumyJvU.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Studio Babelsberg\",\n" +
            "               \"id\":264\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Marvel Studios\",\n" +
            "               \"id\":420\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Walt Disney Studios Motion Pictures\",\n" +
            "               \"id\":3036\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Vita-Ray Dutch Productions (III)\",\n" +
            "               \"id\":84424\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Deluxe Digital Studios\",\n" +
            "               \"id\":84425\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2016-04-27\",\n" +
            "         \"revenue\":1153304495,\n" +
            "         \"runtime\":147,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"ro\",\n" +
            "               \"name\":\"Română\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_639_1\":\"de\",\n" +
            "               \"name\":\"Deutsch\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_639_1\":\"ru\",\n" +
            "               \"name\":\"Pусский\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"Divided We Fall\",\n" +
            "         \"title\":\"Captain America: Civil War\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":7.0,\n" +
            "         \"vote_count\":6947\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg\",\n" +
            "         \"belongs_to_collection\":{  \n" +
            "            \"id\":448150,\n" +
            "            \"name\":\"Deadpool Collection\",\n" +
            "            \"poster_path\":\"/30c5jO7YEXuF8KiWXLg9m28GWDA.jpg\",\n" +
            "            \"backdrop_path\":\"/hBQOWY8qWXJVFAc8yLTh1teIu43.jpg\"\n" +
            "         },\n" +
            "         \"budget\":58000000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":28,\n" +
            "               \"name\":\"Action\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":12,\n" +
            "               \"name\":\"Adventure\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":35,\n" +
            "               \"name\":\"Comedy\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"http://www.foxmovies.com/movies/deadpool\",\n" +
            "         \"id\":293660,\n" +
            "         \"imdb_id\":\"tt1431045\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"Deadpool\",\n" +
            "         \"overview\":\"Deadpool tells the origin story of former Special Forces operative turned mercenary Wade Wilson, who after being subjected to a rogue experiment that leaves him with accelerated healing powers, adopts the alter ego Deadpool. Armed with his new abilities and a dark, twisted sense of humor, Deadpool hunts down the man who nearly destroyed his life.\",\n" +
            "         \"popularity\":34.225321,\n" +
            "         \"poster_path\":\"/inVq3FRqcYIRl2la8iZikYYxFNR.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Twentieth Century Fox Film Corporation\",\n" +
            "               \"id\":306\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Marvel Entertainment\",\n" +
            "               \"id\":7505\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"The Donners' Company\",\n" +
            "               \"id\":11307\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"TSG Entertainment\",\n" +
            "               \"id\":22213\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Kinberg Genre\",\n" +
            "               \"id\":78091\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2016-02-09\",\n" +
            "         \"revenue\":783112979,\n" +
            "         \"runtime\":108,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"Witness the beginning of a happy ending\",\n" +
            "         \"title\":\"Deadpool\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":7.4,\n" +
            "         \"vote_count\":10435\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/5pAGnkFYSsFJ99ZxDIYnhQbQFXs.jpg\",\n" +
            "         \"belongs_to_collection\":{  \n" +
            "            \"id\":453993,\n" +
            "            \"name\":\"The Wolverine Collection\",\n" +
            "            \"poster_path\":\"/8Ht4a5A5Ypxh0PjbVoRTzm1kAu3.jpg\",\n" +
            "            \"backdrop_path\":\"/QtSxEuCwcZSfCTMZfER3nHDVsG.jpg\"\n" +
            "         },\n" +
            "         \"budget\":97000000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":28,\n" +
            "               \"name\":\"Action\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":18,\n" +
            "               \"name\":\"Drama\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":878,\n" +
            "               \"name\":\"Science Fiction\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"http://www.foxmovies.com/movies/logan\",\n" +
            "         \"id\":263115,\n" +
            "         \"imdb_id\":\"tt3315342\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"Logan\",\n" +
            "         \"overview\":\"In the near future, a weary Logan cares for an ailing Professor X in a hideout on the Mexican border. But Logan's attempts to hide from the world and his legacy are upended when a young mutant arrives, pursued by dark forces.\",\n" +
            "         \"popularity\":33.267526,\n" +
            "         \"poster_path\":\"/gGBu0hKw9BGddG8RkRAMX7B6NDB.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Twentieth Century Fox Film Corporation\",\n" +
            "               \"id\":306\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Donners' Company\",\n" +
            "               \"id\":431\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Marvel Entertainment\",\n" +
            "               \"id\":7505\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"TSG Entertainment\",\n" +
            "               \"id\":22213\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2017-02-28\",\n" +
            "         \"revenue\":616218538,\n" +
            "         \"runtime\":137,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_639_1\":\"es\",\n" +
            "               \"name\":\"Español\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"His time has come\",\n" +
            "         \"title\":\"Logan\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":7.5,\n" +
            "         \"vote_count\":5617\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/phszHPFVhPHhMZgo0fWTKBDQsJA.jpg\",\n" +
            "         \"belongs_to_collection\":{  \n" +
            "            \"id\":8945,\n" +
            "            \"name\":\"Mad Max Collection\",\n" +
            "            \"poster_path\":\"/jZowUf4okNYuSlgj5iURE7CDMho.jpg\",\n" +
            "            \"backdrop_path\":\"/zI0q2ENcQOLECbe0gAEGlncVh2j.jpg\"\n" +
            "         },\n" +
            "         \"budget\":150000000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":28,\n" +
            "               \"name\":\"Action\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":12,\n" +
            "               \"name\":\"Adventure\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":878,\n" +
            "               \"name\":\"Science Fiction\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":53,\n" +
            "               \"name\":\"Thriller\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"http://www.madmaxmovie.com/\",\n" +
            "         \"id\":76341,\n" +
            "         \"imdb_id\":\"tt1392190\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"Mad Max: Fury Road\",\n" +
            "         \"overview\":\"An apocalyptic story set in the furthest reaches of our planet, in a stark desert landscape where humanity is broken, and most everyone is crazed fighting for the necessities of life. Within this world exist two rebels on the run who just might be able to restore order. There's Max, a man of action and a man of few words, who seeks peace of mind following the loss of his wife and child in the aftermath of the chaos. And Furiosa, a woman of action and a woman who believes her path to survival may be achieved if she can make it across the desert back to her childhood homeland.\",\n" +
            "         \"popularity\":33.280391,\n" +
            "         \"poster_path\":\"/kqjL17yufvn9OVLyXYpvtyrFfak.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Village Roadshow Pictures\",\n" +
            "               \"id\":79\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Kennedy Miller Productions\",\n" +
            "               \"id\":2537\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Warner Bros.\",\n" +
            "               \"id\":6194\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"AU\",\n" +
            "               \"name\":\"Australia\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2015-05-13\",\n" +
            "         \"revenue\":378858340,\n" +
            "         \"runtime\":120,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"What a Lovely Day.\",\n" +
            "         \"title\":\"Mad Max: Fury Road\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":7.2,\n" +
            "         \"vote_count\":9099\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/aJn9XeesqsrSLKcHfHP4u5985hn.jpg\",\n" +
            "         \"belongs_to_collection\":{  \n" +
            "            \"id\":284433,\n" +
            "            \"name\":\"Guardians of the Galaxy Collection\",\n" +
            "            \"poster_path\":\"/kFWLxUwcSpiLzszZbxUIZT9g6WR.jpg\",\n" +
            "            \"backdrop_path\":\"/jdyyjulTBU8YUYAUvQFj6U1g2Pj.jpg\"\n" +
            "         },\n" +
            "         \"budget\":200000000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":28,\n" +
            "               \"name\":\"Action\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":12,\n" +
            "               \"name\":\"Adventure\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":35,\n" +
            "               \"name\":\"Comedy\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":878,\n" +
            "               \"name\":\"Science Fiction\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"http://marvel.com/movies/movie/221/guardians_of_the_galaxy_vol_2\",\n" +
            "         \"id\":283995,\n" +
            "         \"imdb_id\":\"tt3896198\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"Guardians of the Galaxy Vol. 2\",\n" +
            "         \"overview\":\"The Guardians must fight to keep their newfound family together as they unravel the mysteries of Peter Quill's true parentage.\",\n" +
            "         \"popularity\":55.158981,\n" +
            "         \"poster_path\":\"/y4MBh0EjBlMuOzv9axM4qJlmhzz.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Walt Disney Pictures\",\n" +
            "               \"id\":2\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Marvel Studios\",\n" +
            "               \"id\":420\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2017-04-19\",\n" +
            "         \"revenue\":862668505,\n" +
            "         \"runtime\":137,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"Obviously.\",\n" +
            "         \"title\":\"Guardians of the Galaxy Vol. 2\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":7.6,\n" +
            "         \"vote_count\":3871\n" +
            "      },\n" +
            "      {  \n" +
            "         \"adult\":false,\n" +
            "         \"backdrop_path\":\"/6I2tPx6KIiBB4TWFiWwNUzrbxUn.jpg\",\n" +
            "         \"belongs_to_collection\":{  \n" +
            "            \"id\":435259,\n" +
            "            \"name\":\"Fantastic Beasts Collection\",\n" +
            "            \"poster_path\":\"/wsVseA7i3FqX24m26Z2gD3EtH4l.jpg\",\n" +
            "            \"backdrop_path\":\"/jc1Sh8U6dvWv9rHaRl8aosTAoPN.jpg\"\n" +
            "         },\n" +
            "         \"budget\":180000000,\n" +
            "         \"genres\":[  \n" +
            "            {  \n" +
            "               \"id\":10751,\n" +
            "               \"name\":\"Family\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"id\":14,\n" +
            "               \"name\":\"Fantasy\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"homepage\":\"http://www.fantasticbeasts.com/\",\n" +
            "         \"id\":259316,\n" +
            "         \"imdb_id\":\"tt3183660\",\n" +
            "         \"original_language\":\"en\",\n" +
            "         \"original_title\":\"Fantastic Beasts and Where to Find Them\",\n" +
            "         \"overview\":\"In 1926, Newt Scamander arrives at the Magical Congress of the United States of America with a magically expanded briefcase, which houses a number of dangerous creatures and their habitats. When the creatures escape from the briefcase, it sends the American wizarding authorities after Newt, and threatens to strain even further the state of magical and non-magical relations.\",\n" +
            "         \"popularity\":10.745021,\n" +
            "         \"poster_path\":\"/dXwbjYyZH1Se0IS3oVcPdvueLKd.jpg\",\n" +
            "         \"production_companies\":[  \n" +
            "            {  \n" +
            "               \"name\":\"Heyday films\",\n" +
            "               \"id\":437\n" +
            "            },\n" +
            "            {  \n" +
            "               \"name\":\"Warner Bros.\",\n" +
            "               \"id\":6194\n" +
            "            }\n" +
            "         ],\n" +
            "         \"production_countries\":[  \n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"GB\",\n" +
            "               \"name\":\"United Kingdom\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"iso_3166_1\":\"US\",\n" +
            "               \"name\":\"United States of America\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"release_date\":\"2016-11-16\",\n" +
            "         \"revenue\":809342332,\n" +
            "         \"runtime\":133,\n" +
            "         \"spoken_languages\":[  \n" +
            "            {  \n" +
            "               \"iso_639_1\":\"en\",\n" +
            "               \"name\":\"English\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"status\":\"Released\",\n" +
            "         \"tagline\":\"From J.K. Rowling's wizarding world.\",\n" +
            "         \"title\":\"Fantastic Beasts\",\n" +
            "         \"video\":false,\n" +
            "         \"vote_average\":7.2,\n" +
            "         \"vote_count\":5115\n" +
            "      }\n" +
            "   ]\n" +
            "}";

    private static final String SAMPLE_IN_THEATERS_RESPONSE = "{\"recommendations\":[\n" +
            "{\"adult\":false,\"backdrop_path\":\"/ziO7LDh3aFOrZmwuWvw4i6ghypx.jpg\",\"belongs_to_collection\":null,\"budget\":0,\"genres\":[{\"id\":35,\"name\":\"Comedy\"}],\"homepage\":\"http://thelayoverfilm.com\",\"id\":339404,\"imdb_id\":\"tt4565520\",\"original_language\":\"en\",\"original_title\":\"The Layover\",\"overview\":\"When their plane is rerouted due to a hurricane warning, two single female best friends find themselves competing for the same guy during an extended layover in St. Louis.\",\"popularity\":63.34187,\"poster_path\":\"/kb9osnqanXRpkpm1bnSqAhKoq5T.jpg\",\"production_companies\":[{\"name\":\"Unified Pictures\",\"id\":13238},{\"name\":\"Bron Studios\",\"id\":13240},{\"name\":\"Creative Wealth Media Finance\",\"id\":53152}],\"production_countries\":[{\"iso_3166_1\":\"US\",\"name\":\"United States of America\"}],\"release_date\":\"2017-09-01\",\"revenue\":0,\"runtime\":88,\"spoken_languages\":[{\"iso_639_1\":\"en\",\"name\":\"English\"}],\"status\":\"Released\",\"tagline\":\"The flight is off. The fight is on.\",\"title\":\"The Layover\",\"video\":false,\"vote_average\":7.2,\"vote_count\":9},{\"adult\":false,\"backdrop_path\":\"/dkA8j5DwUdUT3h658Mt1QgQHTR6.jpg\",\"belongs_to_collection\":null,\"budget\":30000000,\"genres\":[{\"id\":28,\"name\":\"Action\"},{\"id\":35,\"name\":\"Comedy\"}],\"homepage\":\"http://thehitmansbodyguard.movie\",\"id\":390043,\"imdb_id\":\"tt1959563\",\"original_language\":\"en\",\"original_title\":\"The Hitman's Bodyguard\",\"overview\":\"The world's top bodyguard gets a new client, a hit man who must testify at the International Court of Justice. They must put their differences aside and work together to make it to the trial on time.\",\"popularity\":162.823802,\"poster_path\":\"/5CGjlz2vyBhW5xHW4eNOZIdgzYq.jpg\",\"production_companies\":[{\"name\":\"Millennium Films\",\"id\":13813},{\"name\":\"Cristaldi Pictures\",\"id\":41364},{\"name\":\"Campbell Grobman Films\",\"id\":48738},{\"name\":\"Tom de Mol Productions\",\"id\":70733},{\"name\":\"Nu Boyana Film Studios\",\"id\":74795},{\"name\":\"Skydance Media\",\"id\":82819},{\"name\":\"East Light Media\",\"id\":94235}],\"production_countries\":[{\"iso_3166_1\":\"US\",\"name\":\"United States of America\"}],\"release_date\":\"2017-08-16\",\"revenue\":21384504,\"runtime\":118,\"spoken_languages\":[{\"iso_639_1\":\"en\",\"name\":\"English\"},{\"iso_639_1\":\"ru\",\"name\":\"Pусский\"}],\"status\":\"Released\",\"tagline\":\"Get Triggered\",\"title\":\"The Hitman's Bodyguard\",\"video\":false,\"vote_average\":6.4,\"vote_count\":322},{\"adult\":false,\"backdrop_path\":\"/jcKzxRGYiXuS7ctTHLdw9wH8d7V.jpg\",\"belongs_to_collection\":null,\"budget\":80000000,\"genres\":[{\"id\":80,\"name\":\"Crime\"},{\"id\":53,\"name\":\"Thriller\"}],\"homepage\":\"http://www.americanmademovie.net/\",\"id\":337170,\"imdb_id\":\"tt3532216\",\"original_language\":\"en\",\"original_title\":\"American Made\",\"overview\":\"The true story of pilot Barry Seal, who transported contraband for the CIA and the Medellin cartel in the 1980s.\",\"popularity\":19.164394,\"poster_path\":\"/8dTWj3c74RDhXfSUZpuyVNJrgS.jpg\",\"production_companies\":[{\"name\":\"Imagine Entertainment\",\"id\":23},{\"name\":\"Cross Creek Pictures\",\"id\":10246},{\"name\":\"Vendian Entertainment\",\"id\":50481},{\"name\":\"Quadrant Pictures\",\"id\":80680}],\"production_countries\":[{\"iso_3166_1\":\"US\",\"name\":\"United States of America\"}],\"release_date\":\"2017-08-17\",\"revenue\":0,\"runtime\":115,\"spoken_languages\":[{\"iso_639_1\":\"en\",\"name\":\"English\"}],\"status\":\"Released\",\"tagline\":\"It’s not a felony if you’re doing it for the good guys\",\"title\":\"American Made\",\"video\":false,\"vote_average\":5.7,\"vote_count\":59},{\"adult\":false,\"backdrop_path\":null,\"belongs_to_collection\":null,\"budget\":0,\"genres\":[{\"id\":10749,\"name\":\"Romance\"},{\"id\":35,\"name\":\"Comedy\"}],\"homepage\":\"\",\"id\":471892,\"imdb_id\":\"tt6971752\",\"original_language\":\"hi\",\"original_title\":\"Shubh Mangal Saavdhan\",\"overview\":\"In this remake of Kalyana Samayal Saadham (2013), a couple fall in love but then the groom discovers that he suffers from erectile dysfunction.\",\"popularity\":17.312266,\"poster_path\":\"/7g8umvSPivb7wnWbTHVtyDaRWfK.jpg\",\"production_companies\":[],\"production_countries\":[],\"release_date\":\"2017-09-01\",\"revenue\":0,\"runtime\":119,\"spoken_languages\":[{\"iso_639_1\":\"hi\",\"name\":\"हिन्दी\"}],\"status\":\"Post Production\",\"tagline\":\"\",\"title\":\"Shubh Mangal Saavdhan\",\"video\":false,\"vote_average\":6.8,\"vote_count\":2},{\"adult\":false,\"backdrop_path\":null,\"belongs_to_collection\":null,\"budget\":0,\"genres\":[{\"id\":18,\"name\":\"Drama\"},{\"id\":10749,\"name\":\"Romance\"}],\"homepage\":\"\",\"id\":465080,\"imdb_id\":\"tt6649066\",\"original_language\":\"en\",\"original_title\":\"Hollywood Dirt\",\"overview\":\"Hollywood arrives in force to Quincy, the small town where the secret Crown Cola billionaire's live. They want to film about the billionaire's and how they made their fortunes. Summer Jenkins, who was the town pariah, joins forces with the scout, Ben, and finds filming locations, extras, lessons with the town officials and house owners, etc. When Cole Masten arrives, they hate each other, but sparks fly. Cole is running from a nasty divorce, yet is captivated by Summer. Summer is dying to leave town to get away from the gossip. This is a great story about Southern customs, a Southern girl, and a Hollywood star who finds his lady.\",\"popularity\":16.724084,\"poster_path\":\"/2TH8o1RH6gTn4zaYY87QNqUxSb8.jpg\",\"production_companies\":[{\"name\":\"PassionFlix\",\"id\":92153}],\"production_countries\":[],\"release_date\":\"2017-09-01\",\"revenue\":0,\"runtime\":0,\"spoken_languages\":[{\"iso_639_1\":\"en\",\"name\":\"English\"}],\"status\":\"Post Production\",\"tagline\":\"\",\"title\":\"Hollywood Dirt\",\"video\":false,\"vote_average\":0.0,\"vote_count\":0},{\"adult\":false,\"backdrop_path\":null,\"belongs_to_collection\":null,\"budget\":0,\"genres\":[{\"id\":53,\"name\":\"Thriller\"},{\"id\":27,\"name\":\"Horror\"},{\"id\":14,\"name\":\"Fantasy\"}],\"homepage\":null,\"id\":460010,\"imdb_id\":\"tt6086876\",\"original_language\":\"ru\",\"original_title\":\"The Goblin\",\"overview\":null,\"popularity\":25.971846,\"poster_path\":\"/7BA7fz61imeFqyVXXJaOSYLKart.jpg\",\"production_companies\":[],\"production_countries\":[],\"release_date\":\"2017-09-01\",\"revenue\":0,\"runtime\":null,\"spoken_languages\":[],\"status\":\"Released\",\"tagline\":null,\"title\":\"The Goblin\",\"video\":false,\"vote_average\":0.0,\"vote_count\":0},{\"adult\":false,\"backdrop_path\":\"/RV9IqkDtCrjdagAPW587P6cTNm.jpg\",\"belongs_to_collection\":null,\"budget\":0,\"genres\":[{\"id\":36,\"name\":\"History\"},{\"id\":27,\"name\":\"Horror\"}],\"homepage\":\"\",\"id\":467239,\"imdb_id\":\"tt4898730\",\"original_language\":\"en\",\"original_title\":\"Temple\",\"overview\":\"Three American tourists follow a mysterious map deep into the jungles of Japan searching for an ancient temple. When spirits entrap them, their adventure quickly becomes a horrific nightmare.\",\"popularity\":28.424147,\"poster_path\":\"/9SqbQbba3DwsRjhH2hNwptUpBYi.jpg\",\"production_companies\":[{\"name\":\"Absurda\",\"id\":11610},{\"name\":\"Hooked Digital Media\",\"id\":92702},{\"name\":\"Hemisphere Motion Picture Partners\",\"id\":92703},{\"name\":\"Toneplus Animation Studios\",\"id\":94458}],\"production_countries\":[{\"iso_3166_1\":\"JP\",\"name\":\"Japan\"},{\"iso_3166_1\":\"US\",\"name\":\"United States of America\"}],\"release_date\":\"2017-09-01\",\"revenue\":0,\"runtime\":78,\"spoken_languages\":[{\"iso_639_1\":\"en\",\"name\":\"English\"},{\"iso_639_1\":\"ja\",\"name\":\"日本語\"}],\"status\":\"Released\",\"tagline\":\"\",\"title\":\"Temple\",\"video\":false,\"vote_average\":3.5,\"vote_count\":2},{\"adult\":false,\"backdrop_path\":\"/djz3lXEfvs6PJfM0GEU7cHq1KZA.jpg\",\"belongs_to_collection\":null,\"budget\":0,\"genres\":[],\"homepage\":\"\",\"id\":407890,\"imdb_id\":\"tt5340300\",\"original_language\":\"en\",\"original_title\":\"Lean on Pete\",\"overview\":\"Charley Thompson is a homeless 15-year-old in Portland, and Lean on Pete is his best friend and a failing racehorse. They set off an a journey to find his only known relative.\",\"popularity\":20.230346,\"poster_path\":\"/rAh4DHepMlKmbzmB2Jcntw8rqVQ.jpg\",\"production_companies\":[{\"name\":\"Film4\",\"id\":9349},{\"name\":\"The Bureau\",\"id\":10441},{\"name\":\"A24\",\"id\":41077}],\"production_countries\":[{\"iso_3166_1\":\"GB\",\"name\":\"United Kingdom\"}],\"release_date\":\"2017-09-01\",\"revenue\":0,\"runtime\":119,\"spoken_languages\":[],\"status\":\"Post Production\",\"tagline\":\"\",\"title\":\"Lean on Pete\",\"video\":false,\"vote_average\":4.0,\"vote_count\":2}]}";

    private QueryUtils(){

    }

    public static ArrayList<Movie> extractMovies(){
        ArrayList<Movie> movies = new ArrayList<>();

        try{

            JSONObject baseJsonObject = new JSONObject(SAMPLE_JSON_RESPONSE);

            JSONArray moviesJsonArray = baseJsonObject.getJSONArray("results");

            for(int i = 0; i < moviesJsonArray.length(); i++){

                JSONObject currentMovieJsonObject = moviesJsonArray.getJSONObject(i);

                String title = currentMovieJsonObject.getString("title");

                String backdropPath = currentMovieJsonObject.getString("backdrop_path");

                JSONArray genreJsonArray = currentMovieJsonObject.getJSONArray("genre_ids");
                ArrayList<Integer> genres = new ArrayList<Integer>();
                for(int j = 0; j < genreJsonArray.length(); j++) {
                     genres.add((Integer) genreJsonArray.get(j));
                }

                double tmdbRating = currentMovieJsonObject.getDouble("vote_average");

                long tmdbId = currentMovieJsonObject.getLong("id");

                Movie movie = new Movie(title, backdropPath, tmdbRating, genres, tmdbId);

                movies.add(movie);
            }
        }
        catch(JSONException e){
            Log.e(LOG_TAG, "Problem parsing the movie JSON results", e);
        }

        return movies;
    }

    public static ArrayList<Movie> extractMoviesRecommended(){
        ArrayList<Movie> movies = new ArrayList<Movie>();

        try{
            JSONObject baseJsonObject = new JSONObject(SAMPLE_RECOMMENDED_RESPONSE);

            JSONArray recommendedMoviesJsonArray = baseJsonObject.getJSONArray("recommendations");

            for(int i = 0; i < recommendedMoviesJsonArray.length(); i++){
                JSONObject currentMovieJsonObject = recommendedMoviesJsonArray.getJSONObject(i);

                boolean isAdult = currentMovieJsonObject.getBoolean("adult");

                String backdropPath = currentMovieJsonObject.getString("backdrop_path");

                long budget = currentMovieJsonObject.getLong("budget");

                long revenue = currentMovieJsonObject.getLong("revenue");

                JSONArray genreJsonArray = currentMovieJsonObject.getJSONArray("genres");
                ArrayList<Integer> genres = new ArrayList<Integer>();
                for(int j = 0; j < genreJsonArray.length(); j++) {
                    JSONObject curentGenreJsonObject = genreJsonArray.getJSONObject(j);
                    Integer currentGenreId = curentGenreJsonObject.getInt("id");
                    genres.add(currentGenreId);
                }

                String homePageUrl = currentMovieJsonObject.getString("homepage");

                long tmdbId = currentMovieJsonObject.getLong("id");

                String imdbId = currentMovieJsonObject.getString("imdb_id");

                String overview = currentMovieJsonObject.getString("overview");

                String title = currentMovieJsonObject.getString("title");

                String tagline = currentMovieJsonObject.getString("tagline");

                String releaseDate = currentMovieJsonObject.getString("release_date");

                String posterPath = currentMovieJsonObject.getString("poster_path");

                int runtime = currentMovieJsonObject.getInt("runtime");

                double popularity = currentMovieJsonObject.getDouble("popularity");

                double rating = currentMovieJsonObject.getDouble("vote_average");

                JSONArray productionCompaniesJsonArray = currentMovieJsonObject.getJSONArray("production_companies");
                ArrayList<Integer> productionCompanies = new ArrayList<Integer>();
                for(int j = 0; j < productionCompaniesJsonArray.length(); j++) {
                    JSONObject currentProductionCompanyJsonObject = productionCompaniesJsonArray.getJSONObject(j);
                    Integer currentProductionCompanyId = currentProductionCompanyJsonObject.getInt("id");
                    productionCompanies.add(currentProductionCompanyId);
                }

                //TODO: Work on this...extract countries...
//                JSONArray productionCountriesJsonArray = currentMovieJsonObject.getJSONArray("production_countries");
//                ArrayList<Integer> productionCountries = new ArrayList<Integer>();
//                for(int j = 0; j < productionCountriesJsonArray.length(); j++) {
//                    JSONObject currentProductionCountryJsonObject = productionCountriesJsonArray.getJSONObject(j);
//                    Integer currentProductionCountryId = currentProductionCountryJsonObject.getInt("id");
//                    productionCountries.add(currentProductionCountryId);
//                }

                long voteCount = currentMovieJsonObject.getLong("vote_count");

                movies.add(new Movie(title, tagline, overview, releaseDate, homePageUrl, posterPath, backdropPath, imdbId, runtime, tmdbId, revenue, budget, voteCount, rating, popularity, isAdult, genres, productionCompanies, null));

            }
        }

        catch (JSONException e){
            Log.e(LOG_TAG, "Problem parsing the movie JSON results for recommended activity", e);
        }

        return movies;
    }

    public static ArrayList<Movie> extractMoviesPopular(){
        ArrayList<Movie> movies = new ArrayList<Movie>();

        try{
            JSONObject baseJsonObject = new JSONObject(SAMPLE_POPULAR_RESPONSE);

            JSONArray recommendedMoviesJsonArray = baseJsonObject.getJSONArray("recommendations");

            for(int i = 0; i < recommendedMoviesJsonArray.length(); i++){
                JSONObject currentMovieJsonObject = recommendedMoviesJsonArray.getJSONObject(i);

                boolean isAdult = currentMovieJsonObject.getBoolean("adult");

                String backdropPath = currentMovieJsonObject.getString("backdrop_path");

                long budget = currentMovieJsonObject.getLong("budget");

                long revenue = currentMovieJsonObject.getLong("revenue");

                JSONArray genreJsonArray = currentMovieJsonObject.getJSONArray("genres");
                ArrayList<Integer> genres = new ArrayList<Integer>();
                for(int j = 0; j < genreJsonArray.length(); j++) {
                    JSONObject curentGenreJsonObject = genreJsonArray.getJSONObject(j);
                    Integer currentGenreId = curentGenreJsonObject.getInt("id");
                    genres.add(currentGenreId);
                }

                String homePageUrl = currentMovieJsonObject.getString("homepage");

                long tmdbId = currentMovieJsonObject.getLong("id");

                String imdbId = currentMovieJsonObject.getString("imdb_id");

                String overview = currentMovieJsonObject.getString("overview");

                String title = currentMovieJsonObject.getString("title");

                String tagline = currentMovieJsonObject.getString("tagline");

                String releaseDate = currentMovieJsonObject.getString("release_date");

                String posterPath = currentMovieJsonObject.getString("poster_path");

                int runtime = currentMovieJsonObject.getInt("runtime");

                double popularity = currentMovieJsonObject.getDouble("popularity");

                double rating = currentMovieJsonObject.getDouble("vote_average");

                JSONArray productionCompaniesJsonArray = currentMovieJsonObject.getJSONArray("production_companies");
                ArrayList<Integer> productionCompanies = new ArrayList<Integer>();
                for(int j = 0; j < productionCompaniesJsonArray.length(); j++) {
                    JSONObject currentProductionCompanyJsonObject = productionCompaniesJsonArray.getJSONObject(j);
                    Integer currentProductionCompanyId = currentProductionCompanyJsonObject.getInt("id");
                    productionCompanies.add(currentProductionCompanyId);
                }

                //TODO: Work on this...extract countries...
//                JSONArray productionCountriesJsonArray = currentMovieJsonObject.getJSONArray("production_countries");
//                ArrayList<Integer> productionCountries = new ArrayList<Integer>();
//                for(int j = 0; j < productionCountriesJsonArray.length(); j++) {
//                    JSONObject currentProductionCountryJsonObject = productionCountriesJsonArray.getJSONObject(j);
//                    Integer currentProductionCountryId = currentProductionCountryJsonObject.getInt("id");
//                    productionCountries.add(currentProductionCountryId);
//                }

                long voteCount = currentMovieJsonObject.getLong("vote_count");

                movies.add(new Movie(title, tagline, overview, releaseDate, homePageUrl, posterPath, backdropPath, imdbId, runtime, tmdbId, revenue, budget, voteCount, rating, popularity, isAdult, genres, productionCompanies, null));

            }
        }

        catch (JSONException e){
            Log.e(LOG_TAG, "Problem parsing the movie JSON results for recommended activity", e);
        }

        return movies;
    }

    public static ArrayList<Movie> extractMoviesInTheaters(){
        ArrayList<Movie> movies = new ArrayList<Movie>();

        try{
            JSONObject baseJsonObject = new JSONObject(SAMPLE_IN_THEATERS_RESPONSE);

            JSONArray recommendedMoviesJsonArray = baseJsonObject.getJSONArray("recommendations");

            for(int i = 0; i < recommendedMoviesJsonArray.length(); i++){
                JSONObject currentMovieJsonObject = recommendedMoviesJsonArray.getJSONObject(i);

                boolean isAdult = currentMovieJsonObject.getBoolean("adult");

                String backdropPath = currentMovieJsonObject.getString("backdrop_path");

                long budget = currentMovieJsonObject.getLong("budget");

                long revenue = currentMovieJsonObject.getLong("revenue");

                JSONArray genreJsonArray = currentMovieJsonObject.getJSONArray("genres");
                ArrayList<Integer> genres = new ArrayList<Integer>();
                for(int j = 0; j < genreJsonArray.length(); j++) {
                    JSONObject curentGenreJsonObject = genreJsonArray.getJSONObject(j);
                    Integer currentGenreId = curentGenreJsonObject.getInt("id");
                    genres.add(currentGenreId);
                }

                String homePageUrl = currentMovieJsonObject.getString("homepage");

                long tmdbId = currentMovieJsonObject.getLong("id");

                String imdbId = currentMovieJsonObject.getString("imdb_id");

                String overview = currentMovieJsonObject.getString("overview");

                String title = currentMovieJsonObject.getString("title");

                String tagline = currentMovieJsonObject.getString("tagline");

                String releaseDate = currentMovieJsonObject.getString("release_date");

                String posterPath = currentMovieJsonObject.getString("poster_path");

                int runtime = currentMovieJsonObject.getInt("runtime");

                double popularity = currentMovieJsonObject.getDouble("popularity");

                double rating = currentMovieJsonObject.getDouble("vote_average");

                JSONArray productionCompaniesJsonArray = currentMovieJsonObject.getJSONArray("production_companies");
                ArrayList<Integer> productionCompanies = new ArrayList<Integer>();
                for(int j = 0; j < productionCompaniesJsonArray.length(); j++) {
                    JSONObject currentProductionCompanyJsonObject = productionCompaniesJsonArray.getJSONObject(j);
                    Integer currentProductionCompanyId = currentProductionCompanyJsonObject.getInt("id");
                    productionCompanies.add(currentProductionCompanyId);
                }

                //TODO: Work on this...extract countries...
//                JSONArray productionCountriesJsonArray = currentMovieJsonObject.getJSONArray("production_countries");
//                ArrayList<Integer> productionCountries = new ArrayList<Integer>();
//                for(int j = 0; j < productionCountriesJsonArray.length(); j++) {
//                    JSONObject currentProductionCountryJsonObject = productionCountriesJsonArray.getJSONObject(j);
//                    Integer currentProductionCountryId = currentProductionCountryJsonObject.getInt("id");
//                    productionCountries.add(currentProductionCountryId);
//                }

                long voteCount = currentMovieJsonObject.getLong("vote_count");

                movies.add(new Movie(title, tagline, overview, releaseDate, homePageUrl, posterPath, backdropPath, imdbId, runtime, tmdbId, revenue, budget, voteCount, rating, popularity, isAdult, genres, productionCompanies, null));

            }
        }

        catch (JSONException e){
            Log.e(LOG_TAG, "Problem parsing the movie JSON results for recommended activity", e);
        }

        return movies;
    }

    public static ArrayList<Movie> extractMoviesRecommendedByGenre(int genreId){
        ArrayList<Movie> movies = new ArrayList<Movie>();

        try{
            JSONObject baseJsonObject = new JSONObject(SAMPLE_RECOMMENDED_RESPONSE);

            JSONArray recommendedMoviesJsonArray = baseJsonObject.getJSONArray("recommendations");

            for(int i = 0; i < recommendedMoviesJsonArray.length(); i++){
                JSONObject currentMovieJsonObject = recommendedMoviesJsonArray.getJSONObject(i);

                boolean isAdult = currentMovieJsonObject.getBoolean("adult");

                String backdropPath = currentMovieJsonObject.getString("backdrop_path");

                long budget = currentMovieJsonObject.getLong("budget");

                long revenue = currentMovieJsonObject.getLong("revenue");

                JSONArray genreJsonArray = currentMovieJsonObject.getJSONArray("genres");
                ArrayList<Integer> genres = new ArrayList<Integer>();
                for(int j = 0; j < genreJsonArray.length(); j++) {
                    JSONObject curentGenreJsonObject = genreJsonArray.getJSONObject(j);
                    Integer currentGenreId = curentGenreJsonObject.getInt("id");
                    genres.add(currentGenreId);
                }

                String homePageUrl = currentMovieJsonObject.getString("homepage");

                long tmdbId = currentMovieJsonObject.getLong("id");

                String imdbId = currentMovieJsonObject.getString("imdb_id");

                String overview = currentMovieJsonObject.getString("overview");

                String title = currentMovieJsonObject.getString("title");

                String tagline = currentMovieJsonObject.getString("tagline");

                String releaseDate = currentMovieJsonObject.getString("release_date");

                String posterPath = currentMovieJsonObject.getString("poster_path");

                int runtime = currentMovieJsonObject.getInt("runtime");

                double popularity = currentMovieJsonObject.getDouble("popularity");

                double rating = currentMovieJsonObject.getDouble("vote_average");

                JSONArray productionCompaniesJsonArray = currentMovieJsonObject.getJSONArray("production_companies");
                ArrayList<Integer> productionCompanies = new ArrayList<Integer>();
                for(int j = 0; j < productionCompaniesJsonArray.length(); j++) {
                    JSONObject currentProductionCompanyJsonObject = productionCompaniesJsonArray.getJSONObject(j);
                    Integer currentProductionCompanyId = currentProductionCompanyJsonObject.getInt("id");
                    productionCompanies.add(currentProductionCompanyId);
                }

                //TODO: Work on this...extract countries...
//                JSONArray productionCountriesJsonArray = currentMovieJsonObject.getJSONArray("production_countries");
//                ArrayList<Integer> productionCountries = new ArrayList<Integer>();
//                for(int j = 0; j < productionCountriesJsonArray.length(); j++) {
//                    JSONObject currentProductionCountryJsonObject = productionCountriesJsonArray.getJSONObject(j);
//                    Integer currentProductionCountryId = currentProductionCountryJsonObject.getInt("id");
//                    productionCountries.add(currentProductionCountryId);
//                }

                long voteCount = currentMovieJsonObject.getLong("vote_count");

                if(genres.contains(new Integer(genreId))) {
                    movies.add(new Movie(title, tagline, overview, releaseDate, homePageUrl, posterPath, backdropPath, imdbId, runtime, tmdbId, revenue, budget, voteCount, rating, popularity, isAdult, genres, productionCompanies, null));
                }

            }
        }

        catch (JSONException e){
            Log.e(LOG_TAG, "Problem parsing the movie JSON results for recommended activity", e);
        }

        return movies;
    }

}
