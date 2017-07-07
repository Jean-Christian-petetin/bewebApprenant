package fr.fondespiere.beweb.mobile.apprenants;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.fondespiere.beweb.mobile.apprenants.DAL.Datas;
import fr.fondespiere.beweb.mobile.apprenants.adapters.ListProjetsAdapter;

/**
 * Created by jc on 04/07/17.
 */

public class DetailApprenantActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_apprenant);

        JSONObject apprenant = Datas.apprenant;

        try {
            ((TextView)findViewById(R.id.detailA_textView_nom)).setText(apprenant.getString("nom"));
            ((TextView)findViewById(R.id.detailA_textView_prenom)).setText(apprenant.getString("prenom"));
            ((TextView)findViewById(R.id.detailA_textView_age)).setText(apprenant.getString("age"));

            JSONArray projets = apprenant.getJSONArray("projets");
            ListProjetsAdapter adapter = new ListProjetsAdapter(this,0,projets);
            ListView listProjets = (ListView)findViewById(R.id.detailA_listView_projet);
            listProjets.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
