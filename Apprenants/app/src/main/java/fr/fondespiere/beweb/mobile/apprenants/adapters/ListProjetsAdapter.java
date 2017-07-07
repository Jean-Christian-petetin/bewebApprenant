package fr.fondespiere.beweb.mobile.apprenants.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import fr.fondespiere.beweb.mobile.apprenants.R;

/**
 * Created by jc on 06/07/17.
 */

public class ListProjetsAdapter extends ArrayAdapter {
    private final Activity activity;
    private final int resource = R.layout.projets_item;
    private JSONArray projets;

    public ListProjetsAdapter(@NonNull Activity activity, @LayoutRes int resource, JSONArray liste) {
        super(activity, resource);
        this.activity = activity;
        this.projets = liste;
    }

    @Override
    public int getCount() {
        return projets.length();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(resource, null);

        TextView textNom = (TextView)convertView.findViewById(R.id.projetItem_textView_nom_projet);
        TextView textGit = (TextView)convertView.findViewById(R.id.projetItem_textView_github);
        TextView textSiteweb = (TextView)convertView.findViewById(R.id.projetItem_textView_siteWeb);
        TextView textDescription = (TextView)convertView.findViewById(R.id.projetItem_textView_description);
        TextView textSkills = (TextView)convertView.findViewById(R.id.projetItem_textView_skills);

        try {
            textNom.setText(projets.getJSONObject(position).getString("nom"));
            textGit.setText(projets.getJSONObject(position).getString("git"));
            textSiteweb.setText(projets.getJSONObject(position).getString("siteweb"));
            textDescription.setText(projets.getJSONObject(position).getString("desc"));
            textSkills.setText(projets.getJSONObject(position).getString("skills"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return convertView;
    }
}
