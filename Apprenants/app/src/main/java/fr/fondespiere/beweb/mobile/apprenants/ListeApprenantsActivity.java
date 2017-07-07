package fr.fondespiere.beweb.mobile.apprenants;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fr.fondespiere.beweb.mobile.apprenants.DAL.Datas;
import fr.fondespiere.beweb.mobile.apprenants.adapters.ListApprenantAdapter;

/**
 * Created by jc on 04/07/17.
 */

public class ListeApprenantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_apprenants);

        //Déclarations des variables.
        final ListView ListeApprenant = (ListView) findViewById(R.id.lA_listView_apprenants);
        final Activity activity = this;
        /**
         * On initialise un tableau vide au format json pour pouvoir y stocker les objets retournés
         * par la reponse de la requete http.
         */
        JSONArray listDatas = null;

        //Initialisation d'une liste de requête.
        RequestQueue request = Volley.newRequestQueue(getApplicationContext());
        //Cette variable nous sers uniquement à ne pas réécrire l'url plusieur fois.
        String url = "http://192.168.1.48/beweb_api/index.php/";

        /**
         * On stocke la requête de type GET qui cible l'url + apprenants et la fonction de la reponse
         * dans la variable jr.
         */
        JsonArrayRequest jr = new JsonArrayRequest(Request.Method.GET, url + "apprenants", listDatas, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                /**
                 * On crée un objet apdapter afin de faire un traitement pour chaque apprenant que
                 * l'on récupère afin de pouvoir les afficher dans la vue
                 */
                ListApprenantAdapter adapter = new ListApprenantAdapter(activity, R.layout.liste_apprenant_item, response);

                ListeApprenant.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        /**
         * On déclare un nouveau tableau pour pouvoir y stocké tout nos skills.
         */
        final ArrayList<String> skillsList = new ArrayList<>();

        /**
         * On prepare la requête pour aller chercher les skills et on prépare la méthode de l'objet
         * Response.
         */
        JsonArrayRequest skillsRequest = new JsonArrayRequest(Request.Method.GET, url + "skills", listDatas, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                /**
                 * 1 On récupère le spinner dans lequel on va afficher nos infirmations.
                 * 2 On donne à chaque information recuperée un morceau de vue qui ira s'afficher
                 * (l'adapter va boucler sur la longeur de la liste recuperer par la requete).
                 * 3 On remplis le spinner avec les informations retournées par l'adapter.
                 */
                Spinner skillSpinner = (Spinner) findViewById(R.id.lA_Spinner_Skills);
                ArrayAdapter skillsAdapter = new ArrayAdapter(activity,android.R.layout.simple_spinner_item,skillsList);
                skillSpinner.setAdapter(skillsAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });





        /**
         * On appele la variable request qui va instancier un liste de requête,
         * après avec le méthode add on ajoute notre requete qui va effectuer le traitement qui
         * sera effectué par l'adapter et retourne une réponse qui affichera le données récuperées
         * sur la vue.
         */
        request.add(jr);
        request.add(skillsRequest);
    }
}