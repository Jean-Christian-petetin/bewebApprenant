package fr.fondespiere.beweb.mobile.apprenants.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import fr.fondespiere.beweb.mobile.apprenants.DAL.Datas;
import fr.fondespiere.beweb.mobile.apprenants.DetailApprenantActivity;
import fr.fondespiere.beweb.mobile.apprenants.R;

/**
 * Created by jc on 05/07/17.
 */

public class ListApprenantAdapter extends ArrayAdapter {

    private final Activity activity;
    private final int resource = R.layout.liste_apprenant_item;
    private final JSONArray apprenants;

    public ListApprenantAdapter(@NonNull Activity activity, @LayoutRes int resource, JSONArray liste) {
        super(activity.getApplicationContext(), resource);
        this.activity = activity;
        this.apprenants = liste;
    }

    @Override
    public int getCount() {
        return apprenants.length();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final int index = position;
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(resource,null);

        TextView textNom = (TextView)convertView.findViewById(R.id.lAItem_textView_nom);
        TextView textPrenom = (TextView)convertView.findViewById(R.id.lAItem_textView_prenom);

        Button detail = (Button)convertView.findViewById(R.id.lAItem_button_detail);
        detail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(activity.getApplicationContext(), DetailApprenantActivity.class);
                    Datas.apprenant = apprenants.getJSONObject(index);
                    activity.startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            textNom.setText(apprenants.getJSONObject(position).getString("nom"));
            textPrenom.setText(apprenants.getJSONObject(position).getString("prenom"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return convertView;
    }
}